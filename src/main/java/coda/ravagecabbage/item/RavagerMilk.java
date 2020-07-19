package coda.ravagecabbage.item;

import coda.ravagecabbage.RavageCabbage;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class RavagerMilk extends Item {
	public RavagerMilk() {
		super(new Item.Settings().group(RavageCabbage.GROUP).maxCount(1));
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		user.setCurrentHand(hand);
		return super.use(world, user, hand);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
		if (!world.isClient) entity.clearStatusEffects();

		if (entity instanceof ServerPlayerEntity) {
			ServerPlayerEntity player = (ServerPlayerEntity)entity;
			Criteria.CONSUME_ITEM.trigger(player, stack);
			player.incrementStat(Stats.USED.getOrCreateStat(this));
		}

		if (entity instanceof PlayerEntity && !((PlayerEntity)entity).isCreative()) {
			stack.decrement(1);
		}

		if (!world.isClient) {
			entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 0));
		}

		return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
	}
}

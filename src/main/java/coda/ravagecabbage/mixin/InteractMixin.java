package coda.ravagecabbage.mixin;

import coda.ravagecabbage.init.ItemInit;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RavagerEntity.class)
public class InteractMixin {

	@Inject(method = "interact", at = @At("HEAD"))
	private void interact(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> result){
		ItemStack itemstack = player.getStackInHand(hand);

		if (itemstack.getItem() == Items.BUCKET) {
			Integer stunTicks = ObfuscationReflectionHelper.getPrivateValue(RavagerEntity.class, (RavagerEntity) event.getTarget(), "field_213692_bA");

			if (stunTicks != null && stunTicks > 0) {

				player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
				if (!player.isCreative()) {
					itemstack.decrement(1);
				}
				if (itemstack.isEmpty()) {
					player.setStackInHand(hand, new ItemStack(ItemInit.RAVAGER_MILK));
				} else if (!player.inventory.insertStack(new ItemStack(ItemInit.RAVAGER_MILK))) {
					player.dropItem(new ItemStack(ItemInit.RAVAGER_MILK), false);
				}
				result.setReturnValue(ActionResult.SUCCESS);
			}
		}
	}

}

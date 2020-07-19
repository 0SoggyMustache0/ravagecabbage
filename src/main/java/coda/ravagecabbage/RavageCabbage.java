package coda.ravagecabbage;

import coda.ravagecabbage.init.BlockInit;
import coda.ravagecabbage.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RavageCabbage implements ModInitializer {

	public static final String MOD_ID = "ravagecabbage";
	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "ravagecabbage_tag"), () -> new ItemStack(ItemInit.CABBAGE));

	@Override
	public void onInitialize() {
		BlockInit.BLOCKS.forEach((k, v) -> Registry.register(Registry.BLOCK, new Identifier(MOD_ID, k), v));
		ItemInit.ITEMS.forEach((k, v) -> Registry.register(Registry.ITEM, new Identifier(MOD_ID, k), v));
	}
}

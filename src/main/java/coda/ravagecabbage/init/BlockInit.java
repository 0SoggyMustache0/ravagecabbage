package coda.ravagecabbage.init;

import coda.ravagecabbage.RavageCabbage;
import coda.ravagecabbage.block.CabbageCrop;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

import java.util.HashMap;
import java.util.Map;

public class BlockInit {

	public static final Map<String, Block> BLOCKS = new HashMap<>();

	public static final Block CABBAGE_CROP = register("cabbage_crop", new CabbageCrop(FabricBlockSettings.copyOf(Blocks.POTATOES)));
	public static final Block CABBAGE_CRATE = register("cabbage_crate", new Block(FabricBlockSettings.of(Material.WOOD).hardness(2.5F).resistance(2.5F).sounds(BlockSoundGroup.WOOD)));

	public static Block register(String name, Block block){
		BLOCKS.put(name, block);
		ItemInit.ITEMS.put(name, new BlockItem(block, new Item.Settings().group(RavageCabbage.GROUP)));
		return block;
	}
	
}

package coda.ravagecabbage.init;

import coda.ravagecabbage.RavageCabbage;
import coda.ravagecabbage.item.RCFood;
import coda.ravagecabbage.item.RavagerMilk;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemInit {

	public static final Map<String, Item> ITEMS = new HashMap<>();

	public static final Item CABBAGE = register("cabbage", new RCFood(2, 0.1F));
	public static final Item CABBAGE_SEEDS = register("cabbage_seeds", new BlockItem(BlockInit.CABBAGE_CROP, new Item.Settings().group(RavageCabbage.GROUP)));
	public static final Item RAVAGER_MILK = register("ravage_milk", new RavagerMilk());

	public static Item register(String name, Item item){
		ITEMS.put(name, item);
		return item;
	}
	
}

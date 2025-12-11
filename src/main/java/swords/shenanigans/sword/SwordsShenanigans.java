package swords.shenanigans.sword;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swords.shenanigans.sword.block.ModBlocks;
import swords.shenanigans.sword.item.ModItemGroups;
import swords.shenanigans.sword.item.ModItems;

public class SwordsShenanigans implements ModInitializer {
	public static final String MOD_ID = "swords";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();


	}
}
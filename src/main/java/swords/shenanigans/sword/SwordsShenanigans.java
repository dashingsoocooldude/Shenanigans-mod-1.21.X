package swords.shenanigans.sword;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swords.shenanigans.sword.block.ModBlocks;
import swords.shenanigans.sword.component.ModDataComponentTypes;
import swords.shenanigans.sword.item.ModItemGroups;
import swords.shenanigans.sword.item.ModItems;
import swords.shenanigans.sword.util.HammerUsageEvent;

public class SwordsShenanigans implements ModInitializer {
	public static final String MOD_ID = "swords";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModDataComponentTypes.registerDataComponentTypes();

        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

	}
}
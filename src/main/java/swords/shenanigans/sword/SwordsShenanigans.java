package swords.shenanigans.sword;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swords.shenanigans.sword.block.ModBlocks;
import swords.shenanigans.sword.component.ModDataComponentTypes;
import swords.shenanigans.sword.effect.ModEffects;
import swords.shenanigans.sword.enchantment.ModEnchantmentEffects;
import swords.shenanigans.sword.item.ModItemGroups;
import swords.shenanigans.sword.item.ModItems;
import swords.shenanigans.sword.potion.ModPotions;
import swords.shenanigans.sword.sound.ModSounds;
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
        ModSounds.registerSounds();

        ModEffects.registerEffects();
        ModPotions.registerPotions();

        ModEnchantmentEffects.registerEnchantmentEffects();

        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);


        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    Items.SLIME_BALL,
                    ModPotions.SLIMEY_POTION // Use .value() for RegistryEntry in recipes
            );
        });

        CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.HONEY_BERRIES, 0.15f);
	}
}
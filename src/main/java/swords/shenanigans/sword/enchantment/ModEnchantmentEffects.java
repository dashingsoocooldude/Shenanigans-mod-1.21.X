package swords.shenanigans.sword.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import swords.shenanigans.sword.SwordsShenanigans;
import swords.shenanigans.sword.enchantment.custom.LightningStrikerEnchantmentEffect;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER =
            registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(SwordsShenanigans.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        SwordsShenanigans.LOGGER.info("Registering Mod Enchantment Effects for " + SwordsShenanigans.MOD_ID);
    }
}

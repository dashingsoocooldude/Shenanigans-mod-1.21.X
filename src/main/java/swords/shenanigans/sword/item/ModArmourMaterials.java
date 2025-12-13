package swords.shenanigans.sword.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import swords.shenanigans.sword.SwordsShenanigans;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmourMaterials {
    public static final RegistryEntry<ArmorMaterial> WEAPON_INGOT_ARMOUR_MATERIAL = registerArmourMaterial("weapon_ingot",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.WEAPON_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(SwordsShenanigans.MOD_ID, "weapon_material"))),0 , 0));


    public static RegistryEntry<ArmorMaterial> registerArmourMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(SwordsShenanigans.MOD_ID, name), material.get());
    }
}

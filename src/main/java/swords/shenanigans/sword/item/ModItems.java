package swords.shenanigans.sword.item;

import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import swords.shenanigans.sword.SwordsShenanigans;
import swords.shenanigans.sword.block.ModBlocks;
import swords.shenanigans.sword.item.custom.ChiselItem;
import swords.shenanigans.sword.item.custom.HammerItem;
import swords.shenanigans.sword.item.custom.ModArmorItem;
import swords.shenanigans.sword.sound.ModSounds;

import java.util.List;

public class ModItems {
    
    public static final Item WEAPON_INGOT = registerItem("weapon_ingot", new Item(new Item.Settings()));
    public static final Item RAW_WEAPON_INGOT = registerItem("raw_weapon_ingot", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.swords.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
            new SwordItem(ModToolMaterials.WEAPON_INGOT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.WEAPON_INGOT, 3, -2.4f))));

    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterials.WEAPON_INGOT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.WEAPON_INGOT, 1 , -2.8f))));

    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
            new ShovelItem(ModToolMaterials.WEAPON_INGOT, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.WEAPON_INGOT, 1.5f , -3.0f))));

    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
            new AxeItem(ModToolMaterials.WEAPON_INGOT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.WEAPON_INGOT, 6 , -3.2f))));

    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
            new HoeItem(ModToolMaterials.WEAPON_INGOT, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.WEAPON_INGOT, 0 , -3f))));

    public static final Item PINK_GARNET_HAMMER = registerItem("pink_garnet_hammer",
            new HammerItem(ModToolMaterials.WEAPON_INGOT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.WEAPON_INGOT, 7 , -3.4f))));

    // ARMOUR
    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
            new ModArmorItem(ModArmourMaterials.WEAPON_INGOT_ARMOUR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
            new ArmorItem(ModArmourMaterials.WEAPON_INGOT_ARMOUR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings",
            new ArmorItem(ModArmourMaterials.WEAPON_INGOT_ARMOUR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
            new ArmorItem(ModArmourMaterials.WEAPON_INGOT_ARMOUR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor",
            new AnimalArmorItem(ModArmourMaterials.WEAPON_INGOT_ARMOUR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    public static final Item DASH_SMITHING_TEMPLATE = registerItem("dash_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(SwordsShenanigans.MOD_ID, "dash"), FeatureFlags.VANILLA));

    public static final Item PINK_GARNET_BOW = registerItem("pink_garnet_bow",
            new BowItem(new Item.Settings().maxDamage(500)));

    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).maxCount(1)));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new Item.Settings()));

    public static final Item HONEY_BERRIES = registerItem("honey_berries",
            new AliasedBlockItem(ModBlocks.HONEY_BERRY_BUSH, new Item.Settings().food(ModFoodComponents.HONEY_BERRY)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SwordsShenanigans.MOD_ID, name), item);
    }

    public static void registerModItems(){
        SwordsShenanigans.LOGGER.info("Registering mod items for " + SwordsShenanigans.MOD_ID);
    }
}

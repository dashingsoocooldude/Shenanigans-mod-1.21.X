package swords.shenanigans.sword.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import swords.shenanigans.sword.SwordsShenanigans;
import swords.shenanigans.sword.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SwordsShenanigans.MOD_ID, "items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.WEAPON_INGOT))
                    .displayName(Text.translatable("itemgroup.swords.items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.WEAPON_INGOT);
                    }).build());

    public static final ItemGroup BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SwordsShenanigans.MOD_ID, "blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.swords.blocks"))
                    .entries((displayContext, entries) -> {

                    }).build());

    public static void registerItemGroups() {
        SwordsShenanigans.LOGGER.info("Registering Item Groups for " + SwordsShenanigans.MOD_ID);


    }
}

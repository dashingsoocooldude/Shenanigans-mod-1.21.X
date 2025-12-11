package swords.shenanigans.sword.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import swords.shenanigans.sword.SwordsShenanigans;

public class ModItems {
    public static final Item WEAPON_INGOT = registerItem("weapon_ingot", new Item(new Item.Settings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SwordsShenanigans.MOD_ID, name), item);
    }

    public static void registerModItems(){
        SwordsShenanigans.LOGGER.info("Registering mod items for " + SwordsShenanigans.MOD_ID);
    }
}

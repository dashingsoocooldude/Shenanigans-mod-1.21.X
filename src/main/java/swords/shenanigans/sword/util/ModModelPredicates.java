package swords.shenanigans.sword.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import swords.shenanigans.sword.SwordsShenanigans;
import swords.shenanigans.sword.component.ModDataComponentTypes;
import swords.shenanigans.sword.item.ModItems;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(SwordsShenanigans.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f: 0f);

    }
}

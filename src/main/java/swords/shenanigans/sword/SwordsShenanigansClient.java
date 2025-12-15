package swords.shenanigans.sword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import swords.shenanigans.sword.block.ModBlocks;
import swords.shenanigans.sword.util.ModModelPredicates;

public class SwordsShenanigansClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout()); //FIXES ALPHA PIXELS (SEE THROUGH)
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout()); //FIXES ALPHA PIXELS (SEE THROUGH)

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout()); //FIXES ALPHA PIXELS (SEE THROUGH)

        ModModelPredicates.registerModelPredicates();
    }
}

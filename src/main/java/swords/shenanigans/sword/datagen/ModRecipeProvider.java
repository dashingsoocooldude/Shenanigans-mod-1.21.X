package swords.shenanigans.sword.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import swords.shenanigans.sword.SwordsShenanigans;
import swords.shenanigans.sword.block.ModBlocks;
import swords.shenanigans.sword.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_WEAPON_INGOT, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.WEAPON_INGOT, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.WEAPON_INGOT, 0.25f, 100, "pink_garnet");

        // PINK GARNET & BLOCK
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.WEAPON_INGOT, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        //RAW PINK GARNET & BLOCK
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_WEAPON_INGOT, RecipeCategory.DECORATIONS, ModBlocks.RAW_PINK_GARNET_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_WEAPON_INGOT, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(recipeExporter, Identifier.of(SwordsShenanigans.MOD_ID, "raw_pink_garnet_from_magic_block"));

        //STAIRS
        createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);
        //SLAB
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLAB, ModBlocks.PINK_GARNET_BLOCK);
        //BUTTON
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BUTTON)
                .input(ModBlocks.PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);
        //PRESSURE PLATE
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK));
        //FENCE
        createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK));
        //FENCE GATE
        createFenceRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK));
        //WALL
        offerWallRecipe(recipeExporter,RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_BLOCK);
        //DOOR
        createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK));
        //TRAPDOOR
        createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK));

        //SWORD RECIPE
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PINK_GARNET_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" S ")
                .input('R', ModItems.WEAPON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.WEAPON_INGOT), conditionsFromItem(ModItems.WEAPON_INGOT))
                .offerTo(recipeExporter);

        //PICKAXE RECIPE
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE)
                .pattern("RRR")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.WEAPON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.WEAPON_INGOT), conditionsFromItem(ModItems.WEAPON_INGOT))
                .offerTo(recipeExporter);

        //AXE RECIPE
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE)
                .pattern("RR ")
                .pattern("RS ")
                .pattern(" S ")
                .input('R', ModItems.WEAPON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.WEAPON_INGOT), conditionsFromItem(ModItems.WEAPON_INGOT))
                .offerTo(recipeExporter);

        //SHOVEL RECIPE
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL)
                .pattern(" R ")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.WEAPON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.WEAPON_INGOT), conditionsFromItem(ModItems.WEAPON_INGOT))
                .offerTo(recipeExporter);

        //HOE RECIPE
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE)
                .pattern("RR ")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.WEAPON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.WEAPON_INGOT), conditionsFromItem(ModItems.WEAPON_INGOT))
                .offerTo(recipeExporter);


        offerSmithingTrimRecipe(recipeExporter,ModItems.DASH_SMITHING_TEMPLATE, Identifier.of(SwordsShenanigans.MOD_ID, "dash")); // armor recipe
        offerSmithingTemplateCopyingRecipe(recipeExporter, ModItems.DASH_SMITHING_TEMPLATE, ModBlocks.PINK_GARNET_BLOCK); // trim duplication recipe
    }




}
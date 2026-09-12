package com.gizmo.meatblocks.datagen.data;

import com.gizmo.meatblocks.MeatBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends RecipeProvider {

	public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void buildRecipes(RecipeOutput output, HolderLookup.Provider holderLookup) {
		allCookingRecipesFor(output, MeatBlocks.RAW_BEEF_BLOCK, MeatBlocks.COOKED_BEEF_BLOCK, 3.15F, 1800);
		allCookingRecipesFor(output, MeatBlocks.RAW_MUTTON_BLOCK, MeatBlocks.COOKED_MUTTON_BLOCK, 3.15F, 1800);
		allCookingRecipesFor(output, MeatBlocks.RAW_PORK_BLOCK, MeatBlocks.COOKED_PORK_BLOCK, 3.15F, 1800);
		allCookingRecipesFor(output, MeatBlocks.RAW_RABBIT_BLOCK, MeatBlocks.COOKED_RABBIT_BLOCK, 3.15F, 1800);
		allCookingRecipesFor(output, MeatBlocks.RAW_CHICKEN_BLOCK, MeatBlocks.COOKED_CHICKEN_BLOCK, 3.15F, 1800);
		allCookingRecipesFor(output, MeatBlocks.RAW_COD_BLOCK, MeatBlocks.COOKED_COD_BLOCK, 3.15F, 1800);
		allCookingRecipesFor(output, MeatBlocks.RAW_SALMON_BLOCK, MeatBlocks.COOKED_SALMON_BLOCK, 3.15F, 1800);

		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.RAW_BEEF_BLOCK, Items.BEEF);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.COOKED_BEEF_BLOCK, Items.COOKED_BEEF);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.RAW_MUTTON_BLOCK, Items.MUTTON);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.COOKED_MUTTON_BLOCK, Items.COOKED_MUTTON);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.RAW_PORK_BLOCK, Items.PORKCHOP);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.COOKED_PORK_BLOCK, Items.COOKED_PORKCHOP);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.RAW_RABBIT_BLOCK, Items.RABBIT);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.COOKED_RABBIT_BLOCK, Items.COOKED_RABBIT);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.RAW_CHICKEN_BLOCK, Items.CHICKEN);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.COOKED_CHICKEN_BLOCK, Items.COOKED_CHICKEN);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.RAW_COD_BLOCK, Items.COD);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.COOKED_COD_BLOCK, Items.COOKED_COD);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.RAW_SALMON_BLOCK, Items.SALMON);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.COOKED_SALMON_BLOCK, Items.COOKED_SALMON);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.TROPICAL_FISH_BLOCK, Items.TROPICAL_FISH);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.PUFFERFISH_BLOCK, Items.PUFFERFISH);
		createStorageBlock(output, RecipeCategory.FOOD, MeatBlocks.ROTTEN_FLESH_BLOCK, Items.ROTTEN_FLESH);
	}

	private static void createStorageBlock(RecipeOutput output, RecipeCategory category, ItemLike compressed, ItemLike uncompressed) {
		String compressedName = BuiltInRegistries.ITEM.getKey(compressed.asItem()).getPath();
		String uncompressedName = BuiltInRegistries.ITEM.getKey(uncompressed.asItem()).getPath();
		ShapedRecipeBuilder.shaped(category, compressed)
			.pattern("iii")
			.pattern("iii")
			.pattern("iii")
			.define('i', uncompressed)
			.unlockedBy("has_uncompressed_item", inventoryTrigger(ItemPredicate.Builder.item().of(uncompressed)))
			.save(output, ResourceLocation.fromNamespaceAndPath(MeatBlocks.MODID, "storage/" + uncompressedName + "_to_" + compressedName));

		ShapelessRecipeBuilder.shapeless(category, uncompressed, 9)
			.requires(compressed)
			.unlockedBy("has_compressed_item", inventoryTrigger(ItemPredicate.Builder.item().of(compressed)))
			.save(output, ResourceLocation.fromNamespaceAndPath(MeatBlocks.MODID, "storage/" + compressedName + "_to_" + uncompressedName));
	}

	private static void allCookingRecipesFor(RecipeOutput recipeOutput, ItemLike input, ItemLike output, float experience, int baseCookTime) {
		String smeltName = BuiltInRegistries.ITEM.getKey(input.asItem()).getPath();
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, output, experience, baseCookTime).unlockedBy("has_meat", has(input)).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MeatBlocks.MODID, "smelting/" + smeltName));
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, output, experience, baseCookTime / 2).unlockedBy("has_meat", has(input)).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MeatBlocks.MODID, "smoking/" + smeltName));
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.FOOD, output, experience, baseCookTime * 3).unlockedBy("has_meat", has(input)).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MeatBlocks.MODID, "campfiring/" + smeltName));
	}
}

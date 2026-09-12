package com.gizmo.meatblocks.datagen.data.tags;

import com.gizmo.meatblocks.MeatBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {

	public ItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, ExistingFileHelper helper) {
		super(output, future, blockTags, MeatBlocks.MODID, helper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(ItemTags.MEAT).add(
			MeatBlocks.ROTTEN_FLESH_BLOCK.asItem(),
			MeatBlocks.COOKED_BEEF_BLOCK.asItem(),
			MeatBlocks.COOKED_MUTTON_BLOCK.asItem(),
			MeatBlocks.COOKED_PORK_BLOCK.asItem(),
			MeatBlocks.COOKED_RABBIT_BLOCK.asItem(),
			MeatBlocks.COOKED_CHICKEN_BLOCK.asItem(),
			MeatBlocks.RAW_BEEF_BLOCK.asItem(),
			MeatBlocks.RAW_MUTTON_BLOCK.asItem(),
			MeatBlocks.RAW_PORK_BLOCK.asItem(),
			MeatBlocks.RAW_RABBIT_BLOCK.asItem(),
			MeatBlocks.RAW_CHICKEN_BLOCK.asItem()
		);

		this.tag(Tags.Items.FOODS_RAW_MEAT).add(
			MeatBlocks.RAW_BEEF_BLOCK.asItem(),
			MeatBlocks.RAW_MUTTON_BLOCK.asItem(),
			MeatBlocks.RAW_PORK_BLOCK.asItem(),
			MeatBlocks.RAW_RABBIT_BLOCK.asItem(),
			MeatBlocks.RAW_CHICKEN_BLOCK.asItem()
		);

		this.tag(Tags.Items.FOODS_COOKED_MEAT).add(
			MeatBlocks.COOKED_BEEF_BLOCK.asItem(),
			MeatBlocks.COOKED_MUTTON_BLOCK.asItem(),
			MeatBlocks.COOKED_PORK_BLOCK.asItem(),
			MeatBlocks.COOKED_RABBIT_BLOCK.asItem(),
			MeatBlocks.COOKED_CHICKEN_BLOCK.asItem()
		);

		this.tag(Tags.Items.FOODS_RAW_FISH).add(
			MeatBlocks.RAW_COD_BLOCK.asItem(),
			MeatBlocks.RAW_SALMON_BLOCK.asItem(),
			MeatBlocks.TROPICAL_FISH_BLOCK.asItem(),
			MeatBlocks.PUFFERFISH_BLOCK.asItem()
		);

		this.tag(Tags.Items.FOODS_COOKED_FISH).add(
			MeatBlocks.COOKED_COD_BLOCK.asItem(),
			MeatBlocks.COOKED_SALMON_BLOCK.asItem()
		);

		this.tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED).add(
			MeatBlocks.COOKED_BEEF_BLOCK.asItem(),
			MeatBlocks.COOKED_MUTTON_BLOCK.asItem(),
			MeatBlocks.COOKED_PORK_BLOCK.asItem(),
			MeatBlocks.COOKED_RABBIT_BLOCK.asItem(),
			MeatBlocks.COOKED_CHICKEN_BLOCK.asItem(),
			MeatBlocks.COOKED_SALMON_BLOCK.asItem(),
			MeatBlocks.COOKED_COD_BLOCK.asItem(),
			MeatBlocks.TROPICAL_FISH_BLOCK.asItem(),
			MeatBlocks.RAW_BEEF_BLOCK.asItem(),
			MeatBlocks.RAW_MUTTON_BLOCK.asItem(),
			MeatBlocks.RAW_PORK_BLOCK.asItem(),
			MeatBlocks.RAW_RABBIT_BLOCK.asItem(),
			MeatBlocks.RAW_CHICKEN_BLOCK.asItem(),
			MeatBlocks.RAW_SALMON_BLOCK.asItem(),
			MeatBlocks.RAW_COD_BLOCK.asItem()
		);

		this.tag(Tags.Items.STORAGE_BLOCKS).add(
			MeatBlocks.ROTTEN_FLESH_BLOCK.asItem(),
			MeatBlocks.COOKED_BEEF_BLOCK.asItem(),
			MeatBlocks.COOKED_MUTTON_BLOCK.asItem(),
			MeatBlocks.COOKED_PORK_BLOCK.asItem(),
			MeatBlocks.COOKED_RABBIT_BLOCK.asItem(),
			MeatBlocks.COOKED_CHICKEN_BLOCK.asItem(),
			MeatBlocks.COOKED_SALMON_BLOCK.asItem(),
			MeatBlocks.COOKED_COD_BLOCK.asItem(),
			MeatBlocks.TROPICAL_FISH_BLOCK.asItem(),
			MeatBlocks.PUFFERFISH_BLOCK.asItem(),
			MeatBlocks.RAW_BEEF_BLOCK.asItem(),
			MeatBlocks.RAW_MUTTON_BLOCK.asItem(),
			MeatBlocks.RAW_PORK_BLOCK.asItem(),
			MeatBlocks.RAW_RABBIT_BLOCK.asItem(),
			MeatBlocks.RAW_CHICKEN_BLOCK.asItem(),
			MeatBlocks.RAW_SALMON_BLOCK.asItem(),
			MeatBlocks.RAW_COD_BLOCK.asItem()
		);
	}
}

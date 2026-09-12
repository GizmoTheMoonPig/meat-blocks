package com.gizmo.meatblocks.datagen.data.tags;

import com.gizmo.meatblocks.MeatBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {

	public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper helper) {
		super(output, future, MeatBlocks.MODID, helper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {

		this.tag(Tags.Blocks.STORAGE_BLOCKS).add(
			MeatBlocks.ROTTEN_FLESH_BLOCK.get(),
			MeatBlocks.COOKED_BEEF_BLOCK.get(),
			MeatBlocks.COOKED_MUTTON_BLOCK.get(),
			MeatBlocks.COOKED_PORK_BLOCK.get(),
			MeatBlocks.COOKED_RABBIT_BLOCK.get(),
			MeatBlocks.COOKED_CHICKEN_BLOCK.get(),
			MeatBlocks.COOKED_SALMON_BLOCK.get(),
			MeatBlocks.COOKED_COD_BLOCK.get(),
			MeatBlocks.TROPICAL_FISH_BLOCK.get(),
			MeatBlocks.PUFFERFISH_BLOCK.get(),
			MeatBlocks.RAW_BEEF_BLOCK.get(),
			MeatBlocks.RAW_MUTTON_BLOCK.get(),
			MeatBlocks.RAW_PORK_BLOCK.get(),
			MeatBlocks.RAW_RABBIT_BLOCK.get(),
			MeatBlocks.RAW_CHICKEN_BLOCK.get(),
			MeatBlocks.RAW_SALMON_BLOCK.get(),
			MeatBlocks.RAW_COD_BLOCK.get()
		);

		this.tag(BlockTags.MINEABLE_WITH_HOE).add(
			MeatBlocks.ROTTEN_FLESH_BLOCK.get(),
			MeatBlocks.RAW_BEEF_BLOCK.get(),
			MeatBlocks.COOKED_BEEF_BLOCK.get(),
			MeatBlocks.RAW_MUTTON_BLOCK.get(),
			MeatBlocks.COOKED_MUTTON_BLOCK.get(),
			MeatBlocks.RAW_PORK_BLOCK.get(),
			MeatBlocks.COOKED_PORK_BLOCK.get(),
			MeatBlocks.RAW_RABBIT_BLOCK.get(),
			MeatBlocks.COOKED_RABBIT_BLOCK.get(),
			MeatBlocks.RAW_CHICKEN_BLOCK.get(),
			MeatBlocks.COOKED_CHICKEN_BLOCK.get(),
			MeatBlocks.RAW_SALMON_BLOCK.get(),
			MeatBlocks.COOKED_SALMON_BLOCK.get(),
			MeatBlocks.RAW_COD_BLOCK.get(),
			MeatBlocks.COOKED_COD_BLOCK.get(),
			MeatBlocks.TROPICAL_FISH_BLOCK.get(),
			MeatBlocks.PUFFERFISH_BLOCK.get()
		);
	}
}

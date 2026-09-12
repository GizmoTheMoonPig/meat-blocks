package com.gizmo.meatblocks.datagen.data;

import com.gizmo.meatblocks.block.MeatBlock;
import com.gizmo.meatblocks.MeatBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends LootTableProvider {

	public LootTableGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, Set.of(), List.of(new SubProviderEntry(Blocks::new, LootContextParamSets.BLOCK)), registries);
	}

	public static class Blocks extends BlockLootSubProvider {

		protected Blocks(HolderLookup.Provider registries) {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
		}

		@Override
		protected void generate() {
			this.add(MeatBlocks.RAW_BEEF_BLOCK.get(), block -> this.meatBlock(block, Items.BEEF, true));
			this.add(MeatBlocks.COOKED_BEEF_BLOCK.get(), block -> this.meatBlock(block, Items.COOKED_BEEF, true));
			this.add(MeatBlocks.RAW_PORK_BLOCK.get(), block -> this.meatBlock(block, Items.PORKCHOP, true));
			this.add(MeatBlocks.COOKED_PORK_BLOCK.get(), block -> this.meatBlock(block, Items.COOKED_PORKCHOP, true));
			this.add(MeatBlocks.RAW_MUTTON_BLOCK.get(), block -> this.meatBlock(block, Items.MUTTON, true));
			this.add(MeatBlocks.COOKED_MUTTON_BLOCK.get(), block -> this.meatBlock(block, Items.COOKED_MUTTON, true));
			this.add(MeatBlocks.RAW_RABBIT_BLOCK.get(), block -> this.meatBlock(block, Items.RABBIT, true));
			this.add(MeatBlocks.COOKED_RABBIT_BLOCK.get(), block -> this.meatBlock(block, Items.COOKED_RABBIT, true));
			this.add(MeatBlocks.RAW_CHICKEN_BLOCK.get(), block -> this.meatBlock(block, Items.CHICKEN, true));
			this.add(MeatBlocks.COOKED_CHICKEN_BLOCK.get(), block -> this.meatBlock(block, Items.COOKED_CHICKEN, true));
			this.add(MeatBlocks.RAW_BEEF_BLOCK.get(), block -> this.meatBlock(block, Items.BEEF, true));
			this.add(MeatBlocks.COOKED_BEEF_BLOCK.get(), block -> this.meatBlock(block, Items.COOKED_BEEF, true));
			this.add(MeatBlocks.RAW_COD_BLOCK.get(), block -> this.meatBlock(block, Items.COD, false));
			this.add(MeatBlocks.COOKED_COD_BLOCK.get(), block -> this.meatBlock(block, Items.COOKED_COD, false));
			this.add(MeatBlocks.RAW_SALMON_BLOCK.get(), block -> this.meatBlock(block, Items.SALMON, false));
			this.add(MeatBlocks.COOKED_SALMON_BLOCK.get(), block -> this.meatBlock(block, Items.COOKED_SALMON, false));
			this.add(MeatBlocks.TROPICAL_FISH_BLOCK.get(), block -> this.meatBlock(block, Items.TROPICAL_FISH, false));
			this.dropSelf(MeatBlocks.PUFFERFISH_BLOCK.get());
			this.dropSelf(MeatBlocks.ROTTEN_FLESH_BLOCK.get());
		}

		private LootTable.Builder meatBlock(Block block, ItemLike meatItem, boolean bone) {
			var table = LootTable.lootTable()
				.withPool(LootPool.lootPool()
				.add(this.applyExplosionCondition(block, LootItem.lootTableItem(block)
					.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
						.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MeatBlock.BITES, 0))))))
				.withPool(LootPool.lootPool()
					.add(this.applyExplosionCondition(block, AlternativesEntry.alternatives(
						LootItem.lootTableItem(meatItem)
							.apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 7)))
							.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
							.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MeatBlock.BITES, 1))),
						LootItem.lootTableItem(meatItem)
							.apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
							.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
								.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MeatBlock.BITES, 2))),
						LootItem.lootTableItem(meatItem)
							.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
							.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
								.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MeatBlock.BITES, 3)))))));

			if (bone) {
				table = table.withPool(LootPool.lootPool()
					.add(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.BONE_MEAL)
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
					.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
						.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MeatBlock.BITES, 0)).invert()))));
			}
			return table;
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return MeatBlocks.BLOCKS.getEntries().stream().map(Holder::value).toList();
		}
	}
}

package com.gizmo.meatblocks;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MeatBlockItem extends BlockItem {
	public MeatBlockItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity entity) {
		return (int) (1.6F * 9 * 20.0F);
	}


	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		if (stack.is(MeatBlocks.PUFFERFISH_BLOCK.asItem())) {
			entity.hurt(level.damageSources().source(MeatBlocks.ADVENTUROUS_EATER), entity.getMaxHealth());
		}
		return super.finishUsingItem(stack, level, entity);
	}
}

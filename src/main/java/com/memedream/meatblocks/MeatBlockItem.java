package com.memedream.meatblocks;

import net.minecraft.server.level.ServerLevel;
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
}

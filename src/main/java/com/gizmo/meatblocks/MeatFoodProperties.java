package com.gizmo.meatblocks;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class MeatFoodProperties {

	public static final FoodProperties RAW_BEEF_BLOCK = new FoodProperties.Builder().nutrition(27).saturationModifier(1.62f).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties COOKED_BEEF_BLOCK = new FoodProperties.Builder().nutrition(64).saturationModifier(7.2f).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties RAW_MUTTON_BLOCK = new FoodProperties.Builder().nutrition(18).saturationModifier(2.7F).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties COOKED_MUTTON_BLOCK = new FoodProperties.Builder().nutrition(54).saturationModifier(7.2F).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties RAW_PORK_BLOCK = new FoodProperties.Builder().nutrition(27).saturationModifier(2.7F).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties COOKED_PORK_BLOCK = new FoodProperties.Builder().nutrition(64).saturationModifier(7.2f).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties RAW_RABBIT_BLOCK = new FoodProperties.Builder().nutrition(27).saturationModifier(2.7F).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties COOKED_RABBIT_BLOCK = new FoodProperties.Builder().nutrition(45).saturationModifier(5.4F).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties RAW_CHICKEN_BLOCK = new FoodProperties.Builder().nutrition(18).saturationModifier(2.7F).usingConvertsTo(Items.BONE).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 8), 0.3F).build();
	public static final FoodProperties COOKED_CHICKEN_BLOCK = new FoodProperties.Builder().nutrition(54).saturationModifier(5.4F).usingConvertsTo(Items.BONE).build();
	public static final FoodProperties RAW_SALMON_BLOCK = new FoodProperties.Builder().nutrition(18).saturationModifier(0.9F).build();
	public static final FoodProperties COOKED_SALMON_BLOCK = new FoodProperties.Builder().nutrition(54).saturationModifier(7.2F).build();
	public static final FoodProperties RAW_COD_BLOCK = new FoodProperties.Builder().nutrition(18).saturationModifier(0.9F).build();
	public static final FoodProperties COOKED_COD_BLOCK = new FoodProperties.Builder().nutrition(45).saturationModifier(5.4F).build();
	public static final FoodProperties TROPICAL_FISH_BLOCK = new FoodProperties.Builder().nutrition(9).saturationModifier(0.9F).build();
	public static final FoodProperties PUFFERFISH_BLOCK = new FoodProperties.Builder().nutrition(9).saturationModifier(0.9F).build();
}

package com.gizmo.meatblocks;

import com.gizmo.meatblocks.block.ConfiguredDirectionalBlock;
import com.gizmo.meatblocks.block.MeatBlock;
import com.gizmo.meatblocks.block.RawMeatBlock;
import com.gizmo.meatblocks.block.RottenFleshBlock;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

import java.util.function.Function;
import java.util.function.Supplier;

@Mod(MeatBlocks.MODID)
public class MeatBlocks {

    public static final String MODID = "meatblocks";
    public static final Logger LOGGER = LogUtils.getLogger();

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, MODID);

	public static final DeferredBlock<Block> COOKED_BEEF_BLOCK = registerWithItem("cooked_beef_block", properties -> new MeatBlock(MeatBlock.BoneType.NORMAL, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.COOKED_BEEF_BLOCK));
	public static final DeferredBlock<Block> COOKED_MUTTON_BLOCK = registerWithItem("cooked_mutton_block", properties -> new MeatBlock(MeatBlock.BoneType.NORMAL, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.COOKED_MUTTON_BLOCK));
	public static final DeferredBlock<Block> COOKED_PORK_BLOCK = registerWithItem("cooked_pork_block", properties -> new MeatBlock(MeatBlock.BoneType.NORMAL, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.COOKED_PORK_BLOCK));
	public static final DeferredBlock<Block> COOKED_RABBIT_BLOCK = registerWithItem("cooked_rabbit_block", properties -> new MeatBlock(MeatBlock.BoneType.THIN, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.COOKED_RABBIT_BLOCK));
	public static final DeferredBlock<Block> COOKED_CHICKEN_BLOCK = registerWithItem("cooked_chicken_block", properties -> new MeatBlock(MeatBlock.BoneType.THIN, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.COOKED_CHICKEN_BLOCK));
	public static final DeferredBlock<Block> COOKED_SALMON_BLOCK = registerWithItem("cooked_salmon_block", properties -> new MeatBlock(MeatBlock.BoneType.NONE, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.COOKED_SALMON_BLOCK));
	public static final DeferredBlock<Block> COOKED_COD_BLOCK = registerWithItem("cooked_cod_block", properties -> new MeatBlock(MeatBlock.BoneType.NONE, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.COOKED_COD_BLOCK));

	public static final DeferredBlock<Block> ROTTEN_FLESH_BLOCK = registerWithItem("rotten_flesh_block", RottenFleshBlock::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.ZOMBIE).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.ROTTEN_FLESH_BLOCK));
	public static final DeferredBlock<Block> TROPICAL_FISH_BLOCK = registerWithItem("tropical_fish_block", properties -> new MeatBlock(MeatBlock.BoneType.NONE, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.TROPICAL_FISH_BLOCK));
	public static final DeferredBlock<Block> PUFFERFISH_BLOCK = registerWithItem("pufferfish_block", ConfiguredDirectionalBlock::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.PUFFERFISH_BLOCK));
	public static final DeferredBlock<Block> RAW_BEEF_BLOCK = registerWithItem("raw_beef_block", properties -> new RawMeatBlock(COOKED_BEEF_BLOCK, MeatBlock.BoneType.NORMAL, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.RAW_BEEF_BLOCK));
	public static final DeferredBlock<Block> RAW_MUTTON_BLOCK = registerWithItem("raw_mutton_block", properties -> new RawMeatBlock(COOKED_MUTTON_BLOCK, MeatBlock.BoneType.NORMAL, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.RAW_MUTTON_BLOCK));
	public static final DeferredBlock<Block> RAW_PORK_BLOCK = registerWithItem("raw_pork_block", properties -> new RawMeatBlock(COOKED_PORK_BLOCK, MeatBlock.BoneType.NORMAL, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.RAW_PORK_BLOCK));
	public static final DeferredBlock<Block> RAW_RABBIT_BLOCK = registerWithItem("raw_rabbit_block", properties -> new RawMeatBlock(COOKED_RABBIT_BLOCK, MeatBlock.BoneType.THIN, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.RAW_RABBIT_BLOCK));
	public static final DeferredBlock<Block> RAW_CHICKEN_BLOCK = registerWithItem("raw_chicken_block", properties -> new RawMeatBlock(COOKED_CHICKEN_BLOCK, MeatBlock.BoneType.THIN, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.RAW_CHICKEN_BLOCK));
	public static final DeferredBlock<Block> RAW_SALMON_BLOCK = registerWithItem("raw_salmon_block", properties -> new RawMeatBlock(COOKED_SALMON_BLOCK, MeatBlock.BoneType.NONE, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.RAW_SALMON_BLOCK));
	public static final DeferredBlock<Block> RAW_COD_BLOCK = registerWithItem("raw_cod_block", properties -> new RawMeatBlock(COOKED_COD_BLOCK, MeatBlock.BoneType.NONE, properties), () -> BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.COW_BELL).strength(2.0F).sound(SoundType.FROGSPAWN), new Item.Properties().food(MeatFoodProperties.RAW_COD_BLOCK));

	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DRIPPING_FLESH = PARTICLES.register("dripping_flesh", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FALLING_FLESH = PARTICLES.register("falling_flesh", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LANDING_FLESH = PARTICLES.register("landing_flesh", () -> new SimpleParticleType(false));

	public static final ResourceKey<DamageType> ADVENTUROUS_EATER = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, "adventurous_eater"));

	public MeatBlocks(IEventBus bus, ModContainer container, Dist dist) {
		BLOCKS.register(bus);
		ITEMS.register(bus);
		PARTICLES.register(bus);

		if (dist.isClient()) {
			bus.addListener(RegisterParticleProvidersEvent.class, event -> {
				event.registerSpriteSet(DRIPPING_FLESH.get(), FleshDripParticle.FleshFallProvider::new);
				event.registerSpriteSet(FALLING_FLESH.get(), FleshDripParticle.FleshFallProvider::new);
				event.registerSpriteSet(LANDING_FLESH.get(), FleshDripParticle.FleshLandProvider::new);
			});
		}

		bus.addListener(BuildCreativeModeTabContentsEvent.class, event -> {
			if (event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS)) {
				event.accept(ROTTEN_FLESH_BLOCK);
				event.accept(RAW_BEEF_BLOCK);
				event.accept(COOKED_BEEF_BLOCK);
				event.accept(RAW_MUTTON_BLOCK);
				event.accept(COOKED_MUTTON_BLOCK);
				event.accept(RAW_PORK_BLOCK);
				event.accept(COOKED_PORK_BLOCK);
				event.accept(RAW_RABBIT_BLOCK);
				event.accept(COOKED_RABBIT_BLOCK);
				event.accept(RAW_CHICKEN_BLOCK);
				event.accept(COOKED_CHICKEN_BLOCK);
				event.accept(RAW_COD_BLOCK);
				event.accept(COOKED_COD_BLOCK);
				event.accept(RAW_SALMON_BLOCK);
				event.accept(COOKED_SALMON_BLOCK);

				event.accept(TROPICAL_FISH_BLOCK);
				event.accept(PUFFERFISH_BLOCK);
			}
		});
    }

	public static <T extends Block> DeferredBlock<T> registerWithItem(String name, Function<BlockBehaviour.Properties, T> block, Supplier<BlockBehaviour.Properties> properties, Item.Properties itemProperties) {
		DeferredBlock<T> ret = BLOCKS.register(name, () -> block.apply(properties.get()));
		ITEMS.registerItem(name, itemProps -> new MeatBlockItem(ret.get(), itemProps), itemProperties);
		return ret;
	}
}

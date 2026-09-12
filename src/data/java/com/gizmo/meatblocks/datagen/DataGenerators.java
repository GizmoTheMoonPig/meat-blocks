package com.gizmo.meatblocks.datagen;

import com.gizmo.meatblocks.MeatBlocks;
import com.gizmo.meatblocks.datagen.data.LootTableGenerator;
import com.gizmo.meatblocks.datagen.data.RecipeGenerator;
import com.gizmo.meatblocks.datagen.data.tags.BlockTagGenerator;
import com.gizmo.meatblocks.datagen.data.tags.DamageTagGenerator;
import com.gizmo.meatblocks.datagen.data.tags.ItemTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MeatBlocks.MODID)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = event.getGenerator().getPackOutput();
		ExistingFileHelper helper = event.getExistingFileHelper();

		DatapackBuiltinEntriesProvider datapackProvider = new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), new RegistrySetBuilder().add(Registries.DAMAGE_TYPE, context ->
			context.register(MeatBlocks.ADVENTUROUS_EATER, new DamageType("meatblocks.adventurous_eater", DamageScaling.NEVER, 0.0F, DamageEffects.THORNS))), Set.of("minecraft", MeatBlocks.MODID));
		CompletableFuture<HolderLookup.Provider> lookupProvider = datapackProvider.getRegistryProvider();

		// -- ASSETS --
//		generator.addProvider(event.includeClient(), new LangGen(output));
//		generator.addProvider(event.includeClient(), new ModelGen(output));

		// -- DATA --
		generator.addProvider(event.includeServer(), datapackProvider);
		generator.addProvider(event.includeServer(), new RecipeGenerator(output, lookupProvider));
		generator.addProvider(event.includeServer(), new LootTableGenerator(output, lookupProvider));
		//tags
		var blockTags = new BlockTagGenerator(output, lookupProvider, helper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(), new ItemTagGenerator(output, lookupProvider, blockTags.contentsGetter(), helper));
		generator.addProvider(event.includeServer(), new DamageTagGenerator(output, lookupProvider, helper));
	}
}

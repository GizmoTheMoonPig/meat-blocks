package com.gizmo.meatblocks.datagen.data.tags;

import com.gizmo.meatblocks.MeatBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class DamageTagGenerator extends TagsProvider<DamageType> {

    public DamageTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper helper) {
        super(output, Registries.DAMAGE_TYPE, future, MeatBlocks.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(DamageTypeTags.BYPASSES_ARMOR).add(MeatBlocks.ADVENTUROUS_EATER);
        this.tag(DamageTypeTags.BYPASSES_EFFECTS).add(MeatBlocks.ADVENTUROUS_EATER);
        this.tag(DamageTypeTags.BYPASSES_ENCHANTMENTS).add(MeatBlocks.ADVENTUROUS_EATER);
        this.tag(DamageTypeTags.BYPASSES_RESISTANCE).add(MeatBlocks.ADVENTUROUS_EATER);
        this.tag(DamageTypeTags.NO_KNOCKBACK).add(MeatBlocks.ADVENTUROUS_EATER);
        this.tag(DamageTypeTags.BYPASSES_WOLF_ARMOR).add(MeatBlocks.ADVENTUROUS_EATER);

	}
}

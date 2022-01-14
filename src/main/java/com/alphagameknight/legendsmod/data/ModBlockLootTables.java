package com.alphagameknight.legendsmod.data;

import com.alphagameknight.legendsmod.Blocks.ModBlocks;
import com.alphagameknight.legendsmod.Items.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    // Defines the Loot Tables for Mod Blocks
    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.MINECRON_BLOCK.get());
        this.dropSelf(ModBlocks.SPEED_BLOCK.get());

        this.add(ModBlocks.MINECRON_ORE.get(), (block) -> {
            return createOreDrop(ModBlocks.MINECRON_ORE.get(), ModItems.MINECRON_SHARD.get());
        });

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}

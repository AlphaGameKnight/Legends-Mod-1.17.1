package com.alphagameknight.legendsmod.util;

import com.alphagameknight.legendsmod.LegendsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static class Blocks {

        private static Tags.IOptionalNamedTag<Block> createTag(String name){

            return BlockTags.createOptional(new ResourceLocation(LegendsMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> createForgeTag(String name){

            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }

    }


    public static class Items {

        public static final Tags.IOptionalNamedTag<Item> MINECRON_SHARD = createForgeTag("shard/minecron");

        private static Tags.IOptionalNamedTag<Item> createTag(String name){

            return ItemTags.createOptional(new ResourceLocation(LegendsMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name){

            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }

    }
}

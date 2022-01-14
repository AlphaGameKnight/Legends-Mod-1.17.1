package com.alphagameknight.legendsmod.Items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

// Creates the Legends of Minecraft Creative Mode Tab
public class ModCreativeModeTab {
    public static final CreativeModeTab LEGENDS_OF_MINECRAFT = new CreativeModeTab("legends_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MINECRON_SHARD.get());
        }
    };
}

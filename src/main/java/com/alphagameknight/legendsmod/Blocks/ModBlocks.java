package com.alphagameknight.legendsmod.Blocks;

import com.alphagameknight.legendsmod.Items.ModCreativeModeTab;
import com.alphagameknight.legendsmod.Items.ModItems;
import com.alphagameknight.legendsmod.LegendsMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LegendsMod.MOD_ID);

    // Registers the Minecron Block
    public static final RegistryObject<Block> MINECRON_BLOCK = registerBlock("minecron_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(12f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.LEGENDS_OF_MINECRAFT);

    // Registers the Minecron Block
    public static final RegistryObject<Block> MINECRON_ORE = registerBlock("minecron_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(12f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.LEGENDS_OF_MINECRAFT);


    // Registers the Block to the programmer-defined Creative Mode Tab
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn =BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    // Registers the Block Item to a generic Creative Mode Tab
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    // Registers the Block to a generic Creative Mode Tab
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn =BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Registers the Block Item
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}

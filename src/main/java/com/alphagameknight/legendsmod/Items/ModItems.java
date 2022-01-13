package com.alphagameknight.legendsmod.Items;

import com.alphagameknight.legendsmod.Items.custom.MinecronInfusedCoal;
import com.alphagameknight.legendsmod.Items.custom.SmartBlowtorchItem;
import com.alphagameknight.legendsmod.LegendsMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.IEventBusInvokeDispatcher;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/* Registers all the items in the mod */
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, LegendsMod.MOD_ID);

    // Registers the Minecron Crystal item
    public static final RegistryObject<Item> MINECRON_ORB = ITEMS.register("minecron_orb",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));

    // Registers the Minecron Shard item
    public static final RegistryObject<Item> MINECRON_SHARD = ITEMS.register("minecron_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));

    // Registers the Tomato food item
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build())));

    // Registers the Blowtorch Custom Item
    public static final RegistryObject<Item> SMART_BLOW_TORCH = ITEMS.register("smart_blow_torch",
            () -> new SmartBlowtorchItem(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT).durability(64)));

    // Registers the Blowtorch Custom Item
    public static final RegistryObject<Item> MINECRON_INFUSED_COAL = ITEMS.register("minecron_infused_coal",
            () -> new MinecronInfusedCoal(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));





    // Makes sure Minecraft knows there are items to be added
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

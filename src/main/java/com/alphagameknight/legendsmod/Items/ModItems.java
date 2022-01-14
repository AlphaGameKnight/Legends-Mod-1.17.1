package com.alphagameknight.legendsmod.Items;

import com.alphagameknight.legendsmod.Items.custom.MinecronInfusedCoal;
import com.alphagameknight.legendsmod.Items.custom.SmartBlowtorchItem;
import com.alphagameknight.legendsmod.LegendsMod;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.IEventBusInvokeDispatcher;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

/* Registers all the items in the mod */
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, LegendsMod.MOD_ID);

    // Registers the Minecron Orb Item
    public static final RegistryObject<Item> MINECRON_ORB = ITEMS.register("minecron_orb",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)) {

                // Tooltip for the Minecron Orb Item
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                            List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

                    if(Screen.hasShiftDown()) {
                        pTooltipComponents.add(new TranslatableComponent("tooltip.legendsmod.minecron_orb"));
                    }else{
                        pTooltipComponents.add(new TranslatableComponent("tooltip.legendsmod.minecron_orb_shift"));
                    }

                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    // Registers the Minecron Shard item
    public static final RegistryObject<Item> MINECRON_SHARD = ITEMS.register("minecron_shard",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)){

                // Tooltip for the Minecron Shard Item
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                            List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

                    if(Screen.hasShiftDown()) {
                        pTooltipComponents.add(new TranslatableComponent("tooltip.legendsmod.minecron_shard"));
                    }else{
                        pTooltipComponents.add(new TranslatableComponent("tooltip.legendsmod.minecron_shard_shift"));
                    }

                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });

    // Registers the Tomato food item
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build())));

    // Registers the Blowtorch Custom Item
    public static final RegistryObject<Item> SMART_BLOW_TORCH = ITEMS.register("smart_blow_torch",
            () -> new SmartBlowtorchItem(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT).durability(64)));

    // Registers the Minecron-Infused Coal Fuel Item
    public static final RegistryObject<Item> MINECRON_INFUSED_COAL = ITEMS.register("minecron_infused_coal",
            () -> new MinecronInfusedCoal(new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));

    // Registers the Minecron Sword Tool Item
    public static final RegistryObject<Item> MINECRON_SWORD = ITEMS.register("minecron_sword",
            () -> new SwordItem(ModTiers.MINECRON, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));

    // Registers the Minecron Pickaxe Tool Item
    public static final RegistryObject<Item> MINECRON_PICKAXE = ITEMS.register("minecron_pickaxe",
            () -> new PickaxeItem(ModTiers.MINECRON, 1, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));

    // Registers the Minecron Axe Tool Item
    public static final RegistryObject<Item> MINECRON_AXE = ITEMS.register("minecron_axe",
            () -> new AxeItem(ModTiers.MINECRON, 4, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));

    // Registers the Minecron Shovel Tool Item
    public static final RegistryObject<Item> MINECRON_SHOVEL = ITEMS.register("minecron_shovel",
            () -> new ShovelItem(ModTiers.MINECRON, 0, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));

    // Registers the Minecron Hoe Tool Item
    public static final RegistryObject<Item> MINECRON_Hoe = ITEMS.register("minecron_hoe",
            () -> new HoeItem(ModTiers.MINECRON, 1, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.LEGENDS_OF_MINECRAFT)));


    // Makes sure Minecraft knows there are items to be added
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

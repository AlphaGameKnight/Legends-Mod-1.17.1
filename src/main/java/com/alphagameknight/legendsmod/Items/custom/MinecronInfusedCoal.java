package com.alphagameknight.legendsmod.Items.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class MinecronInfusedCoal extends Item {

    public MinecronInfusedCoal(Properties pProperties) {
        super(pProperties);
    }

    // Method to determine smelting time
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 1200;
    }

    // Tooltip for Minecron-Infused Coal
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.legendsmod.minecron_infused_coal"));
        }else{
            pTooltipComponents.add(new TranslatableComponent("tooltip.legendsmod.minecron_infused_coal_shift"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

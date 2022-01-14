package com.alphagameknight.legendsmod.data;

import com.alphagameknight.legendsmod.Blocks.ModBlocks;
import com.alphagameknight.legendsmod.Items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    // Recipe for Smart Blowtorch
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(ModItems.SMART_BLOW_TORCH.get())
                .define('O', ModItems.MINECRON_ORB.get())
                .define('S', ModItems.MINECRON_SHARD.get())
                .define('F', Items.FIRE_CHARGE)
                .pattern("FOS")
                .pattern(" SS")
                .pattern(" SS")
                .unlockedBy("has_material", has(ModItems.MINECRON_SHARD.get()))
                .save(pFinishedRecipeConsumer);
    }
}

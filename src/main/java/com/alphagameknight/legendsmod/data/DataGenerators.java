package com.alphagameknight.legendsmod.data;

import com.alphagameknight.legendsmod.LegendsMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

// Registers Data Generators
@Mod.EventBusSubscriber(modid = LegendsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void  gatherData(GatherDataEvent event){
       DataGenerator generator = event.getGenerator();

        generator.addProvider((new ModRecipeProvider(generator)));
        generator.addProvider((new ModLootTableProvider(generator)));

    }

}

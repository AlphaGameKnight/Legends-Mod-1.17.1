package com.alphagameknight.legendsmod.Items.custom;

import com.alphagameknight.legendsmod.Blocks.ModBlocks;
import com.alphagameknight.legendsmod.Items.ModItems;
import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class SmartBlowtorchItem extends Item {
    private static final Map<Block, Item> BLOW_TOCH_ITEM_CRAFT =
            new ImmutableMap.Builder<Block, Item>()
                    .put(ModBlocks.MINECRON_BLOCK.get(), ModItems.MINECRON_ORB.get())
                    .put(Blocks.SAND, Blocks.GLASS.asItem())
                    .build();



    public SmartBlowtorchItem(Properties pProperties) {
        super(pProperties);
    }

    // As a note, type override and check out the other methods that can be modified
    // Overrides the useOn method to turn a block into an item when right-clicked
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if(canBlowTorch(blockClicked)){
                ItemEntity entityItem = new ItemEntity(level,
                        positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(BLOW_TOCH_ITEM_CRAFT.get(blockClicked), 1));

                level.destroyBlock(positionClicked, false);
                level.addFreshEntity(entityItem);
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                    p.broadcastBreakEvent(pContext.getHand());
                });
            } else {
                pContext.getPlayer().sendMessage(new TextComponent("You can't blowtorch this block!"),
                        Util.NIL_UUID);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private boolean canBlowTorch(Block block){
        return BLOW_TOCH_ITEM_CRAFT.containsKey(block);
    }
}

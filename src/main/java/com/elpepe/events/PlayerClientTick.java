package com.elpepe.events;

import com.elpepe.Zbcosmetics;
import com.elpepe.config.ZbcosmeticsConfig;
import com.elpepe.items.ModItems;
import com.elpepe.items.custom.armor.BuilderHelmetItem;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LightBlock;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class PlayerClientTick {
    private static BlockPos lastPlacedBlockPos;

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(client.player != null && client.world != null) {
                ItemStack stack = client.player.getEquippedStack(EquipmentSlot.HEAD);
                if(lastPlacedBlockPos != null) {
                    client.world.setBlockState(lastPlacedBlockPos, Blocks.AIR.getDefaultState());
                    lastPlacedBlockPos = null;
                }

                if(stack.isOf(ModItems.BUILDER_HELMET) ) {
                    ZbcosmeticsConfig config = Zbcosmetics.config;
                    if (config.clientModule.builderHelmetEmitsLight) {
                        HitResult hitResult = client.player.raycast(6, client.getTickDelta(), false);

                        BlockPos posToPlaceLight = BlockPos.ofFloored(hitResult.getPos());

                        if (client.world.getBlockState(posToPlaceLight).isAir()) {
                            client.world.setBlockState(posToPlaceLight, Blocks.LIGHT.getDefaultState().with(LightBlock.LEVEL_15, 12));
                            lastPlacedBlockPos = posToPlaceLight;
                        }
                    }
                }
            }
        });
    }
}

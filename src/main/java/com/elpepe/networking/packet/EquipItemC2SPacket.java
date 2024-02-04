package com.elpepe.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public class EquipItemC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        ItemStack toEquip = buf.readItemStack();

        if(toEquip.getItem() instanceof Equipment) {
            ItemStack stack = player.getEquippedStack(((Equipment) toEquip.getItem()).getSlotType());
            player.setStackInHand(Hand.MAIN_HAND, stack);

            player.equipStack(((Equipment) toEquip.getItem()).getSlotType(), toEquip);
        }
    }
}

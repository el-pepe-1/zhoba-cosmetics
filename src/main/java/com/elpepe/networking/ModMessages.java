package com.elpepe.networking;

import com.elpepe.Zbcosmetics;
import com.elpepe.networking.packet.EquipItemC2SPacket;
import com.elpepe.networking.packet.SetItemInHandC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier SET_ITEM_IN_HAND_ID = new Identifier(Zbcosmetics.MOD_ID, "set_item_in_hand");
    public static final Identifier EQUIP_ITEM_ID = new Identifier(Zbcosmetics.MOD_ID, "equip_item");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(SET_ITEM_IN_HAND_ID, SetItemInHandC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(EQUIP_ITEM_ID, EquipItemC2SPacket::receive);
    }

    public static void registerS2CPackets() {

    }
}

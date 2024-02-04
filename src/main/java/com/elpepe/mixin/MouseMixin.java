package com.elpepe.mixin;

import com.elpepe.items.CosmeticArmor;
import com.elpepe.networking.ModMessages;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {
    @Shadow @Final private MinecraftClient client;

    @Inject(method = "onMouseButton", at = @At("TAIL"))
    private void onMouseClicked(long window, int button, int action, int mods, CallbackInfo ci) {
        if(client.player != null) {
            if(button == 1 && action == 0) {
                ItemStack stackInActiveHand = client.player.getStackInHand(Hand.MAIN_HAND);

                if(stackInActiveHand.getItem() instanceof CosmeticArmor && !client.player.isCreative() && !client.player.isSpectator()) {
                    PacketByteBuf buf = PacketByteBufs.create();
                    buf.writeItemStack(stackInActiveHand);

                    ClientPlayNetworking.send(ModMessages.EQUIP_ITEM_ID, buf);

                    client.player.playSound(((CosmeticArmor) stackInActiveHand.getItem()).getEquipSound(), 1f, 1f);
                }
            }
        }
    }
}

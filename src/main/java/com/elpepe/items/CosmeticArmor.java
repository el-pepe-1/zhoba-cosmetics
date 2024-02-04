package com.elpepe.items;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CosmeticArmor extends Item implements Equipment {
    private final EquipmentSlot slotType;

    private boolean hasDescription = false;
    private List<Text> description = new ArrayList<>();

    private SoundEvent equipSound = SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;

    public CosmeticArmor(Settings settings, EquipmentSlot slotType) {
        super(settings);
        this.slotType = slotType;
    }

    public CosmeticArmor addDescription(Text description) {
        if(!hasDescription) {
            hasDescription = true;
        }

        this.description.add(description);
        return this;
    }

    public CosmeticArmor setEquipSound(SoundEvent sound) {
        this.equipSound = sound;
        return this;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(hasDescription) {
            tooltip.add(Text.literal(" "));
            if(Screen.hasShiftDown()) {
                tooltip.addAll(description);
            }
            else {
                tooltip.add(Text.translatable("tooltip.zbcosmetics.press_shift"));
            }
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public EquipmentSlot getSlotType() {
        return this.slotType;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }
}

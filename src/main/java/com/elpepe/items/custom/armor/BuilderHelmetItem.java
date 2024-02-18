package com.elpepe.items.custom.armor;

import com.elpepe.items.CosmeticArmor;
import com.elpepe.items.custom.CosmeticArmor2DInGui;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class BuilderHelmetItem extends CosmeticArmor2DInGui {
    private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

    public BuilderHelmetItem(String modelName, Settings settings, EquipmentSlot slotType) {
        super(modelName, settings, slotType);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor modifier", 2f, EntityAttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == this.getSlotType() ? this.defaultModifiers : super.getAttributeModifiers(slot);
    }
}

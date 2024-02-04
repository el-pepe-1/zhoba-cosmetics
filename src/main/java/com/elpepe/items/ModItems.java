package com.elpepe.items;

import com.elpepe.Zbcosmetics;
import com.elpepe.items.custom.armor.BuilderHelmetItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COWBOY_HAT = registerItem("cowboy_hat", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item HAY_HAT = registerItem("hay_hat", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item BOW_KNOT_ABOBA = registerItem("bow_knot_aboba", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item BOW_KNOT_SAYORI = registerItem("bow_knot_sayori", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item ZARIF_CLOTH = registerItem("zarif_cloth", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item OLYOSHA = registerItem("olyosha", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item BUILDER_HELMET = registerItem("builder_helmet", new BuilderHelmetItem(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")).setEquipSound(SoundEvents.ITEM_ARMOR_EQUIP_IRON));
    public static final Item BIG_SHOT_GLASSES = registerItem("big_shot_glasses", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item SELIASET_HORNS = registerItem("seliaset_horns", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item PRESENT_HAT = registerItem("present_hat", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item CAKE_HAT = registerItem("cake_hat", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item CRAZY_DAVE = registerItem("crazy_dave", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item ANVIL_HAT = registerItem("anvil_hat", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")).setEquipSound(SoundEvents.BLOCK_ANVIL_LAND));
    public static final Item SOMBRERO = registerItem("sombrero", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));
    public static final Item OLEZHE_HAT = registerItem("olezhe_hat", new CosmeticArmor(new FabricItemSettings().maxCount(1), EquipmentSlot.HEAD).addDescription(Text.translatable("")));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Zbcosmetics.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Zbcosmetics.LOGGER.info("Registering mod items for " + Zbcosmetics.MOD_ID);
    }
}

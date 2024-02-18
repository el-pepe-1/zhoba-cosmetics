package com.elpepe.mixin;

import com.elpepe.items.Item2DInGui;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useCosmeticArmorModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider  vertexConsumerProvider) {
        if(stack.getItem() instanceof Item2DInGui item2DInGui && (renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND && renderMode != ModelTransformationMode.FIXED)) {
            return ((ItemRendererAccessor) this).zbcosmetics$getModels().getModelManager().getModel(new ModelIdentifier(item2DInGui.getModelPath(), "inventory"));
        }
        return value;
    }
}

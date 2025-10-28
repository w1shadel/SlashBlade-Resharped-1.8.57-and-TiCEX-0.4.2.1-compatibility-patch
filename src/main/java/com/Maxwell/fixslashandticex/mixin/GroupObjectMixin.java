package com.Maxwell.fixslashandticex.mixin;

import com.Maxwell.fixslashandticex.ColorHolder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mods.flammpfeil.slashblade.client.renderer.model.obj.Face;
import mods.flammpfeil.slashblade.client.renderer.model.obj.GroupObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GroupObject.class, remap = false)
public class GroupObjectMixin {

    @Redirect(
            method = "render(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lcom/mojang/blaze3d/vertex/PoseStack;II)V",
            at = @At(value = "INVOKE", target = "Lmods/flammpfeil/slashblade/client/renderer/model/obj/Face;addFaceForRender(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lcom/mojang/blaze3d/vertex/PoseStack;II)V")
    )
    private void injectCapturedInfo(Face face, VertexConsumer tessellator, PoseStack matrixStack, int light, int originalColor) {
        Integer capturedColor = ColorHolder.capturedColor.get();
        PoseStack capturedPoseStack = ColorHolder.capturedPoseStack.get();
        Integer capturedLight = ColorHolder.capturedLight.get();
        int finalColor = (capturedColor != null) ? capturedColor : originalColor;
        PoseStack finalPoseStack = (capturedPoseStack != null) ? capturedPoseStack : matrixStack;
        int finalLight = (capturedLight != null) ? capturedLight : light;
        face.addFaceForRender(tessellator, finalPoseStack, finalLight, finalColor);
    }
}
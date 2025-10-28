package com.Maxwell.fixslashandticex.mixin;

import com.Maxwell.fixslashandticex.ColorHolder;
import com.mojang.blaze3d.vertex.PoseStack;
import moffy.ticex.client.modules.slashblade.SBToolRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.awt.*;

@Mixin(value = SBToolRenderState.class, remap = false)
public class SBToolRenderStateMixin {
    @Redirect(method = "renderVC", at = @At(value = "INVOKE", target = "Lmods/flammpfeil/slashblade/client/renderer/model/obj/Face;setCol(Ljava/awt/Color;)V"))
    private static void redirectSetCol(Color color) {
        ColorHolder.capturedColor.set(color != null ? color.getRGB() : null);
    }
    @Redirect(method = "renderVC", at = @At(value = "INVOKE", target = "Lmods/flammpfeil/slashblade/client/renderer/model/obj/Face;resetCol()V"))
    private static void redirectResetCol() {
        ColorHolder.capturedColor.remove();
    }
    @Redirect(method = "renderVC", at = @At(value = "INVOKE", target = "Lmods/flammpfeil/slashblade/client/renderer/model/obj/Face;setLightMap(I)V"))
    private static void redirectSetLightMap(int packedLightIn) {
        ColorHolder.capturedLight.set(packedLightIn);
    }
    @Redirect(method = "renderVC", at = @At(value = "INVOKE", target = "Lmods/flammpfeil/slashblade/client/renderer/model/obj/Face;setMatrix(Lcom/mojang/blaze3d/vertex/PoseStack;)V"))
    private static void redirectSetMatrix(PoseStack matrixStackIn) {
        ColorHolder.capturedPoseStack.set(matrixStackIn);
    }
    @Redirect(method = "renderVC", at = @At(value = "INVOKE", target = "Lmods/flammpfeil/slashblade/client/renderer/model/obj/Face;resetLightMap()V"))
    private static void redirectResetLightMap() {
        ColorHolder.capturedLight.remove();
    }
    @Redirect(method = "renderVC", at = @At(value = "INVOKE", target = "Lmods/flammpfeil/slashblade/client/renderer/model/obj/Face;resetMatrix()V"))
    private static void redirectResetMatrix() {
        ColorHolder.capturedPoseStack.remove();
    }
}
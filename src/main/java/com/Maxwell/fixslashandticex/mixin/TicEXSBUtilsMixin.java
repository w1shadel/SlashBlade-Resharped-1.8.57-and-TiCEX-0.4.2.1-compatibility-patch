package com.Maxwell.fixslashandticex.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mods.flammpfeil.slashblade.client.renderer.model.obj.GroupObject;
import moffy.ticex.lib.utils.TicEXSBUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = TicEXSBUtils.class, remap = false)
public class TicEXSBUtilsMixin {
    @Redirect(
            method = "tessellateWithShader",
            at = @At(
                    value = "INVOKE",
                    target = "Lmods/flammpfeil/slashblade/client/renderer/model/obj/GroupObject;render(Lcom/mojang/blaze3d/vertex/VertexConsumer;)V"
            )
    )
    private static void redirectOldRenderCallToNew(GroupObject instance, VertexConsumer vertexConsumer) {
        instance.render(vertexConsumer, new PoseStack(), 0xF000F0, -1);
    }
}
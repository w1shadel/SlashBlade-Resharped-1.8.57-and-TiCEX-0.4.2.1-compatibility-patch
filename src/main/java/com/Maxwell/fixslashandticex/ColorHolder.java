package com.Maxwell.fixslashandticex;

import com.mojang.blaze3d.vertex.PoseStack;

public class ColorHolder {
    public static final ThreadLocal<Integer> capturedColor = new ThreadLocal<>();
    public static final ThreadLocal<PoseStack> capturedPoseStack = new ThreadLocal<>();
    public static final ThreadLocal<Integer> capturedLight = new ThreadLocal<>();
}
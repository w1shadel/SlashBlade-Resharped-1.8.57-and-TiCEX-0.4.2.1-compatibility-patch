package com.Maxwell.fixslashandticex;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Fix_slash_and_ticex.MODID)
public class Fix_slash_and_ticex
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "fixslashandticex";
    public Fix_slash_and_ticex(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
    }
}

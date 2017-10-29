package com.dse.dseMod.proxy;

import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		// custom loot table load
		System.out.println("common proxy preInit");
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}

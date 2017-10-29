package com.dse.dseMod.mamedol.as;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Yayoi extends MamedolBase{
	public Yayoi() {
		super();
		setUnlocalizedName("mamedol_as_yayoi");
		setRegistryName("mamedol_as_yayoi");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/as/yayoi");
	}
}

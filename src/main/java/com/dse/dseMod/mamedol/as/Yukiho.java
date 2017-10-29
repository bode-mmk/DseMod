package com.dse.dseMod.mamedol.as;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Yukiho extends MamedolBase{

	public Yukiho() {
		super();
		setUnlocalizedName("mamedol_as_yukiho");
		setRegistryName("mamedol_as_yukiho");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/as/yukiho");
	}
}

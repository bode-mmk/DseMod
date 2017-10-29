package com.dse.dseMod.mamedol.as;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Hibiki extends MamedolBase{
	public Hibiki() {
		super();
		setUnlocalizedName("mamedol_as_hibiki");
		setRegistryName("mamedol_as_hibiki");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/as/hibiki");
	}
}

package com.dse.dseMod.mamedol.as;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Iori extends MamedolBase{
	public Iori() {
		super();
		setUnlocalizedName("mamedol_as_iori");
		setRegistryName("mamedol_as_iori");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/as/iori");
	}
}

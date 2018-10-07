package com.dse.dseMod.mamedol.as;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Azusa extends MamedolBase {
	public Azusa() {
		super();
		setUnlocalizedName("mamedol_as_azusa");
		setRegistryName("mamedol_as_azusa");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return  new ModelResourceLocation("dsemod:mamedols/as/azusa");
	}

}

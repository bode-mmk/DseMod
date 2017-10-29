package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Sachiko extends MamedolBase{

	public Sachiko() {
		super();
		setUnlocalizedName("mamedol_cg_sachiko");
		setRegistryName("mamedol_cg_sachiko");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/sachiko");
	}
}

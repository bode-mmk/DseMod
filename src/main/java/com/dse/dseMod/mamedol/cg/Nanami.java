package com.dse.dseMod.mamedol.cg;

import com.dse.dseMod.mamedol.MamedolBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class Nanami extends MamedolBase{

	public Nanami() {
		super();
		setUnlocalizedName("mamedol_cg_nanami");
		setRegistryName("mamedol_cg_nanami");
	}

	@Override
	public ModelResourceLocation getModelResourceLocation() {
		return new ModelResourceLocation("dsemod:mamedols/cg/nanami");
	}
}

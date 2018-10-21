package com.dse.dseMod.block;

import net.minecraft.block.properties.PropertyEnum;

public abstract class BlockAodatami extends BlockDirectionedSlab {
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);
	public static class Double extends BlockAodatami
	{
		public Double() {
			super();
			this.setUnlocalizedName("aodatami_slab_double");
			this.setRegistryName("aodatami_slab_double");
		}

		@Override
		public boolean isDouble() {
			return true;
		}

	}

	public static class Half extends BlockAodatami
	{

		public Half() {
			super();
			this.setUnlocalizedName("aodatami_slab");
			this.setRegistryName("aodatami_slab");
		}

		@Override
		public boolean isDouble() {
			return false;
		}

	}
}

package com.dse.dseMod.entity;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;

public class EntityDsecartEmpty extends EntityDsecart {
	public EntityDsecartEmpty(World worldIn) {
		super(worldIn);
	}

	public EntityDsecartEmpty(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

    public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
    {
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.minecart.MinecartInteractEvent(this, player, hand))) return true;

        if (player.isSneaking())
        {
            return false;
        }
        else if (this.isBeingRidden())
        {
            return true;
        }
        else
        {
            if (!this.world.isRemote)
            {
                player.startRiding(this);
            }

            return true;
        }
    }

    public static void registerFixesMinecartEmpty(DataFixer fixer)
    {
        EntityMinecart.registerFixesMinecart(fixer, EntityDsecartEmpty.class);
    }
}

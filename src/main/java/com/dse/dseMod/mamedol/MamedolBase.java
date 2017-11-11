package com.dse.dseMod.mamedol;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


abstract public class MamedolBase extends Item {
	protected int stamina = 20;

	public MamedolBase() {
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(64);
	}

	abstract public ModelResourceLocation getModelResourceLocation();

	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
		if(!stack.hasTagCompound()) {
			// デフォルト値
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("stamina", 20);
			tag.setInteger("likability", 1);
			tag.setInteger("starrank", 1);
			stack.setTagCompound(tag);
		}

        return this.getUnlocalizedName();
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	if(stack.hasTagCompound()) {
    		tooltip.add(I18n.format("item.mamedol.parameter.stamina") + ":" + stack.getTagCompound().getInteger("stamina"));
    		tooltip.add(I18n.format("item.mamedol.parameter.likability") + ":" + stack.getTagCompound().getInteger("likability"));
    		tooltip.add(I18n.format("item.mamedol.parameter.starrank") + ":" + stack.getTagCompound().getInteger("starrank"));
    	}
    }

    public void decreaseStamina(ItemStack stack, int value) {
    	decreaseParameter(stack, "stamina", value);
    }

    public boolean decreaseParameter(ItemStack stack, String key, int value) {
    	if(stack.hasTagCompound()) {
    		NBTTagCompound tag = stack.getTagCompound();
    		if(tag.hasKey(key)) {
    			int parameter = tag.getInteger(key);
    			parameter -= value;
    			if(parameter < 0) {
    				parameter = 0;
    			}
    			tag.setInteger(key, parameter);
    			return true;
       		}else {
       			return false;
       		}
    	}

    	return false;
    }
}

package com.dse.dseMod.entity;

import com.dse.dseMod.DseMod;

import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityDsecart extends EntityMinecart {
	/*
    private static final DataParameter<Integer> ROLLING_AMPLITUDE = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> ROLLING_DIRECTION = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
    private static final DataParameter<Float> DAMAGE = EntityDataManager.<Float>createKey(EntityMinecart.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> DISPLAY_TILE = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> DISPLAY_TILE_OFFSET = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> SHOW_BLOCK = EntityDataManager.<Boolean>createKey(EntityMinecart.class, DataSerializers.BOOLEAN);
    */

    /** Minecart rotational logic matrix (from EntityMinecart) */
    private static final int[][][] MATRIX = new int[][][] {{{0, 0, -1}, {0, 0, 1}}, {{ -1, 0, 0}, {1, 0, 0}}, {{ -1, -1, 0}, {1, 0, 0}}, {{ -1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, { -1, 0, 0}}, {{0, 0, -1}, { -1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};

    public EntityDsecart(World worldIn)
    {
        super(worldIn);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.7F);
    }

    public EntityDsecart(World worldIn, double x, double y, double z) {
    	this(worldIn);
    	this.setPosition(x, y, z);
    	this.motionX = 0.0D;
    	this.motionY = 0.0D;
    	this.motionZ = 0.0D;
    	this.prevPosX = x;
    	this.prevPosY = y;
    	this.prevPosZ = z;
    }

    public boolean hasNoGravity() {
    	return true;
    }

    protected void entityInit()
    {
    	super.entityInit();
    	/*
    	this.dataManager = new EntityDataManager(this);
        this.dataManager.register(ROLLING_AMPLITUDE, Integer.valueOf(0));
        this.dataManager.register(ROLLING_DIRECTION, Integer.valueOf(1));
        this.dataManager.register(DAMAGE, Float.valueOf(0.0F));
        this.dataManager.register(DISPLAY_TILE, Integer.valueOf(0));
        this.dataManager.register(DISPLAY_TILE_OFFSET, Integer.valueOf(6));
        this.dataManager.register(SHOW_BLOCK, Boolean.valueOf(false));
        */
    }

    public static EntityDsecart create(World worldIn, double x, double y, double z, EntityMinecart.Type typeIn) {
    	return new EntityDsecartEmpty(worldIn, x, y, z);
    }

	@Override
	public Type getType() {
		// TODO 自動生成されたメソッド・スタブ
		return EntityMinecart.Type.RIDEABLE;
	}

    protected double getMaximumSpeed()
    {
        return 1.2D;
    }

    public float getMaxCartSpeedOnRail()
    {
        return 1.2f;
    }

    protected double getMaxSpeed()
    {
    	return 30.0D;
    }

    @SuppressWarnings("incomplete-switch")
    protected void moveAlongTrack(BlockPos pos, IBlockState state)
    {
        this.fallDistance = 0.0F;
        Vec3d vec3d = this.getPos(this.posX, this.posY, this.posZ);
        this.posY = (double)pos.getY();
        boolean flag = false;
        boolean flag1 = false;
        boolean is_dse_active_flag = false;
        boolean is_dse_no_active_flag = false;
        BlockRailBase blockrailbase = (BlockRailBase)state.getBlock();

        if (blockrailbase == Blocks.GOLDEN_RAIL)
        {
            flag = ((Boolean)state.getValue(BlockRailPowered.POWERED)).booleanValue();
            flag1 = !flag;
        }

        // どすえれーるの時のフラグを見る
        if(blockrailbase == DseMod.BLOCKS.rail_dse) {
        	is_dse_active_flag = ((Boolean)state.getValue(BlockRailPowered.POWERED)).booleanValue();
        	is_dse_no_active_flag = !is_dse_active_flag;
        }

        double slopeAdjustment = getSlopeAdjustment();
        BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = blockrailbase.getRailDirection(world, pos, state, this);

        switch (blockrailbase$enumraildirection)
        {
            case ASCENDING_EAST:
                this.motionX -= slopeAdjustment;
                ++this.posY;
                break;
            case ASCENDING_WEST:
                this.motionX += slopeAdjustment;
                ++this.posY;
                break;
            case ASCENDING_NORTH:
                this.motionZ += slopeAdjustment;
                ++this.posY;
                break;
            case ASCENDING_SOUTH:
                this.motionZ -= slopeAdjustment;
                ++this.posY;
        }

        int[][] aint = MATRIX[blockrailbase$enumraildirection.getMetadata()];
        double d1 = (double)(aint[1][0] - aint[0][0]);
        double d2 = (double)(aint[1][2] - aint[0][2]);
        double d3 = Math.sqrt(d1 * d1 + d2 * d2);
        double d4 = this.motionX * d1 + this.motionZ * d2;

        if (d4 < 0.0D)
        {
            d1 = -d1;
            d2 = -d2;
        }

        double d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

        if (d5 > 2.0D)
        {
            d5 = 2.0D;
        }

        this.motionX = d5 * d1 / d3;
        this.motionZ = d5 * d2 / d3;
        Entity entity = this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);

        if (entity instanceof EntityLivingBase)
        {
            double d6 = (double)((EntityLivingBase)entity).moveForward;

            if (d6 > 0.0D)
            {
                double d7 = -Math.sin((double)(entity.rotationYaw * 0.017453292F));
                double d8 = Math.cos((double)(entity.rotationYaw * 0.017453292F));
                double d9 = this.motionX * this.motionX + this.motionZ * this.motionZ;

                if (d9 < 0.01D)
                {
                    this.motionX += d7 * 0.1D;
                    this.motionZ += d8 * 0.1D;
                    flag1 = false;
                }
            }
        }

        if (flag1 && shouldDoRailFunctions())
        {
            double d17 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

            if (d17 < 0.03D)
            {
            	this.motionX *= 0.0D;
            	this.motionY *= 0.0D;
            	this.motionZ *= 0.0D;
            }
            else
            {
            	this.motionX *= 0.78D;
            	this.motionY *= 0.0D;
            	this.motionZ *= 0.78D;
            }
        }

        if(is_dse_no_active_flag && shouldDoRailFunctions()) {
           	// 通常のスピード以下ならそのまま緩やかに減速
        	double dd_speed_vector = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        	// sqrt(0.4^2 + 0.4^2) ≒ 0.56D
        	if(dd_speed_vector < 0.56D) {
        		this.motionX *= 0.98D;
        		this.motionY *= 0.0D;
        		this.motionZ *= 0.98D;
        	}else {
        		// それ以上は急激に減速
        		this.motionX *= 0.8D;
        		this.motionY *= 0.0D;
        		this.motionZ *= 0.8D;
        	}
        }

        double d18 = (double)pos.getX() + 0.5D + (double)aint[0][0] * 0.5D;
        double d19 = (double)pos.getZ() + 0.5D + (double)aint[0][2] * 0.5D;
        double d20 = (double)pos.getX() + 0.5D + (double)aint[1][0] * 0.5D;
        double d21 = (double)pos.getZ() + 0.5D + (double)aint[1][2] * 0.5D;
        d1 = d20 - d18;
        d2 = d21 - d19;
        double d10;

        if (d1 == 0.0D)
        {
            this.posX = (double)pos.getX() + 0.5D;
            d10 = this.posZ - (double)pos.getZ();
        }
        else if (d2 == 0.0D)
        {
            this.posZ = (double)pos.getZ() + 0.5D;
            d10 = this.posX - (double)pos.getX();
        }
        else
        {
            double d11 = this.posX - d18;
            double d12 = this.posZ - d19;
            d10 = (d11 * d1 + d12 * d2) * 2.0D;
        }

        this.posX = d18 + d1 * d10;
        this.posZ = d19 + d2 * d10;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.moveMinecartOnRail(pos);

        if (aint[0][1] != 0 && MathHelper.floor(this.posX) - pos.getX() == aint[0][0] && MathHelper.floor(this.posZ) - pos.getZ() == aint[0][2])
        {
            this.setPosition(this.posX, this.posY + (double)aint[0][1], this.posZ);
        }
        else if (aint[1][1] != 0 && MathHelper.floor(this.posX) - pos.getX() == aint[1][0] && MathHelper.floor(this.posZ) - pos.getZ() == aint[1][2])
        {
            this.setPosition(this.posX, this.posY + (double)aint[1][1], this.posZ);
        }

        this.applyDrag();
        Vec3d vec3d1 = this.getPos(this.posX, this.posY, this.posZ);

        if (vec3d1 != null && vec3d != null)
        {
            double d14 = (vec3d.y - vec3d1.y) * 0.05D;
            d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

            if (d5 > 0.0D)
            {
                this.motionX = this.motionX / d5 * (d5 + d14);
                this.motionZ = this.motionZ / d5 * (d5 + d14);
            }

            this.setPosition(this.posX, vec3d1.y, this.posZ);
        }

        int j = MathHelper.floor(this.posX);
        int i = MathHelper.floor(this.posZ);

        if (j != pos.getX() || i != pos.getZ())
        {
            d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.motionX = d5 * (double)(j - pos.getX());
            this.motionZ = d5 * (double)(i - pos.getZ());
        }


        if(shouldDoRailFunctions())
        {
            ((BlockRailBase)state.getBlock()).onMinecartPass(world, this, pos);
        }

        if ((flag && shouldDoRailFunctions()) || (is_dse_active_flag && shouldDoRailFunctions()))
        {
            double d15 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

            if (d15 > 0.01D)
            {
                double d16 = 0.06D;

                // dse railの場合は3倍
                if(is_dse_active_flag) {
                	d16 = 0.18D;
                }
                this.motionX += this.motionX / d15 * d16;
                this.motionZ += this.motionZ / d15 * d16;
            }
            else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.EAST_WEST)
            {
                if (this.world.getBlockState(pos.west()).isNormalCube())
                {
                    this.motionX = 0.2D;
                }
                else if (this.world.getBlockState(pos.east()).isNormalCube())
                {
                    this.motionX = -0.2D;
                }
            }
            else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.NORTH_SOUTH)
            {
                if (this.world.getBlockState(pos.north()).isNormalCube())
                {
                    this.motionZ = 0.2D;
                }
                else if (this.world.getBlockState(pos.south()).isNormalCube())
                {
                    this.motionZ = -0.2D;
                }
            }
        }
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!this.world.isRemote && !this.isDead)
        {
            if (this.isEntityInvulnerable(source))
            {
                return false;
            }
            else
            {
                this.setRollingDirection(-this.getRollingDirection());
                this.setRollingAmplitude(10);
                this.setBeenAttacked();
                this.setDamage(this.getDamage() + amount * 10.0F);
                boolean flag = source.getTrueSource() instanceof EntityPlayer && ((EntityPlayer)source.getTrueSource()).capabilities.isCreativeMode;

                if (flag || this.getDamage() > 400.0F)
                {
                    this.removePassengers();

                    if (flag && !this.hasCustomName())
                    {
                        this.setDead();
                    }
                    else
                    {
                        this.killMinecart(source);
                    }
                }

                return true;
            }
        }
        else
        {
            return true;
        }
    }

    public void killMinecart(DamageSource source)
    {
        this.setDead();

        if (this.world.getGameRules().getBoolean("doEntityDrops"))
        {
            ItemStack itemstack = new ItemStack(DseMod.ITEMS.dsecart, 1);

            if (this.hasCustomName())
            {
                itemstack.setStackDisplayName(this.getCustomNameTag());
            }

            this.entityDropItem(itemstack, 0.0F);
        }
    }

}

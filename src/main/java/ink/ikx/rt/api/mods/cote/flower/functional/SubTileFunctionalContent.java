package ink.ikx.rt.api.mods.cote.flower.functional;

import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.EntityHelper;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.CTPlayer;
import com.teamacronymcoders.contenttweaker.api.ctobjects.enums.Hand;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import java.util.Objects;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.SubTileFunctional;

public class SubTileFunctionalContent extends SubTileFunctional implements SubTileEntityInGame {

    public String name;
    public final SubTileRepresentation subtile;

    public SubTileFunctionalContent(SubTileRepresentation subtile) {
        this.subtile = subtile;
    }

    @Override
    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(toBlockPos(), subtile.getRange());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, entity, stack);
        if (Objects.nonNull(subtile.onBlockPlaceBy)) {
            subtile.onBlockPlaceBy.call(CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getBlockState(state), EntityHelper.getIEntityLivingBase(entity), CraftTweakerMC.getIItemStack(stack));
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        return Objects.nonNull(subtile.onBlockActivated) && subtile.onBlockActivated.call(CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getBlockState(state), new CTPlayer(player), Hand.of(hand), CraftTweakerMC.getIFacing(side), hitX, hitY, hitZ);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        if (Objects.nonNull(subtile.onBlockAdded)) {
            subtile.onBlockAdded.call(CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getBlockState(state));
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (Objects.nonNull(subtile.onBlockHarvested)) {
            subtile.onBlockHarvested.call(CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getBlockState(state), new CTPlayer(player));
        }
    }

    @Override
    public boolean isOvergrowthAffected() {
        return subtile.isOvergrowthAffected();
    }

    @Override
    public int getMaxMana() {
        return subtile.getMaxMana();
    }

    @Override
    public int getColor() {
        return subtile.getColor();
    }

    @Override
    public boolean canSelect(EntityPlayer player, ItemStack wand, BlockPos pos, EnumFacing side) {
        if (Objects.nonNull(subtile.canSelect)) {
            return subtile.canSelect.call(new CTPlayer(player), CraftTweakerMC.getIItemStack(wand), CraftTweakerMC.getIBlockPos(pos), CraftTweakerMC.getIFacing(side));
        }
        return true;
    }

    @Override
    public void readFromPacketNBT(NBTTagCompound compound) {
        customData.readFromNBT(compound.getCompoundTag(TAG_CUSTOM_DATA));
        this.name = compound.getString(TAG_NAME);
        super.readFromPacketNBT(compound);
    }

    @Override
    public void writeToPacketNBT(NBTTagCompound compound) {
        if (!compound.hasKey(TAG_CUSTOM_DATA)) {
            compound.setTag(TAG_CUSTOM_DATA, new NBTTagCompound());
        }
        customData.writeToNBT(compound.getCompoundTag(TAG_NAME));
        customData.writeToNBT(compound.getCompoundTag(TAG_CUSTOM_DATA));
        super.writeToPacketNBT(compound);
    }

    @Override
    public void addMana(int mana) {
        super.addMana(mana);
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public int getRedstoneSignal() {
        return this.redstoneSignal;
    }

    @Override
    public int getPassiveDecayTicks() {
        return 0;
    }

    @Override
    public void sync() {
        super.sync();
    }

    @Override
    public boolean acceptsRedstone() {
        return super.acceptsRedstone();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
    }

    @Override
    public boolean isValidBinding() {
        return super.isValidBinding();
    }

    @Override
    public BlockPos getBinding() {
        return super.getBinding();
    }

    @Override
    public String typeOf() {
        return "functional";
    }

    @Override
    public String getUnlocalizedName() {
        return subtile.getUnlocalizedName();
    }

    @Override
    public Object getInstance() {
        return subtile;
    }

    public static class Mini extends SubTileFunctionalContent {

        public Mini(SubTileRepresentation subtile) {
            super(subtile);
        }

        @Override
        public RadiusDescriptor getRadius() {
            return new RadiusDescriptor.Square(toBlockPos(), ((SubTileFunctionalRepresentation) subtile).getMiniRange());
        }

        @Override
        public String getUnlocalizedName() {
            return super.getUnlocalizedName() + "Chibi";
        }
    }
}

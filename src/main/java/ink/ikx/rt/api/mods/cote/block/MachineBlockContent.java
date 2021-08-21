package ink.ikx.rt.api.mods.cote.block;

import com.teamacronymcoders.contenttweaker.modules.vanilla.blocks.BlockContent;
import ink.ikx.rt.api.mods.cote.block.tile.TileEntityContent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import youyihj.zenutils.api.cotx.annotation.ExpandContentTweakerEntry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

@ExpandContentTweakerEntry
public class MachineBlockContent extends BlockContent {

    private final MachineBlockRepresentation machineBlockRepresentation;

    public MachineBlockContent(MachineBlockRepresentation machineBlockRepresentation) {
        super(machineBlockRepresentation);
        this.machineBlockRepresentation = machineBlockRepresentation;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return Objects.nonNull(machineBlockRepresentation.tileEntity);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(@Nullable World world, @Nonnull IBlockState state) {
        return hasTileEntity(state) ? new TileEntityContent(machineBlockRepresentation.tileEntity.getId()) : null;
    }
}

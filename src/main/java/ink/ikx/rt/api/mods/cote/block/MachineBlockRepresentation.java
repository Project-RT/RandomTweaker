package ink.ikx.rt.api.mods.cote.block;

import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.modules.vanilla.blocks.BlockRepresentation;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.api.mods.cote.block.tile.TileEntityRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.Block")
public class MachineBlockRepresentation extends BlockRepresentation {

    @ZenProperty
    public TileEntityRepresentation tileEntity;

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(BlockRegistry.class, "BLOCK").register(new MachineBlockContent(this));
    }
}

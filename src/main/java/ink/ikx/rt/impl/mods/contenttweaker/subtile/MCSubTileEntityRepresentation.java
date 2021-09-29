package ink.ikx.rt.impl.mods.contenttweaker.subtile;

import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.functional.ISubTileEntityFunctionalRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.generating.ISubTileEntityGeneratingRepresentation;

public class MCSubTileEntityRepresentation extends ISubTileEntityRepresentation {

    public MCSubTileEntityRepresentation(int color, String unlocalizedName) {
        super(color, unlocalizedName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ISubTileEntityRepresentation that = (ISubTileEntityRepresentation) o;

        return unlocalizedName.equals(that.unlocalizedName);
    }

    @Override
    public int hashCode() {
        return unlocalizedName.hashCode();
    }

    public static class MCSubTileEntityGeneratingRepresentation extends ISubTileEntityGeneratingRepresentation {

        public MCSubTileEntityGeneratingRepresentation(int color, String unlocalizedName) {
            super(color, unlocalizedName);
        }

    }

    public static class MCSubTileEntityFunctionalRepresentation extends ISubTileEntityFunctionalRepresentation {

        public MCSubTileEntityFunctionalRepresentation(int color, String unlocalizedName) {
            super(color, unlocalizedName);
        }

    }

}

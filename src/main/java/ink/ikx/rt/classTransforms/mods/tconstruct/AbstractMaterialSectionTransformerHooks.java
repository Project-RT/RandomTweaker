package ink.ikx.rt.classTransforms.mods.tconstruct;

import ink.ikx.rt.Main;
import slimeknights.mantle.client.gui.book.element.ElementItem;
import slimeknights.tconstruct.library.materials.Material;


public class AbstractMaterialSectionTransformerHooks {

    public static boolean isMaterialInHiddenItems(Material material) {
        return Main.HIDDEN_MATERIAL_LIST.contains(material.getIdentifier());
    }

    public static boolean isMaterialInShowItemMap(Material material) {
        return Main.MATERIAL_SHOW_ITEM_MAP.containsKey(material.getIdentifier());
    }

    public static ElementItem createElementItem(Material material) {
        return new ElementItem(0, 0, 1.0F, Main.MATERIAL_SHOW_ITEM_MAP.get(material.getIdentifier()));
    }
}

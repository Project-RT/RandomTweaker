package ink.ikx.rt.classTransforms.mods.tconstruct;

import ink.ikx.rt.api.mods.tconstruct.IBook;
import slimeknights.mantle.client.gui.book.element.ElementItem;
import slimeknights.tconstruct.library.materials.Material;

import static ink.ikx.rt.api.mods.tconstruct.IBook.MATERIAL_SHOW_ITEM_MAP;

public class AbstractMaterialSectionTransformerHooks {

    public static boolean isMaterialInHiddenItems(Material material) {
        return IBook.HIDDEN_MATERIAL_LIST.contains(material.getIdentifier());
    }

    public static boolean isMaterialInShowItemMap(Material material) {
        return IBook.MATERIAL_SHOW_ITEM_MAP.containsKey(material.getIdentifier());
    }

    public static ElementItem createElementItem(Material material) {
        return new ElementItem(0, 0, 1.0F, MATERIAL_SHOW_ITEM_MAP.get(material.getIdentifier()));
    }
}

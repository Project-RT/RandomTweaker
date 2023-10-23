package ink.ikx.rt.classTransforms.mods.tconstruct;

import ink.ikx.rt.Main;
import slimeknights.mantle.client.gui.book.element.ElementItem;
import slimeknights.tconstruct.library.materials.Material;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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

    public static List<Material> sortMaterialList(List<Material> materialList) {
        return materialList.stream()
                .sorted(Comparator.comparing(m -> Main.MATERIAL_PRIORITY_MAP.getOrDefault(m.getIdentifier(), 0)))
                .collect(Collectors.toList());
    }

}

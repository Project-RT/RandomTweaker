package ink.ikx.rt.mixins.tinkers;


import crafttweaker.api.minecraft.CraftTweakerMC;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import slimeknights.mantle.client.book.data.SectionData;
import slimeknights.mantle.client.book.data.content.PageContent;
import slimeknights.mantle.client.book.data.element.ImageData;
import slimeknights.mantle.client.book.repository.BookRepository;
import slimeknights.mantle.client.gui.book.element.ElementImage;
import slimeknights.mantle.client.gui.book.element.ElementItem;
import slimeknights.mantle.client.gui.book.element.SizedBookElement;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.book.content.ContentPageIconList;
import slimeknights.tconstruct.library.book.sectiontransformer.AbstractMaterialSectionTransformer;
import slimeknights.tconstruct.library.book.sectiontransformer.SectionTransformer;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.PageData;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import static ink.ikx.rt.api.mods.tinkers.IBook.hiddenmaterialList;
import static ink.ikx.rt.api.mods.tinkers.IBook.materialshowitem;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2023/10/3 18:58
 */
@Mixin(value = AbstractMaterialSectionTransformer.class, remap = false)
public abstract class MixinAbstractMaterialSectionTransformer extends SectionTransformer {



    public MixinAbstractMaterialSectionTransformer(String sectionName) {
        super(sectionName);
    }

    @Shadow
    protected abstract boolean isValidMaterial(Material var1);

    @Shadow
    protected abstract PageContent getPageContent(Material var1);

    /**
     * @author
     * @reason
     */
    @Overwrite
    public void transform(BookData book, SectionData data) {
        data.source = BookRepository.DUMMY;
        data.parent = book;
        List<Material> materialList = TinkerRegistry.getAllMaterials().stream().filter((m) -> !m.isHidden()).filter(Material::hasItems).filter(this::isValidMaterial).collect(Collectors.toList());


        if (!materialList.isEmpty()) {
            List<ContentPageIconList> listPages = ContentPageIconList.getPagesNeededForItemCount(materialList.size(), data, book.translate(this.sectionName));
            ListIterator<ContentPageIconList> iter = listPages.listIterator();
            ContentPageIconList overview = (ContentPageIconList)iter.next();
            Iterator var7 = materialList.iterator();

            while(var7.hasNext()) {
                Material material = (Material)var7.next();
                if (!hiddenmaterialList.contains(material.getIdentifier())) {
                    PageData page = this.addPage(data, material.getIdentifier(), "toolmaterial", this.getPageContent(material));
                    Object icon;
                    if (material.getRepresentativeItem() != null) {
                        icon = new ElementItem(0, 0, 1.0F, material.getRepresentativeItem());
                    } else {
                        icon = new ElementImage(ImageData.MISSING);
                    }

                    if (materialshowitem.containsKey(material.getIdentifier()))
                        icon = new ElementItem(0, 0, 1.0F, CraftTweakerMC.getItemStack(materialshowitem.get(material.getIdentifier())));

                    while (!overview.addLink((SizedBookElement) icon, material.getLocalizedNameColored(), page)) {
                        overview = (ContentPageIconList) iter.next();
                    }
                }
            }

        }
    }
}

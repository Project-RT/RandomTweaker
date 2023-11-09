package ink.ikx.rt.classTransforms;

import ink.ikx.rt.classTransforms.mods.astralsorcery.ASMTileAttunementAltar;
import ink.ikx.rt.classTransforms.mods.tconstruct.ASMAbstractMaterialSectionTransformer;
import ink.ikx.rt.classTransforms.vanilla.ASMItemStack;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;

import static org.objectweb.asm.Opcodes.ASM5;

public class RandomTweakerClassTransformer implements IClassTransformer {

    private ClassWriter createClassWriter(@SuppressWarnings("SameParameterValue") boolean debug) {
        return new RandomTweakerClassWriter(debug ? 0 : ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
    }

    private ClassWriter createDefaultClassWriter(@SuppressWarnings("SameParameterValue") boolean debug) {
        return new ClassWriter(debug ? 0 : ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
    }

    private byte[] tryGetAsmResult(
            String modName,
            byte[] basicClass,
            ClassVisitor visitor,
            ClassWriter writer,
            @SuppressWarnings("SameParameterValue") boolean debug
    ) {
        try {
            LogManager.getLogger().info("On {} class visitor", modName);
            ClassReader classReader = new ClassReader(basicClass);
            classReader.accept(visitor, 0);
            byte[] toReturn = writer.toByteArray();
            if (debug) FileUtils.writeByteArrayToFile(new File("ASMDebug.class"), toReturn);
            return toReturn;
        } catch (Exception e) {
            LogManager.getLogger().error("Error loading {} ASM", modName, e);
        }
        return basicClass;
    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("hellfirepvp.astralsorcery.common.tile.TileAttunementAltar")) {
            LogManager.getLogger().info("transforming class {} ({})", transformedName, name);
            ClassWriter classWriter = createClassWriter(false);
            ASMTileAttunementAltar asm = new ASMTileAttunementAltar(ASM5, classWriter);
            return tryGetAsmResult("astral sorcery", basicClass, asm, classWriter, false);
        }
        if (transformedName.equals("slimeknights.tconstruct.library.book.sectiontransformer.AbstractMaterialSectionTransformer")) {
            LogManager.getLogger().info("transforming class {} ({})", transformedName, name);
            ClassWriter classWriter = createClassWriter(false);
            ASMAbstractMaterialSectionTransformer asm = new ASMAbstractMaterialSectionTransformer(ASM5, classWriter);
            return tryGetAsmResult("tinkers construct", basicClass, asm, classWriter, false);
        }
        if (transformedName.equals("net.minecraft.item.ItemStack")) {
            LogManager.getLogger().info("transforming class {} ({})", transformedName, name);
            ClassWriter classWriter = createDefaultClassWriter(false);
            ASMItemStack asm = new ASMItemStack(ASM5, classWriter, name);
           return tryGetAsmResult("vanilla", basicClass, asm, classWriter, false);
        }
        return basicClass;
    }
}

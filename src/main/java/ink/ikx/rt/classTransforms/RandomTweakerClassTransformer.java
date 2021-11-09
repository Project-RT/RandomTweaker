package ink.ikx.rt.classTransforms;

import ink.ikx.rt.classTransforms.mods.astralsorcery.ASMTileAttunementAltar;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM5;

public class RandomTweakerClassTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (transformedName.equals("hellfirepvp.astralsorcery.common.tile.TileAttunementAltar")) {
            LogManager.getLogger().info("transforming class {}", transformedName);
            ClassWriter writer = new ClassWriter(0);
            ASMTileAttunementAltar asm = new ASMTileAttunementAltar(ASM5, writer);
            try {
                System.out.println("on astral sorcery class visitor");
                ClassReader classReader = new ClassReader("hellfirepvp.astralsorcery.common.tile.TileAttunementAltar");
                classReader.accept(asm, 0);
                byte[] result = writer.toByteArray();
                /*
                Path dir = Paths.get("rtDebug");
                Files.createDirectories(dir);
                Files.write(dir.resolve("TileAttunementAltar.class"), result);
                 */
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return basicClass;
    }
}

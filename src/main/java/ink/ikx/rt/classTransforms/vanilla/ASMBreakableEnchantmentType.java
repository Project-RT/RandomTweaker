package ink.ikx.rt.classTransforms.vanilla;

import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author youyihj
 */
public class ASMBreakableEnchantmentType extends ClassVisitor {
    private final String className;

    public ASMBreakableEnchantmentType(int api, ClassVisitor cv, String className) {
        super(api, cv);
        this.className = className;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        String methodName = FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(className, name, desc);
        if (methodName.equals("func_77557_a") || methodName.equals("canEnchantItem")) {
            return new ASMCanEnchantItem(api, super.visitMethod(access, name, desc, signature, exceptions));
        }

        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}

class ASMCanEnchantItem extends MethodVisitor implements Opcodes {

    public ASMCanEnchantItem(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        Label remain = new Label();
        super.visitVarInsn(ALOAD, 1);
        super.visitMethodInsn(INVOKESTATIC, "ink/ikx/rt/classTransforms/vanilla/Hooks", "isInBreakableEnchantmentBlacklist", "(Lnet/minecraft/item/Item;)Z", false);
        super.visitJumpInsn(IFEQ, remain);
        super.visitInsn(ICONST_0);
        super.visitInsn(IRETURN);
        super.visitLabel(remain);
    }
}

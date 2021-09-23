package ink.ikx.rt.impl.mods.crafttweaker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a certain class is only available when all mod matches are
 * available.
 *
 * @author ikexing
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModTotal {

    String[] value() default {};

}

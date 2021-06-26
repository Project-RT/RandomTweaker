package ink.ikx.rt.api.instance.file;

import ink.ikx.rt.RandomTweaker;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.randomtweaker.Prop")
public class Prop {

    private static final boolean ISWINDOWS = System.getProperties().getProperty("os.name").startsWith("Windows");
    private static final String MARK = ISWINDOWS ? "\\" : "/";
    private static final String FILE = getPath(System.getProperty("user.dir"), RandomTweaker.MODID + ".prop");

    @ZenMethod
    public static String read(String key) throws IOException {
        Properties prop = new Properties();
        try (FileReader fr = new FileReader(FILE)) {
            prop.load(fr);
        }
        return prop.getProperty(key);
    }

    @ZenMethod
    public static void writer(String key, String value) throws IOException {
        Properties prop = new Properties();
        try (FileReader fr = new FileReader(FILE)) {
            prop.load(fr);
            prop.setProperty(key, value);
            try (FileWriter fw = new FileWriter(FILE)) {
                prop.store(fw, null);
            }
        }
    }

    @ZenMethod
    public static String[] getAllKeys() throws IOException {
        List<String> keys = new ArrayList<>();

        Properties prop = new Properties();
        try (FileReader fr = new FileReader(FILE)) {
            prop.load(fr);
            prop.keySet().forEach(s -> keys.add((String) s));
        }
        return keys.toArray(new String[0]);
    }

    public static boolean createOrDelete(boolean flag) throws IOException {
        File file = new File(FILE);
        if (flag) {
            if (!file.exists()) {
                file.createNewFile();
            }
        } else {
            if (file.exists()) {
                file.delete();
            }
        }
        return flag;
    }

    public static String getPath(String... path) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : path) {
            sb.append(sb.toString().endsWith(MARK) ? s1 : (MARK + s1));
        }
        return sb.toString();
    }
}
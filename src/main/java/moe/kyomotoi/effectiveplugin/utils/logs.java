package moe.kyomotoi.effectiveplugin.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class logs {
    
    public static BukkitLog log;

    public static File file;

    public logs(File file) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd--HH-mm-ss");
        Date date = new Date();

        logs.file = new File(file, sdf.format(date) + ".log");
        if (!logs.file.exists()) {
            file.createNewFile();
        }
    }

    public static void logStore(String text) {
        FileWriter fw = null;
        PrintWriter pw = new PrintWriter(fw);
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd--HH:mm:ss");
        Date date = new Date();

        try {
            fw = new FileWriter(file, true);
            String w = "EffectivePlugin | " + sdf.format(date) + " >> " + text;
            //pw.println(w);
            pw.flush();
            fw.flush();
            pw.close();
            fw.close();
        } catch (Exception e) {
            log.warning("§c[EffectivePlugin] 日志写入失败" + e.getMessage());
        }
    }
}

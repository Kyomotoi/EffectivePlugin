package moe.kyomotoi.effectiveplugin.utils;

import moe.kyomotoi.effectiveplugin.API.SelfLogger;

import java.util.logging.Logger;

public class BukkitLog implements SelfLogger {

    private final Logger Logger;

    public BukkitLog(Logger Logger) {
        this.Logger = Logger;
    }

    @Override
    public void info(String data) {
        Logger.info(data);
    }

    @Override
    public void warning(String data) {
        Logger.warning(data);
    }
}

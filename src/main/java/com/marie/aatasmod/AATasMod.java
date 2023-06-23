package com.marie.aatasmod;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AATasMod implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void onInitialize() {
        LOGGER.info("Hi chat");
    }
}

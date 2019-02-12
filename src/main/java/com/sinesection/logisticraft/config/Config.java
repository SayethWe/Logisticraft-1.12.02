package com.sinesection.logisticraft.config;
import org.apache.logging.log4j.Level;

import com.sinesection.logisticraft.Logisticraft;
import com.sinesection.logisticraft.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;

public class Config {

	private static final String CATEGORY_GENERAL = "general";
	private static final String GENERAL_COMMENT = "General Configuration";
	private static final String ERROR_TEXT = "Error loading config file";
	
	//config values
	public static int timeModifier;
	
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initGeneralConfig(cfg);
		} catch (Exception e1) {
			Logisticraft.logger.log(Level.ERROR, ERROR_TEXT, e1);
		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, GENERAL_COMMENT);
		cfg.getInt("timeModifier", CATEGORY_GENERAL, 1, 0, 255, "a multiplier on how much time processing takes");
	}
	
}

package me.bodiw.adminscreen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;

public class Mod implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("adminscreen");

	@Override
	public void onInitialize() {
		LOGGER.info("Admin commands has loaded");
	}
}

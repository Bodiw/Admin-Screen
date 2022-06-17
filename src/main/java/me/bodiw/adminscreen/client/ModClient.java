package me.bodiw.adminscreen.client;

import org.lwjgl.glfw.GLFW;

import me.bodiw.adminscreen.client.screen.AdminScreen;
import me.bodiw.adminscreen.client.serializer.CommandSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

@Environment(EnvType.CLIENT)
public class ModClient implements ClientModInitializer {

    public static final KeyBinding adminKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.adminscreen.openscreen", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, "category.adminscreen.adminpanel"));

    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (adminKey.wasPressed()) {
                client.setScreen(new AdminScreen(null));
            }
        });

        CommandSerializer.init();
    }

}
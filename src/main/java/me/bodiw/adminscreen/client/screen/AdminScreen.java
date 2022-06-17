package me.bodiw.adminscreen.client.screen;

import me.bodiw.adminscreen.client.ModClient;
import me.bodiw.adminscreen.client.serializer.CommandSerializer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;

public class AdminScreen extends Screen {

    public AdminScreen(Screen parent) {
        super(new LiteralText("Admin Screen"));
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (super.keyPressed(keyCode, scanCode, modifiers)) {
            return true;
        }
        if (ModClient.adminKey.matchesKey(keyCode, scanCode) || client.options.inventoryKey.matchesKey(keyCode, scanCode)) {
            this.close();
            return true;
        }
        return true;
    }

    protected void init() {

        if (CommandSerializer.categories == null) {
            CommandSerializer.init();
        }

        // exit button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 155, this.height / 6 - 12 + 144, 150, 20, new LiteralText("Exit"), button -> {
            this.client.setScreen(null);
        }));

        int i = 0;
        for (String s : CommandSerializer.categories.keySet()) {
            int j = this.width / 2 - 155 + (i / 6) * 85;
            int k = this.height / 6 - 12 + 24 * (i % 6);
            this.addDrawableChild(new ButtonWidget(j, k, 75, 20, new LiteralText(s), button -> {
                client.setScreen(new CategoryScreen(s, this));
            }));
            i++;
        }
    }
}
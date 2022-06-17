package me.bodiw.adminscreen.client.screen;

import me.bodiw.adminscreen.client.ModClient;
import me.bodiw.adminscreen.client.serializer.Command;
import me.bodiw.adminscreen.client.serializer.CommandSerializer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.text.LiteralText;

public class CategoryScreen extends Screen {

    private final Screen parent;
    private String category;

    public CategoryScreen(String category, Screen parent) {
        super(new LiteralText(category + " Screen"));
        this.parent = parent;
        this.category = category;
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
        // back button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 155, this.height / 6 - 12 + 144, 150, 20, new LiteralText("Back"), button -> {
            this.client.setScreen(this.parent);
        }));

        int i = 0;

        for (Command c : CommandSerializer.categories.get(category)) {
            int j = this.width / 2 - 155 + (i / 6) * 85;
            int k = this.height / 6 - 12 + 24 * (i % 6);
            this.addDrawableChild(new ButtonWidget(j, k, 75, 20, new LiteralText(c.getName()), button -> {
                this.client.getNetworkHandler().sendPacket(new ChatMessageC2SPacket("/" + c.getCommand()));
            }));
            i++;
        }
    }
}
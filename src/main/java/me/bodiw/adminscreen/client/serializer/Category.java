package me.bodiw.adminscreen.client.serializer;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private String category;

    private ArrayList<Command> commands = new ArrayList<>();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }
}

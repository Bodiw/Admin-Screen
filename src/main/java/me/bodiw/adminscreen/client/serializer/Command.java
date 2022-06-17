package me.bodiw.adminscreen.client.serializer;

import java.io.Serializable;

public class Command implements Serializable {

    private String name;

    private String command;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
package me.bodiw.adminscreen.client.serializer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.spongepowered.include.com.google.gson.Gson;
import org.spongepowered.include.com.google.gson.stream.JsonReader;

import net.fabricmc.loader.api.FabricLoader;

public class CommandSerializer {

    public static LinkedHashMap<String, ArrayList<Command>> categories = new LinkedHashMap<>();

    public static JsonReader readJson(String file) {
        try {
            return new JsonReader(Files.newBufferedReader(Paths.get(file)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void init() {
        String dir = FabricLoader.getInstance().getConfigDir().toString() + "/admincommands.json";

        if (!Files.exists(Paths.get(dir))) {
            try {
                Files.createFile(Paths.get(dir));
                Files.write(Paths.get(dir), "[{\"category\": \"gamemode\",\"commands\": [{\"name\": \"survival\",\"command\": \"gamemode survival\"},{\"name\": \"creative\",\"command\": \"gamemode creative\"}]}]".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JsonReader json = readJson(dir);

        Gson gson = new Gson();

        Category[] cat = gson.fromJson(json, Category[].class);

        for (Category c : cat) {
            categories.put(c.getCategory(), c.getCommands());
        }
    }

}

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Position;
import com.codecool.dungeoncrawl.logic.items.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GameLoader {

    public void loadGame() {
        try{
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = (JsonArray) parser.parse(new FileReader("src/main/resources/saves/asd.json"));
            ArrayList<JsonObject> jsonMaps = new ArrayList<>();
            ArrayList<GameMap> maps = new ArrayList<GameMap>();

            for (Object object : jsonArray) {
                jsonMaps.add((JsonObject) object);
            }

            for(JsonObject jsonMap : jsonMaps){
                maps.add(loadMap(jsonMap));
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public GameMap loadMap(JsonObject jsonMap){
        int[] mapSizes = getMapSizes(jsonMap);
        GameMap map = new GameMap(mapSizes[0], mapSizes[1]);
        getCellsOfMap(jsonMap, map);
        getGates(jsonMap, map);
        /*
        player
        enemies
        */
        return map;
    }

    public int[] getMapSizes(JsonObject jsonMap){
        int width = jsonMap.get("width").getAsInt();
        int height = jsonMap.get("height").getAsInt();
        return new int[]{width, height};
    }

    public void getCellsOfMap(JsonObject jsonMap, GameMap map){
        Cell[][] cells = new Cell[map.getWidth()][map.getHeight()];
        int x = 0;
        int y = 0;
        JsonArray rows = jsonMap.get("cells").getAsJsonArray();
        for (JsonElement row : rows){
            JsonArray rowAsArray = row.getAsJsonArray();
            for (JsonElement jsonCell : rowAsArray){
                Cell cell = getCell(jsonCell.getAsJsonObject());
                x++;
                cells[x][y] = cell;
            }
            x = 0;
            y++;
        }
        map.setCells(cells);
    }

    public Cell getCell(JsonObject cellObject){
        Position cellPosition = getObjectPosition(cellObject);
        CellType type = getCellType(cellObject);
        return new Cell(cellPosition, type);
    }

    public CellType getCellType(JsonObject jsonCell){
        String jsonCellType = jsonCell.get("type").getAsJsonObject().toString();
        return CellType.valueOf(jsonCellType);
    }

    public Position getObjectPosition(JsonObject jsonObject){
        int x = Integer.parseInt(jsonObject.get("position").getAsJsonObject().get("x").toString());
        int y = Integer.parseInt(jsonObject.get("position").getAsJsonObject().get("y").toString());
        return new Position(x,y);
    }

    public String getName(JsonObject jsonObject){
        return jsonObject.get("name").toString();
    }

    public int getCoinValue(JsonObject jsonObject){
        return jsonObject.get("value").getAsInt();
    }

    public Item getItem(JsonObject jsonObject){
        Position position = getObjectPosition(jsonObject);
        String name = getName(jsonObject);
        switch (name){
            case "star":
                return new Star(position, name);
            case "chick":
                return new Chick(position, name);
            case "coin":
                int value = getCoinValue(jsonObject);
                return new Coin(position, value);
            case "gun":
                return new Gun(position, name);
            case "hat":
                return new Hat(position, name);
            case "rose":
                return new Rose(position, name);
            case "tequila":
                return new Tequila(position, name);
        }
        return null;
    }

    public void getItems(JsonObject jsonMap, GameMap map){
        ArrayList<Item> items = new ArrayList<>();

        JsonArray jsonItems = jsonMap.get("items").getAsJsonArray();
        for(JsonElement jsonItem : jsonItems){
            Item item = getItem(jsonItem.getAsJsonObject());
            items.add(item);
        }

        map.setItems(items);
    }


    public void getGates(JsonObject jsonMap, GameMap map){
        ArrayList<Gate> gates = new ArrayList<>();

        JsonArray jsonGates = jsonMap.get("gates").getAsJsonArray();
        for (JsonElement jsonGate : jsonGates) {
            Gate gate = createGateFromJson(jsonGate.getAsJsonObject());
            gates.add(gate);
        }
        map.setGates(gates);
    }

    public Gate createGateFromJson(JsonObject jsonGate){
        Position gatePosition = getObjectPosition(jsonGate);
        int newCurrentMap = getNewCurrentMapValueOfGate(jsonGate);
        return  new Gate(gatePosition, newCurrentMap);
    }

    public int getNewCurrentMapValueOfGate(JsonObject jsonGate){
        return jsonGate.get("newCurrentMap").getAsInt();
    }

}

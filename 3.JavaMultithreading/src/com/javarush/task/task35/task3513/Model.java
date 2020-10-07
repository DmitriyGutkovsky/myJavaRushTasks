package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

//будет содержать игровую логику и хранить игровое поле
public class Model {
    private static final int FIELD_WIDTH = 4; // определяющая ширину игрового поля
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
    }

    private List getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTile[j].value == 0) {
                    emptyTiles.add(gameTile[j]);
                }
            }
        }
        return emptyTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int index = (int) (Math.random() * emptyTiles.size()) % emptyTiles.size();
            Tile emptyTile = emptyTiles.get(index);
            emptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    public void resetGameTiles() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

}

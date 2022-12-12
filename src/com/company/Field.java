package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private final Player player;

    private boolean isGameEnd;

    private Cell[][] field;

    private int headX;
    private int headY;
    private Random rnd;


    public Field(Player player) {
        this.player = player;
        this.field = initField(Settings.DEFAULT_FIELD_SIZE, Settings.DEFAULT_SNAKE_LENGTH);
        addAppleToField();
        rnd = new Random();
    }

    private Cell[][] initField(int fieldSize, int length) {
        headX = fieldSize / 2;
        headY = fieldSize / 2;

        Cell[][] field = new Cell[fieldSize][fieldSize];
        initSnake(field, length);

        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (r == 0 || r == fieldSize - 1 || c == 0 || c == fieldSize - 1) {
                    field[r][c] = new Cell(CellState.WALL);
                } else {
                    field[r][c] = new Cell(CellState.FREE);
                }
            }
        }

        return field;
    }

    private void addAppleToField() {
        List<Point> freePoints = new ArrayList<>();
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].getCellState() == CellState.FREE) {
                    freePoints.add(new Point(col, row));
                }
            }
        }
        if (freePoints.size() == 0) {

        }

        Point applePoint = freePoints.get(rnd.nextInt(freePoints.size()));
        field[applePoint.y][applePoint.x] = new Cell(CellState.APPLE);
    }

    private void initSnake(Cell[][] field, int snakeLength) {
        int curColIndex = headY;
        for (int curLength = snakeLength; curLength >= 1; curLength--) {
            field[headY][curColIndex] = new Cell(CellState.SNAKE, curLength);
            curColIndex--;
        }
    }


    public void move() {

    }
}






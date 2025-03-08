package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Board{

    private int dimension;
    private int cellCount;
    private Map<Integer,BoardEntity> boardEntityMap;

    public Board(int dimension){
        this.dimension = dimension;
        this.cellCount = dimension * dimension;
        boardEntityMap = new HashMap<>();
//        Initialize 'n' snakes and 'n' ladders

//        Add 'n' snakes , start > end
        for(int i = 0 ; i < dimension ; i++){
            int min = 2;
            int max = cellCount - 1;

            int start = (int)(Math.floor(Math.random() * (max - min + 1) + min));
            max = start - 1;

            int end = (int)(Math.floor(Math.random() * (max - min + 1) + min));

            if(!hasSnakeOrLadder(start)){
                boardEntityMap.put(start,new Snake(start,end));
            }
        }

    }

    private boolean hasSnakeOrLadder(int index){
        return boardEntityMap.containsKey(index);
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Map<Integer, BoardEntity> getBoardEntityMap() {
        return boardEntityMap;
    }

    public void setBoardEntityMap(Map<Integer, BoardEntity> boardEntityMap) {
        this.boardEntityMap = boardEntityMap;
    }

    public int getCellCount() {
        return cellCount;
    }

    public void setCellCount(int cellCount) {
        this.cellCount = cellCount;
    }
}

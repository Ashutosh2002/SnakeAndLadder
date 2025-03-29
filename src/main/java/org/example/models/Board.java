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

//        Add 'n' snakes and 'n' ladders
        addSnakesAndLadders();


    }

    private void addSnakesAndLadders(){
        for(int i = 0 ; i < dimension ; i++){
            int min = 2;
            int max = cellCount - 1;

            int start = (int)(Math.floor(Math.random() * (max - min + 1) + min));
            max = start - 1;

            int end = (int)(Math.floor(Math.random() * (max - min + 1) + min));

            if(!hasSnakeOrLadder(start)){
                boardEntityMap.put(start,new Snake(start,end));
            }

//            Ladder -> end > start
            max = cellCount - 1;
            end = (int)(Math.floor(Math.random() * (max - min + 1) + min));
            max = end - 1;
            start = (int)(Math.floor(Math.random() * (max - min + 1) + min));

            if(!hasSnakeOrLadder(start)){
                boardEntityMap.put(start,new Ladder(start,end));
            }

        }
    }

    public boolean hasSnakeOrLadder(int index){
        return boardEntityMap.containsKey(index);
    }

    public void print(){
        int tempCellCount = cellCount;
        int index;
        for (int row = 0; row < dimension; row++) {
            // Print left to right if even row, right to left if odd
            if (row % 2 == 0) {
                for (int col = 0; col < dimension; col++) {
                    index = tempCellCount;

                    System.out.printf("%4d", tempCellCount);

                    if (hasSnakeOrLadder(index)) {
                        BoardEntity entity = boardEntityMap.get(index);
                        entity.printEntity();
                    }

                    tempCellCount-=1;
                }
            } else {
                int temp = tempCellCount - dimension+ 1;
                for (int col = 0; col < dimension; col++) {

                    System.out.printf("%4d", temp);

                    if (hasSnakeOrLadder(temp)) {
                        BoardEntity entity = boardEntityMap.get(temp);
                        entity.printEntity();
                    }

                    temp+=1;
                }
                tempCellCount -= dimension;
            }
            System.out.println(); // New line for each row
        }
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

package game;

import enums.GameState;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private int[][] numbers = new int[9][9];
    private List<String> fixedPositions = new ArrayList<>();
    private List<String> expectedInputs = new ArrayList<>();
    private List<String> inputs = new ArrayList<>();
    private GameState gameState = GameState.INCOMPLETE;

    public Board(String[] args) {

        for (String arg : args) {
            String[] fields = arg.split(",");
            if (fields[2].equals("false")) {
                expectedInputs.add(fields[0] + "," + fields[1]);
            } else {
                fixedPositions.add(fields[0] + "," + fields[1]);
            }
        }

        defaultPositions();
    }

    public StringBuilder verifyGame() {
        StringBuilder sb = new StringBuilder();

        if(isGameEmpty()) {
            sb.append("Jogo incompleto");
        } else {
            sb.append("Jogo completo");
        }

        if(isGameWrong()) {
            sb.append(" e com erros!");
        } else {
            sb.append(" e sem erros!");
        }

        return sb;
    }

    public boolean isGameEmpty() {
        for(int i = 0; i < numbers.length; i ++) {
            for(int j = 0; j < numbers[i].length; j ++) {
                if(numbers[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGameWrong() {
        for(String value : inputs) {
            if(!expectedInputs.contains(value)) {
                return true;
            }
        }
        return false;
    }

    public void defaultPositions() {
        for(String value : fixedPositions) {
            String[] fields = value.split(";");
            String[] position = fields[0].split(",");
            int number = Integer.parseInt(fields[1]);
            numbers[Integer.parseInt(position[1])][Integer.parseInt(position[0])] = number;
        }
    }

    public void addInput(String input) {
        inputs.add(input);
    }

    public void removePastInput(String input) {
        inputs.removeIf(value -> value.split(";")[0].equals(input));
    }

    public void clearInputs() {
        inputs.clear();
    }

    public void addNumber(int line, int column, int number) {
        numbers[line][column] = number;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public List<String> getFixedPositions() {
        return fixedPositions;
    }

    public List<String> getExpectedInputs() {
        return expectedInputs;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}

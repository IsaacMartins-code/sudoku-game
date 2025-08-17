package application;

public class UI {

    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";   // GREEN
    private static final String RESET = "\u001B[0m";

    public static StringBuilder generateBoard(int[][] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========SUDOKU=========" + "\n");
        for (int i = 0; i < numbers.length; i++) {
            if(i == 3) {
                sb.append("=========================" + "\n");
            }
            for (int j = 0; j < numbers[i].length; j++) {
                if(j == 0 || j == 3 || j == 6) {
                    sb.append("| ").append(numbers[i][j]).append(" ");
                } else if(j == 8) {
                    sb.append(numbers[i][j]).append(" |\n");
                } else {
                    sb.append(numbers[i][j]).append(" ");
                }
            }
            if(i == 5 || i == 8) {
                sb.append("=========================" + "\n");
            }
        }
        return sb;
    }

    public static StringBuilder generateBoard(int[][] numbers, int selectedLine) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========SUDOKU=========" + "\n");
        for (int i = 0; i < numbers.length; i++) {
            if(i == 3) {
                sb.append("=========================" + "\n");
            }

            for (int j = 0; j < numbers[i].length; j++) {
                if(i == selectedLine) {
                    sb.append(ANSI_BLUE_BACKGROUND);
                    if(j == 0 || j == 3 || j == 6) {
                        sb.append("| ").append(numbers[i][j]).append(" ");
                    } else if(j == 8) {
                        sb.append(numbers[i][j]).append(" |\n");
                    } else {
                        sb.append(numbers[i][j]).append(" ");
                    }
                    sb.append(RESET);
                } else {
                    if(j == 0 || j == 3 || j == 6) {
                        sb.append("| ").append(numbers[i][j]).append(" ");
                    } else if(j == 8) {
                        sb.append(numbers[i][j]).append(" |\n");
                    } else {
                        sb.append(numbers[i][j]).append(" ");
                    }
                }
            }
            if(i == 5 || i == 8) {
                sb.append("=========================" + "\n");
            }
        }
        return sb;
    }

    public static StringBuilder generateBoard(int[][] numbers, int selectedLine, int selectedColumn) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========SUDOKU=========" + "\n");
        for (int i = 0; i < numbers.length; i++) {
            if(i == 3) {
                sb.append("=========================" + "\n");
            }

            for (int j = 0; j < numbers[i].length; j++) {
                if(i == selectedLine && j == selectedColumn) {
                    if(j == 0 || j == 3 || j == 6) {
                        sb.append(ANSI_BLUE_BACKGROUND).append("| ").append(RESET).append(ANSI_GREEN_BACKGROUND).append(numbers[i][j]).append(RESET).append(ANSI_BLUE_BACKGROUND).append(" ");
                    } else if(j == 8) {
                        sb.append(ANSI_GREEN_BACKGROUND).append(numbers[i][j]).append(RESET).append(ANSI_BLUE_BACKGROUND).append(" |\n").append(RESET);
                    } else {
                        sb.append(ANSI_GREEN_BACKGROUND).append(numbers[i][j]).append(ANSI_BLUE_BACKGROUND).append(" ");
                    }
                } else if (i == selectedLine) {
                    sb.append(ANSI_BLUE_BACKGROUND);
                    if(j == 0 || j == 3 || j == 6) {
                        sb.append("| ").append(numbers[i][j]).append(" ");
                    } else if(j == 8) {
                        sb.append(numbers[i][j]).append(" |\n");
                    } else {
                        sb.append(numbers[i][j]).append(" ");
                    }
                    sb.append(RESET);
                } else {
                    if(j == 0 || j == 3 || j == 6) {
                        sb.append("| ").append(numbers[i][j]).append(" ");
                    } else if(j == 8) {
                        sb.append(numbers[i][j]).append(" |\n");
                    } else {
                        sb.append(numbers[i][j]).append(" ");
                    }
                }
            }
            if(i == 5 || i == 8) {
                sb.append("=========================" + "\n");
            }
        }
        return sb;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

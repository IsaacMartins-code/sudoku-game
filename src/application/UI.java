package application;

public class UI {

    public static StringBuilder generateBoard(int[][] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========SUDOKU=========" + "\n");
        for (int i = 0; i < numbers.length; i++) {
            if(i == 3) {
                sb.append("=========================" + "\n");
            }
            for (int j = 0; j < numbers[i].length; j++) {
                if(j == 0 || j == 3 || j == 6) {
                    sb.append("| " + numbers[i][j] + " ");
                } else if(j == 8) {
                    sb.append(numbers[i][j] + " |\n");
                } else {
                    sb.append(numbers[i][j] + " ");
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

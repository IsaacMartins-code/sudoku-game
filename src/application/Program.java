package application;

import java.util.Scanner;
import enums.GameState;
import game.Board;
import static application.UI.*;

public class Program {
    public static void main(String[] args) {

        Board board = new Board(args);
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

       while(board.getGameState() == GameState.INCOMPLETE || board.getGameState() != GameState.FINISHED) {
           clearScreen();
           System.out.println(generateBoard(board.getNumbers()));
           System.out.println(sb);
           System.out.println(" ");

           if(!board.isGameEmpty() && !board.isGameWrong()) {
               board.setGameState(GameState.COMPLETE);
               System.out.println("Jogo concluído! Parabéns!");
               break;
           }

            System.out.println("Digite 'R' caso queira reiniciar;");
            System.out.println("Digite 'V' caso queira verificar o jogo;");
            System.out.println("Digite 'S' caso queira sair do jogo;");
            System.out.println("Digite qualquer valor caso queira continuar;");
            char selected = sc.next().toUpperCase().charAt(0);

            switch (selected) {
                case 'R':
                    board.clearInputs();
                    break;

                case 'V':
                    sb = board.verifyGame();
                    break;

                case 'S':
                    board.setGameState(GameState.FINISHED);
                    break;

                default:
                    System.out.print("Selecione a linha que deseja alterar: ");
                    int line = sc.nextInt();

                    boolean stop = false;
                    String message = "";
                    while (!stop) {
                        clearScreen();
                        System.out.println(generateBoard(board.getNumbers(), line));
                        System.out.println(message);
                        System.out.println(" ");

                        System.out.println("(Alterando a linha " + line + ")");
                        int column;
                        int number;

                        System.out.print("Selecione a coluna que deseja alterar: ");
                        column = sc.nextInt();
                        clearScreen();
                        System.out.println(generateBoard(board.getNumbers(), line, column));
                        System.out.print("Selecione o numero que deseja colocar: ");
                        number = sc.nextInt();


                        String input = column + "," + line;
                        String fixed = "";
                        for (String value : board.getFixedPositions()) {
                            if (input.equals(value.split(";")[0])) {
                                fixed = value;
                                break;
                            }
                        }

                        if (!fixed.isEmpty()) {
                            message = "Essa posição não pode ser alterada!";
                        } else if (number  > 9 || number < 1) {
                            message = "Número inválido! Apenas valores entre 1 e 9!";
                        } else if(column > 8 || column < 0) {
                            message = "Coluna inválida! Apenas valores entre 0 e 8!";
                        } else {
                            board.removePastInput(input);
                            board.addInput(input + ";" + number);
                            board.addNumber(line, column, number);
                            clearScreen();
                            System.out.println(generateBoard(board.getNumbers(), line));
                            System.out.println("Continuar? (S/N): ");
                            stop = sc.next().toUpperCase().charAt(0) == 'N';
                        }
                    }
            }
       }
        sc.close();
    }
}

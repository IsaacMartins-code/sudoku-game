package application;

import java.util.Scanner;
import enums.GameState;
import game.Board;
import static application.UI.clearScreen;
import static application.UI.generateBoard;

public class Program {
    public static void main(String[] args) {

        Board board = new Board(args);
        Scanner sc = new Scanner(System.in);

       while(board.getGameState() == GameState.INCOMPLETE || board.getGameState() != GameState.FINISHED) {
            clearScreen();
            System.out.println(generateBoard(board.getNumbers()));

            System.out.println("Digite 'R' caso queria reiniciar; ");
            System.out.println("Digite 'V' caso queira verificar o jogo; ");
            System.out.println("Digite 'S' caso queira sair do jogo;");
            System.out.println("Digite qualquer valor caso queira continuar; ");
            char selected = sc.next().toUpperCase().charAt(0);

            switch (selected) {
                case 'R':
                    board.defaultPositions();
                    board.clearInputs();
                    break;

                case 'V':
                    System.out.println(board.verifyGame());
                    break;

                case 'S':
                    board.setGameState(GameState.FINISHED);
                    break;

                default:
                    System.out.println("Selecione a linha, a coluna e o número que deseja colocar, respectivamente: ");
                    int line = sc.nextInt();
                    int column = sc.nextInt();
                    int number = sc.nextInt();

                    String input = column + "," + line;
                    String fixed = "";
                    for(String value : board.getFixedPositions()) {
                        if(input.equals(value.split(";")[0])) {
                            fixed = value;
                            break;
                        }
                    }
                    if(!fixed.isEmpty()) {
                        System.out.println("Essa posição não pode ser alterada!");
                    } else if(number > 9 || number < 1) {
                        System.out.println("digite apenas valores entre 1 e 9!");
                    } else {
                        board.removePastInput(input);
                        board.addInput(input + ";" + number);
                        board.addNumber(line, column, number);
                    }
                    if(!board.isGameEmpty() && !board.isGameWrong()) {
                        board.setGameState(GameState.COMPLETE);
                        System.out.println("Jogo concluído! Parabéns!");
                    }
            }
       }
        sc.close();
    }
}

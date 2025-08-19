package application;

import java.util.InputMismatchException;
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
                    clearScreen();
                    System.out.println(generateBoard(board.getNumbers()));

                    Integer line = null;

                    while(line == null) {
                        try {
                            System.out.print("Selecione a linha que deseja alterar: ");
                            if(sc.hasNextInt()) {
                                line = sc.nextInt();
                                if(line < 0 || line > 8) {
                                    line = null;
                                    throw new InputMismatchException("Linha inválida! Apenas números entre 0 e 8!");
                                }
                            } else {
                                sc.next();
                                throw new InputMismatchException("Linha inválida! Apenas números entre 0 e 8!");
                            }

                        } catch (InputMismatchException e) {
                            clearScreen();
                            System.out.println(generateBoard(board.getNumbers()));
                            System.out.println(" ");
                            System.out.println(e.getMessage());
                        }
                    }

                    boolean stop = false;
                    String message = "";
                    while (!stop) {
                        clearScreen();
                        System.out.println(generateBoard(board.getNumbers(), line));
                        System.out.println(message);
                        System.out.println(" ");

                        Integer column = null;
                        Integer number = null;

                        while(column == null || number == null) {
                            try {
                                System.out.println(" ");
                                System.out.println("(Alterando a linha " + line + ")");
                                System.out.print("Selecione a coluna que deseja alterar: ");
                                if(sc.hasNextInt()) {
                                    column = sc.nextInt();
                                    if(column < 0 || column > 8) {
                                        column = null;
                                        throw new InputMismatchException("Coluna inválida! Apenas números entre 0 e 8!");
                                    }
                                } else {
                                    sc.next();
                                    throw new InputMismatchException("Coluna inválida! Apenas números entre 0 e 8!");
                                }


                                clearScreen();
                                System.out.println(generateBoard(board.getNumbers(), line, column));
                                System.out.print("Selecione o número que deseja colocar: ");
                                if(sc.hasNextInt()) {
                                    number = sc.nextInt();
                                    if (number < 1 || number > 9) {
                                        number = null;
                                        throw new InputMismatchException("Número inválido! Apenas números entre 1 e 9!");
                                    }
                                } else {
                                    sc.next();
                                    throw new InputMismatchException("Número inválido! Apenas entre 1 e 9!");
                                }


                            } catch (InputMismatchException e) {
                                clearScreen();
                                System.out.println(generateBoard(board.getNumbers(), line));
                                System.out.println(" ");
                                System.out.println(e.getMessage());
                            }
                        }

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

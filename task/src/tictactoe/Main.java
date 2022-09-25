package tictactoe;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String[][] inputArray = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        print(inputArray);
        boolean end = false;
        int chooseChar = 1;
        while (!end) {
            newInput(inputArray, chooseChar);
            print(inputArray);
            end = checkWinner(inputArray);
            chooseChar++;
        }


    }

    public static boolean checkWinner(String[][] inputArray) {
        boolean xWins = false;
        boolean oWins = false;

        if (inputArray[0][0].equals(inputArray[0][1]) && inputArray[0][1].equals(inputArray[0][2]) && !inputArray[0][0].equals(" ")) {
            if (inputArray[0][0].equals("X")) {
                xWins = true;
            } else if (inputArray[0][0].equals("O")) {
                oWins = true;
            }
        }
        if (inputArray[1][0].equals(inputArray[1][1]) && inputArray[1][1].equals(inputArray[1][2]) && !inputArray[1][0].equals(" ")) {
            if (inputArray[1][0].equals("X")) {
                xWins = true;
            } else if (inputArray[1][0].equals("O")) {
                oWins = true;
            }
        }
        if (inputArray[2][0].equals(inputArray[2][1]) && inputArray[2][1].equals(inputArray[2][2]) && !inputArray[2][0].equals(" ")) {
            if (inputArray[2][0].equals("X")) {
                xWins = true;
            } else if (inputArray[2][0].equals("O")) {
                oWins = true;
            }
        }
        if (inputArray[0][0].equals(inputArray[1][0]) && inputArray[1][0].equals(inputArray[2][0]) && !inputArray[0][0].equals(" ")) {
            if (inputArray[0][0].equals("X")) {
                xWins = true;
            } else if (inputArray[0][0].equals("O")) {
                oWins = true;
            }
        }
        if (inputArray[0][1].equals(inputArray[1][1]) && inputArray[1][1].equals(inputArray[2][1]) && !inputArray[0][1].equals(" ")) {
            if (inputArray[0][1].equals("X")) {
                xWins = true;
            } else if (inputArray[0][1].equals("O")) {
                oWins = true;
            }
        }
        if (inputArray[0][2].equals(inputArray[1][2]) && inputArray[1][2].equals(inputArray[2][2]) && !inputArray[0][2].equals(" ")) {
            if (inputArray[0][2].equals("X")) {
                xWins = true;
            } else if (inputArray[0][2].equals("O")) {
                oWins = true;
            }
        }
        if (inputArray[0][0].equals(inputArray[1][1]) && inputArray[1][1].equals(inputArray[2][2]) && !inputArray[0][0].equals(" ")) {
            if (inputArray[0][0].equals("X")) {
                xWins = true;
            } else if (inputArray[0][0].equals("O")) {
                oWins = true;
            }
        }
        if (inputArray[0][2].equals(inputArray[1][1]) && inputArray[1][1].equals(inputArray[2][0]) && !inputArray[0][2].equals(" ")) {
            if (inputArray[0][2].equals("X")) {
                xWins = true;
            } else if (inputArray[0][2].equals("O")) {
                oWins = true;
            }
        }
        //amount of x and o
        int xCount = 0;
        int oCount = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j].equals("X")) {
                    xCount++;
                } else if (inputArray[i][j].equals("O")) {
                    oCount++;
                }
            }
        }


        if (xWins && !oWins) {
            System.out.println("X wins");
            return true;
        } else if (oWins && !xWins) {
            System.out.println("O wins");
            return true;
        } else if (xCount == 4 && oCount == 5 || xCount == 5 && oCount == 4) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }

    public static void print(String[][] inputArray) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void newInput(String[][] inputArray, int chooseChar) {
        Scanner scanner = new Scanner(System.in);
        String secondInput = scanner.nextLine();
        int row = 0;
        int column = 0;
        try {
            String[] pieces = secondInput.split(" ");
            row = Integer.parseInt(pieces[0]);
            column = Integer.parseInt(pieces[1]);

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");

        }
        if (row > 3 || column > 3 || row < 1 || column < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            newInput(inputArray, chooseChar);
        } else if (inputArray[row - 1][column - 1].equals("X") || inputArray[row - 1][column - 1].equals("O")) {
            System.out.println("This cell is occupied! Choose another one!");
            newInput(inputArray, chooseChar);
        } else {
            if (chooseChar % 2 == 0) {
                inputArray[row - 1][column - 1] = "O";
            } else {
                inputArray[row - 1][column - 1] = "X";
            }
        }
        print(inputArray);
    }
}







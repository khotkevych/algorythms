import java.util.Scanner;

/*
* You are given a game of Tic Tac Toe.
* You have to write a function in which you pass the whole game and name of a player.
* The function will return whether the player has won the game or not.
* First you to decide which data structure you will use for the game.
* You need to tell the algorithm first and then need to write the code.
* Note: Some position may be blank in the game। So your data structure should consider this condition also.
* */

// todo add validation, clean etc. And check more!

public class TicTacToe {

    private final int SIZE = 3;
    private String playerX;
    private String playerO;
    private String winner;
    private int[][] field;
    private int freeCells;

    private TicTacToe(String playerX, String playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.field = new int[SIZE][SIZE];
        freeCells = 9;
    }

    private boolean isFinished() {
        return freeCells == 0;
    }

    private String check(int x, int y) {
        int sum = 0;
        // row
        for (int cell : field[x]) {
            sum += cell;
        }
        if (Math.abs(sum) == SIZE) {
            System.out.println("row: "+ sum);
            return sum == SIZE ? playerX : playerO;
        }
        sum = 0;
        // column
        for (int i = 0; i < SIZE; i++) {
            sum += field[i][y];
        }
        if (Math.abs(sum) == SIZE) {
            System.out.println("column: "+ sum);
            return sum == SIZE ? playerX : playerO;
        }
        // diagonal
        if (x == y || x + y == SIZE + 1) {
            // need to check central element only for odd matrix
            if (SIZE % 2 != 0 && x == y && x == (SIZE + 1) / 2) {
                // central element - check both diagonals
                sum = mainDiagonal();
                if (Math.abs(sum) == SIZE) {
                    return sum == SIZE ? playerX : playerO;
                }
                sum = secondaryDiagonal();
                if (Math.abs(sum) == SIZE) {
                    return sum == SIZE ? playerX : playerO;
                }
            } else {
                // check only one diagonal
                if (x == y) {
                    sum = mainDiagonal();
                } else {
                    sum = secondaryDiagonal();
                }
                if (Math.abs(sum) == SIZE) {
                    return sum == SIZE ? playerX : playerO;
                }
            }
        }
        return null;
    }

    private int mainDiagonal() {
        int sum = 0;
        for (int i = 0, j = 0; i < SIZE; i++, j++) {
            sum += field[i][j];
        }
        return sum;
    }

    private int secondaryDiagonal() {
        int sum = 0;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            sum += field[i][j];
        }
        return sum;
    }

    private String play(int x, int y, boolean isX) {
        if (isFinished()) {
            return "The game is over. The winner is: " + winner;
        }
        if (field[x][y] != 0) {
            throw new RuntimeException("Cell is occupied");
        }
        if (isX) {
            field[x][y] = 1;
        } else {
            field[x][y] = -1;
        }
        freeCells--;
        print();
        winner = check(x, y);
        if (winner == null && freeCells == 0) {
            winner = "A tie";
        }
        return winner;
    }


    private void print() {
        for (int[] row : field) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "X\t" : cell == -1 ? "0\t" : "_\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe("Katya", "Bot");
        String winner = null;
        int x, y;
        boolean isX = true;

        // Console is not working well with IDE
        Scanner reader = new Scanner(System.in);
        while (winner == null) {
            System.out.println((isX ? "X" : "0") + " is playing");
            System.out.println("Enter X: ");
            x = reader.nextInt();
            System.out.println("Enter Y: ");
            y = reader.nextInt();
            winner = game.play(x, y, isX);
            isX = !isX;
        }
        reader.close();
        System.out.println(winner);



       /* System.out.println(game.play(0,1,true));
        System.out.println(game.play(0,0,false));

        System.out.println(game.play(1,1,true));
        System.out.println(game.play(0,2,false));

        System.out.println(game.play(1,2,true));
        System.out.println(game.play(1,0,false));

        System.out.println(game.play(2,0,true));
        System.out.println(game.play(2,1,false));

        System.out.println(game.play(2,2,true));*/
    }
}

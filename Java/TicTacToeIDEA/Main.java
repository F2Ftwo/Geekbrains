package com.F_two.TicTacToe;//package com.F_two.TicTacToe;

import java.util.*;

class TicTacToe{

    private final char PLAYER_DOT = 'x';
    private final char AI_DOT = 'o';
    private final char EMPTY_DOT = '.';
    private final int FIELD_SIZE = 3;
    private char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new TicTacToe().go();
    }

    private void go() {
        initField();
        while (true) {
            printField();
            turnPlayer();

            if (checkWin(PLAYER_DOT)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Sorry, draw...");
                break;
            }
            printField();
            turnAI();

            if (checkWin(AI_DOT)) {
                System.out.println("COMPUTER WON!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Sorry, draw...");
                break;
            }
        }
    }

    private void turnPlayer() {
        int x, y;
        do {
            System.out.println("Enter coordinates X Y (1-3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        field[x][y] = PLAYER_DOT;
    }

    private void turnAI() {
        int x, y;
        do {
            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (!isCellEmpty(x, y));
        field[x][y] = AI_DOT;
    }

    private boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) return false;
        if (field[x][y] == EMPTY_DOT) return true;
        return false;
    }

    private boolean isFieldFull() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                if (field[i][j] == EMPTY_DOT) return false;
        return true;
    }

    private boolean checkWin(char ch) {
        //Check Horizontal
        if (field[0][0] == ch && field[0][1] == ch && field[0][2] == ch) return true;
        if (field[1][0] == ch && field[1][1] == ch && field[1][2] == ch) return true;
        if (field[2][0] == ch && field[2][1] == ch && field[2][2] == ch) return true;
        //Check Vertical
        if (field[0][0] == ch && field[1][0] == ch && field[2][0] == ch) return true;
        if (field[0][1] == ch && field[1][1] == ch && field[2][1] == ch) return true;
        if (field[0][2] == ch && field[1][2] == ch && field[2][2] == ch) return true;
        //Check Diag
        if (field[0][0] == ch && field[1][1] == ch && field[2][2] == ch) return true;
        if (field[2][0] == ch && field[1][1] == ch && field[0][2] == ch) return true;
        else  return false;

    }

    private void initField() {
        for(int i =0; i < FIELD_SIZE; i++)
            for(int j =0; j < FIELD_SIZE; j++)
                field[i][j] = EMPTY_DOT;
    }

    private void printField() {
        for(int i =0; i < FIELD_SIZE; i++) {
            for(int j =0; j < FIELD_SIZE; j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
    }
}

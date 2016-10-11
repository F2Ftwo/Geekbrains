import java.util.*;

class TicTacToe {

	final char PLAYER_DOT = 'x';
	final char AI_DOT = 'o';
	final char EMTPTY_DOT = '.';
	final int FIELD_SIZE = 3;
	char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	
	public static void main(String[] args) {
		new TicTacToe().go();
	}
	
	void go() {
		initField();
        while (true) {
            turnPlayer();
            printField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Sorry, draw...");
                break;
            }
            turnAI();
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("COMPUTER WON!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Sorry, draw...");
                break;
            }
	} 
	
	void turnPlayer() {
		int x, y;
		do {
			System.out.println("Enter coodinates X Y (1-3):");
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
		} while (!isCellEmty(x, y));
		field[x][y] = PLAYER_DOT;
	}
	
	void turnAI() {
		int x, y;
		do {
			x = sc.nextInt(3);
			y = sc.nextInt(3);
		} while (!isCellEmty(x, y));
		field[x][y] = AI_DOT;
	}
	
	boolean isCellEmty(int x, int y) {
		if (x < 0 || y < 0 || x > 2 || y > 2) return false;
		if (field[x][y] == EMTPTY_DOT) return true;
		return false;
	}
	
	boolean isFieldFull() {
		for (int i = 0; i < FIELD_SIZE; i++)
			for (int j = 0; j < FIELD_SIZE; j++)
				if (field[i][j] == EMTPTY_DOT) return false;
			return true;
	}
	
	boolean checkWin(char ch) {
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
		return false;
	}
	
	void initField() {
		for(int i =0; i < FIELD_SIZE; i++)
			for(int j =0; j < FIELD_SIZE; j++)
				field[i][j] = EMTPTY_DOT;
	}
	
	void printField() {
		for(int i =0; i < FIELD_SIZE; i++) {
			for(int j =0; j < FIELD_SIZE; j++)
				System.out.print(field[i][j]);
			System.out.println();
		}
	}
}
package com.example.tictactoe;

public class TicTacToe {
    public static final int SIDE = 4;
    private int turn;
    private int [][] game;

    public TicTacToe() {
        game = new int[SIDE][SIDE];
        resetGame();
    }

    public int play( int row, int col ) {
        int currentTurn = turn;
        if( row >= 0 && col >= 0 && row < SIDE && col < SIDE && game[row][col] == 0 ) {
            game[row][col] = turn;
            if( turn == 1 )
                turn = 2;
            else
                turn = 1;
            return currentTurn;
        }
        else
            return 0;
    }

    public int whoWon( ) {

        /* your ccode here    */

        int rows = checkRows();
        if (rows > 0 )
            return rows;
        int col = checkColumns();
        if (col > 0)
            return col;
        int diagonals = checkDiagonals();
        if(diagonals > 0 )
            return diagonals;
        return 0;
    }

    protected int checkRows( ) {
        for ( int row = 0; row < SIDE; row++ ) {

            /* your ccode here    */

            if(game[row][0] != 0 && game[row][0] == game[row][1] && game[row][1] == game[row][2] &&
            game[row][2] == game[row][3]){
                return game[row][0];
            }
        }
        return 0;
    }

    protected int checkColumns( ) {
        for ( int col = 0; col < SIDE; col++ ) {

            /* your ccode here    */

            if (game[0][col] != 0 && game[0][col] == game[1][col] && game[1][col] == game[2][col] &&
            game[2][col] == game[3][col]){
                return game[0][col];
            }
        }
        return 0;
    }

    protected int checkDiagonals( ) {

        /* your ccode here    */

        if(game[0][0] != 0 && game[0][0] == game[1][1] && game[1][1] ==game[2][2] && game[2][2] == game[3][3]){
            return game[0][0];
        }

        if(game[0][3] != 0 && game[0][3] == game[1][2] && game[1][2] ==game[2][1] && game[2][1] == game[3][0]){
            return game[0][0];
        }

        return 0;
    }

    public boolean canNotPlay( ) {
        boolean result = true;
        for (int row = 0; row < SIDE; row++)
            for( int col = 0; col < SIDE; col++ )
                if ( game[row][col] == 0 )
                    result = false;
        return result;
    }

    public boolean isGameOver( ) {
        return canNotPlay( ) || ( whoWon( ) > 0 );
    }

    public void resetGame( ) {
        for (int row = 0; row < SIDE; row++)
            for( int col = 0; col < SIDE; col++ )
                game[row][col] = 0;
        turn = 1;
    }

    public String result( ) {
        if( whoWon( ) > 0 )
            return "Player " + whoWon( ) + " won";
        else if( canNotPlay( ) )
            return "Tie Game";
        else
            return "PLAY !!";
    }
}

package lk.ijse.dep.service;

public interface Board extends BoardUI{
    final int NUM_OF_ROWS = 5;
    final int NUM_OF_COLS = 6;

    BoardUI getBordUi();
    int findNextAvailableShot(int col);
    boolean isLegalMove(int col);
    boolean existLegalMoves();
    void updateMove(int col,Piece move);
    void updateMove(int col,int row,Piece move);
    Winner findWinner();
}
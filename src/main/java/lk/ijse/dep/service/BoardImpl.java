package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private Piece[][] pieces;
    private BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        super();
        this.boardUI = boardUI;
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        inotializing(pieces);
    }

    private Piece[][] inotializing(Piece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
        return pieces;
    }

    @Override
    public BoardUI getBordUi() {
        return boardUI;
    }

    @Override
    public int findNextAvailableShot(int col) {
        for (int i = 0; i < pieces[col].length; i++) {
            if (pieces[col][i].equals(Piece.EMPTY)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        if (findNextAvailableShot(col) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < pieces.length; i++) {
            if (findNextAvailableShot(i) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        int index = findNextAvailableShot(col);
        pieces[col][index] = move;
    }

    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {
        //HumanPlayerWinner==============================colWinner check
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length - 3; j++) {
                if (pieces[i][j] == Piece.BLUE & pieces[i][j + 1] == Piece.BLUE & pieces[i][j + 2] == Piece.BLUE & pieces[i][j + 3] == Piece.BLUE) {
                    int col1 = i;
                    int row1 = j;
                    int col2 = i;
                    int row2 = (j + 3);
                    return new Winner(Piece.BLUE, col1, row1, col2, row2);
                }
            }
        }

        for (int i = 0; i < pieces.length - 3; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.BLUE & pieces[i + 1][j] == Piece.BLUE & pieces[i + 2][j] == Piece.BLUE & pieces[i + 3][j] == Piece.BLUE) {
                    int col1 = i;
                    int row1 = j;
                    int col2 = (i + 3);
                    int row2 = j;
                    return new Winner(Piece.BLUE, col1, row1, col2, row2);
                }
            }
        }

        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length - 3; j++) {
                if (pieces[i][j] == Piece.GREEN & pieces[i][j + 1] == Piece.GREEN & pieces[i][j + 2] == Piece.GREEN & pieces[i][j + 3] == Piece.GREEN) {
                    int col1 = i;
                    int row1 = j;
                    int col2 = i;
                    int row2 = (j + 3);
                    return new Winner(Piece.GREEN, col1, row1, col2, row2);
                }
            }
        }

        for (int i = 0; i < pieces.length - 3; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == Piece.GREEN & pieces[i + 1][j] == Piece.GREEN & pieces[i + 2][j] == Piece.GREEN & pieces[i + 3][j] == Piece.GREEN) {
                    int col1 = i;
                    int row1 = j;
                    int col2 = (i + 3);
                    int row2 = j;
                    return new Winner(Piece.GREEN, col1, row1, col2, row2);
                }
            }
        }
        return new Winner(Piece.EMPTY);
    }


    @Override
    public void update(int col, boolean isHuman) {

    }

    @Override
    public void notifyWinner(Winner winner) {

    }
}
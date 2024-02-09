package lk.ijse.dep.service;


public class HumanPlayer extends Player {
    public HumanPlayer(Board newBoard) {
        super(newBoard);
    }
    @Override
    public void movePiece(int col) {
        if (board.isLegalMove(col)) {
            board.updateMove(col,Piece.BLUE);
            board.getBordUi().update(col,true);
            if (board.findWinner().getWinningPiece().equals(Piece.EMPTY)) {
                if (!board.existLegalMoves()){
                    board.getBordUi().notifyWinner(new Winner(Piece.EMPTY));
                }
            }else {
                board.getBordUi().notifyWinner(board.findWinner());
            }
        }
    }
}
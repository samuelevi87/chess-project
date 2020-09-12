package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() { // este tabuleiro é de uso interno desta camada, por isso está protegido.
        return board;
    }



    

    
}

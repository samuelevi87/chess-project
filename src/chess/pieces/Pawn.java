package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

  private ChessMatch chessMatch;

  public Pawn(Board board, Color color, ChessMatch chessMatch) {
    super(board, color);
    this.chessMatch = chessMatch;
  }

  @Override
  public String toString() {
    return "P";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
    Position p = new Position(0, 0);
    if (getColor() == Color.WHITE) { // movimentos do peão branco
      p.setValues(position.getRow() - 1, position.getColumn());// movimento padrão
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValues(position.getRow() - 2, position.getColumn());// movimento inicial
      Position p2 = new Position(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
          && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValues(position.getRow() - 1, position.getColumn() - 1);// movimento de captura diagonal esquerda
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValues(position.getRow() - 1, position.getColumn() + 1);// movimento de captura diagonal direita
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      // #specialmove "en passant" branco
      if (position.getRow() == 3) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left) && isThereOpponentPiece(left)
            && getBoard().piece(left) == chessMatch.getEnPassantVunerable()) {
          mat[left.getRow() - 1][left.getColumn()] = true;
        }
        Position right = new Position(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(right) && isThereOpponentPiece(right)
            && getBoard().piece(right) == chessMatch.getEnPassantVunerable()) {
          mat[right.getRow() - 1][right.getColumn()] = true;
        }
      }
    } else {// movimentos do peão preto
      p.setValues(position.getRow() + 1, position.getColumn());// movimento padrão
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValues(position.getRow() + 2, position.getColumn());// movimento inicial
      Position p2 = new Position(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
          && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValues(position.getRow() + 1, position.getColumn() - 1);// movimento de captura diagonal esquerda
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }
      p.setValues(position.getRow() + 1, position.getColumn() + 1);// movimento de captura diagonal direita
      if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
        mat[p.getRow()][p.getColumn()] = true;
      }

      // #specialmove "en passant" preto
      if (position.getRow() == 4) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left) && isThereOpponentPiece(left)
            && getBoard().piece(left) == chessMatch.getEnPassantVunerable()) {
          mat[left.getRow() + 1][left.getColumn()] = true;
        }
        Position right = new Position(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(right) && isThereOpponentPiece(right)
            && getBoard().piece(right) == chessMatch.getEnPassantVunerable()) {
          mat[right.getRow() + 1][right.getColumn()] = true;
        }
      }
    }

    return mat;
  }

}

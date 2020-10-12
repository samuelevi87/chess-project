package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

  public Pawn(Board board, Color color) {
    super(board, color);
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
    }

    return mat;
  }

}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

  public Queen(Board board, Color color) {
    super(board, color);
  }

  @Override
  public String toString() {
    return "Q";
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

    Position p = new Position(0, 0);

    // above checking, same column and row decrementing.
    p.setValues(position.getRow() - 1, position.getColumn());
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setRow(p.getRow() - 1);
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // left checking, same row and column decrementing.
    p.setValues(position.getRow(), position.getColumn() - 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setColumn(p.getColumn() - 1);
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // right checking, same row and column incrementing.
    p.setValues(position.getRow(), position.getColumn() + 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setColumn(p.getColumn() + 1);
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // below checking, same column and row incrementing.
    p.setValues(position.getRow() + 1, position.getColumn());
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setRow(p.getRow() + 1);
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // Northwest checking, column and row decrementing.
    p.setValues(position.getRow() - 1, position.getColumn() - 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setValues(p.getRow() - 1, p.getColumn() - 1);
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // Northeast checking, row decrementing and column incrementing.
    p.setValues(position.getRow() - 1, position.getColumn() + 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setValues(p.getRow() - 1, p.getColumn() + 1);
      ;
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // Southeast checking, row and column incrementing.
    p.setValues(position.getRow() + 1, position.getColumn() + 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setValues(p.getRow() + 1, p.getColumn() + 1);
      ;
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    // Southwest checking, same column and row incrementing.
    p.setValues(position.getRow() + 1, position.getColumn() - 1);
    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
      p.setValues(p.getRow() + 1, p.getColumn() - 1);
    }
    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    }

    return mat;
  }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Rook;
import chess.pieces.King;
import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
  private Board board;
  private int turn;
  private Color currentPlayer;
  
  private List<Piece> piecesOnBoard= new ArrayList<>();
  private List<Piece> capturedPieces= new ArrayList<>();
   
  public ChessMatch(){
      board=new Board(8, 8);
      turn=1;
      currentPlayer=Color.WHITE;
      inicialSetup();
  }
  
  public int getTurn(){
      return turn;
  }
  
  public Color getCurrentPlayer(){
      return currentPlayer;
  }
  
  public ChessPiece[][]getPieces(){
    ChessPiece[][]mat=new ChessPiece[board.getRows()][board.getColumns()];
    for(int i=0; i< board.getRows();i++){
        for(int j=0; j<board.getColumns();j++){
            mat[i][j]= (ChessPiece) board.piece(i, j);
        }
    }
    return mat;
  }
  
  public boolean[][]possibleMoves(ChessPosition  sourcePosition){
      Position position=sourcePosition.toPosition();
      validateSourcePosition(position);
      return board.piece(position).possibleMoves();
  }
  
  public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
      Position source=sourcePosition.toPosition();
      Position target=targetPosition.toPosition();
      validateSourcePosition(source);
      validateTargetPosition(source,target);
      Piece capturePiece = makeMove(source, target);
      nextTurn();
      return (ChessPiece)capturePiece;
  }
  
  private Piece makeMove(Position source,Position target){
      Piece p=board.removePiece(source);
      Piece capturePiece=board.removePiece(target);
      board.placePiece(p, target);
      
      if(capturePiece!= null){
          piecesOnBoard.remove(capturePiece);
          capturedPieces.add(capturePiece);
      }
      return (ChessPiece)capturePiece;
  }
  
  private void validateSourcePosition(Position position) {
      if(!board.thereIsAPiece(position))
      { throw new ChessExeption("There is not a piece on source position");
      
      }
      if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
          throw new ChessExeption("The chosen piece is not yours");
      }
      if(!board.piece(position).isThereAnyPossibleMove()){
          throw new ChessExeption("There is not possible moves for the chosen piece");
      }
    }
  
  private void nextTurn(){
      turn++;
      currentPlayer=(currentPlayer ==Color.WHITE)? Color.BLACK:Color.WHITE;
  }

  private void validateTargetPosition(Position source, Position target){
      if(!board.piece(source).possibleMove(target)){
          throw new ChessExeption("The chosen piece can't move to target position");
      }
  }
  
  
  private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
                piecesOnBoard.add(piece);
	}
  
  private void inicialSetup(){
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));
        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author jaime
 */
public class Rook extends ChessPiece{

    public Rook(Board board, Color color) {
        super(board, color);
    }
    //@override
   public String toString(){
       return "R";
   }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][]mat=new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        //above
        //position herea el atributo de su clase padre Piece
        p.setValues(position.getRow()-1, position.getCol());
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getCol()]=true;
            p.setRow(p.getRow()-1);
        }
        if(getBoard().positionExist(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //left
         p.setValues(position.getRow(), position.getCol()-1);
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getCol()]=true;
            p.setCol(p.getCol()-1);
        }
        if(getBoard().positionExist(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //right
           p.setValues(position.getRow(), position.getCol()+1);
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getCol()]=true;
            p.setCol(p.getCol()+1);
        }
        if(getBoard().positionExist(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //botton
        p.setValues(position.getRow()+1, position.getCol());
        while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getCol()]=true;
            p.setRow(p.getRow()+1);
        }
        if(getBoard().positionExist(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        return mat;
    }
    
}

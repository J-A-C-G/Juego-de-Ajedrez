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
public class King extends ChessPiece{

    public King(Board board, Color color) {
        super(board, color);
    }
    //@overrie
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][]mat=new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p=new Position(0, 0);
        //above
        p.setValues(position.getRow()-1,position.getCol());
        if(getBoard().positionExist(p) && canMove(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //below
        p.setValues(position.getRow()+1, position.getCol());
        if(getBoard().positionExist(p)&& canMove(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //rigth
          p.setValues(position.getRow(), position.getCol()-1);
        if(getBoard().positionExist(p)&& canMove(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //left
          p.setValues(position.getRow(), position.getCol()+1);
        if(getBoard().positionExist(p)&& canMove(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        
        //diagonal nw
           p.setValues(position.getRow()-1, position.getCol()-1);
        if(getBoard().positionExist(p)&& canMove(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //ne
           p.setValues(position.getRow()-1, position.getCol()+1);
        if(getBoard().positionExist(p)&& canMove(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //sw
           p.setValues(position.getRow()+1, position.getCol()-1);
        if(getBoard().positionExist(p)&& canMove(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        //se
           p.setValues(position.getRow()+1, position.getCol()+1);
        if(getBoard().positionExist(p)&& canMove(p)){
            mat[p.getRow()][p.getCol()]=true;
        }
        return mat;
    }    
}

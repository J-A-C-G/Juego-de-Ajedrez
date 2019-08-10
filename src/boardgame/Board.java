/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

/**
 *
 * @author jaime
 */
public class Board {
    
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows<1 || columns<1){
        throw new BoardExeption("Error creating board: there must be at least 1 row and 1 column");
    }
        this.rows = rows;
        this.columns = columns;
        pieces= new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExist(row, column)){
            throw new BoardExeption("Position not in the board");
        }
        return pieces[row][column];
    }
    public Piece piece(Position position){
        if(!positionExist(position)){
            throw new BoardExeption("Position not in the board");
        }
        return pieces[position.getRow()][position.getCol()];
    }
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardExeption("There is already a piece on position "+ position);
        }
        pieces[position.getRow()][position.getCol()]=piece;
        piece.position=position;
    }
    
    //metodo auxiliar privado de la clase
    private boolean positionExist(int row ,int column){
        return row>=0 && row< rows && column >=0 && column<columns;
}
    
    public boolean positionExist(Position position){
        return positionExist(position.getRow(), position.getCol());
    }
    
    public boolean thereIsAPiece(Position position){
        if(!positionExist(position)){
            throw new BoardExeption("Position not in the board");
        }
        return piece(position)!=null;
    }
}

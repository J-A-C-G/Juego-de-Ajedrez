/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position=null;
    }

    protected Board getBoard() {
        return board;
    }
    
    public abstract boolean[][]possibleMoves();
    
    //utilizamos un metodo normal para llamar a un metodo abstracto
    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getCol()];
    }
    
    public boolean isThereAnyPossibleMove(){
        boolean[][]mat=possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j]){
                    return true;
                }
            }
            
        }
        return false;
    }
    
}

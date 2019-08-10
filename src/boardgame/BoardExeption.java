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
public class BoardExeption  extends RuntimeException{
    private static final long serialVersionUID=1L;
    
    //constructor que pasa un mensaje a su clase padre RuntimeExeption
    public BoardExeption(String msg){
        super(msg);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Usuario
 */
class ClaveNoExisteException extends Exception {
    
    public ClaveNoExisteException(){
        super("clave no existe");
    }
    
    public ClaveNoExisteException(String mensaje){
     super(mensaje);
    }
}

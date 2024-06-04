/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IArbolBusqueda<k extends Comparable<k>, v> {
    void insertar(k clave,v valor);
    //void insertarAVL(k clave,v valor);
    v eliminar(k clave);
    v buscar(k clave);
    boolean contiene(k clave);
    int size();//cuenta los nodos que hay en el arbol
    int altura();
    void vaciar();
    boolean esArbolVacio();
    int nivel();
    List<k> recorridoInOrden();
    List<k> recorridoPorNiveles();
    List<k> recorridoPostOrden();
    List<k> recorridoPreOrden();
    int cantidadDeHijosIzq();
    k minimo();
   

    Object getRaiz();

    public int getOrden();
}

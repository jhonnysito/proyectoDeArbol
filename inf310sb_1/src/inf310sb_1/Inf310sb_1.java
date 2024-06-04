/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf310sb_1;

import java.util.LinkedList;
import java.util.List;
import negocio.AVL;
import negocio.ArbolBinarioBusqueda;
import negocio.ArbolMViasBusqueda;
import negocio.IArbolBusqueda;
import negocio.NodoMVias;

/**
 *
 * @author Usuario
 */
public class Inf310sb_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolMViasBusqueda<Integer,String> MVias=new ArbolMViasBusqueda<>(4);
        MVias.insertar(50, "jhonny");
        MVias.insertar(25, "diego");
        MVias.insertar(75, "deivy");
        MVias.insertar(33, "rosi");
        MVias.insertar(40, "iver");
        MVias.insertar(15, "marcial");
        MVias.insertar(10, "jhonny");
        MVias.insertar(19, "diego");
        MVias.insertar(23, "deivy");
        MVias.insertar(60, "rosi");
        MVias.insertar(100, "iver");
        MVias.insertar(95, "marcial");
        System.out.println(MVias.buscar(50));
      int cant=MVias.cantidadDeClavesVaciasAntesDelNivel(2);
        System.out.println(MVias.cantidadDeClavesVaciasAntesDelNivel(0));
        System.out.println(MVias.cantidadDeClavesVacias());
        System.out.println(MVias.cantidadDeHojas());
        //IArbolBusqueda<Integer,String> arbol=new ArbolMViasBusqueda<>();
       // AVL<Integer,String> arbolAVL=new AVL<>();
       //  arbolAVL.insertarAVL(19, "anthonio");
       // arbol.insertar(1, "jhonny");
       // arbolAVL.insertarAVL(50, "jhon");
       // arbolAVL.insertarAVL(13, "carlos");
      
       
       // arbolAVL.insertarAVL(55, "juan");
        // List<Integer> recorrido=new LinkedList<>();
       // System.out.println(arbol.recorridoPreOrden());
       // System.out.println(arbol.size());
        //System.out.println(arbol.buscar(55));
       // System.out.println(arbol.recorridoPorNiveles());
        //System.out.println(arbol.recorridoPostOrden());
       // recorrido=arbol.recorridoInOrden();
       // System.out.println(recorrido);
      //  System.out.println(arbol.eliminar(19));
        //System.out.println(arbol.recorridoInOrden());
        //System.out.println(arbol.altura());
        //System.out.println(arbol.nivel());
       
       // System.out.println(arbol.recorridoInOrden());
       // System.out.println(arbol.nivel());
        //System.out.println("CANTIDAD DE HIJOS IZQUIERDOS DE TODO EL ARBOL="+arbol.cantidadDeHijosIzq());
        //System.out.println("LA CLAVE MINIMA DEL ARBOL ES "+arbol.minimo());
       // String s=arbol.ToString();
        //System.out.println(arbolAVL.ToString());
       
       
    }
    
}

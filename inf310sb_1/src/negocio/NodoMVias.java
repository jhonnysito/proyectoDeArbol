/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NodoMVias<k,v> {
    private List<k> ListaDeClaves;
    private List<v> ListaDeValores;
    private List<NodoMVias<k,v>> ListaDeHijos;
    
    public NodoMVias(int orden){
        ListaDeHijos=new LinkedList<>();
        ListaDeClaves=new LinkedList<>();
        ListaDeValores=new LinkedList<>();
        for (int i = 0; i < orden-1; i++) {
            ListaDeClaves.add((k) NodoMVias.datoVacio());
            ListaDeHijos.add(NodoMVias.nodoVacio());
            ListaDeValores.add((v) NodoMVias.datoVacio());
        }
        ListaDeHijos.add(NodoMVias.nodoVacio());
    }
     public NodoMVias(int orden,int x){
        ListaDeHijos=new LinkedList<>();
        ListaDeClaves=new LinkedList<>();
        ListaDeValores=new LinkedList<>();
        for (int i = 0; i < orden; i++) {
            ListaDeClaves.add((k) NodoMVias.datoVacio());
            ListaDeHijos.add(NodoMVias.nodoVacio());
            ListaDeValores.add((v) NodoMVias.datoVacio());
        }
        ListaDeHijos.add(NodoMVias.nodoVacio());
    }
    public NodoMVias(int orden,k primerClave,v primerValor){
        this(orden);
        ListaDeClaves.set(0, primerClave);
        ListaDeValores.set(0, primerValor);
    }
    public static NodoMVias nodoVacio(){
        return null;
    }
    public static Object datoVacio(){
        return null;
    }
    public void setClave(int posicion,k clave){
        ListaDeClaves.set(posicion, clave);
    }
    public k getclave(int posicion){
        return ListaDeClaves.get(posicion);
    }
     public void setValor(int posicion,v valor){
        ListaDeValores.set(posicion, valor);
    }
     public v getValor(int posicion){
        return ListaDeValores.get(posicion);
    }
     public void setHijo(int posicion,NodoMVias<k,v> nodo){
         ListaDeHijos.set(posicion, nodo);
     }
     public NodoMVias<k,v> getHijo(int posicion){
         return ListaDeHijos.get(posicion);
     }
     public static boolean esNodoVacio(NodoMVias nodo){
         return nodo==NodoMVias.nodoVacio();
     }
     public boolean esClaveVacia(int posicion){
         return ListaDeClaves.get(posicion)==NodoMVias.datoVacio();
     }
     public boolean esHijoVacio(int posicion){
         return ListaDeHijos.get(posicion)==NodoMVias.nodoVacio();
     }
     public boolean esHoja(){
         for (int i = 0; i < ListaDeHijos.size(); i++) {
             if (!esHijoVacio(i)) {
                 return false;
             }
         }
         return true;
     }
     public boolean estanClavesLlenas(){
         for (int i = 0; i < ListaDeClaves.size(); i++) {
             if (esClaveVacia(i)) {
                 return false;
             }
         }
         return true;
     }
     public int cantidadDeClavesNoVacias(){
         int cantidad=0;
         for (int i = 0; i < ListaDeClaves.size(); i++) {
             if (!esClaveVacia(i)) {
                 cantidad++;
             }
         }
         return cantidad;
     }
     public int cantidadDeHijosVacios(){
         int cantidad=0;
         for (int i = 0; i < ListaDeHijos.size(); i++) {
             if (esHijoVacio(i)) {
                 cantidad++;
             }
         }
         return cantidad;
     }
     public int cantidadDeHijosNoVacios(){
         int cantidad=0;
         for (int i = 0; i < ListaDeHijos.size(); i++) {
             if (!esHijoVacio(i)) {
                 cantidad++;
             }
         }
         return cantidad;
     }
}

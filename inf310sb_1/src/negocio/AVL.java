/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AVL<k extends Comparable<k> ,v> extends ArbolBinarioBusqueda<k, v>{
    
    private static final byte DIFERENCIA_MAXIMA=1;

    @Override
    public void insertar(k clave, v valor){
        
        if (clave==null) {
            throw new IllegalArgumentException("la clave no puede ser nula");
        }
        if (valor==null) {
            throw new IllegalArgumentException("el valor no puede ser nulo");
        }
        super.raiz=insertar(raiz,clave, valor);
    }

    private NodoBinario<k, v> insertar(NodoBinario<k, v> nodoActual, k clave, v valor) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            NodoBinario<k,v> nuevoNodo=new NodoBinario<>(clave,valor);
            return nuevoNodo;
        }
        if (clave.compareTo(nodoActual.getClave())>0) {
            NodoBinario<k,v> supuestoHijoDer=insertar(nodoActual.getHijoDerecho(), clave, valor);
            nodoActual.setHijoDerecho(supuestoHijoDer);
            return balancear(nodoActual);
        }
        if (clave.compareTo(nodoActual.getClave())<0) {
            NodoBinario<k,v> supuestoHijoIzq=insertar(nodoActual.getHijoIzquierdo(), clave, valor);
            nodoActual.setHijoIzquierdo(supuestoHijoIzq);
            return balancear(nodoActual);
        }
        
        nodoActual.setValor(valor);
        return nodoActual;
    }

    private NodoBinario<k, v> balancear(NodoBinario<k, v> nodoActual) {
       int alturaRamaIzq=altura(nodoActual.getHijoIzquierdo());
       int alturaRamaDer=altura(nodoActual.getHijoDerecho());
       //aqui se tiene que hacer la rotacion a derecha porque el nivel de la izquierda-derecha 
       //sobrepasa la diferencia maxima
        if ((alturaRamaIzq-alturaRamaDer)>DIFERENCIA_MAXIMA) {
            NodoBinario<k,v> hijoIzquierdo=nodoActual.getHijoIzquierdo();
            alturaRamaIzq=altura(hijoIzquierdo.getHijoIzquierdo());
            alturaRamaDer=altura(hijoIzquierdo.getHijoDerecho());
            //aqui se hace rotacion doble a derecha 
            if (alturaRamaDer>alturaRamaIzq) {
                return rotacionDobleDerecha(nodoActual);
            }
            //aqui se hace rotacion simple a derecha
            else {
                return rotacionSimpleDerecha(nodoActual);
            }
        }
        //aqui se tiene que hacer la rotacion a izquierda porque el nivel de la izquierda-derecha 
       //sobrepasa la diferencia maxima
       //la altura de la rama derecha es mucho mayor que la izquierda
        if ((alturaRamaIzq-alturaRamaDer)< -DIFERENCIA_MAXIMA) {
             NodoBinario<k,v> hijoDerecho=nodoActual.getHijoDerecho();
             alturaRamaIzq=altura(hijoDerecho.getHijoIzquierdo());
             alturaRamaDer=altura(hijoDerecho.getHijoDerecho());
             if (alturaRamaIzq>alturaRamaDer) {
                return rotacionDobleIzquierda(nodoActual);
            }else{
                 return rotacionSimpleIzquierda(nodoActual);
             }
             
        }
        return nodoActual;
    }

    private NodoBinario<k, v> rotacionSimpleDerecha(NodoBinario<k, v> nodoActual) {
        NodoBinario<k,v> hijoIzquierdo=nodoActual.getHijoIzquierdo();
        nodoActual.setHijoIzquierdo(hijoIzquierdo.getHijoDerecho());
        hijoIzquierdo.setHijoDerecho(nodoActual);
        return hijoIzquierdo;
    }

    private NodoBinario<k, v> rotacionDobleDerecha(NodoBinario<k, v> nodoActual) {
        nodoActual.setHijoIzquierdo(rotacionSimpleIzquierda(nodoActual.getHijoIzquierdo()));
        return rotacionSimpleDerecha(nodoActual);
    }

    private NodoBinario<k, v> rotacionSimpleIzquierda(NodoBinario<k, v> nodoActual) {
        NodoBinario<k,v> hijoDerecho=nodoActual.getHijoDerecho();
        nodoActual.setHijoDerecho(hijoDerecho.getHijoIzquierdo());
        hijoDerecho.setHijoIzquierdo(nodoActual);
        return hijoDerecho;
    }

    private NodoBinario<k, v> rotacionDobleIzquierda(NodoBinario<k, v> nodoActual) {
        nodoActual.setHijoDerecho(rotacionSimpleDerecha(nodoActual.getHijoDerecho()));
        return rotacionSimpleIzquierda(nodoActual);
    }
    @Override
    public v eliminar(k clave){
        v valor=buscar(clave);
        if (valor==null) {
            return null;
        }
        raiz=eliminar(raiz,clave);
        return valor;
    }

    private NodoBinario<k, v> eliminar(NodoBinario<k, v> nodoActual, k clave) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return NodoBinario.nodoVacio();
        }
        k claveActual=nodoActual.getClave();
        if (clave.compareTo(claveActual)<0) {
            NodoBinario<k,v> supuestoHijoI=eliminar(nodoActual.getHijoIzquierdo(), clave);
            nodoActual.setHijoIzquierdo(supuestoHijoI);
            return balancear(nodoActual);
        }
           if (clave.compareTo(claveActual)>0) {
            NodoBinario<k,v> supuestoHijoD=eliminar(nodoActual.getHijoDerecho(), clave);
            nodoActual.setHijoIzquierdo(supuestoHijoD);
            return balancear(nodoActual);
        }
           //caso 1
           if (nodoActual.esHoja()) {
               return NodoBinario.nodoVacio();
            }
           
           //caso 2
           if (nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()) {
               return nodoActual.getHijoDerecho();
             }
            if (!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()) {
               return nodoActual.getHijoIzquierdo();
             }
            
            //caso 3
             NodoBinario<k,v> nodoDelSucesor=getSucesor(nodoActual.getHijoDerecho());
            NodoBinario<k,v> supuestoHijoDer=eliminar(nodoActual.getHijoDerecho(),nodoDelSucesor.getClave());
            nodoActual.setClave(nodoDelSucesor.getClave());
            nodoActual.setValor(nodoDelSucesor.getValor());
            nodoActual.setHijoDerecho(supuestoHijoDer);
            return balancear(nodoActual);
    }
     private NodoBinario<k,v> getSucesor(NodoBinario<k,v> nodoActual){
      NodoBinario<k,v> nodoAnterior=nodoActual;
      while (!NodoBinario.esNodoVacio(nodoActual)) { 
          nodoAnterior=nodoActual;
          nodoActual=nodoActual.getHijoIzquierdo();
      }
      return nodoAnterior;
  }
}

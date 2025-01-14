/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class ArbolBinarioBusqueda<k extends Comparable<k> ,v> implements IArbolBusqueda<k,v> {
 
    protected NodoBinario<k,v> raiz;
    
    public ArbolBinarioBusqueda(){}
    
    
    
    public void insertar(k clave, v valor) {
        int cambio=0;
        if(esArbolVacio()){
            raiz=new NodoBinario<>(clave,valor);
        }else {
            NodoBinario<k,v> nodoAnterior=NodoBinario.nodoVacio();
            NodoBinario<k,v> nodoActual=raiz;
            do {                
                k claveDelNodoActual=nodoActual.getClave();
                nodoAnterior=nodoActual;
                if (clave.compareTo(claveDelNodoActual)<0){
                    nodoActual=nodoActual.getHijoIzquierdo();
                }else if(clave.compareTo(claveDelNodoActual)>0){
                            nodoActual=nodoActual.getHijoDerecho();
                        }else{
                                 nodoActual.setValor(valor);
                                  return;
                             }
            } while (!NodoBinario.esNodoVacio(nodoActual));
            
            NodoBinario<k,v> nuevoNodo=new NodoBinario<>(clave,valor);
            if(nodoAnterior.getClave().compareTo(clave)<0){
                nodoAnterior.setHijoDerecho(nuevoNodo);
            }else{
                nodoAnterior.setHijoIzquierdo(nuevoNodo);
            }
        }
    }

   
    public v eliminar(k clave) {
        if (clave==null) {
            throw new IllegalArgumentException("la clave a eliminar no puede ser nula");
        }
        v valor=buscar(clave);
        if (valor==null) {
            throw new IllegalArgumentException("la clave a eliminar nose encuentra en el arbol");
        }
        raiz=eliminarR(raiz,clave);
        return valor;
    }
  private NodoBinario<k, v> eliminarR(NodoBinario<k, v> nodoActual, k clave) {
            if (NodoBinario.esNodoVacio(nodoActual)) {
          return null;
              }
            k claveActual=nodoActual.getClave();
            if (clave.compareTo(claveActual)>0) {
                    NodoBinario<k,v> supuestoHijoDer=eliminarR(nodoActual.getHijoDerecho(), clave);
                    nodoActual.setHijoDerecho(supuestoHijoDer);
                    return nodoActual;
                }
            if (clave.compareTo(claveActual)<0) {
                NodoBinario<k,v> supuestoHijoIzq=eliminarR(nodoActual.getHijoIzquierdo(), clave);
                nodoActual.setHijoIzquierdo(supuestoHijoIzq);
                return nodoActual;
            }
            if (nodoActual.esHoja()) {
                   return NodoBinario.nodoVacio();
            }
            if (!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()) {
                return nodoActual.getHijoIzquierdo();
            }
            if (nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()) {
                return nodoActual.getHijoDerecho();
            }
            NodoBinario<k,v> nodoDelSucesor=getSucesor(nodoActual.getHijoDerecho());
            NodoBinario<k,v> supuestoHijoDer=eliminarR(nodoActual.getHijoDerecho(),nodoDelSucesor.getClave());
            nodoActual.setClave(nodoDelSucesor.getClave());
            nodoActual.setValor(nodoDelSucesor.getValor());
            nodoActual.setHijoDerecho(supuestoHijoDer);
            return nodoActual;
                    
    }
  private NodoBinario<k,v> getSucesor(NodoBinario<k,v> nodoActual){
      NodoBinario<k,v> nodoAnterior=nodoActual;
      while (!NodoBinario.esNodoVacio(nodoActual)) { 
          nodoAnterior=nodoActual;
          nodoActual=nodoActual.getHijoIzquierdo();
      }
      return nodoAnterior;
  }
    @Override
    public v buscar(k clave) {
       if(clave==null){
           throw new IllegalArgumentException("la clave no puede ser nula");
       }
       if(esArbolVacio()){
           return null;
       }
       NodoBinario<k,v> nodoActual=raiz;
       
        while (!NodoBinario.esNodoVacio(nodoActual)) {            
            if(nodoActual.getClave().compareTo(clave)==0){
                return nodoActual.getValor();
            }else if(clave.compareTo(nodoActual.getClave())>0){
                nodoActual=nodoActual.getHijoDerecho();
            }else{
                nodoActual=nodoActual.getHijoIzquierdo();
            }
        }
       return null;
    }

    @Override
    public boolean contiene(k clave) {
       return buscar(clave)!=null;
    }

    @Override
    public int size() {
        int nroDeNodos=0;
        if (!esArbolVacio()) {
            Stack<NodoBinario<k,v>> pilaDeNodos=new Stack<>();
            pilaDeNodos.push(raiz);
            while (!pilaDeNodos.isEmpty()) {                
                NodoBinario<k,v> nodoActual=pilaDeNodos.pop();
                nroDeNodos++;
                if (!nodoActual.esVacioHijoDerecho()) {
                    pilaDeNodos.push(nodoActual.getHijoDerecho());
                }
                if (!nodoActual.esVacioHijoIzquierdo()) {
                    pilaDeNodos.push(nodoActual.getHijoIzquierdo());
                }
            }
        }
        return nroDeNodos;
    }

    @Override
    public int altura() {
     return altura(raiz);
    }
    protected int altura(NodoBinario<k,v> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int alturaPorIzq=altura(nodoActual.getHijoIzquierdo());
        int alturaPorDer=altura(nodoActual.getHijoDerecho());
        return alturaPorIzq>alturaPorDer? alturaPorIzq+1:alturaPorDer+1;
    }
    @Override
    public void vaciar() {
        this.raiz=NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(raiz);
    }

    @Override
    public int nivel() {
        if (esArbolVacio()) {
            return 0;
        }
       int nivel=nivel(raiz);
       return nivel;
    }
    private int nivel(NodoBinario<k,v> nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
           return -1;
       }
        int nivelXIzq=nivel(nodoActual.getHijoIzquierdo());
        int nivelXDer=nivel(nodoActual.getHijoDerecho());
        return nivelXIzq>nivelXDer? nivelXIzq+1:nivelXDer+1;
    }
    
    
    
    public List<k> recorridoInOrden(){
       List<k> recorrido=new LinkedList<>();
        if (esArbolVacio()) {
            return recorrido;
        }
        Stack<NodoBinario<k,v>> pilaDeNodos=new Stack<>();
        pilaDeNodos.push(raiz);
        while (!pilaDeNodos.isEmpty()) {            
            NodoBinario<k,v> nodoActual=pilaDeNodos.peek();
              if (!nodoActual.esVacioHijoIzquierdo()) {
                  while (!nodoActual.esVacioHijoIzquierdo()) {                      
                      pilaDeNodos.push(nodoActual.getHijoIzquierdo());
                      nodoActual=pilaDeNodos.peek();
                  }
                  
              }
                  nodoActual=pilaDeNodos.pop();
                  recorrido.add(nodoActual.getClave());
                  if (nodoActual.esVacioHijoDerecho()) {
                      while (nodoActual.esVacioHijoDerecho() && !pilaDeNodos.isEmpty()) {                          
                          nodoActual=pilaDeNodos.pop();
                          recorrido.add(nodoActual.getClave());
                          if (!nodoActual.esVacioHijoDerecho()) {
                              pilaDeNodos.push(nodoActual.getHijoDerecho());
                          }
                      }
                  }else{
                      pilaDeNodos.push(nodoActual.getHijoDerecho());
                  }
            }
        
        return recorrido;
    }
    public List<k> recorridoPorNiveles(){
       List<k> recorrido=new LinkedList<>();
       
       
       if (!esArbolVacio()){
           Queue<NodoBinario<k,v>> colaDeNodos=new LinkedList<>();
           colaDeNodos.add(raiz);
           do {   
               NodoBinario<k,v> nodoActual=colaDeNodos.poll();
               recorrido.add(nodoActual.getClave());
               if (!nodoActual.esVacioHijoIzquierdo()) {
                   colaDeNodos.add(nodoActual.getHijoIzquierdo());
               }
               if(!nodoActual.esVacioHijoDerecho()){
                   colaDeNodos.add(nodoActual.getHijoDerecho());
               }
           } while (!colaDeNodos.isEmpty());
       }
       return recorrido;
    }
    public List<k> recorridoPostOrden(){
         List<k> recorrido=new LinkedList<>();
         if(esArbolVacio()){
             return recorrido;
         }
        Stack<NodoBinario<k,v>> pilaDeNodos=new Stack<>();
        NodoBinario<k,v> nodoActual=raiz;
        //NodoBinario<k,v> nodoAnterior=NodoBinario.nodoVacio();
        
        meterPilaParaPostOrden(pilaDeNodos, nodoActual);
        
        while (!pilaDeNodos.isEmpty()) {            
            nodoActual=pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());
            if (!pilaDeNodos.isEmpty()) {
                NodoBinario<k,v> nodoTope=pilaDeNodos.peek();
                if (!nodoTope.esVacioHijoDerecho() && nodoTope.getHijoDerecho()!=nodoActual) {
                    meterPilaParaPostOrden(pilaDeNodos, nodoTope.getHijoDerecho());
                    
                }
            }
        }
        return recorrido;
    }
    private void meterPilaParaPostOrden(Stack<NodoBinario<k,v>> pilaDeNodos,NodoBinario<k,v> nodoActual){
         while (!NodoBinario.esNodoVacio(nodoActual)) {            
            pilaDeNodos.push(nodoActual);
            if(!nodoActual.esVacioHijoIzquierdo()){
                nodoActual=nodoActual.getHijoIzquierdo();
            }else{
                 nodoActual=nodoActual.getHijoDerecho();
            }
           // nodoAnterior=nodoActual;
            //nodoActual=nodoActual.getHijoIzquierdo();
            
        }
    }
    public List<k> recorridoPreOrden(){
         List<k> recorrido=new LinkedList<>();
       
       
       if (!esArbolVacio()){
           Stack<NodoBinario<k,v>> pilaDeNodos=new Stack<>();
           pilaDeNodos.add(raiz);
           do {   
               NodoBinario<k,v> nodoActual=pilaDeNodos.pop();
               recorrido.add(nodoActual.getClave());
               
               if(!nodoActual.esVacioHijoDerecho()){
                   pilaDeNodos.add(nodoActual.getHijoDerecho());
               }
               if (!nodoActual.esVacioHijoIzquierdo()) {
                   pilaDeNodos.add(nodoActual.getHijoIzquierdo());
               }
           } while (!pilaDeNodos.isEmpty());
       }
       return recorrido;
    }
    public void ArbolBinarioBusquedaReconstruido(List<k> clavesInOrden,List<v> valoresInOrden
                                ,List<k> clavesPreOrden,List<v> valoresPreOrden,boolean conPreOrden){
        if (conPreOrden) {
            raiz=ReconstruirArbolConPreOrden( clavesInOrden, valoresInOrden, clavesPreOrden, valoresPreOrden);
        }else{
            raiz=ReconstruirArbolConNoPreOrden( clavesInOrden, valoresInOrden, clavesPreOrden, valoresPreOrden);
        }
        
    }
    private NodoBinario<k,v> ReconstruirArbolConPreOrden(List<k> clavesInOrden,List<v> valoresInOrden,List<k> clavesPreOrden,List<v> valoresPreOrden){
      
        return null;
    }

    private NodoBinario<k, v> ReconstruirArbolConNoPreOrden(List<k> clavesInOrden, List<v> valoresInOrden, List<k> clavesPreOrden, List<v> valoresPreOrden) {
       return null;
    }

    public k minimo() {
       
        k claveMinima=minimo(raiz);
        return  claveMinima;
    }
    //retorna la clave minima del arbol
    private k minimo(NodoBinario<k,v> nodoActual){
       if (NodoBinario.esNodoVacio(nodoActual)) {
            return null;
        }
        k minimoXIzq=minimo(nodoActual.getHijoIzquierdo());
        k minimoXDer=minimo(nodoActual.getHijoDerecho());
        k claveActual=nodoActual.getClave();
        if (minimoXIzq==null || minimoXDer==null) {
            return claveActual;
        }
        if (minimoXIzq.compareTo(minimoXDer)<0) {
            return minimoXIzq.compareTo(claveActual)<0? minimoXIzq:claveActual;
        }
        return minimoXDer.compareTo(claveActual)<0? minimoXDer:claveActual;
    }
//metodo que retorna la cantidad de hijos izquierdos que tiene todo el arbol
    
  public int cantidadDeHijosIzq(){
      
      int cantidad=cantidadDeHijosIzq(raiz);
      
      return cantidad;
  }

    private int cantidadDeHijosIzq(NodoBinario<k, v> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int nroHijosXIzq=cantidadDeHijosIzq(nodoActual.getHijoIzquierdo());
        int nroHijosXDer=cantidadDeHijosIzq(nodoActual.getHijoDerecho());
        int cantidad=nroHijosXDer+nroHijosXIzq;
        if(!NodoBinario.esNodoVacio(nodoActual.getHijoIzquierdo())){
            cantidad++;
          }
  return cantidad;
}

 
    public int cantidadDeHijosIzquierdo(int nivel){
        int cantidad=cantidadDeHijosIzq(raiz,nivel,0);
        return cantidad;
    }

    private int cantidadDeHijosIzq(NodoBinario<k, v> nodoActual, int nivel,int nivelActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        if (nivelActual<nivel) {
            int CantidadHijosXIzq=cantidadDeHijosIzq(nodoActual.getHijoIzquierdo(), nivel, nivelActual+1);
            int CantidadHijosXDer=cantidadDeHijosIzq(nodoActual.getHijoDerecho(), nivel, nivelActual+1);
            return CantidadHijosXDer+CantidadHijosXDer;
        }
        if (!NodoBinario.esNodoVacio(nodoActual.getHijoIzquierdo())) {
            return 1;
        }
        return 0;
    }

    public NodoBinario<k,v> getRaiz() {
    return raiz;
    }

    @Override
    public int getOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

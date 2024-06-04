/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class ArbolMViasBusqueda<k extends Comparable<k> ,v> implements 
        IArbolBusqueda<k,v> {

    protected NodoMVias<k,v> raiz;
    protected int orden;
    
    public ArbolMViasBusqueda(){
        this.orden=3;
    }
    public ArbolMViasBusqueda(int orden){
        if (orden<3) {
            throw new IllegalArgumentException("el orden debe ser mayor a 3");
        }
        this.orden=orden;
    }
    @Override
    public void insertar(k claveAInsertar, v valorAInsertar) {
        if(esArbolVacio()){
            raiz=new NodoMVias<>(orden,claveAInsertar,valorAInsertar);
            return;
        }
        NodoMVias<k,v> nodoActual=raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {            
            int posicionDatoExistente=existeClaveEnNodo(nodoActual,claveAInsertar);
            if (posicionDatoExistente!=-1) {
                nodoActual.setValor(posicionDatoExistente, valorAInsertar);
                return;
            }
            if (nodoActual.esHoja()) {
                if (nodoActual.estanClavesLlenas()) {
                    int posicionPorDondeBajar=porDondeBajar(nodoActual,claveAInsertar);
                    NodoMVias<k,v> nuevoNodo=new NodoMVias<>(orden,claveAInsertar,valorAInsertar);
                    nodoActual.setHijo(posicionPorDondeBajar, nuevoNodo);
                }else{
                    insertarDatosOrdenados(nodoActual,claveAInsertar,valorAInsertar);
                    
                }
                return;
            }else{
                int posicionPorDondeBajar=porDondeBajar(nodoActual,claveAInsertar);
                if (nodoActual.esHijoVacio(posicionPorDondeBajar)) {
                    NodoMVias<k,v> nuevoNodo=new NodoMVias<>(orden,claveAInsertar,valorAInsertar);
                    nodoActual.setHijo(posicionPorDondeBajar, nuevoNodo);
                    return;
                }else{
                    nodoActual=nodoActual.getHijo(posicionPorDondeBajar);
                }
            }
        }
    }

    @Override
    public v eliminar(k clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public v buscar(k claveABuscar) {
        NodoMVias<k,v> nodoActual=raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {            
            boolean huboCambio=false;
            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias() && !huboCambio; i++) {
                k claveActual=nodoActual.getclave(i);
                if (claveABuscar.compareTo(claveActual)==0) {
                    return nodoActual.getValor(i);
                }
                if (claveABuscar.compareTo(claveActual)<0) {
                    nodoActual=nodoActual.getHijo(i);
                    huboCambio=true;
                }
            }
           
        }
        return (v)NodoMVias.datoVacio();
    }

    @Override
    public boolean contiene(k clave) {
        return buscar(clave)!=null;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vaciar() {
        this.raiz=NodoMVias.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoMVias.esNodoVacio(raiz);
    }

    @Override
    public int nivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<k> recorridoInOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<k> recorridoPorNiveles() {
        List<k> recorrido=new LinkedList<>();
       
       
       if (!esArbolVacio()){
           Queue<NodoMVias<k,v>> colaDeNodos=new LinkedList<>();
           colaDeNodos.add(raiz);
           do {   
               NodoMVias<k,v> nodoActual=colaDeNodos.poll();
               for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
                   recorrido.add(nodoActual.getclave(i));
                   if (!nodoActual.esHijoVacio(i)) {
                       colaDeNodos.offer(nodoActual.getHijo(i));
                   }
               }
               if (!nodoActual.esHijoVacio(nodoActual.cantidadDeClavesNoVacias())) {
                       colaDeNodos.offer(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
                   }
           } while (!colaDeNodos.isEmpty());
       }
       return recorrido;
    }

    @Override
    public List<k> recorridoPostOrden() {
        
        List<k> recorrido=new LinkedList<>();
         recorridoPostOrden(raiz,recorrido);
         return recorrido;
    }

    @Override
    public List<k> recorridoPreOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadDeHijosIzq() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public k minimo() {
        if (esArbolVacio()) {
            return null;
        }
        NodoMVias<k,v> nodoActual=raiz;
        NodoMVias<k,v> nodoAnterior=nodoActual;
        while (!NodoMVias.esNodoVacio(nodoActual)) {            
            nodoAnterior=nodoActual;
            nodoActual=nodoActual.getHijo(0);
        }
        return nodoAnterior.getclave(0);
        
    }

 
    private void recorridoPostOrden(NodoMVias<k, v> nodoActual, List<k> recorrido) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return ;
        }
        recorridoPostOrden(nodoActual.getHijo(0), recorrido);
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            
            recorridoPostOrden(nodoActual.getHijo(i+1), recorrido);
            recorrido.add(nodoActual.getclave(i)); 
        }
    }
    public int cantidadDeClavesVaciasAntesDelNivel(int nivel){
        if (esArbolVacio()) {
            return 0;
        }
        Queue<NodoMVias<k,v>> colaDeNodos=new LinkedList<>();
        int cantidad=0;
        
        colaDeNodos.add(raiz);
        
        int nivelActual=0;
        do {            
            NodoMVias<k,v> nodoActual=colaDeNodos.poll();
            cantidad=cantidad+orden-1-nodoActual.cantidadDeClavesNoVacias();
            nivelActual++;
            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias() && nivelActual<nivel; i++) {
                if (!nodoActual.esHijoVacio(i)) {
                    colaDeNodos.add(nodoActual.getHijo(i));
                }
            }
            if (!nodoActual.esHijoVacio(nodoActual.cantidadDeClavesNoVacias())&& nivelActual<nivel ) {
                    colaDeNodos.add(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
                }
        } while(!colaDeNodos.isEmpty());
        return cantidad;
    }

    public int existeClaveEnNodo(NodoMVias<k, v> nodoActual,k claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            k claveActual=nodoActual.getclave(i);
            if(claveABuscar.compareTo(claveActual)==0){
                return i;
            }
            
        }
        return -1;
    }

    public int porDondeBajar(NodoMVias<k, v> nodoActual, k claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
             k claveActual=nodoActual.getclave(i);
            if(claveABuscar.compareTo(claveActual)<0){
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    public void insertarDatosOrdenados(NodoMVias<k, v> nodoActual, k claveAInsertar, v valorAInsertar) {
        int cont=0;
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            cont++;
             k claveActual=nodoActual.getclave(i);
            if(claveAInsertar.compareTo(claveActual)<0){
                for (int j = nodoActual.cantidadDeClavesNoVacias()-1; j>=i; j--) {
                    nodoActual.setClave(j+1,nodoActual.getclave(j));
                    nodoActual.setValor(j+1,nodoActual.getValor(j));
                    
                }
                nodoActual.setClave(i, claveAInsertar);
                nodoActual.setValor(i, valorAInsertar);
                return;
            }
            
        }
         nodoActual.setClave(cont, claveAInsertar);
         nodoActual.setValor(cont, valorAInsertar);
        
    }

   public NodoMVias<k,v> obtenerNodoRaiz() {
        return raiz;
    }
   public int cantidadDeClavesVacias(){
       return cantidadDeClavesVacias(raiz);
   }

    private int cantidadDeClavesVacias(NodoMVias<k, v> nodoActual) {
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return 0;
        }
        int cantidad=0;
        for (int i = 0; i < orden-1; i++) {
            cantidad=cantidad+cantidadDeClavesVacias(nodoActual.getHijo(i));
            if (nodoActual.esClaveVacia(i)) {
                cantidad++;
            }
        }
        cantidad=cantidad+cantidadDeClavesVacias(nodoActual.getHijo(orden-1));
        return cantidad;
    }
    public int cantidadDeHojas(){
        return cantidadDeHojas(raiz);
    }
    private int cantidadDeHojas(NodoMVias<k,v> nodoActual){
        if (nodoActual.esHoja()) {
            return 1;
        }
        int cantidad=0;
        for(int i = 0; i < orden-1; i++) {
            if (!nodoActual.esHijoVacio(i)) {
                cantidad=cantidad+cantidadDeHojas(nodoActual.getHijo(i));
            }
        }
        cantidad=cantidad+cantidadDeHojas(nodoActual.getHijo(orden-1));
        return cantidad;
    }

    @Override
    public NodoMVias<k, v> getRaiz() {
    return this.raiz;
}
    public int getOrden(){
        return orden;
    }
}

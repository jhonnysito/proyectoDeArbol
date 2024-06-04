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
public class NodoBinario<k,v> {
    private k clave;
    private v valor;
    
    private NodoBinario<k,v> hijoIzquierdo;
    private NodoBinario<k,v> hijoDerecho;
    
    public NodoBinario(){
    }
    
    public NodoBinario(k clave,v valor){
        this.clave=clave;
        this.valor=valor;
    }

    public void setClave(k clave) {
        this.clave = clave;
    }

    public void setValor(v valor) {
        this.valor = valor;
    }

    public void setHijoIzquierdo(NodoBinario<k, v> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoBinario<k, v> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public k getClave() {
        return clave;
    }

    public v getValor() {
        return valor;
    }

    public NodoBinario<k, v> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoBinario<k, v> getHijoDerecho() {
        return hijoDerecho;
    }
    public static NodoBinario nodoVacio() {
        return null;
    }
    public static boolean esNodoVacio(NodoBinario unNodo){
        return unNodo==NodoBinario.nodoVacio();
    }
    public boolean esVacioHijoIzquierdo(){
        return NodoBinario.esNodoVacio(this.getHijoIzquierdo());
    }
    public boolean esVacioHijoDerecho(){
        return NodoBinario.esNodoVacio(this.getHijoDerecho());
    }
    public boolean esHoja(){
        return this.esVacioHijoIzquierdo() && this.esVacioHijoDerecho();
    }
}

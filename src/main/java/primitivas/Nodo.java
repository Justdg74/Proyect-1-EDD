/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author luisa
 */
public class Nodo<T> {
    
    private Nodo nodoSiguiente;
    private static int id = -1;
    
    public Nodo(T dato) {
        this.nodoSiguiente = null;
        id++;
    }

    /**
     * @return the nodoSiguiente
     */
    public Nodo getNodoSiguiente() {
        return nodoSiguiente;
    }

    /**
     * @param nodoSiguiente the nodoSiguiente to set
     */
    public void setNodoSiguiente(Nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    /**
     * @return the id
     */
    public static int getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(int aId) {
        id = aId;
    }

    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author luisa
 */
public class Lista<T> {

    private Nodo nodoPrimero;
    private int longitud;

    public Lista() {
        this.nodoPrimero = null;
        this.longitud = 0;
    }

    /**
     * @return the nodoPrimero
     */
    public Nodo getNodoPrimero() {
        return nodoPrimero;
    }

    /**
     * @param nodoPrimero the nodoPrimero to set
     */
    public void setNodoPrimero(Nodo nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    /**
     * @return the longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public boolean esVacia() {
        return this.getNodoPrimero() == null;
    }

    public void vaciar() {
        this.setNodoPrimero(null);
        this.setLongitud(0);
    }

    public void agregarAlFinal(T dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (this.esVacia()) {
            this.setNodoPrimero(nuevoNodo);
        } else {
            Nodo nodoUltimo = this.obtenerNodoUltimo();
            nodoUltimo.setNodoSiguiente(nuevoNodo);
        }
        longitud++;
    }

    public Nodo obtenerNodoUltimo() {
        if (this.esVacia()) {
            return null;
        } else {
            Nodo nodoAux = this.getNodoPrimero();
            while (nodoAux.getNodoSiguiente() != null) {
                nodoAux = nodoAux.getNodoSiguiente();
            }
            Nodo nodoUltimo = nodoAux;
            return nodoUltimo;
        }
    }

    public boolean buscar(int id) {
        if (!this.esVacia()) {
            Nodo nodoAux = this.getNodoPrimero();
            while (nodoAux != null) {
                if (nodoAux.getId() != id) {
                    nodoAux = nodoAux.getNodoSiguiente();
                } else {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void eliminar(int id) {
        if (!this.esVacia()) {
            boolean estaEnLista = this.buscar(id);
            Nodo nodoAux = this.getNodoPrimero();
            Nodo nodoAnterior = null;
            if (estaEnLista) {
                if (this.getNodoPrimero().getId() == id) {
                    this.setNodoPrimero(nodoAux.getNodoSiguiente());
                    nodoAux.setNodoSiguiente(null);
                } else {
                    while (nodoAux.getId() != id) {
                        nodoAnterior = nodoAux;
                        nodoAux = nodoAux.getNodoSiguiente();
                    }
                    nodoAnterior.setNodoSiguiente(nodoAux.getNodoSiguiente());
                }

            }

        }
    }

    public int buscarPorPosicion(int posListaAdya) {
        Nodo nodoAux = this.getNodoPrimero();
        int aux = 0;
        while (aux != posListaAdya) {
            nodoAux = nodoAux.getNodoSiguiente();
            aux++;
        }
        return nodoAux.getId();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

import java.util.Random;

/**
 *
 * @author luisa
 */
public class Grafo {

    private int numFilas;
    private int numColumnas;
    private int maxVertices = numFilas * numColumnas;
    private int cantidadVert;
    private Lista[] arregloVertices;
    private int[] verticesBorde;

    public Grafo(int m, int n) {
        this.cantidadVert = 0;
        this.numFilas = m;
        this.numColumnas = n;
        this.maxVertices = m * n;
        this.arregloVertices = new Lista[m * n];
        this.verticesBorde = new int[m * n - (m - 2) * (n - 2)];

        this.determinarNodosBorde();
        this.insertarVertice(this.getNumFilas() * this.getNumColumnas());
    }

    public void insertarArista(int i, int j) {
        if (i < getCantidadVert()) {
            getArregloVertices()[i].agregarAlFinal(j);
            getArregloVertices()[j].agregarAlFinal(i);
        }
    }

    public void eliminarArista(int i, int j) {
        if (j < getCantidadVert()) {
            getArregloVertices()[i].eliminar(j);
            getArregloVertices()[j].eliminar(i);
        }
    }

    public void insertarVertice(int num) {
        if (num <= getMaxVertices() - getCantidadVert()) {
            for (int i = getCantidadVert(); i < getCantidadVert() + num; i++) {
                getArregloVertices()[i] = new Lista();
            }
            setCantidadVert(getCantidadVert() + num);
        }
    }

    public int tamanio() {
        int tamanio = 0;
        for (int i = 0; i < getCantidadVert(); i++) {
            tamanio += this.getArregloVertices()[i].getLongitud();
        }
        tamanio = tamanio / 2;
        return tamanio;
    }

    public int gradoEntrada(int vertice) {
        int entrada = 0;
        for (int i = 0; i < getCantidadVert(); i++) {
            if (i != vertice) {
                if (getArregloVertices()[i].buscar(vertice)) {
                    entrada++;
                }
            }
        }
        return entrada;
    }

    public int incidencia(int i) {
        return gradoEntrada(i);
    }

    public void determinarNodosBorde() {
        int aux = 0;
        for (int i = 0; i < this.getMaxVertices(); i++) {
            if (i < this.getNumColumnas()) {
                this.verticesBorde[aux] = i;
                aux++;
            } else if (i > (this.getNumFilas() - 1) * this.getNumColumnas()) {
                this.verticesBorde[aux] = i;
                aux++;
            } else if (i >= this.getNumColumnas()) {
                for (int j = 0; j < this.getNumFilas(); j++) {
                    if (i == this.getNumColumnas() * j) {
                        this.verticesBorde[aux] = i;
                        aux++;
                    } else if (i == ((j + 1) * this.getNumColumnas()) - 1) {
                        this.verticesBorde[aux] = i;
                        aux++;
                    }
                }
            }
        }
    }

    public void InicializarGrafo() {

        //Aristas de las cuatros esquinas del laberinto//
        this.insertarArista(0, 1);
        this.insertarArista(0, this.getMaxVertices());
        this.insertarArista(this.getMaxVertices() - 1, this.getMaxVertices() - 2);
        this.insertarArista(this.getMaxVertices() - 1, (2 * this.getMaxVertices()) - 1);
        this.insertarArista((this.getMaxVertices() * this.getMaxVertices()) - this.getMaxVertices(), (this.getMaxVertices() * this.getMaxVertices()) - (2 * this.getMaxVertices()));
        this.insertarArista((this.getMaxVertices() * this.getMaxVertices()) - this.getMaxVertices(), (this.getMaxVertices() * this.getMaxVertices()) - this.getMaxVertices() + 1);
        this.insertarArista((this.getMaxVertices() * this.getMaxVertices()) - 1, (this.getMaxVertices() * this.getMaxVertices()) - this.getMaxVertices() - 1);
        this.insertarArista((this.getMaxVertices() * this.getMaxVertices()) - 1, (this.getMaxVertices() * this.getMaxVertices()) - 2);

        //Aristas del borde superior del laberinto//
        for (int i = 1; i < (this.getMaxVertices() - 1); i++) {
            if (!this.getArregloVertices()[i].buscar(i - 1)) {
                this.insertarArista(i, i - 1);
            }
            if (!this.getArregloVertices()[i].buscar(i + 1)) {
                this.insertarArista(i, i + 1);
            }
            if (!this.getArregloVertices()[i].buscar(this.maxVertices + i)) {
                this.insertarArista(i, this.getMaxVertices() + i);
            }
        }

        //Aristas del borde inferior del laberinto//
        for (int i = (this.getMaxVertices() * this.getMaxVertices()) - this.getMaxVertices() + 1; i < (this.getMaxVertices() * this.getMaxVertices()) - 1; i++) {

            if (!this.getArregloVertices()[i].buscar(i - 1)) {
                this.insertarArista(i, i - 1);
            }
            if (!this.getArregloVertices()[i].buscar(i + 1)) {
                this.insertarArista(i, i + 1);
            }
            if (!this.getArregloVertices()[i].buscar((this.maxVertices * this.maxVertices) - (2 * this.maxVertices) + (i - ((this.maxVertices * this.maxVertices) - this.maxVertices)))) {
                this.insertarArista(i, (this.getMaxVertices() * this.getMaxVertices()) - (2 * this.getMaxVertices()) + (i - ((this.getMaxVertices() * this.getMaxVertices()) - this.getMaxVertices())));
            }

        }

        //Aristas del borde izquierdo del laberinto//
        for (int i = this.getMaxVertices(); i < (this.getMaxVertices() * this.getMaxVertices()) - this.getMaxVertices(); i = i + this.getMaxVertices()) {
            if (!this.getArregloVertices()[i].buscar(i - this.maxVertices)) {
                this.insertarArista(i, i - this.getMaxVertices());
            }
            if (!this.getArregloVertices()[i].buscar(i + this.maxVertices)) {
                this.insertarArista(i, i + this.getMaxVertices());
            }
            if (!this.getArregloVertices()[i].buscar(i + 1)) {
                this.insertarArista(i, i + 1);
            }
        }

        //Aristas del borde derecho del laberinto//
        for (int i = (2 * this.getMaxVertices()) - 1; i < (this.getMaxVertices() * this.getMaxVertices()) - 1; i = i + this.getMaxVertices()) {
            if (!this.getArregloVertices()[i].buscar(i - this.maxVertices)) {
                this.insertarArista(i, i - this.getMaxVertices());
            }
            if (!this.getArregloVertices()[i].buscar(i + this.maxVertices)) {
                this.insertarArista(i, i + this.getMaxVertices());
            }
            if (!this.getArregloVertices()[i].buscar(i - 1)) {
                this.insertarArista(i, i - 1);
            }
        }

        //Aristas del resto del laberinto//
        for (int i = (this.getMaxVertices() + 1); i < (this.getMaxVertices() * this.getMaxVertices()) - this.getMaxVertices() + 1; i = i + this.getMaxVertices()) {
            for (int j = i; j < (i + this.getMaxVertices() - 2); j++) {
                if (!this.getArregloVertices()[j].buscar(j - this.maxVertices)) {
                    this.insertarArista(j, j - this.getMaxVertices());
                }
                if (!this.getArregloVertices()[j].buscar(j + this.maxVertices)) {
                    this.insertarArista(j, j + this.getMaxVertices());
                }
                if (!this.getArregloVertices()[j].buscar(j - 1)) {
                    this.insertarArista(j, j - 1);
                }
                if (!this.getArregloVertices()[j].buscar(j + 1)) {
                    this.insertarArista(j, j + 1);
                }
            }
        }

    }

    public Grafo arbolExpansionPrim() {
        int nodoVisitado;
        int proximoNodoRand;
        Grafo grafoLaberinto = new Grafo(this.getNumFilas(), this.getNumColumnas());
        Lista nodosNoVisitados = new Lista();
        Random rand = new Random();
        int seleccionNoVisitados;
        int nodoAnterior;
        int nodoNuevo;
        
        for (int i = 0; i < grafoLaberinto.getCantidadVert(); i++) {
            nodosNoVisitados.agregarAlFinal(i);
        }

        // Selecciona un nodo aleatorio que este en el borde
        proximoNodoRand = rand.nextInt(grafoLaberinto.getVerticesBorde().length);
        nodoVisitado = grafoLaberinto.getVerticesBorde()[proximoNodoRand];

        // Guarda el primer nodo, que es la entrada, en la posicion 0 del arreglo
        nodosNoVisitados.eliminar(nodoVisitado);
        
        nodoAnterior = nodoVisitado;

        for (int i = 0; i < grafoLaberinto.getCantidadVert(); i++) {

            // Selecciona aleatoriamente la posicion del siguiente nodo adyacente a nodoVisitado en la lista de adyacencia de nodoVisitado
            proximoNodoRand = rand.nextInt(grafoLaberinto.getArregloVertices()[nodoVisitado].getLongitud());

            // Luego, determina cual es la posicion del nodo adyacente a nodoVisitado seleccionado en el grafo.
            // El nodo adyacente anteriormente seleccionado pasa a ser nodoVisitado
            nodoVisitado = grafoLaberinto.getArregloVertices()[nodoVisitado].buscarPorPosicion(proximoNodoRand);
            nodoNuevo = nodoVisitado;

            // Despues, guarda en la siguiente posicion el ID del nodo en el arreglo de los visitados
            nodosNoVisitados.eliminar(nodoVisitado);
            grafoLaberinto.insertarArista(nodoAnterior, nodoNuevo);

            // Determina aleatoriamente el nuevo nodo nodoVisitado de la lista del arreglo de visitados
            seleccionNoVisitados = rand.nextInt(nodosNoVisitados.getLongitud());
            nodoVisitado = nodosNoVisitados.buscarPorPosicion(seleccionNoVisitados);
            
            nodoAnterior = nodoVisitado;
        }

        return grafoLaberinto;

    }

    /**
     * @return the numFilas
     */
    public int getNumFilas() {
        return numFilas;
    }

    /**
     * @param numFilas the numFilas to set
     */
    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    /**
     * @return the numColumnas
     */
    public int getNumColumnas() {
        return numColumnas;
    }

    /**
     * @param numColumnas the numColumnas to set
     */
    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    /**
     * @return the maxVertices
     */
    public int getMaxVertices() {
        return maxVertices;
    }

    /**
     * @param maxVertices the maxVertices to set
     */
    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }

    /**
     * @return the cantidadVert
     */
    public int getCantidadVert() {
        return cantidadVert;
    }

    /**
     * @param cantidadVert the cantidadVert to set
     */
    public void setCantidadVert(int cantidadVert) {
        this.cantidadVert = cantidadVert;
    }

    /**
     * @return the arregloVertices
     */
    public Lista[] getArregloVertices() {
        return arregloVertices;
    }

    /**
     * @param arregloVertices the arregloVertices to set
     */
    public void setArregloVertices(Lista[] arregloVertices) {
        this.arregloVertices = arregloVertices;
    }

    /**
     * @return the verticesBorde
     */
    public int[] getVerticesBorde() {
        return verticesBorde;
    }

    /**
     * @param verticesBorde the verticesBorde to set
     */
    public void setVerticesBorde(int[] verticesBorde) {
        this.verticesBorde = verticesBorde;
    }

}

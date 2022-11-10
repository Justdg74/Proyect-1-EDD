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
public class ArbolExpansionMinimo {

    Random rand = new Random();
    private int n;
    private Grafo grafo;

    public ArbolExpansionMinimo(Grafo grafo) {
        this.n = grafo.getCantidadVert();
        this.grafo = grafo;
    }

    public boolean[] arbolExpansionPrim() {
        int nodoVisitado;
        int proximoNodoRand;
        boolean[] nodosVisitados = new boolean[this.n];

        // Selecciona un nodo aleatorio que este en el borde
        proximoNodoRand = rand.nextInt(grafo.getVerticesBorde().length);
        nodoVisitado = grafo.getVerticesBorde()[proximoNodoRand];

        // Guarda el primer nodo, que es la entrada, en la posicion 0 del arreglo
        nodosVisitados[nodoVisitado] = true;

        for (int i = 0; i < n; i++) {

            // Selecciona aleatoriamente la posicion del siguiente nodo adyacente a nodoVisitado en la lista de adyacencia de nodoVisitado
            proximoNodoRand = rand.nextInt(grafo.getArregloVertices()[nodoVisitado].getLongitud());

            // Luego, determina cual es la posicion del nodo adyacente a nodoVisitado seleccionado en el grafo.
            // El nodo adyacente anteriormente seleccionado pasa a ser nodoVisitado
            nodoVisitado = grafo.getArregloVertices()[nodoVisitado].buscarPorPosicionAdy(proximoNodoRand);

            // Despues, guarda en la siguiente posicion el ID del nodo en el arreglo de los visitados
            nodosVisitados[nodoVisitado] = true;

            // Determina aleatoriamente el nuevo nodo nodoVisitado de la lista del arreglo de visitados
            do {
                nodoVisitado = rand.nextInt(nodosVisitados.length);
            } while (nodosVisitados[nodoVisitado] == false);
        }

        return nodosVisitados;

    }

}

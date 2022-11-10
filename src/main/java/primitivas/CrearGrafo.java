
package primitivas;

public class CrearGrafo {
    int n = 30;
    Grafo myGrafo = new Grafo(n*n);
    
    
    public Grafo InicializarGrafo(){

        
        myGrafo.insertarVertice(n*n);
        
        //Aristas de las cuatros esquinas del laberinto//
        myGrafo.insertarArista(0, 1);
        myGrafo.insertarArista(0, n);
        myGrafo.insertarArista(n-1, n-2);
        myGrafo.insertarArista(n-1, (2*n)-1);
        myGrafo.insertarArista((n*n)-n, (n*n)-(2*n));
        myGrafo.insertarArista((n*n)-n, (n*n)-n+1);
        myGrafo.insertarArista((n*n)-1, (n*n)-n-1);
        myGrafo.insertarArista((n*n)-1, (n*n)-2);
        
        //Aristas del borde superior del laberinto//
        for (int i = 1; i < (n - 1); i++) {
            if (!myGrafo.getListaAdya()[i].buscar(i-1)) {
                myGrafo.insertarArista(i, i - 1);
            }    
            if (!myGrafo.getListaAdya()[i].buscar(i+1)){
                myGrafo.insertarArista(i, i + 1);
            }
            if (!myGrafo.getListaAdya()[i].buscar(n+i)){
                myGrafo.insertarArista(i, n + i);
            }
        }
        
        //Aristas del borde inferior del laberinto//
        for (int i = (n * n) - n + 1; i < (n * n)-1; i++) {

            if (!myGrafo.getListaAdya()[i].buscar(i - 1)) {
                myGrafo.insertarArista(i, i - 1);
            }
            if (!myGrafo.getListaAdya()[i].buscar(i + 1)) {
                myGrafo.insertarArista(i, i + 1);
            }
            if (!myGrafo.getListaAdya()[i].buscar((n * n) - (2 * n) + (i - ((n * n) - n )))) {
                myGrafo.insertarArista(i, (n * n) - (2 * n) + (i - ((n * n) - n )));
            }

        }
        
        //Aristas del borde izquierdo del laberinto//
        for (int i = n; i < (n*n)-n; i=i+n) {
            if (!myGrafo.getListaAdya()[i].buscar(i-n)) {
                myGrafo.insertarArista(i, i - n);
            }    
            if (!myGrafo.getListaAdya()[i].buscar(i+n)){
                myGrafo.insertarArista(i, i + n);
            }
            if (!myGrafo.getListaAdya()[i].buscar(i+1)){
                myGrafo.insertarArista(i, i+1);
            }
        }
        
        //Aristas del borde derecho del laberinto//
        for (int i = (2*n)-1; i < (n*n)-1; i=i+n) {
            if (!myGrafo.getListaAdya()[i].buscar(i-n)) {
                myGrafo.insertarArista(i, i - n);
            }    
            if (!myGrafo.getListaAdya()[i].buscar(i+n)){
                myGrafo.insertarArista(i, i + n);
            }
            if (!myGrafo.getListaAdya()[i].buscar(i-1)){
                myGrafo.insertarArista(i, i-1);
            }
        }
        
        //Aristas del resto del laberinto//
        for (int i = (n+1); i < (n*n)-n+1; i=i+n) {
            for (int j = i; j < (i+n-2); j++) {
                if (!myGrafo.getListaAdya()[j].buscar(j-n)) {
                    myGrafo.insertarArista(j, j - n);
                }    
                if (!myGrafo.getListaAdya()[j].buscar(j+n)){
                    myGrafo.insertarArista(j, j + n);
                }
                if (!myGrafo.getListaAdya()[j].buscar(j-1)){
                    myGrafo.insertarArista(j, j-1);
                }
                if (!myGrafo.getListaAdya()[j].buscar(j+1)){
                    myGrafo.insertarArista(j, j+1);
                }
            }
        }
        
        return myGrafo;
        

        
    }
}

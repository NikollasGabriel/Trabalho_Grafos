package grafos;

public class Aresta {
    
    private int numeroAresta;
    private Vertice vertice;

    public int getNumeroAresta() {
        return numeroAresta;
    }

    public void setNumeroAresta(int numeroAresta) {
        this.numeroAresta = numeroAresta;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public void setVertice(Vertice vertice) {
        this.vertice = vertice;
    }

    public Aresta() {
    }

    public Aresta(int numeroAresta, Vertice vertice) {
        this.numeroAresta = numeroAresta;
        this.vertice = vertice;
    }
    
}

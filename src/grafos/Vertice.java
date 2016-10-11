//Nikollas
//pedro

package grafos;

import java.util.ArrayList;

public class Vertice {

    private String nomeVertice;
    private ArrayList<Aresta> arestas = new ArrayList<>();

    public String getNomeVertice() {
        return nomeVertice;
    }

    public void setNomeVertice(String nomeVertice) {
        this.nomeVertice = nomeVertice;
    }
    
    void adcionaAresta (Aresta aresta){
        arestas.add(aresta);
    }
    
    void mostraArestas (){
        System.out.println("Vertice: "+this.getNomeVertice());
        for (Aresta aresta : arestas) {
            System.out.println("Arestas: "+aresta.getNumeroAresta());
        }
    }

    public Vertice(String nomeVertice) {
        this.nomeVertice = nomeVertice;

    }

    public Vertice() {
    }

}

// <editor-fold defaultstate="collapsed" desc="Código útil.">
/*void exibeLista(Vertice bleh){
    public Vertice(){};
    
    void exibeLista(Vertice bleh){
        
        System.out.println("Vertice: "+bleh.getNomeVertice());
        for (Vertice vertice : ponteiros) {
            System.out.println("Vertices: "+vertice.getNomeVertice());
        }
    }*/
//</editor-fold>


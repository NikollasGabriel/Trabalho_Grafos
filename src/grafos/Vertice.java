package grafos;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String nomeVertice;
    private List<Vertice> ponteiros = new ArrayList<>();

    public String getNomeVertice() {
        return nomeVertice;
    }

    public void setNomeVertice(String nomeVertice) {
        this.nomeVertice = nomeVertice;
    }

    public List<Vertice> getPonteiros() {
        return ponteiros;
    }

    public void setPonteiros(Vertice vertice) {
        this.ponteiros.add(vertice);
    }

    public Vertice(String nomeVertice, Vertice vertice) {
        this.nomeVertice = nomeVertice;
        this.ponteiros.add(vertice);
    }
    
    public Vertice(){};
    
    void exibeLista(Vertice bleh){
        
        System.out.println("Vertice: "+bleh.getNomeVertice());
        for (Vertice vertice : ponteiros) {
            System.out.println("Vertices: "+vertice.getNomeVertice());
        }
    }
}   

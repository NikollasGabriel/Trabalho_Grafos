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
        return ponteiros.getNomeVertice();
    }

    public void setPonteiros(Vertice vertice) {
        this.ponteiros.add(vertice);
    }

    public Vertice(String nomeVertice, Vertice vertice) {
        this.nomeVertice = nomeVertice;
        this.ponteiros.add(vertice);
    }
    
    public Vertice(){};
    
    void exibeLista(){
        
        int cont = 0;
        
        while(cont < ponteiros.size())
        {
      
            
        }
    }
}   

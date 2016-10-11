package grafos;

public class MainTemporario {

    public static void main(String[] args) {
       Vertice A = new Vertice("A");
       
       Aresta a1 = new Aresta(1,A);
       Aresta a2 = new Aresta(7,A);
       Aresta a3 = new Aresta(10,A);
     
       
       A.adcionaAresta(a1);
       A.adcionaAresta(a2);
       A.adcionaAresta(a3);
       
      
       A.mostraArestas();
    }
    
}

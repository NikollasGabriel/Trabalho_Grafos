package grafos;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Kruskal {

    List<Vertex> arvores = new ArrayList<>();
    List<Edge> arestas = new ArrayList<>();
    List<Edge> AGMArestas = new ArrayList<>();
    List<Vertex> AGM = new ArrayList<>();
    int peso = Integer.MAX_VALUE;
    Edge menorAresta = null;

    public Kruskal() {

    }

    public void getArvoreGeradoraMinimaKruskal(Graph grafo) {

        arestas.addAll((Collection) grafo.getEdges());

        while (!arestas.isEmpty()) {
            for (Edge e : arestas) {
                if ((Integer) e.getProperty("weight") < peso) {
                    if (AGM.isEmpty()) {
                        peso = (Integer) e.getProperty("weight");
                        menorAresta = e;
                    } else if (!AGM.contains(e.getVertex(Direction.OUT)) && !AGM.contains(e.getVertex(Direction.IN))) {
                        peso = (Integer) e.getProperty("weight");
                        menorAresta = e;
                    } else {
                        peso = (Integer) e.getProperty("weight");
                        menorAresta = e;
                    }
                }
            }
            arestas.remove(menorAresta);
            peso = Integer.MAX_VALUE;

            if (menorAresta != null) {
                if (!AGM.contains(menorAresta.getVertex(Direction.OUT))) {
                    AGM.add(menorAresta.getVertex(Direction.OUT));
                    /*if (!AGMArestas.contains(grafo.getEdge(menorAresta.getId()))) {
                        AGMArestas.add(grafo.getEdge(menorAresta.getId()));
                    }*/
                }
                if (!AGM.contains(menorAresta.getVertex(Direction.IN))) {
                    AGM.add(menorAresta.getVertex(Direction.IN));
                    if (!AGMArestas.contains(grafo.getEdge(menorAresta.getId()))) {
                        AGMArestas.add(grafo.getEdge(menorAresta.getId()));
                    }
                }
                /*if(){
                
                }*/
            }
            //AGMArestas.add(grafo.getEdge(menorAresta.getId()));

        }
        System.out.println(AGM);
        System.out.println(AGMArestas);
    }
}

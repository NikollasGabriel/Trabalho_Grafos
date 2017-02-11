package grafos;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Profundidade {

    public Profundidade() {
    }

    public Vertex getRaiz(Graph grafo) {

        Vertex vertice;

        List<Vertex> vertices = new ArrayList<>((Collection) grafo.getVertices());
        List<Edge> arestas = new ArrayList<>((Collection) grafo.getEdges());
        List<Vertex> verticesP = new ArrayList<>((Collection) grafo.getVertices());

        for (Vertex v : vertices) {
            for (Edge e : arestas) {
                if (e.getVertex(Direction.IN).equals(v)) {
                    verticesP.remove(v);
                }
            }
        }
        vertice = verticesP.get(0);

        return vertice;

    }

    public void BuscaGrafo(Graph grafo) {

        List<Vertex> verticesFinal = new ArrayList<>();
        LinkedList<Vertex> nosFilhos = new LinkedList<>();
        LinkedList<Vertex> listaAcumulada = new LinkedList<>();
        
        Vertex vertice = null;
        vertice = getRaiz(grafo);

        while (!verticesFinal.containsAll((Collection) grafo.getVertices())) {
            vertice.getVertices(Direction.OUT).forEach(nosFilhos::add);
            
            if(!verticesFinal.contains(vertice)){
                verticesFinal.add(vertice);

            }
            if(!nosFilhos.isEmpty()){
                vertice = nosFilhos.getFirst();
                nosFilhos.removeFirst();
            }else{
                nosFilhos.removeFirst();
            }
        }
        
        System.out.println(verticesFinal);

    }

}

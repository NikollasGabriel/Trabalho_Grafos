package grafos;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;

public class Largura {

    public Largura() {
    }

    public Vertex getRaiz(Graph g) {

        Vertex vertice;

        List<Vertex> vertices = new ArrayList<>((Collection) g.getVertices());
        List<Edge> arestas = new ArrayList<>((Collection) g.getEdges());
        List<Vertex> verticesP = new ArrayList<>((Collection) g.getVertices());

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

        Vertex vertice = null;
        List<Vertex> verticesAdjacentes = new ArrayList<>();
        List<Vertex> verticesMarcados = new ArrayList<>();
        List<Vertex> verticesFinal = new ArrayList<>();

        vertice = getRaiz(grafo);
        verticesMarcados.add(vertice);

        while (!verticesFinal.containsAll((Collection) grafo.getVertices())) {

            verticesMarcados.get(0).getVertices(Direction.OUT).forEach(verticesAdjacentes::add);

            if (!verticesFinal.contains(verticesMarcados.get(0))) {
                verticesFinal.add(verticesMarcados.get(0));
                verticesMarcados.addAll(verticesAdjacentes);
                verticesMarcados.remove(0);
            } else {
                verticesMarcados.addAll(verticesAdjacentes);
                verticesMarcados.remove(0);
            }
            
            vertice = verticesMarcados.get(0);
        }
//        System.out.println(verticesFinal);
        String saida = "Vertices:" + verticesFinal;
        JOptionPane.showMessageDialog(null, saida);
    }
}

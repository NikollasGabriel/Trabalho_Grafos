/*
prim(G) # G é grafo
    # Escolhe qualquer vértice do grafo como vértice inicial/de partida
    s ← seleciona-um-elemento(vertices(G))

    para todo v ∈ vertices(G)
        π[v] ← nulo
    Q ← {(0, s)}
    S ← ø

    enquanto Q ≠ ø
        v ← extrair-mín(Q)
        S ← S ∪ {v}

        para cada u adjacente a v
            se u ∉ S e pesoDaAresta(π[u]→u) > pesoDaAresta(v→u)
                Q ← Q \ {(pesoDaAresta(π[u]→u), u)}
                Q ← Q ∪ {(pesoDaAresta(v→u), u)}
                π[u] ← v

    retorna {(π[v], v) | v ∈ vertices(G) e π[v] ≠ nulo}
π[v] indica o predecessor de v. Após o término do algoritmo, para cada v pertencente aos vértices de G, π[v]→v representa
uma aresta selecionada para a árvore geradora mínima se π[v] ≠ nulo. O algoritmo retorna o conjunto dessas arestas, 
formado pelos pares (π[v], v). Q é um conjunto de pares (peso, vértice). O método extrair-mín(Q) deve extrair o menor elemento 
de Q; um par (a,b) é menor que um par (c,d) se a < c ou se a = c e b < d. S é um conjunto que armazena os vértices cujas adjacências
já foram analisadas.
 */
package grafos;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
//import java.util.Map;
import java.util.Set;

public class Prim {

    /*private Iterable<Vertex> vertices;
    private Iterable<Edge> arestas;*/
    private Set<Vertex> naoVisitados;
    private Set<Vertex> arvoreGeradoraMinima;
    private List<Edge> adjacentes;
    private int peso = Integer.MAX_VALUE;
    private Vertex menorVertice;

    public Prim() {

    }

    /*
    todos os vertices
    todas as arestas
    arvore geradora minima
    todos os nos não incluidos
    lista de arestas adjacentes
    
    enquanto nao visitados > 0 
        pega um v, remove dos n visitados e adciona na agm, pega todas as arestas que ele é source
        armazena na agm o vertice de destino da aresta de menor peso e que cujo vertice n esteja presente na agm, retira dos n visitados
        repete
     */
    public void getArvoreGeradoraMinimaPrim(Graph grafo, Vertex origem) {
        arvoreGeradoraMinima = new HashSet<Vertex>();
        naoVisitados = new HashSet<Vertex>((Collection) grafo.getVertices());
        adjacentes = new ArrayList<Edge>();
        naoVisitados.remove(origem);
        arvoreGeradoraMinima.add(origem);
        System.out.println("1");

        while (!naoVisitados.isEmpty()) {
            adjacentes = new ArrayList<Edge>();
            for (Vertex v : arvoreGeradoraMinima) {
                for (Edge e : grafo.getEdges()) {
                    if (e.getVertex(Direction.OUT).equals(v) /*&& naoVisitados.contains(e.getVertex(Direction.IN))*/ && !arvoreGeradoraMinima.contains(e.getVertex(Direction.IN))) {
                        adjacentes.add(e);
                    }
                }
            }
            System.out.println("2");
            for (Edge e : adjacentes) {
                if ((Integer) e.getProperty("weight") < peso) {
                    peso = (Integer) e.getProperty("weight");
                    menorVertice = e.getVertex(Direction.IN);
                }
            }
            arvoreGeradoraMinima.add(menorVertice);
            naoVisitados.remove(menorVertice);
        }
        System.out.println("3");
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        path.addAll(arvoreGeradoraMinima);
        Collections.reverse(path);
        for (Vertex v : path) {

            System.out.println(v);

        }

    }
}

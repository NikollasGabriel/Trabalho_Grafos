package grafos;

//<editor-fold defaultstate="collapsed" desc="Tentativa 1">
/*import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.graphstream.graph.Path;

//     B-(1)-C
//    /       \
//  (1)       (10)
//  /           \
// A             F
//  \           /
//  (1)       (1)
//    \       /
//     D-(1)-E
//A xy: 0,1
//B xy: 1,2
//C xy: 2,2
//D xy: 1,0
//E xy: 2,0
//F xy: 3,1
//AB A B weight:1
//AD A D weight:1
//BC B C weight:1
//CF C F weight:10
//DE D E weight:1
//EF E F weight:1
public class AEstrela {

protected String source;
protected String target;
protected HashMap<No, NoAEstrela> open = new HashMap<No, NoAEstrela>();
protected HashMap<No, NoAEstrela> closed = new HashMap<No, NoAEstrela>();
protected Path result;
protected boolean pathFound = false;

public class No {

private String id;
private float posX;
private float posY;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public Float getPosX() {
return posX;
}

public void setPosX(Float posX) {
this.posX = posX;
}

public Float getPosY() {
return posY;
}

public void setPosY(Float posY) {
this.posY = posY;
}

public No(String id, float posX, float posY) {
this.id = id;
this.posX = posX;
this.posY = posY;
}
}

public class Aresta {

private String id;
private No origem;
private No alvo;
private float peso;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public No getOrigem() {
return origem;
}

public void setOrigem(No origem) {
this.origem = origem;
}

public No getAlvo() {
return alvo;
}

public void setAlvo(No alvo) {
this.alvo = alvo;
}

public float getPeso() {
return peso;
}

public void setPeso(float peso) {
this.peso = peso;
}

public Aresta(String id, No origem, No alvo, float peso) {
this.id = id;
this.origem = origem;
this.alvo = alvo;
this.peso = peso;
}
}

public class grafo {

private String id;
private Map<String, No> nos = new HashMap<String, No>();
private Map<String, Aresta> arestas = new HashMap<String, Aresta>();

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public Map<String, No> getNos() {
return nos;
}

public void setNos(Map<String, No> nos) {
this.nos = nos;
}

public Map<String, Aresta> getArestas() {
return arestas;
}

public void setArestas(Map<String, Aresta> arestas) {
this.arestas = arestas;
}
}

protected class NoAEstrela {

public No no;
public NoAEstrela pai;
public Aresta aresta;
public double g;
public double h;
public double rank;

public NoAEstrela(No no, Aresta aresta, NoAEstrela pai, double g, double h) {
this.no = no;
this.aresta = aresta;
this.pai = pai;
this.g = g;
this.h = h;
this.rank = g + h;
}
}

protected void clearAll() {
open.clear();
closed.clear();

result = null;
pathFound = false;
}

public void setSource(String nodeName) {
clearAll();
source = nodeName;
}

public void setTarget(String nodeName) {
clearAll();
target = nodeName;
}

public void compute(String source, String target) {
setSource(source);
setTarget(target);
compute();
}

public void compute() {
if (source != null && target != null) {
No sourceNode = graph.getNode(source);
No targetNode = graph.getNode(target);

if (sourceNode == null) {
throw new RuntimeException("source node '" + source
+ "' does not exist in the graph");
}

if (targetNode == null) {
throw new RuntimeException("target node '" + target
+ "' does not exist in the graph");
}

aStar(sourceNode, targetNode);
}
}

protected void aStar(No sourceNode, No targetNode) {
clearAll();
open.put(
sourceNode,
new AStarNode(sourceNode, null, null, 0, costs.heuristic(
sourceNode, targetNode)));

pathFound = false;

while (!open.isEmpty()) {
AStarNode current = getNextBetterNode();

assert (current != null);

if (current.node == targetNode) {
// We found it !
assert current.edge != null;
pathFound = true;
result = buildPath(current);
return;
} else {
open.remove(current.node);
closed.put(current.node, current);

Iterator<? extends Edge> nexts = current.node
.getLeavingEdgeIterator();

while (nexts.hasNext()) {
Edge edge = nexts.next();
Node next = edge.getOpposite(current.node);
double h = costs.heuristic(next, targetNode);
double g = current.g + costs.cost(current.node, edge, next);
double f = g + h;

AStarNode alreadyInOpen = open.get(next);

if (alreadyInOpen != null && alreadyInOpen.rank <= f) {
continue;
}

AStarNode alreadyInClosed = closed.get(next);

if (alreadyInClosed != null && alreadyInClosed.rank <= f) {
continue;
}

closed.remove(next);
open.put(next, new AStarNode(next, edge, current, g, h));
}
}
}
}
}*/
//</editor-fold>
import java.io.IOException;
import java.io.StringReader;
import static org.graphstream.algorithm.Toolkit.edgeLength;
import static org.graphstream.algorithm.Toolkit.nodePosition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.graphstream.algorithm.AStar;
import org.graphstream.algorithm.Algorithm;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSourceDGS;

public class AEstrela implements Algorithm {

    protected Graph graph;

    protected String source;

    protected String target;

    protected Costs costs = new DefaultCosts();

    protected HashMap<Node, AStarNode> open = new HashMap<Node, AStarNode>();

    protected HashMap<Node, AStarNode> closed = new HashMap<Node, AStarNode>();

    protected Path result;

    protected boolean pathFound = false;

    public AEstrela() {
    }

    public AEstrela(Graph graph) {
        init(graph);
    }

    public AEstrela(Graph graph, String src, String trg) {
        this(graph);
        setSource(src);
        setTarget(trg);
    }

    public void setSource(String nodeName) {
        clearAll();
        source = nodeName;
    }

    public void setTarget(String nodeName) {
        clearAll();
        target = nodeName;
    }

    public void setCosts(Costs costs) {
        this.costs = costs;
    }

    public void init(Graph graph) {
        clearAll();
        this.graph = graph;
    }

    public void compute() {
        if (source != null && target != null) {
            Node sourceNode = graph.getNode(source);
            Node targetNode = graph.getNode(target);

            if (sourceNode == null) {
                throw new RuntimeException("source node '" + source
                        + "' does not exist in the graph");
            }

            if (targetNode == null) {
                throw new RuntimeException("target node '" + target
                        + "' does not exist in the graph");
            }

            aStar(sourceNode, targetNode);
        }
    }

    public Path getShortestPath() {
        return result;
    }

    public boolean noPathFound() {
        return (!pathFound);
    }

    public Path buildPath(AStarNode target) {
        Path path = new Path();

        ArrayList<AStarNode> thePath = new ArrayList<AStarNode>();
        AStarNode node = target;

        while (node != null) {
            thePath.add(node);
            node = node.parent;
        }

        int n = thePath.size();

        if (n > 1) {
            AStarNode current = thePath.get(n - 1);
            AStarNode follow = thePath.get(n - 2);

            path.add(current.node, follow.edge);

            current = follow;

            for (int i = n - 3; i >= 0; i--) {
                follow = thePath.get(i);
                path.add(follow.edge);
                current = follow;
            }
        }

        return path;
    }

    public void compute(String source, String target) {
        setSource(source);
        setTarget(target);
        compute();
    }

    protected void clearAll() {
        open.clear();
        closed.clear();

        result = null;
        pathFound = false;
    }

    protected void aStar(Node sourceNode, Node targetNode) {
        clearAll();
        open.put(
                sourceNode,
                new AStarNode(sourceNode, null, null, 0, costs.heuristic(
                        sourceNode, targetNode)));

        pathFound = false;

        while (!open.isEmpty()) {
            AStarNode current = getNextBetterNode();

            assert (current != null);

            if (current.node == targetNode) {

                assert current.edge != null;
                pathFound = true;
                result = buildPath(current);
                return;
            } else {
                open.remove(current.node);
                closed.put(current.node, current);

                Iterator<? extends Edge> nexts = current.node
                        .getLeavingEdgeIterator();

                while (nexts.hasNext()) {
                    Edge edge = nexts.next();
                    Node next = edge.getOpposite(current.node);
                    double h = costs.heuristic(next, targetNode);
                    double g = current.g + costs.cost(current.node, edge, next);
                    double f = g + h;

                    AStarNode alreadyInOpen = open.get(next);

                    if (alreadyInOpen != null && alreadyInOpen.rank <= f) {
                        continue;
                    }

                    AStarNode alreadyInClosed = closed.get(next);

                    if (alreadyInClosed != null && alreadyInClosed.rank <= f) {
                        continue;
                    }

                    closed.remove(next);
                    open.put(next, new AStarNode(next, edge, current, g, h));
                }
            }
        }
    }

    protected AStarNode getNextBetterNode() {

        double min = Float.MAX_VALUE;
        AStarNode theChosenOne = null;

        for (AStarNode node : open.values()) {
            if (node.rank < min) {
                theChosenOne = node;
                min = node.rank;
            }
        }

        return theChosenOne;
    }

    public interface Costs {

        double heuristic(Node node, Node target);

        double cost(Node parent, Edge from, Node next);
    }

    public static class DefaultCosts implements Costs {

        protected String weightAttribute = "weight";

        public DefaultCosts() {
        }

        public DefaultCosts(String weightAttributeName) {
            weightAttribute = weightAttributeName;
        }

        public double heuristic(Node node, Node target) {
            return 0;
        }

        public double cost(Node parent, Edge edge, Node next) {

            if (edge != null && edge.hasNumber(weightAttribute)) {
                return ((Number) edge.getNumber(weightAttribute)).doubleValue();
            }

            return 1;
        }
    }

    public static class DistanceCosts implements AEstrela.Costs {

        public double heuristic(Node node, Node target) {
            double xy1[] = nodePosition(node);
            double xy2[] = nodePosition(target);

            /*double x = xy2[0] - xy1[0];
            double y = xy2[1] - xy1[1];
            double z = (xy1.length > 2 && xy2.length > 2) ? (xy2[2] - xy1[2])
                    : 0;
            return Math.sqrt((x * x) + (y * y) + (z * z));*/
            
            double x = Math.abs(xy2[0] - xy1[0]);
            double y = Math.abs(xy2[1] - xy1[1]);
            return x + y;
        }

        public double cost(Node parent, Edge edge, Node next) {
            return edgeLength(edge);// parent.getEdgeToward( next.getId() ) );
        }
    }

    protected class AStarNode {

        public Node node;

        public AStarNode parent;

        public Edge edge;

        public double g;

        public double h;

        public double rank;

        public AStarNode(Node node, Edge edge, AStarNode parent, double g,
                double h) {
            this.node = node;
            this.edge = edge;
            this.parent = parent;
            this.g = g;
            this.h = h;
            this.rank = g + h;
        }
    }

    static String my_graph
            = "DGS004\n"
            + "my 0 0\n"
            + "an A xy: 0,1\n"
            + "an B xy: 1,2\n"
            + "an C xy: 2,2\n"
            + "an D xy: 1,0\n"
            + "an E xy: 2,0\n"
            + "an F xy: 3,1\n"
            + "ae AB A B weight:1 \n"
            + "ae AD A D weight:1 \n"
            + "ae BC B C weight:1 \n"
            + "ae CF C F weight:10 \n"
            + "ae DE D E weight:1 \n"
            + "ae EF E F weight:6 \n";

    public static void main(String[] args) throws IOException {
        Graph graph = new DefaultGraph("A Test");
        StringReader reader = new StringReader(my_graph);

        FileSourceDGS source = new FileSourceDGS();
        source.addSink(graph);
        source.readAll(reader);

        AStar astar = new AStar(graph);
        //astar.setCosts(new DistanceCosts());
        astar.compute("C", "F");

        System.out.println(astar.getShortestPath());
    }
}

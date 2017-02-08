package grafos;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLWriter;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLTokens;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AplicacaoMain {

    static Graph grafo = new TinkerGraph();
    static int k = 1;

    public static void main(String[] args) throws Exception {

        /*criarVertices(11);
        criarArestaValorada("1", "1", "2", 85);
        criarArestaValorada("2", "1", "3", 217);
        criarArestaValorada("3", "1", "5", 173);
        criarArestaValorada("4", "3", "7", 186);
        criarArestaValorada("5", "3", "8", 103);
        criarArestaValorada("6", "4", "8", 183);
        criarArestaValorada("7", "6", "9", 250);
        criarArestaValorada("8", "9", "10", 84);
        criarArestaValorada("9", "8", "10", 167);
        criarArestaValorada("10", "5", "10", 502);
        criarArestaValorada("11", "10", "11", 40);
        criarArestaValorada("12", "2", "11", 600);
        
        criarGraphMLValorado("C:\\Users\\asus note\\Desktop\\teste7.xml");

        lerGraphXML("C:\\Users\\asus note\\Desktop\\teste7.xml");
        Dijkstra d = new Dijkstra(grafo);
        d.execute(grafo.getVertex(1));
        LinkedList<Vertex> path = d.getPath(grafo.getVertex(11));
        
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }*/
        
        /*criarVertices(7);
        criarArestaValorada("1", "4", "1", 5);
        criarArestaValorada("2", "4", "2", 9);
        criarArestaValorada("3", "4", "5", 15);
        criarArestaValorada("4", "4", "6", 6);
        criarArestaValorada("5", "1", "2", 7);
        criarArestaValorada("6", "2", "3", 8);
        criarArestaValorada("7", "2", "5", 7);
        criarArestaValorada("8", "5", "4", 5);
        criarArestaValorada("9", "5", "7", 9);
        criarArestaValorada("10", "6", "5", 8);
        criarArestaValorada("11", "6", "7", 11);
        criarGraphMLValorado("C:\\Users\\asus note\\Desktop\\teste8.xml");*/
        lerGraphXML("C:\\Users\\asus note\\Desktop\\teste8.xml");
        Prim p = new Prim();
        p.getArvoreGeradoraMinimaPrim(grafo, grafo.getVertex(4));
        
    }

    public static void lerGraphXML(String caminhoArquivo) throws Exception {

        grafo = new TinkerGraph();
        GraphMLReader leitor = new GraphMLReader(grafo);

        InputStream caminho = new BufferedInputStream(new FileInputStream(caminhoArquivo));
        leitor.inputGraph(caminho);

        //<editor-fold defaultstate="collapsed" desc="codigo velho">
/*
        Iterable<Vertex> vertices = grafo.getVertices();
        Iterator<Vertex> verticesIterator = vertices.iterator();

while (verticesIterator.hasNext()) {
    Vertex vertice = verticesIterator.next();
    Iterable<Edge> arestas = vertice.getEdges(Direction.BOTH);
    Iterator<Edge> arestasIterator = arestas.iterator();
    
    while (arestasIterator.hasNext()) {
        
        Edge aresta = arestasIterator.next();
        
        Vertex outVertex = aresta.getVertex(Direction.OUT);
        Vertex inVertex = aresta.getVertex(Direction.IN);
        
        //Vertex outVertex = aresta.getOutVertex();
        //Vertex inVertex = aresta.getInVertex();
        String sentence = null;
        
        String origem = (String) outVertex.getId();
        String alvo = (String) inVertex.getId();
        
        sentence = "\n" + origem + " " + "-->" + aresta.getLabel() + " " + "-->" + alvo + ".";
        sentenca = sentenca + sentence;
        System.out.println(sentenca);
    }
    
}

return sentenca;*/
//</editor-fold>
    }

    public static void criarGraphML(String caminhoArquivo) throws Exception {

        OutputStream saida = new FileOutputStream(caminhoArquivo);
        GraphMLWriter writer = new GraphMLWriter(grafo);
        writer.setNormalize(true);
        writer.outputGraph(saida);
        grafo.shutdown();
        grafo = null;
    }

    public static void criarGraphMLValorado(String caminhoArquivo) throws Exception {

        OutputStream saida = new FileOutputStream(caminhoArquivo);
        Map<String, String> edgeKeyTypes = new HashMap<String, String>();
        edgeKeyTypes.put("weight", GraphMLTokens.INT);
        GraphMLWriter writer = new GraphMLWriter(grafo);
        writer.setEdgeKeyTypes(edgeKeyTypes);
        writer.setNormalize(true);
        writer.outputGraph(saida);
        grafo.shutdown();
        grafo = null;
    }

    public static List<Vertex> criarVertices(int numeroVertices) throws Exception {

        List<Vertex> vertices = new ArrayList();

        for (int i = 1; i <= numeroVertices; i++) {
            vertices.add(grafo.addVertex(i));
        }
        return vertices;
    }

    public static Edge criarAresta(String nome, String origemVertice, String alvoVertice) throws Exception {

        Iterable<Vertex> vertices = grafo.getVertices();
        Iterator<Vertex> verticesIterator = vertices.iterator();
        Vertex outVertice = null;
        Vertex inVertice = null;
        Edge aresta;

        if (origemVertice.equals(alvoVertice)) {
            while (verticesIterator.hasNext()) {
                Vertex vertice = verticesIterator.next();
                if (((String) vertice.getId()).equals(origemVertice)) {
                    outVertice = vertice;
                    inVertice = vertice;
                    grafo.addEdge(k, outVertice, inVertice, nome);
                    k++;
                }
            }
        } else {
            while (verticesIterator.hasNext()) {
                Vertex vertice = verticesIterator.next();
                if (((String) vertice.getId()).equals(origemVertice)) {
                    outVertice = vertice;
                } else if (((String) vertice.getId()).equals(alvoVertice)) {
                    inVertice = vertice;
                }
            }
        }
        aresta = grafo.addEdge(k, outVertice, inVertice, nome);
        k++;
        return aresta;
    }

    public static Edge criarArestaValorada(String nome, String origemVertice, String alvoVertice, int peso) throws Exception {

        Iterable<Vertex> vertices = grafo.getVertices();
        Iterator<Vertex> verticesIterator = vertices.iterator();
        Vertex outVertice = null;
        Vertex inVertice = null;
        Edge aresta;

        if (origemVertice.equals(alvoVertice)) {
            while (verticesIterator.hasNext()) {
                Vertex vertice = verticesIterator.next();
                if (((String) vertice.getId()).equals(origemVertice)) {
                    outVertice = vertice;
                    inVertice = vertice;
                    Edge a = grafo.addEdge(k, outVertice, inVertice, nome);
                    a.setProperty("weight", peso);
                    k++;
                }
            }
        } else {
            while (verticesIterator.hasNext()) {
                Vertex vertice = verticesIterator.next();
                if (((String) vertice.getId()).equals(origemVertice)) {
                    outVertice = vertice;
                } else if (((String) vertice.getId()).equals(alvoVertice)) {
                    inVertice = vertice;
                }
            }
        }
        aresta = grafo.addEdge(k, outVertice, inVertice, nome);
        aresta.setProperty("weight", peso);
        k++;
        return aresta;
    }

    public static Iterable<Vertex> obterVertices() {

        Iterable<Vertex> vertices = grafo.getVertices();
        return vertices;
    }

    public static Iterable<Edge> obterArestas() {

        Iterable<Edge> arestas = grafo.getEdges();
        return arestas;
    }

    public static int contaVertices() {

        int numeroArestas = 0;

        Iterable<Vertex> vertices = grafo.getVertices();

        for (Vertex vertice : vertices) {
            numeroArestas++;
        }

        return numeroArestas;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.drawOval(100, 100, 100, 100);
    }
}

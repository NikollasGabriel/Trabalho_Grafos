package grafos;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLWriter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AplicacaoMain {

    public static void main(String[] args) throws Exception {

    }
    static Graph grafo = new TinkerGraph();
    static int k = 1;

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
        
        for(Vertex vertice : vertices){
            numeroArestas++;
        }
       
        return numeroArestas;
    }
    
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.drawOval(100, 100, 100, 100);
    }
}

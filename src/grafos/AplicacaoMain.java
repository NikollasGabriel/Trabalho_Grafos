package grafos;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.pgm.util.io.graphml.GraphMLReader;
import com.tinkerpop.blueprints.pgm.util.io.graphml.GraphMLWriter;
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
        //lerGraphXML("C:\\Users\\asus note\\Desktop\\novo3.xml"); //MUDE AQUI C:\\Users\\Daniel\\Desktop\\nik.xml
        //criarGraphML(10, 10 , "novo2");
    }

    public static String lerGraphXML(String caminhoArquivo) throws Exception {
        String sentenca = "";

        Graph grafo = new TinkerGraph(); //cria um grafo do tipo Graph com o contrutor da classe TinkerGraph
        GraphMLReader leitor = new GraphMLReader(grafo); // cria um variavel leitor do tipo GraphMLReader passando como parametro ao construtor o grafo

        InputStream caminho = new BufferedInputStream(new FileInputStream(caminhoArquivo)); // atribui o endereço do arquivo a variavel caminho que sera passada ao leitor
        leitor.inputGraph(caminho);

        Iterable<Vertex> vertices = grafo.getVertices(); // organiza os vertices na forma de uma Collection
        Iterator<Vertex> verticesIterator = vertices.iterator(); // cria o objeto verticesIterator que ira cicular pela collecton

        while (verticesIterator.hasNext()) {
            Vertex vertice = verticesIterator.next();
            Iterable<Edge> arestas = vertice.getInEdges();
            Iterator<Edge> arestasIterator = arestas.iterator();

            while (arestasIterator.hasNext()) {

                Edge aresta = arestasIterator.next();
                Vertex outVertex = aresta.getOutVertex();
                Vertex inVertex = aresta.getInVertex();
                String sentence = null;

                String origem = (String) outVertex.getId();
                String alvo = (String) inVertex.getId();

                sentence = "\n" + origem + " " + "-->" + aresta.getLabel() + " " + "-->" + alvo + ".";
                sentenca = sentenca + sentence;
                System.out.println(sentenca);
            }

        }

        return sentenca;
    }

    public static void criarGraphML(int numeroVertices, int numeroArestas, String nome) throws Exception {

        String localCriacao = "C:\\Users\\asus note\\Desktop\\";
        String nomeArquivo = nome + ".xml";
        String caminhoArquivo = localCriacao + nomeArquivo;
        List <Vertex> vertices = new ArrayList();
        int j = 1;
        Vertex atual = null;
        
        OutputStream saida = new FileOutputStream(caminhoArquivo);
        TinkerGraph grafo = new TinkerGraph();

        for (int i = 1; i < numeroVertices; i++) {
            
            vertices.add(grafo.addVertex(i));
        }
        
        for (Vertex vertice : vertices){
            
            if(atual != null){
             
                Vertex origemAresta = atual;
                Vertex destinoAresta = vertice; 
                grafo.addEdge(j, origemAresta, destinoAresta, "Aresta " + j);
                j++;
            }
            
            atual = vertice;
        }
        
        GraphMLWriter writer = new GraphMLWriter(grafo);
        writer.outputGraph(saida);
    }
}

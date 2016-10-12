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
import java.util.Iterator;
import java.util.Scanner;

public class MainTemporario {

    public static void main(String[] args) throws Exception {
        lerGraphXML("C:\\Users\\Daniel\\Desktop\\nik.xml"); //MUDE AQUI
        criarGraphML();
    }
    
    public static void lerGraphXML(String caminhoArquivo) throws Exception {
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

                String person = (String) outVertex.getProperty("name");
                String knownPerson = (String) inVertex.getProperty("name");
                int since = (Integer) aresta.getProperty("since");

                String sentence = person + " " + aresta.getLabel() + " " + knownPerson
                        + " since " + since + ".";
                System.out.println(sentence);

            }

        }
    }
    
    public static void criarGraphML () throws Exception {
        
        String localCriacao = "C:\\Users\\Daniel\\Desktop\\nik.xml"; //MUDE AQUI
        String nomeArquivo = "novo.xml";
        String caminhoArquivo = localCriacao+nomeArquivo;
        
        OutputStream saida = new FileOutputStream(caminhoArquivo);
        TinkerGraph grafo  = new TinkerGraph();
 
        Scanner input = new Scanner(System.in);
        int entradaNumVertice;
        
        System.out.println("-----------------------");
        System.out.println("Quantos Vertices:");
        entradaNumVertice = input.nextInt();
        
        for(int i=0; i== entradaNumVertice; i++){           
            Vertex origemAresta = grafo.addVertex(1);
            Vertex destinoAresta = grafo.addVertex("2");
            grafo.addEdge("3", origemAresta, destinoAresta, "Aresta 1");            
        }
        
        //Vertex origemAresta = grafo.addVertex(entradaNumVertice);
       // Vertex destinoAresta = grafo.addVertex("2");
       // grafo.addEdge("3", origemAresta, destinoAresta, "Aresta 1");
 
        GraphMLWriter writer = new GraphMLWriter(grafo);
        writer.outputGraph(saida);
    }

}

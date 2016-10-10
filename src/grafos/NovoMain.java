/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author asus note
 */
public class NovoMain {

    public static void main(String[] args) {
        // TODO code application logic here
        Vertice a  = new Vertice();
        Vertice b  = new Vertice();
        Vertice c  = new Vertice();
        Vertice d  = new Vertice();
        Vertice e  = new Vertice();
        Vertice f  = new Vertice();
        
        a.setNomeVertice("A");
        b.setNomeVertice("B");
        c.setNomeVertice("C");
        d.setNomeVertice("D");
        e.setNomeVertice("E");
        f.setNomeVertice("F");
        
        a.setPonteiros(b);
        a.setPonteiros(c);
        a.setPonteiros(d);
        
        System.out.println("Vertices"+a.getPonteiros());
    }
    
    
}

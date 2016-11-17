package Interface;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import static grafos.AplicacaoMain.contaVertices;
import static grafos.AplicacaoMain.lerGraphXML;
import static grafos.AplicacaoMain.obterVertices;
import static grafos.AplicacaoMain.obterArestas;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class AbrirGrafo extends javax.swing.JFrame {

    private DefaultListModel modelVertices = new DefaultListModel();
    private DefaultTableModel modelArestas = new DefaultTableModel();
    private Iterable<Vertex> vertices;
    private Iterable<Edge> arestas;

    public AbrirGrafo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        GrauVertice = new javax.swing.JButton();
        AdjacenteVertice = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaArestas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        AdjacenteAresta = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaVertices = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Abrir Grafo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Selecionar Arquivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Caminho do Arquivo:");

        GrauVertice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        GrauVertice.setText("Grau");
        GrauVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrauVerticeActionPerformed(evt);
            }
        });

        AdjacenteVertice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AdjacenteVertice.setText("Adjacência");
        AdjacenteVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdjacenteVerticeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("                    Vertices do Grafo");

        listaArestas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listaArestas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Vertice Origem", "Vertice Alvo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listaArestas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("                             Arestas do Grafo");

        AdjacenteAresta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AdjacenteAresta.setText("Adjacência");
        AdjacenteAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdjacenteArestaActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("Ordem do Grafo");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        listaVertices.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(listaVertices);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(GrauVertice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AdjacenteVertice))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdjacenteAresta)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GrauVertice)
                    .addComponent(AdjacenteVertice)
                    .addComponent(AdjacenteAresta))
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Principal tela = new Principal();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String caminhoArquivo = jTextField1.getText();
        try {
            lerGraphXML(caminhoArquivo);

            try {
                vertices = obterVertices();
                modelVertices.removeAllElements();
                listaVertices.setModel(modelVertices);
                Iterator<Vertex> verticesIterator = vertices.iterator();
                while (verticesIterator.hasNext()) {
                    modelVertices.addElement(verticesIterator.next());
                }
            } catch (Exception ex) {
                throw ex;
            }

            try {
                arestas = obterArestas();
                modelArestas = (DefaultTableModel) listaArestas.getModel();
                Iterator<Edge> arestasIterator = arestas.iterator();

                while (arestasIterator.hasNext()) {
                    Edge aresta = arestasIterator.next();
                    Object[] row = {aresta.getLabel(), aresta.getVertex(Direction.OUT), aresta.getVertex(Direction.IN)};
                    modelArestas.addRow(row);
                }
            } catch (Exception ex) {
                throw ex;
            }

        } catch (Exception ex) {
            Logger.getLogger(AbrirGrafo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtroXML = new FileNameExtensionFilter("Arquivos XML", "xml");
        chooser.addChoosableFileFilter(filtroXML);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String caminhoArquivo = chooser.getSelectedFile().getAbsolutePath();
            jTextField1.setText(caminhoArquivo);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        int numeroVertices = contaVertices();
        jTextField2.setText("" + numeroVertices);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void GrauVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrauVerticeActionPerformed

        int indice = listaVertices.getSelectedIndex() + 1;
        int grauEmissao = 0;
        int grauRecepcao = 0;

        if ((indice > 0) && (vertices.iterator().hasNext())) {
            Graph auxiliar = new TinkerGraph();
            auxiliar.addVertex(indice);
            Iterator<Vertex> verticesIterator = vertices.iterator();
            while (verticesIterator.hasNext()) {
                Vertex vertice = verticesIterator.next();
                if (auxiliar.getVertex(indice).getId().equals(vertice.getId())) {
                    Iterator<Edge> arestasIterator = arestas.iterator();
                    while (arestasIterator.hasNext()) {
                        Edge aresta = arestasIterator.next();
                        if (aresta.getVertex(Direction.OUT).equals(vertice)) {
                            grauEmissao++;
                        }
                        if (aresta.getVertex(Direction.IN).equals(vertice)) {
                            grauRecepcao++;
                        }
                    }
                }
            }
            String saida = "Vertice[" + indice + "]:" + "\n" + "Grau de emissao:" + grauEmissao + "\n" + "Grau de recepção:" + grauRecepcao;
            JOptionPane.showMessageDialog(null, saida);
        } else if (jTextField1.getText().equals("")) {
            String saida = "Abra um grafo antes de clicar nessa opção!";
            JOptionPane.showMessageDialog(null, saida);
        } else if (indice <= 0) {
            String saida = "Escolha um vertice antes!";
            JOptionPane.showMessageDialog(null, saida);
        }
    }//GEN-LAST:event_GrauVerticeActionPerformed

    private void AdjacenteVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdjacenteVerticeActionPerformed

        String saida = "São adjacentes:\n";
        Iterator<Edge> arestasIterator = arestas.iterator();
        Edge aresta;

        while (arestasIterator.hasNext()) {
            aresta = arestasIterator.next();

            if (aresta.getVertex(Direction.OUT).equals(aresta.getVertex(Direction.IN))) {
                saida = saida + "A aresta " + aresta.getLabel() + " é um laço no vértice " + aresta.getVertex(Direction.OUT) + "\n";
            } else {
                saida = saida + aresta.getVertex(Direction.OUT) + " e " + aresta.getVertex(Direction.IN) + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, saida);
    }//GEN-LAST:event_AdjacenteVerticeActionPerformed

    private void AdjacenteArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdjacenteArestaActionPerformed

        Iterable<Edge> arestas1 = obterArestas();
        Iterable<Edge> arestas2 = obterArestas();
        Iterator<Edge> arestasIterator1 = arestas1.iterator();
        Iterator<Edge> arestasIterator2 = arestas2.iterator();
        Edge aresta1;
        Edge aresta2;
        String saida = "São adjacentes:\n";

        while (arestasIterator1.hasNext()) {
            aresta1 = arestasIterator1.next();
            System.out.println("1");
            while (arestasIterator2.hasNext()) {
                aresta2 = arestasIterator2.next();
                System.out.println("2");
                if ((aresta1.getVertex(Direction.IN).equals(aresta2.getVertex(Direction.OUT)))) {
                    saida = saida + "As arestas " + aresta1.getLabel() + " e " + aresta2.getLabel() + " são adjacentes em " + aresta2.getVertex(Direction.OUT) + "\n";
                    System.out.println("3");
                } else {
                    System.out.println("4");
                    //saida = saida + "As arestas " + aresta1.getLabel() + " e " + aresta2.getLabel() + " são adjacentes em " + aresta2.getVertex(Direction.OUT) + "\n";
                }
            }
        }
        JOptionPane.showMessageDialog(null, saida);
    }//GEN-LAST:event_AdjacenteArestaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AbrirGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbrirGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbrirGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbrirGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbrirGrafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdjacenteAresta;
    private javax.swing.JButton AdjacenteVertice;
    private javax.swing.JButton GrauVertice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable listaArestas;
    private javax.swing.JList<String> listaVertices;
    // End of variables declaration//GEN-END:variables

}

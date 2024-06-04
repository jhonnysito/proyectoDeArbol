/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import negocio.AVL;
import negocio.ArbolBinarioBusqueda;
import negocio.ArbolMViasBusqueda;
import negocio.IArbolBusqueda;

/**
 *
 * @author Usuario
 */
public class formularioArrastrandoBotones extends javax.swing.JFrame {
       private IArbolBusqueda arbol;
       private MViasTreePanel MViasTreePanel;
      private TreePanel treePanel;
     public formularioArrastrandoBotones() {
        this.setPreferredSize(new Dimension(800, 700));
        
        jPanel3 = new JPanel(); 
       // jPanel3.setPreferredSize(new Dimension(800, 700));
        initComponents();
  
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("arbol Binario");

        jPanel3.setLayout(new java.awt.BorderLayout());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "insertar", "eliminar", "buscar", "recorridoPorNivel", "recorridoPreOrden", "recorridoInOrden", "recorridoPostOrden", "contiene", "size", "altura", "mostrarDatosYaInsertados" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arbol Binario", "Arbol AVL", "Arbol MVias" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Clave");

        jLabel2.setText("Valor");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "insertar", "eliminar", "buscar", "recorridoPorNivel", "recorridoPreOrden", "recorridoInOrden", "recorridoPostOrden", "contiene", "size", "altura", "mostrarDatosYaInsertados" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "insertar", "eliminar", "buscar", "recorridoPorNivel", "recorridoPreOrden", "recorridoInOrden", "recorridoPostOrden", "contiene", "size", "altura", "mostrarDatosI" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
          String selected = (String) jComboBox1.getSelectedItem();
        
        switch (selected) {
              case "Arbol Binario":
                  //JOptionPane.showMessageDialog(null, "ya se creo el arbol binario");
                    jComboBox3.setVisible(false);
                    jComboBox4.setVisible(false);
                    jComboBox2.setVisible(true);
                    arbol=new ArbolBinarioBusqueda();
                    treePanel=new TreePanel((ArbolBinarioBusqueda) arbol);
                     //treePanel.setPreferredSize(new Dimension(800, 700));
                    jPanel3.removeAll();
                       jPanel3.add(treePanel);
                    jPanel3.revalidate();
                     jPanel3.repaint();
                  //   treePanel = new TreePanel(arbolBinario);
                    //  getContentPane().add(treePanel, BorderLayout.CENTER);
                break;
            case "Arbol AVL":
                    jComboBox2.setVisible(false);
                    jComboBox4.setVisible(false);
                    jComboBox3.setVisible(true);
                 arbol=new AVL();
                 treePanel=new TreePanel((AVL) arbol);
                // treePanel.setPreferredSize(new Dimension(800, 700));
                 jPanel3.removeAll();
                   jPanel3.add(treePanel);
                    jPanel3.revalidate();
                   jPanel3.repaint();
                 //formularioAVL AVL = new formularioAVL();
                 //AVL.setVisible(true);
                 //this.setVisible(false);
                break;
            case "Arbol MVias":
                jComboBox2.setVisible(false);
                 jComboBox3.setVisible(false);
                int orden=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el orden del arbol"));
                arbol=new ArbolMViasBusqueda(orden);
                MViasTreePanel=new MViasTreePanel(arbol);
                 jPanel3.removeAll();
                   jPanel3.add(MViasTreePanel);
                    jPanel3.revalidate();
                   jPanel3.repaint();
                 //treePanel=new TreePanel((ArbolMViasBusqueda) arbol);
                // treePanel.setPreferredSize(new Dimension(800, 700));
                break;
                
            default:
                // Default case if needed
                break;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        int cantidad=0;
        List<Integer> listaDeClaves=new LinkedList<>();
         String clave=jTextField1.getText();
         String claveDeRecorrido = "";
         String valor=jTextField2.getText();
        String selected = (String) jComboBox2.getSelectedItem();
         switch (selected) {
        case "insertar":
             valor=jTextField2.getText();
             clave=jTextField1.getText();
            if (!clave.isEmpty() && !valor.isEmpty()) {
                arbol.insertar(Integer.parseInt(clave), valor);
            }
            // Lógica para manejar la inserción
            //JOptionPane.showMessageDialog(null, "ya se insertaron los datos");
           jPanel3.add(treePanel);
            jPanel3.revalidate();
           jPanel3.repaint();
            //arbolBinario.insertar(WIDTH, ERROR);
            break;
        case "eliminar":
             clave=jTextField1.getText();
           
            if (!clave.isEmpty()) {
                 try {
                     valor=(String) arbol.eliminar(Integer.parseInt(clave));
                     jTextField3.setText("");
                     jTextField3.setText(valor);
                      jPanel3.add(treePanel);
                     jPanel3.revalidate();
                      jPanel3.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La clave debe ser un numero entero");
            }
                
            }
            // Lógica para manejar la eliminación
            break;
        case "buscar":
            // Lógica para manejar la búsqueda
             clave=jTextField1.getText();
             if (!clave.isEmpty()) {
                 try {
                     valor=(String) arbol.buscar(Integer.parseInt(clave));
                     jTextField3.setText("");
                     jTextField3.setText(valor);
                 }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La clave debe ser un numero entero");
            }
             }
            break;
        case "recorridoPorNivel":
            // Lógica para manejar el recorrido por nivel
           
                     listaDeClaves=arbol.recorridoPorNiveles();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeRecorrido=claveDeRecorrido+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeRecorrido);
            break;
        case "recorridoPreOrden":
            // Lógica para manejar el recorrido preorden
              listaDeClaves=arbol.recorridoPreOrden();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeRecorrido=claveDeRecorrido+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeRecorrido);
            break;
        case "recorridoInOrden":
            // Lógica para manejar el recorrido inorden
            listaDeClaves=arbol.recorridoInOrden();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeRecorrido=claveDeRecorrido+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeRecorrido);
            break;
        case "recorridoPostOrden":
            // Lógica para manejar el recorrido postorden
           listaDeClaves=arbol.recorridoPostOrden();
                     jTextField3.setText("");
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeRecorrido=claveDeRecorrido+listaDeClave.toString()+"  ";
                    }
                     
                     jTextField3.setText(claveDeRecorrido);
            break;
        case "contiene":
            // Lógica para manejar la verificación de si el árbol contiene un elemento
            break;
        case "size":
            // Lógica para obtener el tamaño del árbol
            cantidad=arbol.size();
            jTextField3.setText("");
            jTextField3.setText(cantidad+"");
            break;
        case "altura":
            // Lógica para obtener la altura del árbol
            cantidad=arbol.altura();
            jTextField3.setText("");
            jTextField3.setText(cantidad+"");
            break;
        case "mostrarDatosYaInsertados":
            // Lógica para obtener la altura del árbol
             arbol.insertar(25, "jhonny");
                 arbol.insertar(34, "iver");
                 arbol.insertar(20, "Deivy");
                  arbol.insertar(33, "rosi");
                arbol.insertar(30, "Diego");
                  jPanel3.add(treePanel);
                 jPanel3.revalidate();
                     jPanel3.repaint();
                     
            break;
        default:
            // Default case si es necesario
            break;
    }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
         int cantidad=0;
         String claveDeR="";
        List<Integer> listaDeClaves=new LinkedList<>();
         String clave=jTextField1.getText();
         String valor=jTextField2.getText();
          String selected = (String) jComboBox3.getSelectedItem();
         switch (selected) {
        case "insertar":
            
             clave=jTextField1.getText();
             valor=jTextField2.getText();
            if (!clave.isEmpty() && !valor.isEmpty()) {
                arbol.insertar(Integer.parseInt(clave), valor);
            }
            // Lógica para manejar la inserción
            //JOptionPane.showMessageDialog(null, "ya se insertaron los datos");
           jPanel3.add(treePanel);
            jPanel3.revalidate();
           jPanel3.repaint();
            //arbolBinario.insertar(WIDTH, ERROR);
            break;
        case "eliminar":
            String claveAEliminar=jTextField1.getText();
           
            if (!claveAEliminar.isEmpty()) {
                 try {
                    valor= (String) arbol.eliminar(Integer.parseInt(claveAEliminar));
                    jTextField3.setText("");
                     jTextField3.setText(valor);
                      jPanel3.add(treePanel);
                     jPanel3.revalidate();
                      jPanel3.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La clave debe ser un numero entero");
            }
                
            }
            // Lógica para manejar la eliminación
            break;
        case "buscar":
            // Lógica para manejar la búsqueda
            clave=jTextField1.getText();
             if (!clave.isEmpty()) {
                 try {
                     valor=(String) arbol.buscar(Integer.parseInt(clave));
                     jTextField3.setText("");
                     jTextField3.setText(valor);
                 }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La clave debe ser un numero entero");
            }
             }
            break;
        case "recorridoPorNivel":
            // Lógica para manejar el recorrido por nivel
           
                     listaDeClaves=arbol.recorridoPorNiveles();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeR=claveDeR+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeR);
            break;
        case "recorridoPreOrden":
            // Lógica para manejar el recorrido preorden
              listaDeClaves=arbol.recorridoPreOrden();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeR=claveDeR+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeR);
            break;
        case "recorridoInOrden":
            // Lógica para manejar el recorrido inorden
            listaDeClaves=arbol.recorridoInOrden();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeR=claveDeR+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeR);
            break;
        case "recorridoPostOrden":
            // Lógica para manejar el recorrido postorden
           listaDeClaves=arbol.recorridoPostOrden();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeR=claveDeR+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeR);
            break;
        case "contiene":
            // Lógica para manejar la verificación de si el árbol contiene un elemento
            break;
        case "size":
            // Lógica para obtener el tamaño del árbol
            cantidad=arbol.size();
            jTextField3.setText("");
            jTextField3.setText(cantidad+"");
            break;
        case "altura":
            // Lógica para obtener la altura del árbol
            cantidad=arbol.altura();
            jTextField3.setText("");
            jTextField3.setText(cantidad+"");
            break;
        case "mostrarDatosYaInsertados":
            // Lógica para obtener la altura del árbol
             arbol.insertar(25, "jhonny");
                 arbol.insertar(34, "iver");
                 arbol.insertar(20, "Deivy");
                  arbol.insertar(33, "rosi");
                arbol.insertar(30, "Diego");
                  jPanel3.add(treePanel);
                 jPanel3.revalidate();
                     jPanel3.repaint();
                     
            break;
        default:
            // Default case si es necesario
            break;
    }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
            int cantidad=0;
         String claveDeR="";
        List<Integer> listaDeClaves=new LinkedList<>();
         String clave=jTextField1.getText();
         String valor=jTextField2.getText();
          String selected = (String) jComboBox4.getSelectedItem();
         switch (selected) {
        case "insertar":
            
             clave=jTextField1.getText();
             valor=jTextField2.getText();
            if (!clave.isEmpty() && !valor.isEmpty()) {
                arbol.insertar(Integer.parseInt(clave), valor);
            }
            // Lógica para manejar la inserción
            //JOptionPane.showMessageDialog(null, "ya se insertaron los datos");
           jPanel3.add(MViasTreePanel);
            jPanel3.revalidate();
           jPanel3.repaint();
            //arbolBinario.insertar(WIDTH, ERROR);
            break;
        case "eliminar":
            String claveAEliminar=jTextField1.getText();
           
            if (!claveAEliminar.isEmpty()) {
                 try {
                    valor= (String) arbol.eliminar(Integer.parseInt(claveAEliminar));
                    jTextField3.setText("");
                     jTextField3.setText(valor);
                      jPanel3.add(treePanel);
                     jPanel3.revalidate();
                      jPanel3.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La clave debe ser un numero entero");
            }
                
            }
            // Lógica para manejar la eliminación
            break;
        case "buscar":
            // Lógica para manejar la búsqueda
            clave=jTextField1.getText();
             if (!clave.isEmpty()) {
                 try {
                     valor=(String) arbol.buscar(Integer.parseInt(clave));
                     jTextField3.setText("");
                     jTextField3.setText(valor);
                 }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La clave debe ser un numero entero");
            }
             }
            break;
        case "recorridoPorNivel":
            // Lógica para manejar el recorrido por nivel
           
                     listaDeClaves=arbol.recorridoPorNiveles();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeR=claveDeR+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeR);
            break;
        case "recorridoPreOrden":
            // Lógica para manejar el recorrido preorden
              listaDeClaves=arbol.recorridoPreOrden();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeR=claveDeR+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeR);
            break;
        case "recorridoInOrden":
            // Lógica para manejar el recorrido inorden
            listaDeClaves=arbol.recorridoInOrden();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeR=claveDeR+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeR);
            break;
        case "recorridoPostOrden":
            // Lógica para manejar el recorrido postorden
           listaDeClaves=arbol.recorridoPostOrden();
                     
                     for (Integer listaDeClave : listaDeClaves) {
                        claveDeR=claveDeR+listaDeClave.toString()+"  ";
                    }
                     jTextField3.setText("");
                     jTextField3.setText(claveDeR);
            break;
        case "contiene":
            // Lógica para manejar la verificación de si el árbol contiene un elemento
            break;
        case "size":
            // Lógica para obtener el tamaño del árbol
           // cantidad=arbol.size();
           // jTextField3.setText("");
           // jTextField3.setText(cantidad+"");
            break;
        case "altura":
            // Lógica para obtener la altura del árbol
          //  cantidad=arbol.altura();
          //  jTextField3.setText("");
           // jTextField3.setText(cantidad+"");
            break;
        case "mostrarDatosI":
            // Lógica para obtener la altura del árbol
            //JOptionPane.showMessageDialog(null, "La clave debe ser un numero entero");
             arbol.insertar(100, "jhonny");
                 arbol.insertar(200, "iver");
                 arbol.insertar(400, "Deivy");
                  arbol.insertar(500, "rosi");
                arbol.insertar(50, "Diego");
                 arbol.insertar(150, "iver");
                  arbol.insertar(190, "iver");
                   arbol.insertar(250, "iver");
                    arbol.insertar(450, "iver");
                     arbol.insertar(700, "iver");
                       arbol.insertar(170, "iver");
                         arbol.insertar(110, "iver");
                           arbol.insertar(130, "iver");
                             arbol.insertar(180, "iver");
                               arbol.insertar(140, "iver");
                jPanel3.removeAll();
                  jPanel3.add(MViasTreePanel);
                 jPanel3.revalidate();
                     jPanel3.repaint();
                     
            break;
        default:
            // Default case si es necesario
            break;
    }//GEN-LAST:event_jComboBox4ActionPerformed

    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(formularioArrastrandoBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formularioArrastrandoBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formularioArrastrandoBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formularioArrastrandoBotones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formularioArrastrandoBotones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

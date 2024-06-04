/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

/**
 *
 * @author Usuario
 */
import javax.swing.*;
import java.awt.*;
import negocio.IArbolBusqueda;
import negocio.NodoMVias;

public class MViasTreePanel extends JPanel {
    private IArbolBusqueda tree;

    public MViasTreePanel(IArbolBusqueda tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tree != null && tree.getRaiz() != null) {
            drawTree(g, (NodoMVias) tree.getRaiz(), getWidth() / 2, 30, getWidth() / 4);
        }
    }

      private void drawTree(Graphics g, NodoMVias node, int x, int y, int xOffset) {
        if (node == null) return;

        // Dibujar las claves del nodo en la misma línea horizontal con separadores
        int claveX = x - (node.cantidadDeClavesNoVacias() * 20 / 2);
        for (int i = 0; i < node.cantidadDeClavesNoVacias(); i++) {
            g.drawString(node.getclave(i).toString()+",", claveX, y);
            claveX += 25; // Espacio entre claves
        }
        int orden=tree.getOrden();
        
        // Calcular la posición y dibujar los hijos
        int childX = x+140 - ((node.cantidadDeClavesNoVacias() + 1) * xOffset) / 2;
        for (int i = 0; i < orden; i++) {
            NodoMVias hijo = node.getHijo(i);
            if (hijo != null) {
             
                     g.drawLine(x, y + 5, childX, y + 35); // Ajuste de posición de línea
                     drawTree(g, hijo, childX, y + 50, xOffset / 2);
               
                g.drawLine(x, y + 5, childX, y + 35); // Ajuste de posición de línea
                drawTree(g, hijo, childX, y + 50, xOffset / 2);
                childX=childX-20;
                
                }
                
            childX += xOffset;
        }
    }
}
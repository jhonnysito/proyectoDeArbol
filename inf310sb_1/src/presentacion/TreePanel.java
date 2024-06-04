/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
  import javax.swing.*;
import java.awt.*;
import negocio.ArbolBinarioBusqueda;
import negocio.IArbolBusqueda;
import negocio.NodoBinario;
/**
 *
 * @author Usuario
 */

  

class TreePanel extends JPanel {
    private IArbolBusqueda tree;
    
    public TreePanel(IArbolBusqueda tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tree != null && tree.getRaiz() != null) {
            drawTree(g, (NodoBinario) tree.getRaiz(), getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void drawTree(Graphics g, NodoBinario node, int x, int y, int xOffset) {
        if (node == null) return;
        g.drawString( node.getClave().toString(), x, y);
        if (node.getHijoIzquierdo() != null) {
            g.drawLine(x, y, x - xOffset, y + 30);
            drawTree(g, node.getHijoIzquierdo(), x - xOffset, y + 50, xOffset / 2);
        }
        if (node.getHijoDerecho()!= null) {
            g.drawLine(x, y, x + xOffset, y + 30);
            drawTree(g, node.getHijoDerecho(), x + xOffset, y + 50, xOffset / 2);
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectovisual.gProductos;

import fiuni.edu.py.Controladores.ControladorProducto;
import fiuni.edu.py.Modelo.Producto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que representa la interfaz gráfica para listar todos los productos
 * disponibles.
 *
 * Muestra en una tabla los productos registrados, ya sea por unidades o por
 * peso. Esta clase forma parte de la GUI y extiende {@link javax.swing.JFrame}.
 * Utiliza el {@link ControladorProducto} para obtener la lista de productos
 * desde el modelo.
 *
 * Cada fila de la tabla contiene:
 * <ul>
 * <li>ID del producto</li>
 * <li>Nombre</li>
 * <li>Tipo (por Kgs o por unidades)</li>
 * <li>Precio</li>
 * <li>Stock (peso o unidades)</li>
 * </ul>
 *
 * Al presionar el botón, se regresa al menú de gestión de productos.
 *
 * @author luisf
 */
public class ListarProducto extends javax.swing.JFrame {

    /**
     * Controlador para la lógica de negocio relacionada con productos.
     */
    private final ControladorProducto controlador = new ControladorProducto();

    /**
     * Constructor de la clase. Inicializa los componentes gráficos, centra la
     * ventana y carga la lista de productos en la tabla.
     */
    public ListarProducto() {
        initComponents();
        setLocationRelativeTo(null);
        listar();

    }

    /**
     * Método encargado de cargar los productos en la tabla visual. Utiliza un
     * {@link DefaultTableModel} para llenar los datos según el tipo de
     * producto. Si el producto es por peso, se muestra como "Por Kgs", de lo
     * contrario, como "Por unidades".
     */
    public void listar() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        String peso = "Por Kgs";
        String unidad = "Por unidades";
        List<Producto> productos = controlador.obtenerTodos();
        for (Producto p : productos) {
            if (p.getPeso() != -1) {
                modelo.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getNombre(),
                    peso,
                    p.getPrecio(),
                    p.getPeso(),});
            } else {
                modelo.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getNombre(),
                    unidad,
                    p.getPrecio(),
                    p.getUnidades(),});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 220, 180));
        setMinimumSize(new java.awt.Dimension(640, 420));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(5, 0));

        jPanel1.setBackground(new java.awt.Color(220, 220, 180));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 112));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("LISTA DE PRODUCTOS");
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2);

        jSeparator3.setForeground(java.awt.Color.darkGray);
        jSeparator3.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel1.add(jSeparator3);

        jSeparator4.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator4.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 25));
        jPanel1.add(jSeparator4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Precio", "Stock"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(600, 70));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);

        jPanel4.setBackground(new java.awt.Color(220, 220, 180));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 400));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator10.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator10.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator10.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel4.add(jSeparator10);

        jPanel1.add(jPanel4);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("VOLVER");
        jButton2.setAlignmentX(0.5F);
        jButton2.setAlignmentY(1.0F);
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(200, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción ejecutada al presionar el botón de volver. Cierra la ventana
     * actual y abre el menú de gestión de productos.
     *
     * @param evt Evento generado por el botón.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new MenuGestionProductos().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

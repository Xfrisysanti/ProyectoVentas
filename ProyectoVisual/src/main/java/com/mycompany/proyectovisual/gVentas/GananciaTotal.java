/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectovisual.gVentas;

import fiuni.edu.py.Controladores.ControladorVentas;
import fiuni.edu.py.Modelo.Ventas;

/**
 * Ventana que muestra la ganancia total generada por todas las ventas
 * realizadas.
 *
 * Esta clase representa una interfaz gráfica que calcula y visualiza el total
 * de ingresos sumando el valor de todas las ventas registradas.
 *
 * Utiliza un controlador para obtener los datos de ventas, siguiendo el patrón
 * MVC.
 *
 * @author luisf
 */
public class GananciaTotal extends javax.swing.JFrame {

    // Controlador que gestiona las operaciones relacionadas con las ventas
    private final ControladorVentas controlador = new ControladorVentas();
    // Variable que almacena la ganancia total calculada
    private int total;

    /**
     * Constructor de la clase. Inicializa los componentes gráficos, centra la
     * ventana y llama al método para mostrar la ganancia total.
     */
    public GananciaTotal() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarGananciaTotal();
    }

    /**
     * Calcula y muestra la ganancia total sumando el valor de todas las ventas.
     * La suma se realiza llamando al método {@code calcularTotalVenta} del
     * controlador. El resultado se muestra en la etiqueta {@code jLabel1}.
     */
    public void mostrarGananciaTotal() {

        for (Ventas v : controlador.listarVentas()) {
            total += controlador.calcularTotalVenta(v);
        }
        jLabel1.setText(String.valueOf(total));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
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

        jSeparator3.setForeground(java.awt.Color.darkGray);
        jSeparator3.setMaximumSize(new java.awt.Dimension(32767, 150));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 100));
        jPanel1.add(jSeparator3);

        jPanel3.setBackground(new java.awt.Color(220, 220, 180));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator9.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator9.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator9.setMaximumSize(new java.awt.Dimension(150, 25));
        jPanel3.add(jSeparator9);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("El monto de todas las ventas es");
        jPanel3.add(jLabel2);

        jSeparator12.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator12.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator12.setMaximumSize(new java.awt.Dimension(5, 25));
        jPanel3.add(jSeparator12);

        jPanel4.setBackground(new java.awt.Color(220, 220, 180));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setMaximumSize(new java.awt.Dimension(100, 40));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator10.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator10.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator10.setMaximumSize(new java.awt.Dimension(12, 25));
        jPanel4.add(jSeparator10);

        jLabel1.setText("XXX");
        jPanel4.add(jLabel1);

        jPanel3.add(jPanel4);

        jSeparator18.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator18.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator18.setMaximumSize(new java.awt.Dimension(5, 25));
        jPanel3.add(jSeparator18);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Gs.");
        jPanel3.add(jLabel5);

        jPanel1.add(jPanel3);

        jSeparator4.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator4.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel1.add(jSeparator4);

        jSeparator5.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator5.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator5.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel1.add(jSeparator5);

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
     * Acción que se ejecuta al presionar el botón para regresar al menú de
     * gestión de ventas. Abre la ventana de gestión de ventas y cierra la
     * actual.
     *
     * @param evt Evento generado al hacer clic en el botón.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new MenuGestionVentas().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(GananciaTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GananciaTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GananciaTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GananciaTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GananciaTotal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}

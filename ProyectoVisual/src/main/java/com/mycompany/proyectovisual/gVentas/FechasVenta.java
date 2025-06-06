/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectovisual.gVentas;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Ventana para ingresar un rango de fechas y visualizar las ventas realizadas
 * entre esas fechas.
 *
 * Esta clase permite al usuario introducir dos fechas (inicio y fin) para luego
 * filtrar las ventas realizadas en ese rango. Las fechas deben tener el formato
 * "yyyy-MM-dd".
 *
 * @author luisf
 */
public class FechasVenta extends javax.swing.JFrame {

    // Fecha de inicio del rango
    private LocalDate fecha1;
    // Fecha de fin del rango
    private LocalDate fecha2;

    /**
     * Constructor que inicializa la interfaz gráfica y centra la ventana.
     */
    public FechasVenta() {
        initComponents();
        setLocationRelativeTo(null);
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
        jSeparator12 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jSeparator18 = new javax.swing.JSeparator();
        jTextField6 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jSeparator17 = new javax.swing.JSeparator();
        jTextField3 = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 220, 180));
        setMinimumSize(new java.awt.Dimension(640, 420));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(220, 220, 180));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 112));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jSeparator3.setForeground(java.awt.Color.darkGray);
        jSeparator3.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel1.add(jSeparator3);

        jPanel3.setBackground(new java.awt.Color(220, 220, 180));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator9.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator9.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator9.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel3.add(jSeparator9);

        jSeparator12.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator12.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator12.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel3.add(jSeparator12);

        jPanel1.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(220, 220, 180));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator10.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator10.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator10.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel4.add(jSeparator10);

        jPanel1.add(jPanel4);

        jSeparator4.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator4.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel1.add(jSeparator4);

        jPanel5.setBackground(new java.awt.Color(220, 220, 180));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator11.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator11.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator11.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel5.add(jSeparator11);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ingrese la Fecha de Inicio (AAAA-MM-DD)");
        jPanel5.add(jLabel3);

        jSeparator13.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator13.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator13.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel5.add(jSeparator13);

        jPanel1.add(jPanel5);

        jPanel9.setBackground(new java.awt.Color(220, 220, 180));
        jPanel9.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator18.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator18.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator18.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel9.add(jSeparator18);

        jTextField6.setText("Ingrese el texto aquí");
        jTextField6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField6.setMaximumSize(new java.awt.Dimension(500, 40));
        jTextField6.setPreferredSize(new java.awt.Dimension(50, 26));
        jPanel9.add(jTextField6);

        jPanel1.add(jPanel9);

        jSeparator5.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator5.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator5.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel1.add(jSeparator5);

        jPanel7.setBackground(new java.awt.Color(220, 220, 180));
        jPanel7.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator15.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator15.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator15.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel7.add(jSeparator15);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ingrese la Fecha de Fin (AAAA-MM-DD)");
        jPanel7.add(jLabel4);

        jSeparator16.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator16.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator16.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel7.add(jSeparator16);

        jPanel1.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(220, 220, 180));
        jPanel8.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator17.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator17.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator17.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel8.add(jSeparator17);

        jTextField3.setText("Ingrese el texto aquí");
        jTextField3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField3.setMaximumSize(new java.awt.Dimension(500, 40));
        jTextField3.setPreferredSize(new java.awt.Dimension(50, 26));
        jPanel8.add(jTextField3);

        jPanel1.add(jPanel8);

        jSeparator6.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator6.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator6.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel1.add(jSeparator6);

        jPanel11.setBackground(new java.awt.Color(220, 220, 180));
        jPanel11.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator22.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator22.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator22.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel11.add(jSeparator22);

        jSeparator23.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator23.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator23.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel11.add(jSeparator23);

        jPanel1.add(jPanel11);

        jSeparator7.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator7.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator7.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel1.add(jSeparator7);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("SIGUIENTE");
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

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al presionar el botón para buscar ventas entre dos
     * fechas.
     *
     * Este método realiza lo siguiente:
     * <ul>
     * <li>Lee las fechas introducidas en los campos de texto.</li>
     * <li>Valida que las fechas tengan el formato correcto (yyyy-MM-dd).</li>
     * <li>Muestra mensajes de error si alguna fecha es inválida.</li>
     * <li>Si ambas fechas son válidas, abre la ventana
     * {@code VentasEntreFechas} con ese rango.</li>
     * </ul>
     *
     * @param evt Evento generado al hacer clic en el botón.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Validar campo Fecha1
        String fechaTexto1 = jTextField6.getText().trim();
        try {
            fecha1 = LocalDate.parse(fechaTexto1); // formato esperado: yyyy-MM-dd
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use yyyy-MM-dd (por ejemplo: 2006-02-04).");
        }

        // Validar campo Fecha2
        String fechaTexto2 = jTextField3.getText().trim();
        try {
            fecha2 = LocalDate.parse(fechaTexto2); // formato esperado: yyyy-MM-dd
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use yyyy-MM-dd (por ejemplo: 2006-02-04).");
        }

        new VentasEntreFechas(fecha1, fecha2).setVisible(true);
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
            java.util.logging.Logger.getLogger(FechasVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FechasVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FechasVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FechasVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FechasVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}

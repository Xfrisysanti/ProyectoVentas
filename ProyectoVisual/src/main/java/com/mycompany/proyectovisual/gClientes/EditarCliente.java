/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectovisual.gClientes;

import fiuni.edu.py.Controladores.ControladorClientes;
import static java.lang.Integer.parseInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Clase que representa la ventana para editar los datos de un cliente
 * existente. Permite modificar el nombre, la edad y el correo electrónico
 * (Gmail) de un cliente previamente registrado en el sistema, identificado por
 * su ID.
 *
 * Autor: luisf
 */
public class EditarCliente extends javax.swing.JFrame {

    /**
     * ID del cliente que se desea editar.
     */
    private int id;
    /**
     * Nombre del cliente.
     */
    private String nombre;
    /**
     * Correo electrónico (Gmail) del cliente.
     */
    private String gmail;
    /**
     * Edad del cliente.
     */
    private int edad;

    /**
     * Controlador encargado de gestionar las operaciones relacionadas con
     * clientes.
     */
    private final ControladorClientes controlador = new ControladorClientes();

    /**
     * Constructor que recibe el ID del cliente a editar. Inicializa la interfaz
     * gráfica y la centra en la pantalla.
     *
     * @param id ID del cliente a editar
     */
    public EditarCliente(int id) {
        this.id = id;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Constructor sin parámetros. Inicializa la interfaz gráfica y la centra en
     * la pantalla. Se puede utilizar para pruebas o para cargar el formulario
     * sin un cliente específico.
     */
    public EditarCliente() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    
    
    private static boolean isValidExtension(String extension) {
        String[] validExtensions = {"com", "org", "net", "int", "edu", "gov", "mil"};
        for (String validExtension : validExtensions) {
            if (extension.equalsIgnoreCase(validExtension)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si el dominio es válido.
     *
     * @param domain El nombre del dominio.
     * @return true si el dominio es válido, false en caso contrario.
     */
    private static boolean isValidDomain(String domain) {
        // Verificar si el dominio es nulo, está vacío o no contiene un punto
        if (domain == null || domain.isEmpty() || !domain.contains(".")) {
            return false;
        }

        // Verificar que el dominio tenga solo un punto separador entre el nombre del dominio y la extensión
        int firstDotIndex = domain.indexOf(".");
        int lastDotIndex = domain.lastIndexOf(".");
        // Si hay más de un punto, se considera inválido
        if (firstDotIndex != lastDotIndex) {
            return false;
        }
        String extension = domain.substring(lastDotIndex + 1);
        // Expresión regular para verificar que el dominio solo contenga un punto
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(domain);

        return matcher.matches() && isValidExtension(extension);
    }

    /**
     * Verifica si el correo electrónico es válido.
     *
     * @param email La dirección de correo electrónico a verificar.
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    public static boolean isValidEmail(String email) {
    if (email == null || email.isEmpty()) {
        return false;
    }

    // Verificar que contenga exactamente un símbolo '@'
    int atIndex = email.indexOf('@');
    if (atIndex == -1 || atIndex != email.lastIndexOf('@')) {
        return false;
    }

    // Verificar estructura general del email con regex simple
    Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+$");
    Matcher matcher = pattern.matcher(email);
    if (!matcher.matches()) {
        return false;
    }

    // Extraer y validar dominio
    String domain = email.substring(atIndex + 1);
    return isValidDomain(domain);
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
        jPanel5 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jSeparator14 = new javax.swing.JSeparator();
        jTextField2 = new javax.swing.JTextField();
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
        jLabel6 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        jSeparator24 = new javax.swing.JSeparator();
        jTextField4 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 220, 180));
        setMinimumSize(new java.awt.Dimension(640, 420));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 0));

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

        jPanel5.setBackground(new java.awt.Color(220, 220, 180));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator11.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator11.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator11.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel5.add(jSeparator11);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ingrese el Nombre del Cliente Editado");
        jPanel5.add(jLabel3);

        jSeparator13.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator13.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator13.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel5.add(jSeparator13);

        jPanel1.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(220, 220, 180));
        jPanel6.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator14.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator14.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator14.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel6.add(jSeparator14);

        jTextField2.setText("Ingrese el texto aquí");
        jTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField2.setMaximumSize(new java.awt.Dimension(500, 40));
        jTextField2.setPreferredSize(new java.awt.Dimension(50, 26));
        jPanel6.add(jTextField2);

        jPanel1.add(jPanel6);

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
        jLabel4.setText(" Ingrese la Edad del Cliente Editado");
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ingrese el Email del Cliente Editado (Ej: nombre@gmail.com) ");
        jPanel11.add(jLabel6);

        jSeparator23.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator23.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator23.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel11.add(jSeparator23);

        jPanel1.add(jPanel11);

        jPanel10.setBackground(new java.awt.Color(220, 220, 180));
        jPanel10.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator19.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator19.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator19.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel10.add(jSeparator19);

        jSeparator20.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator20.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator20.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel10.add(jSeparator20);

        jPanel12.setBackground(new java.awt.Color(220, 220, 180));
        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator24.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator24.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator24.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel12.add(jSeparator24);

        jTextField4.setText("Ingrese el texto aquí");
        jTextField4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField4.setMaximumSize(new java.awt.Dimension(500, 40));
        jTextField4.setPreferredSize(new java.awt.Dimension(50, 26));
        jPanel12.add(jTextField4);

        jPanel10.add(jPanel12);

        jPanel1.add(jPanel10);

        jSeparator7.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator7.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator7.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel1.add(jSeparator7);

        jPanel2.setBackground(new java.awt.Color(220, 220, 180));
        jPanel2.setMaximumSize(new java.awt.Dimension(700, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(40, 100));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("CANCELAR");
        jButton3.setAlignmentX(0.5F);
        jButton3.setAlignmentY(1.0F);
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(200, 50));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jSeparator1.setPreferredSize(new java.awt.Dimension(100, 10));
        jPanel2.add(jSeparator1);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("GUARDAR CAMBIOS");
        jButton2.setAlignmentX(0.5F);
        jButton2.setAlignmentY(1.0F);
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(200, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta al presionar el botón de guardar cambios. Obtiene
     * los datos ingresados por el usuario (nombre, edad, gmail), los valida, y
     * si son correctos, actualiza la información del cliente mediante el
     * controlador. En caso de error numérico en la edad, se muestra un mensaje
     * y se retorna al menú de gestión.
     *
     * @param evt Evento de acción del botón
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        nombre = jTextField2.getText();// Obtener nombre del campo de texto
        gmail = jTextField4.getText();// Obtener gmail del campo de texto
        if(!isValidEmail(gmail)){
            JOptionPane.showMessageDialog(this, "Email del cliente no válido, no cumple la tipología esperada.");
        return;
        }
        try {
            edad = parseInt(jTextField3.getText());// Convertir edad a entero
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al ingresar edad. Verifique que sea un número válido.");
            new MenuGestionClientes().setVisible(true);// Volver al menú
            dispose();
        }
        // Llamar al controlador para editar el cliente
        controlador.editarCliente(id, nombre, edad, gmail);
        JOptionPane.showMessageDialog(this, "Cliente Guardado con exito.");
        // Redirigir al menú principal de clientes
        new MenuGestionClientes().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MenuGestionClientes().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}

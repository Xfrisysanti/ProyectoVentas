/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectovisual.gVentas;

import fiuni.edu.py.Controladores.ControladorClientes;
import javax.swing.JOptionPane;
import fiuni.edu.py.Controladores.ControladorProducto;
import fiuni.edu.py.Controladores.ControladorVentas;
import fiuni.edu.py.Modelo.ItemVenta;
import fiuni.edu.py.Modelo.Ventas;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author luisf
 */
public class AgregarVenta extends javax.swing.JFrame {
    private int ci;
    private String nombre;
    private LocalDate fecha;
    private int cantidadInt;
    private double cantidadDouble;
    private ItemVenta itemVenta;
    List<ItemVenta> listaDeVentas = new ArrayList<>();
    ControladorProducto controladorProductos = new ControladorProducto();
    ControladorVentas controladorVentas= new ControladorVentas();
    ControladorClientes controladorClientes= new ControladorClientes();
    /**
    * Creates new form MenuPrincipal
     */
    public AgregarVenta() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public void cargarDatos1() {
    // Validar campo CI
    String ciTexto = jTextField6.getText().trim();
    if (ciTexto.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo CI no puede estar vacío.");
        resetearPanelCliente();
        return;
    }

    try {
        ci = Integer.parseInt(ciTexto);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "CI inválido. Ingrese solo números.");
        resetearPanelCliente();
        return;
    }

    if (controladorClientes.buscarCliente(ci) == null) {
        JOptionPane.showMessageDialog(null, "CI del cliente no encontrado. Verifique que exista o que no tenga errores de escritura.");
        resetearPanelCliente();
        return;
    }
    
    // Validar campo Fecha
    String fechaTexto = jTextField3.getText().trim();
    if (fechaTexto.isEmpty()) {
    JOptionPane.showMessageDialog(null, "El campo de fecha no puede estar vacío.");
    resetearPanelCliente();
    return;
    }

    try {
    fecha = LocalDate.parse(fechaTexto); // formato esperado: yyyy-MM-dd
    if (fecha.isAfter(LocalDate.now())) {
        JOptionPane.showMessageDialog(null, "La fecha no puede ser posterior a la fecha actual.");
        resetearPanelCliente();
        return;
    }
    } catch (DateTimeParseException e) {
    JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use yyyy-MM-dd (por ejemplo: 2006-02-04).");
    resetearPanelCliente();
    return;
    }
    jPanel1.setVisible(false);
    jPanel2.setVisible(true);
}
  
    
    
   public void cargarDatos2() {
    nombre = jTextField4.getText().trim();

    // Validar campo nombre
    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El nombre del producto no puede estar vacío.");
        resetearPanelProductos();
        return;
    }

    // Verificar si el producto existe
    if (!controladorProductos.existeProductosConEsteNombre(nombre)) {
        JOptionPane.showMessageDialog(null, "Producto no encontrado. Verifique el nombre.");
        resetearPanelProductos();
        return;
    }

    try {
        cantidadInt = Integer.parseInt(jTextField5.getText().trim());
        cantidadDouble = Double.parseDouble(jTextField5.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Cantidad inválida. Ingrese un número válido.");
        resetearPanelProductos();
        return;
    }

    int idProducto = controladorProductos.buscarProductoPorNombre(nombre);

    // Producto por peso
    if (controladorProductos.getPeso(idProducto) != -1) {
        double stockDisponible = controladorProductos.getPeso(idProducto);

        if (cantidadDouble <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero.");
            resetearPanelProductos();
            return;
        }

        if (stockDisponible >= cantidadDouble) {
            itemVenta = new ItemVenta(idProducto, cantidadDouble);
            controladorProductos.setPeso(controladorProductos.buscarProductoPorNombre(nombre), stockDisponible-cantidadDouble);
        } else {
            JOptionPane.showMessageDialog(null, "Stock insuficiente. Disponible: " + stockDisponible + " kg.");
            resetearPanelProductos();
            return;
        }
    }
    // Producto por unidad
    else {
        int stockDisponible = controladorProductos.getUnidades(idProducto);

        if (cantidadInt <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero.");
            resetearPanelProductos();
            return;
        }

        if (stockDisponible >= cantidadInt) {
            itemVenta = new ItemVenta(idProducto, cantidadInt);
            controladorProductos.setUnidades(controladorProductos.buscarProductoPorNombre(nombre), stockDisponible-cantidadInt);
        } else {
            JOptionPane.showMessageDialog(null, "Stock insuficiente. Disponible: " + stockDisponible + " unidades.");
            resetearPanelProductos();
            return;
        }
    }
}

        
        
    
    private void resetearPanelProductos() {
    jTextField4.setText("Ingrese el texto"); // Nombre del producto
    jTextField5.setText("Ingrese el texto"); // Cantidad
    jPanel2.setVisible(true);  // Asegura que se muestra el panel
    }
    
    private void resetearPanelCliente() {
    jTextField6.setText("Ingrese el texto"); // Nombre del producto
    jTextField3.setText("Ingrese el texto"); // Cantidad
    jPanel1.setVisible(true);  // Asegura que se muestra el panel
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
        jPanel2 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jPanel13 = new javax.swing.JPanel();
        jSeparator26 = new javax.swing.JSeparator();
        jTextField4 = new javax.swing.JTextField();
        jSeparator27 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        jPanel15 = new javax.swing.JPanel();
        jSeparator30 = new javax.swing.JSeparator();
        jTextField5 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator33 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jSeparator34 = new javax.swing.JSeparator();
        jSeparator35 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 220, 180));
        setMinimumSize(new java.awt.Dimension(640, 420));
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
        jLabel3.setText("Ingrese el número de CI del Cliente");
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
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
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
        jLabel4.setText("Ingrese la Fecha de la Venta (AAAA-MM-DD)");
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

        jPanel2.setBackground(new java.awt.Color(220, 220, 180));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 112));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jSeparator8.setForeground(java.awt.Color.darkGray);
        jSeparator8.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel2.add(jSeparator8);

        jPanel10.setBackground(new java.awt.Color(220, 220, 180));
        jPanel10.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator20.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator20.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator20.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel10.add(jSeparator20);

        jPanel2.add(jPanel10);

        jSeparator21.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator21.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator21.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel2.add(jSeparator21);

        jPanel12.setBackground(new java.awt.Color(220, 220, 180));
        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator24.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator24.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator24.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel12.add(jSeparator24);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ingrese el Nombre del Producto");
        jPanel12.add(jLabel5);

        jSeparator25.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator25.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator25.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel12.add(jSeparator25);

        jPanel2.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(220, 220, 180));
        jPanel13.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator26.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator26.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator26.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel13.add(jSeparator26);

        jTextField4.setText("Ingrese el texto aquí");
        jTextField4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField4.setMaximumSize(new java.awt.Dimension(500, 40));
        jTextField4.setPreferredSize(new java.awt.Dimension(50, 26));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField4);

        jPanel2.add(jPanel13);

        jSeparator27.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator27.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator27.setMaximumSize(new java.awt.Dimension(32767, 10));
        jPanel2.add(jSeparator27);

        jPanel14.setBackground(new java.awt.Color(220, 220, 180));
        jPanel14.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator28.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator28.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator28.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel14.add(jSeparator28);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ingrese la Cantidad del Producto");
        jPanel14.add(jLabel6);

        jSeparator29.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator29.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator29.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel14.add(jSeparator29);

        jPanel2.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(220, 220, 180));
        jPanel15.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator30.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator30.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator30.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel15.add(jSeparator30);

        jTextField5.setText("Ingrese el texto aquí");
        jTextField5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField5.setMaximumSize(new java.awt.Dimension(500, 40));
        jTextField5.setPreferredSize(new java.awt.Dimension(50, 26));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel15.add(jTextField5);

        jPanel2.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(220, 220, 180));
        jPanel16.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator32.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator32.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator32.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel16.add(jSeparator32);

        jSeparator33.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator33.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator33.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel16.add(jSeparator33);

        jPanel2.add(jPanel16);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("AGREGAR OTRO PRODUCTO AL CARRITO");
        jButton3.setToolTipText("");
        jButton3.setAlignmentX(0.5F);
        jButton3.setAlignmentY(1.0F);
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(400, 50));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jPanel17.setBackground(new java.awt.Color(220, 220, 180));
        jPanel17.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator34.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator34.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator34.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel17.add(jSeparator34);

        jSeparator35.setBackground(new java.awt.Color(220, 220, 180));
        jSeparator35.setForeground(new java.awt.Color(220, 220, 180));
        jSeparator35.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel17.add(jSeparator35);

        jPanel2.add(jPanel17);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 102, 102));
        jButton4.setText("FINALIZAR VENTA");
        jButton4.setAlignmentX(0.5F);
        jButton4.setAlignmentY(1.0F);
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(200, 50));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        getContentPane().add(jPanel2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargarDatos1();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                  
        cargarDatos2();
        listaDeVentas.add(itemVenta); 
        resetearPanelProductos(); 
  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        listaDeVentas.add(itemVenta);
        Ventas nuevaVenta=new Ventas(ci,listaDeVentas,fecha);
        controladorVentas.registrarVenta(nuevaVenta);
        new MenuGestionVentas().setVisible(true);
        JOptionPane.showMessageDialog(this, "Venta agregada exitosamente con id:"+nuevaVenta.getIdVenta());
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}

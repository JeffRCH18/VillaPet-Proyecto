package Swing;

import Clases.Cliente;
import Clases.ClienteDAO;
import Clases.DetalleDAO;
import Clases.Producto;
import Clases.Servicio;
import Clases.Sucursal;
import Clases.SucursalDAO;
import Clases.VentaDAO;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class JFVenta extends javax.swing.JFrame {
    DefaultTableModel modelo;
    VentaDAO ventadao = new VentaDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    SucursalDAO sucursalDAO = new SucursalDAO();
    DetalleDAO detalleDAO = new DetalleDAO(); 
    DefaultTableModel modeloCarrito;
    public JFVenta() {
        initComponents();
        llenarComboBoxSucursal();
        tablaCarrito();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblmenuVentas = new javax.swing.JLabel();
        lblmenuVentas3 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblNumeroVenta = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblProductoAdquirido = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblMontoFactura = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        txtVentasxSucursal = new javax.swing.JTextField();
        btnVentasporSucursal = new javax.swing.JButton();
        btnVentasEmpSucursal = new javax.swing.JButton();
        boxSucursal = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        lblimagenSucursal = new javax.swing.JLabel();
        lblMontoFactura1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        lblmenuVentas.setBackground(new java.awt.Color(255, 255, 255));
        lblmenuVentas.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblmenuVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblmenuVentas.setText("MENÚ VENTAS");

        lblmenuVentas3.setBackground(new java.awt.Color(255, 255, 255));
        lblmenuVentas3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblmenuVentas3.setForeground(new java.awt.Color(255, 255, 255));
        lblmenuVentas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/sucursalpeq.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Villa Pet");

        lblNumeroVenta.setBackground(new java.awt.Color(255, 255, 255));
        lblNumeroVenta.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblNumeroVenta.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroVenta.setText("ID CLIENTE");

        txtID.setBackground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
        });

        lblProductoAdquirido.setBackground(new java.awt.Color(255, 255, 255));
        lblProductoAdquirido.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblProductoAdquirido.setForeground(new java.awt.Color(255, 255, 255));
        lblProductoAdquirido.setText("NOMBRE");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        lblMontoFactura.setBackground(new java.awt.Color(255, 255, 255));
        lblMontoFactura.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblMontoFactura.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoFactura.setText("CORREO");

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnEliminar.setBackground(new java.awt.Color(153, 153, 153));
        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(153, 153, 153));
        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/nuevo.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tablaVentas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVentas);

        btnRegresar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegresar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/regresar peq.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtVentasxSucursal.setBackground(new java.awt.Color(255, 255, 255));
        txtVentasxSucursal.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnVentasporSucursal.setBackground(new java.awt.Color(204, 204, 204));
        btnVentasporSucursal.setForeground(new java.awt.Color(0, 0, 0));
        btnVentasporSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/edificio sucursal peq.png"))); // NOI18N
        btnVentasporSucursal.setText("Ventas por Sucursal");
        btnVentasporSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasporSucursalActionPerformed(evt);
            }
        });

        btnVentasEmpSucursal.setBackground(new java.awt.Color(204, 204, 204));
        btnVentasEmpSucursal.setForeground(new java.awt.Color(0, 0, 0));
        btnVentasEmpSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/empledo sucursal peq.png"))); // NOI18N
        btnVentasEmpSucursal.setText("Ventas empleado por Sucursal");
        btnVentasEmpSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasEmpSucursalActionPerformed(evt);
            }
        });

        boxSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaCarrito);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));

        btnPagar.setBackground(new java.awt.Color(153, 153, 153));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/contrasena.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        lblimagenSucursal.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblimagenSucursal.setForeground(new java.awt.Color(255, 255, 255));
        lblimagenSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/sucursal peq.png"))); // NOI18N

        lblMontoFactura1.setBackground(new java.awt.Color(255, 255, 255));
        lblMontoFactura1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblMontoFactura1.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoFactura1.setText("TOTAL:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Número de sucursal");
        jLabel4.setMaximumSize(new java.awt.Dimension(69, 15));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNumeroVenta)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblProductoAdquirido)
                                .addGap(82, 82, 82)
                                .addComponent(lblMontoFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lblmenuVentas3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblmenuVentas)
                                        .addGap(333, 333, 333)
                                        .addComponent(lblTitulo)))
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(lblimagenSucursal)
                                        .addGap(8, 8, 8)
                                        .addComponent(boxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(436, 436, 436)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btnEliminar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lblMontoFactura1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVentasxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVentasporSucursal)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVentasEmpSucursal)
                                .addGap(44, 44, 44))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMontoFactura)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblmenuVentas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblmenuVentas3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNumeroVenta)
                                    .addComponent(lblProductoAdquirido))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblimagenSucursal))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnPagar)
                                    .addComponent(btnEliminar))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMontoFactura1)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnAgregar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVentasxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVentasporSucursal)
                        .addGap(51, 51, 51)
                        .addComponent(btnVentasEmpSucursal)))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int filaSeleccionada = tablaVentas.getSelectedRow();
        if (filaSeleccionada != -1) {
        String tipo = (String) modelo.getValueAt(filaSeleccionada, 0);

        if (tipo.equals("Servicio")) {
            agregarAlCarrito(filaSeleccionada, 1);
        } else if (tipo.equals("Producto")) {
            int cantidad = solicitarCantidadProducto();
            if (cantidad > 0) {
                agregarAlCarrito(filaSeleccionada, cantidad);
            }
        }

        total_pagar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
        JFPrincipal principal = new JFPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnVentasporSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasporSucursalActionPerformed
        String sucursal = txtNombre.getText();
        if (!sucursal.isEmpty()) {
            VentaDAO ventaDAO = new VentaDAO();
            int ventas = ventaDAO.obtenerVentasPorSucursal(Integer.parseInt(sucursal));
            txtVentasxSucursal.setText(String.valueOf(ventas));
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el número de la sucursal.");
        }
    }//GEN-LAST:event_btnVentasporSucursalActionPerformed

    private void btnVentasEmpSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasEmpSucursalActionPerformed
        VentaDAO ventaDAO = new VentaDAO();
        String listaVentas = ventaDAO.listarVentasPorEmpleadoSucursal();
        JOptionPane.showMessageDialog(this, listaVentas, "Listar Ventas por Empleado y Sucursal", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnVentasEmpSucursalActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        List<Sucursal> listaSucursal = sucursalDAO.ListarSucursal();
        
        int idCliente = Integer.parseInt(txtID.getText());
        String nombreSucursal = (String) boxSucursal.getSelectedItem();
       
        int idSucursal = SucursalDAO.obtenerIdPorDescripcions(nombreSucursal, listaSucursal);

        
        int montoTotal = Integer.parseInt(txtTotal.getText());
        LocalDate fechaActual = LocalDate.now();
        
        ventadao.insertarVenta(idCliente, idSucursal, montoTotal,fechaActual);
        registrar_detalle();
        listar();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        
        if (!"".equals(txtID.getText().trim())) {
            try {
                int id = Integer.parseInt(txtID.getText().trim());
                Cliente cli = ClienteDAO.buscarClientePorId(id);
                if (cli != null && cli.getNombre_Cliente() != null) {
                    txtNombre.setText(cli.getNombre_Cliente()+" "+cli.getApellido_Cliente());
                    txtCorreo.setText(cli.getCorreo_Cliente());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún cliente para el ID especificado");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido para el ID");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un número de ID");
        }
    }
    }//GEN-LAST:event_txtIDKeyPressed

    public void listar() {
        List<Object> lista = ventadao.usarVista();

        modelo = new DefaultTableModel();
        modelo.addColumn("Tipo");
        modelo.addColumn("ID");
        modelo.addColumn("Descripción");
        modelo.addColumn("Detalle");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");

        for (Object obj : lista) {
            if (obj instanceof Producto) {
                Producto producto = (Producto) obj;
                modelo.addRow(new Object[]{"Producto", producto.getID_Producto(),
                        producto.getDescripcion(), "", producto.getPrecio(), producto.getStock()});
            } else if (obj instanceof Servicio) {
                Servicio servicio = (Servicio) obj;
                modelo.addRow(new Object[]{"Servicio", servicio.getID_Servicio(),
                        servicio.getNombre_Servicios(), servicio.getDescripcion_Servicio(),
                        servicio.getPrecio(), ""});
            }
        }
        tablaVentas.setModel(modelo);
    }
    
    public void registrar_detalle() {
    int idVenta = ventadao.IdVenta();

    for (int i = 0; i < tablaCarrito.getRowCount(); i++) {
        try {
            String tipoElemento = (String) tablaCarrito.getValueAt(i, 0);  // 'Producto' o 'Servicio'
            int idElemento = Integer.parseInt(tablaCarrito.getValueAt(i, 1).toString());
            int cantidad = Integer.parseInt(tablaCarrito.getValueAt(i, 4).toString());
            int precio = Integer.parseInt(tablaCarrito.getValueAt(i, 3).toString());

            // Insertar detalle de venta
            detalleDAO.insertarDetalleVenta(tipoElemento, idElemento, cantidad, precio, idVenta);
        } catch (NumberFormatException e) {
            System.out.println("Error al obtener datos de la fila " + i + ": " + e.getMessage());
        }
    }
}
    
    private void agregarAlCarrito(int filaSeleccionada, int cantidad) {
        // Obtener el modelo de la tabla de ventas
        DefaultTableModel modeloProductos = (DefaultTableModel) tablaVentas.getModel();

        // Obtener los datos de la fila seleccionada en la tabla de ventas
        String tipo = (String) modeloProductos.getValueAt(filaSeleccionada, 0); // Tipo (Producto/Servicio)
        int id = (int) modeloProductos.getValueAt(filaSeleccionada, 1);
        String nombre = (String) modeloProductos.getValueAt(filaSeleccionada, 2);
        int precio = (int) modeloProductos.getValueAt(filaSeleccionada, 4);

        // Verificar si es un producto o un servicio
        if (tipo.equals("Producto")) {
            int stockDisponible = (int) modeloProductos.getValueAt(filaSeleccionada, 5);

            // Verificar si la cantidad solicitada es mayor que el stock disponible
            if (cantidad > stockDisponible) {
                JOptionPane.showMessageDialog(this, "No hay suficiente stock disponible para " + nombre,
                        "Stock Insuficiente", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un array para los datos del carrito (Tipo, ID, Nombre, Precio, Cantidad)
            Object[] filaDatosCarrito = new Object[]{
                    tipo, id, nombre, precio, cantidad
            };

            // Agregar la fila al modelo del carrit
            modeloCarrito.addRow(filaDatosCarrito);

            // Restar la cantidad agregada del stock disponible en la tabla de ventas
            int nuevoStock = stockDisponible - cantidad;
            modeloProductos.setValueAt(nuevoStock, filaSeleccionada, 5); // Actualizar el stock en la tabla de ventas
        } else if (tipo.equals("Servicio")) {
            Object[] filaDatosCarrito = new Object[]{
                    tipo, id, nombre, precio, cantidad
            };

            // Agregar la fila al modelo del carrito (modeloCarrito)
            modeloCarrito.addRow(filaDatosCarrito);
        }
    }
    
    private int solicitarCantidadProducto() {
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad deseada:", "Cantidad", JOptionPane.PLAIN_MESSAGE);
        if (cantidadStr == null || cantidadStr.isEmpty()) {
            return 0;
        }
        try {
            int cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
            return cantidad;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    } 
     
    public final void llenarComboBoxSucursal() {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        // Obtener lista de sucursales
        List<Sucursal> sucursales = sucursalDAO.ListarSucursal();
        // Agregar ítem por defecto al modelo del JComboBox
        comboBoxModel.addElement("Seleccione una Sucursal");
        // Agregar sucursales al modelo del JComboBox
        for (Sucursal sucursal : sucursales) {
            comboBoxModel.addElement(sucursal.getNombre_Sucursal());
        }
        // Establecer el modelo en el JComboBox
        boxSucursal.setModel(comboBoxModel);  
    }
    
    public void total_pagar(){
        int total_pagar = 0;
        DefaultTableModel modelo = (DefaultTableModel) tablaCarrito.getModel();
        int numFilas = modelo.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            // Obtener el valor de la columna precio
            int precio = (int) modelo.getValueAt(i, 3);
            int cantidad = (int) modeloCarrito.getValueAt(i, 4);
            // Calcular el subtotal para este producto
            int subtotal = precio * cantidad;
            // Sumar el subtotal al total_pagar
            total_pagar += subtotal;
        }
    }
    
    public void tablaCarrito(){
        modeloCarrito = new DefaultTableModel();
        modeloCarrito.addColumn("Tipo");
        modeloCarrito.addColumn("ID");
        modeloCarrito.addColumn("Descripción");
        modeloCarrito.addColumn("Precio");
        modeloCarrito.addColumn("Cantidad");
        tablaCarrito.setModel(modeloCarrito); 
    
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(JFVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(JFVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(JFVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(JFVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxSucursal;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVentasEmpSucursal;
    private javax.swing.JButton btnVentasporSucursal;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMontoFactura;
    private javax.swing.JLabel lblMontoFactura1;
    private javax.swing.JLabel lblNumeroVenta;
    private javax.swing.JLabel lblProductoAdquirido;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblimagenSucursal;
    private javax.swing.JLabel lblmenuVentas;
    private javax.swing.JLabel lblmenuVentas3;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVentasxSucursal;
    // End of variables declaration//GEN-END:variables
}

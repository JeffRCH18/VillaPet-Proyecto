package Swing;

import Clases.Empleado;
import Clases.EmpleadoDAO;
import Clases.Puesto;
import Clases.PuestoDAO;
import Clases.Rol;
import Clases.RolDAO;
import Clases.Sucursal;
import Clases.SucursalDAO;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class JFEmpleado extends javax.swing.JFrame {

    RolDAO rolDAO = new RolDAO();
    PuestoDAO puestoDAO = new PuestoDAO();
    SucursalDAO sucursalDAO = new SucursalDAO();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    DefaultTableModel modelo;

    public JFEmpleado() {
        initComponents();
        listar();
        llenarComboBoxRoles();
        llenarComboBoxPuesto();
        llenarComboBoxSucursal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblmenuEmpleados = new javax.swing.JLabel();
        lblmenuEmpleados1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPuesto = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        lblAcciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        lblSalario1 = new javax.swing.JLabel();
        boxPuesto = new javax.swing.JComboBox<>();
        boxSucursal = new javax.swing.JComboBox<>();
        lblSalario2 = new javax.swing.JLabel();
        lblSalario3 = new javax.swing.JLabel();
        lblSalario4 = new javax.swing.JLabel();
        boxRol = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        txtSalarioMin = new javax.swing.JTextField();
        txtSalarioMax = new javax.swing.JTextField();
        btnEmpleadosporRangoSalario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        lblmenuEmpleados.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblmenuEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        lblmenuEmpleados.setText("MENÚ EMPLEADOS");

        lblmenuEmpleados1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblmenuEmpleados1.setForeground(new java.awt.Color(255, 255, 255));
        lblmenuEmpleados1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/empleadopeq.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblTitulo.setText("Villa Pet");

        txtContraseña.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("NOMBRE:");

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        lblPuesto.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblPuesto.setForeground(new java.awt.Color(255, 255, 255));
        lblPuesto.setText("APELLIDO:");

        txtApellido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        lblCorreo.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("CORREO:");

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        lblSalario.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblSalario.setForeground(new java.awt.Color(255, 255, 255));
        lblSalario.setText("CONTRASENA:");

        txtSalario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(153, 153, 153));
        btnBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(153, 153, 153));
        btnLimpiar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnRefrescar.setBackground(new java.awt.Color(153, 153, 153));
        btnRefrescar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/refrescar.png"))); // NOI18N
        btnRefrescar.setText("Refrescar");
        btnRefrescar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnActualizar.setBackground(new java.awt.Color(153, 153, 153));
        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        btnNuevo.setBackground(new java.awt.Color(153, 153, 153));
        btnNuevo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        lblAcciones.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblAcciones.setForeground(new java.awt.Color(255, 255, 255));
        lblAcciones.setText("ACCIONES:");

        tablaEmpleados.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaEmpleados);

        lblSalario1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblSalario1.setForeground(new java.awt.Color(255, 255, 255));
        lblSalario1.setText("SALARIO:");

        boxPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPuestoActionPerformed(evt);
            }
        });

        lblSalario2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblSalario2.setForeground(new java.awt.Color(255, 255, 255));
        lblSalario2.setText("ROL");

        lblSalario3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblSalario3.setForeground(new java.awt.Color(255, 255, 255));
        lblSalario3.setText("PUESTO");

        lblSalario4.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblSalario4.setForeground(new java.awt.Color(255, 255, 255));
        lblSalario4.setText("SUCURSAL");

        boxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegresar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegresar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/regresar peq.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtSalarioMin.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtSalarioMax.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnEmpleadosporRangoSalario.setText("EmpleadosporRangoSalario");
        btnEmpleadosporRangoSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosporRangoSalarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblPuesto)
                                            .addComponent(lblSalario1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSalario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(lblmenuEmpleados1))
                                    .addComponent(lblmenuEmpleados)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCorreo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalario2))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalario3))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalario4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAcciones)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSalarioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSalarioMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEmpleadosporRangoSalario))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(60, 60, 60))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblmenuEmpleados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblmenuEmpleados1))
                                    .addComponent(btnRegresar))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblNombre)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPuesto)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblCorreo)
                                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblSalario)
                                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSalario1)
                                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSalario2)
                                    .addComponent(lblSalario3)
                                    .addComponent(lblSalario4))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boxPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(lblAcciones)
                                .addGap(18, 18, 18)
                                .addComponent(btnNuevo)
                                .addGap(29, 29, 29)
                                .addComponent(btnEliminar)
                                .addGap(29, 29, 29)
                                .addComponent(btnActualizar)
                                .addGap(29, 29, 29)
                                .addComponent(btnRefrescar)))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblTitulo)
                            .addGap(137, 137, 137))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSalarioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSalarioMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(btnEmpleadosporRangoSalario))))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void boxPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxPuestoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Obtener lista de roles, puestos y sucursales de cada DAO
        List<Rol> listaRoles = rolDAO.Listarrol();
        List<Puesto> listaPuesto = puestoDAO.ListarPuesto();
        List<Sucursal> listaSucursal = sucursalDAO.ListarSucursal();
        // Se obtiene datos del empleado desde los campos de texto y combobox
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String correo = txtCorreo.getText();
        String contraseña = txtContraseña.getText();
        int salario = Integer.parseInt(txtSalario.getText());
        String nombreSucursal = (String) boxSucursal.getSelectedItem();
        String nombreRol = (String) boxRol.getSelectedItem();
        String nombrePuesto = (String) boxPuesto.getSelectedItem();

        // Se obtiene IDs de rol, sucursal y puesto utilizando los nombres seleccionados en cada combobox
        int idRolSeleccionador = RolDAO.obtenerIdPorDescripcionr(nombreRol, listaRoles);
        int idRolSeleccionados = SucursalDAO.obtenerIdPorDescripcions(nombreSucursal, listaSucursal);
        int idRolSeleccionadop = PuestoDAO.obtenerIdPorDescripcionp(nombrePuesto, listaPuesto);

        try
        {
            // Se inserta nuevo empleado utilizando los datos y IDs obtenidos
            empleadoDAO.insertarEmpleado(idRolSeleccionadop, idRolSeleccionador, nombre, apellido, correo, contraseña, salario, idRolSeleccionados);
            // Después de insertar, se debe actualizar la lista de empleados y limpiar los campos
            listar();
            limpiarCampos();
            llenarComboBoxSucursal();
            llenarComboBoxRoles();
            llenarComboBoxPuesto();
        } catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Salario inválido. Por favor, ingrese un valor numérico válido.");
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        //  Obtiene el índice de la fila seleccionada en la tabla
        int filaSeleccionada = tablaEmpleados.getSelectedRow();
        if (filaSeleccionada >= 0)
        {
            // Se obtiene datos del empleado seleccionado desde la tabla
            int idRol = (int) tablaEmpleados.getValueAt(filaSeleccionada, 2);
            int idPuesto = (int) tablaEmpleados.getValueAt(filaSeleccionada, 1);
            int idSucursal = (int) tablaEmpleados.getValueAt(filaSeleccionada, 3);
            String nombre = (String) tablaEmpleados.getValueAt(filaSeleccionada, 4);
            String apellido = (String) tablaEmpleados.getValueAt(filaSeleccionada, 5);
            String correo = (String) tablaEmpleados.getValueAt(filaSeleccionada, 6);
            String contraseña = (String) tablaEmpleados.getValueAt(filaSeleccionada, 7);
            int salario = (int) tablaEmpleados.getValueAt(filaSeleccionada, 8);
            // Se obtiene descripciones de rol, puesto y sucursal a partir de sus IDs
            List<Rol> listaRoles = rolDAO.Listarrol();
            List<Puesto> listaPuestos = puestoDAO.ListarPuesto();
            List<Sucursal> listaSucursales = sucursalDAO.ListarSucursal();

            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            txtCorreo.setText(correo);
            txtContraseña.setText(contraseña);
            txtSalario.setText(String.valueOf(salario));
            String descripcionRol = RolDAO.obtenerDescripcionRolPorID(idRol, listaRoles);
            String descripcionPuesto = PuestoDAO.obtenerDescripcionPuestoPorID(idPuesto, listaPuestos);
            String descripcionSucursal = SucursalDAO.obtenerDescripcionSucursalPorID(idSucursal, listaSucursales);

            // Actualiza combobox con las descripciones obtenidas
            boxRol.setSelectedItem(descripcionRol);
            boxPuesto.setSelectedItem(descripcionPuesto);
            boxSucursal.setSelectedItem(descripcionSucursal);
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tablaEmpleados.getSelectedRow();
        if (filaSeleccionada >= 0)
        {
            // Obtener el ID del cliente seleccionado en la tabla
            int idEmpleado = Integer.parseInt(tablaEmpleados.getValueAt(filaSeleccionada, 0).toString());

            // Instanciar la clase Cliente_DAO
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();

            // Llamar al método eliminarCliente con el ID del cliente seleccionado
            empleadoDAO.eliminarEmpleado(idEmpleado);

            // Actualizar la tabla después de eliminar el cliente
            // Aquí deberías tener un método para actualizar la tabla con los clientes
            // Si no tienes uno, deberías crearlo o implementarlo según tu estructura
            listar();
            limpiarCampos();
            // Opcionalmente, mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
        } else
        {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un Empleado primero");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();

        JFPrincipal principal = new JFPrincipal();
        principal.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEmpleadosporRangoSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosporRangoSalarioActionPerformed
        // TODO add your handling code here:
        double salarioMinimo = Double.parseDouble(txtSalarioMin.getText());
        double salarioMaximo = Double.parseDouble(txtSalarioMax.getText());

        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        String listaEmpleados = empleadoDAO.listarEmpleadosPorRangoSalario(salarioMinimo, salarioMaximo);
        JOptionPane.showMessageDialog(this, listaEmpleados, "Listar Empleados por Rango de Salario", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEmpleadosporRangoSalarioActionPerformed

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtContraseña.setText("");
        txtSalario.setText("");
    }

    public final void llenarComboBoxRoles() {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        // Obtener lista de roles
        List<Rol> roles = rolDAO.Listarrol();
        // Agregar ítem por defecto al modelo del JComboBox
        comboBoxModel.addElement("Seleccione un Rol");
        // Agregar roles al modelo del JComboBox
        for (Rol rol : roles)
        {
            comboBoxModel.addElement(rol.getDescripcion_Rol());
        }
        // Establecer el modelo en el JComboBox
        boxRol.setModel(comboBoxModel);
    }

    public final void llenarComboBoxPuesto() {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        // Obtener lista de puestos
        List<Puesto> puestos = puestoDAO.ListarPuesto();
        // Agregar ítem por defecto al modelo del JComboBox
        comboBoxModel.addElement("Seleccione un Puesto");
        // Agregar puestos al modelo del JComboBox
        for (Puesto puesto : puestos)
        {
            comboBoxModel.addElement(puesto.getDescripcion_Puesto());
        }
        // Establecer el modelo en el JComboBox
        boxPuesto.setModel(comboBoxModel);
    }

    public final void llenarComboBoxSucursal() {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        // Obtener lista de sucursales
        List<Sucursal> sucursales = sucursalDAO.ListarSucursal();
        // Agregar ítem por defecto al modelo del JComboBox
        comboBoxModel.addElement("Seleccione una Sucursal");

        // Agregar sucursales al modelo del JComboBox
        for (Sucursal sucursal : sucursales)
        {
            comboBoxModel.addElement(sucursal.getNombre_Sucursal());
        }

        // Establecer el modelo en el JComboBox
        boxSucursal.setModel(comboBoxModel);

    }

    public final void listar() {
        /*Llama al método ListarCliente de la clase cliente_DAO para obtener la
        lista de clientes desde la DB.*/
        List<Empleado> lista = empleadoDAO.ListarEmpleado();
        /*Inicializa un nuevo modelo de tabla DefaultTableModel, se 
        utilizará para almacenar los datos de la tabla antes de mostrarlos en la interfaz de usuario*/
        modelo = new DefaultTableModel();
        /*Agregar nombres de columna que coincidan con las columnas de salida 
        del procedimiento aunque se puede hacer directo en tabla*/
        modelo.addColumn("ID_Empleado");
        modelo.addColumn("ID_Puesto");
        modelo.addColumn("ID_Rol");
        modelo.addColumn("ID_Sucursal");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Salario");
        /*Crea un nuevo array de objetos con una longitud de 6 atributosm que se utiliza 
        para almacenar los datos de cada cliente antes de agregarlos al modelo de la tabla*/
        Object[] empleado = new Object[9];
        /*Itera sobre la lista de clientes recuperados de la base de datos*/
        for (int i = 0; i < lista.size(); i++)
        {
            /*Toma los atributos de cada cliente de la lista y los asigna al array client en las posiciones correspondientes*/
            empleado[0] = lista.get(i).getID_Empleado();
            empleado[1] = lista.get(i).getID_Puesto();
            empleado[2] = lista.get(i).getID_Rol();
            empleado[3] = lista.get(i).getID_Sucursal();
            empleado[4] = lista.get(i).getNombre_Empleado();
            empleado[5] = lista.get(i).getApellido();
            empleado[6] = lista.get(i).getCorreo();
            empleado[7] = lista.get(i).getContrasena();
            empleado[8] = lista.get(i).getSalario();
            /*Agrega una fila al modelo de tabla utilizando los datos almacenados en el array client*/
            modelo.addRow(empleado);
        }
        /*Establece el modelo de tabla creado antes como el modelo de datos
        para la tabla tablaClientes,que actualiza la interfaz de usuario para mostrar
        los datos de los clientes en la tabla*/
        tablaEmpleados.setModel(modelo);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxPuesto;
    private javax.swing.JComboBox<String> boxRol;
    private javax.swing.JComboBox<String> boxSucursal;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEmpleadosporRangoSalario;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAcciones;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSalario1;
    private javax.swing.JLabel lblSalario2;
    private javax.swing.JLabel lblSalario3;
    private javax.swing.JLabel lblSalario4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblmenuEmpleados;
    private javax.swing.JLabel lblmenuEmpleados1;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtSalarioMax;
    private javax.swing.JTextField txtSalarioMin;
    // End of variables declaration//GEN-END:variables
}

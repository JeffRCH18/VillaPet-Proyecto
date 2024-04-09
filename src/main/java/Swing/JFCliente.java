package Swing;


import Clases.Cliente;
import Clases.Cliente_DAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFCliente extends javax.swing.JFrame {
    DefaultTableModel modelo;
    Cliente_DAO cliente_DAO = new Cliente_DAO();
    
    public JFCliente() {
        initComponents();
        listar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblmenuClientes = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        lblAcciones = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnRefrescar = new javax.swing.JButton();
        lblimagenclientes = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblDireccion1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuOpcionVolver = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1007, 740));

        lblTitulo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Villa Pet");

        lblmenuClientes.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblmenuClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblmenuClientes.setText("MENÚ CLIENTES");

        lblApellido.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("APELLIDO:");

        lblTelefono.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("TELÉFONO:");

        lblDireccion.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("CORREO:");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
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

        btnActualizar.setBackground(new java.awt.Color(204, 204, 204));
        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 204));
        btnLimpiar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaClientes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaClientes.setForeground(new java.awt.Color(0, 0, 0));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        btnRefrescar.setBackground(new java.awt.Color(204, 204, 204));
        btnRefrescar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(0, 0, 0));
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/refrescar.png"))); // NOI18N
        btnRefrescar.setText("Refrescar");
        btnRefrescar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        lblimagenclientes.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblimagenclientes.setForeground(new java.awt.Color(255, 255, 255));
        lblimagenclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/clientepeq.png"))); // NOI18N

        lblNombre1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre1.setText("NOMBRE:");

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        lblDireccion1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblDireccion1.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion1.setText("DIRECCIÓN:");

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDireccion)
                                            .addComponent(lblDireccion1)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(204, 204, 204)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTelefono)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblNombre1)
                                                .addComponent(lblApellido)))))
                                .addGap(388, 388, 388)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(btnRefrescar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblAcciones)
                                        .addGap(9, 9, 9))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblmenuClientes)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(lblimagenclientes)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(294, 294, 294)
                                        .addComponent(lblTitulo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                            .addComponent(txtApellido)
                                            .addComponent(txtTelefono)
                                            .addComponent(txtDireccion)
                                            .addComponent(txtCorreo))
                                        .addGap(45, 45, 45)))))
                        .addGap(0, 133, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lblAcciones))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblmenuClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblimagenclientes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblTitulo)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnActualizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(29, 29, 29)
                        .addComponent(btnRefrescar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccion)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 6, 920, 740));

        jMenu1.setText("Opciones");

        menuOpcionVolver.setText("Volver");
        menuOpcionVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcionVolverActionPerformed(evt);
            }
        });
        jMenu1.add(menuOpcionVolver);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpcionVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcionVolverActionPerformed

    }//GEN-LAST:event_menuOpcionVolverActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
       
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String direccion = txtDireccion.getText();
        String correo = txtCorreo.getText();
        int telefono = Integer.parseInt(txtTelefono.getText());

        Cliente_DAO clienteDAO = new Cliente_DAO();       

        try {
            clienteDAO.insertarCliente(nombre, apellido, direccion, correo, telefono);
            limpiarCampos();
            listar();
        }catch (NumberFormatException ex) {
            // Manejo de error si el número de teléfono no es válido
            JOptionPane.showMessageDialog(this, "Número de teléfono inválido. Por favor, ingrese un número válido.");
        }
        // Aquí puedes mostrar un mensaje de error al usuario, por ejemplo:
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

       
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();

        // Obtener el índice de la fila seleccionada en la tabla de clientes
        int filaSeleccionada = tablaClientes.getSelectedRow();

        // Verificar si se ha seleccionado una fila válida
        if (filaSeleccionada != -1) {
            // Obtener el ID del cliente de la columna correspondiente en la fila seleccionada
            int idCliente = (int) tablaClientes.getValueAt(filaSeleccionada, 0);

            // Llamar al método para actualizar el cliente en la base de datos
            cliente_DAO.actualizarCliente(idCliente, nombre, apellido, direccion, telefono, correo);

            // Actualizar la tabla de clientes para reflejar los cambios
            listar();
        } else {
            // Mostrar un mensaje de error si no se seleccionó ninguna fila
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un cliente para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
// Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener el ID del cliente seleccionado en la tabla
            int idCliente = Integer.parseInt(tablaClientes.getValueAt(filaSeleccionada, 0).toString());
            
            // Instanciar la clase Cliente_DAO
            Cliente_DAO clienteDAO = new Cliente_DAO();
            
            // Llamar al método eliminarCliente con el ID del cliente seleccionado
            clienteDAO.eliminarCliente(idCliente);
            
            // Actualizar la tabla después de eliminar el cliente
            // Aquí deberías tener un método para actualizar la tabla con los clientes
            // Si no tienes uno, deberías crearlo o implementarlo según tu estructura
            listar();
            limpiarCampos();
            // Opcionalmente, mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un cliente primero");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
        // Obtener los valores de la fila seleccionada
        int idCliente = Integer.parseInt(tablaClientes.getValueAt(filaSeleccionada, 0).toString());
        String nombre = tablaClientes.getValueAt(filaSeleccionada, 1).toString();
        String apellido = tablaClientes.getValueAt(filaSeleccionada, 2).toString();
        String direccion = tablaClientes.getValueAt(filaSeleccionada, 3).toString();
        String telefono = tablaClientes.getValueAt(filaSeleccionada, 4).toString();
        String correo = tablaClientes.getValueAt(filaSeleccionada, 5).toString();
        

        // Rellenar los campos de texto con los valores obtenidos
        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtDireccion.setText(direccion);
        txtCorreo.setText(correo);
        txtTelefono.setText(telefono);
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    public void listar(){
        /*Llama al método ListarCliente de la clase cliente_DAO para obtener la
        lista de clientes desde la DB.*/
        List<Cliente> lista = cliente_DAO.ListarCliente();
        /*Inicializa un nuevo modelo de tabla DefaultTableModel, se 
        utilizará para almacenar los datos de la tabla antes de mostrarlos en la interfaz de usuario*/
        modelo = new DefaultTableModel();
        /*Agregar nombres de columna que coincidan con las columnas de salida 
        del procedimiento aunque se puede hacer directo en tabla*/
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");
        /*Crea un nuevo array de objetos con una longitud de 6 atributosm que se utiliza 
        para almacenar los datos de cada cliente antes de agregarlos al modelo de la tabla*/
        Object[] client = new Object[6];
        /*Itera sobre la lista de clientes recuperados de la base de datos*/
        for(int i = 0; i < lista.size(); i++){
            /*Toma los atributos de cada cliente de la lista y los asigna al array client en las posiciones correspondientes*/
            client[0] = lista.get(i).getID_Cliente();
            client[1] = lista.get(i).getNombre_Cliente();
            client[2] = lista.get(i).getApellido_Cliente();
            client[3] = lista.get(i).getDireccion_Cliente();
            client[4] = lista.get(i).getTelefono_Cliente();
            client[5] = lista.get(i).getCorreo_Cliente();
            /*Agrega una fila al modelo de tabla utilizando los datos almacenados en el array client*/
            modelo.addRow(client);
        }
        /*Establece el modelo de tabla creado antes como el modelo de datos
        para la tabla tablaClientes,que actualiza la interfaz de usuario para mostrar
        los datos de los clientes en la tabla*/
        tablaClientes.setModel(modelo);
}
    
    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAcciones;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccion1;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblimagenclientes;
    private javax.swing.JLabel lblmenuClientes;
    private javax.swing.JMenuItem menuOpcionVolver;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

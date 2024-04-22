package Swing;
import Clases.Categoria;
import Clases.CategoriaDAO;
import Clases.Pago;
import Clases.PagoDAO;
import Clases.Proveedor;
import Clases.ProveedorDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFPago extends javax.swing.JFrame {
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    PagoDAO pagoDAO = new PagoDAO();
    DefaultTableModel modelo;
    public JFPago() {
        initComponents();
        llenarComboBoxProveedor();
        listar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblimagenProductos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblPago = new javax.swing.JLabel();
        lbPagoID = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        lblMontoPago = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        lblAcciones = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPago = new javax.swing.JTable();
        btnRegresar1 = new javax.swing.JButton();
        txtPagosaProveedor = new javax.swing.JTextField();
        btnPagoaProveedor = new javax.swing.JButton();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        txtPagosporPeriodo = new javax.swing.JTextField();
        btnPagosporPeriodo = new javax.swing.JButton();
        boxProveedor = new javax.swing.JComboBox<>();
        lblimagenProveedor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblimagenProductos1 = new javax.swing.JLabel();

        lblimagenProductos.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblimagenProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblimagenProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/productopeq.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        lblTitulo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblTitulo.setText("Villa Pet");

        lblPago.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblPago.setForeground(new java.awt.Color(255, 255, 255));
        lblPago.setText("MENÚ PAGO");

        lbPagoID.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lbPagoID.setForeground(new java.awt.Color(255, 255, 255));
        lbPagoID.setText("ID PROVEEDOR:");

        lblProveedor.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblProveedor.setText("PROVEEDOR:");

        txtProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        lblMontoPago.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblMontoPago.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoPago.setText("MONTO DE PAGO:");

        txtPago.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

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

        btnActualizar.setBackground(new java.awt.Color(153, 153, 153));
        btnActualizar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
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

        btnRefrescar.setBackground(new java.awt.Color(153, 153, 153));
        btnRefrescar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/refrescar.png"))); // NOI18N
        btnRefrescar.setText("Refrescar");
        btnRefrescar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRefrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaPago.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPago);

        btnRegresar1.setBackground(new java.awt.Color(204, 204, 204));
        btnRegresar1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/regresar peq.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        txtPagosaProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnPagoaProveedor.setBackground(new java.awt.Color(204, 204, 204));
        btnPagoaProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/pago peq.png"))); // NOI18N
        btnPagoaProveedor.setText("Pagos al Proveedor");
        btnPagoaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoaProveedorActionPerformed(evt);
            }
        });

        txtFechaInicio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtFechaFin.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtPagosporPeriodo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnPagosporPeriodo.setBackground(new java.awt.Color(204, 204, 204));
        btnPagosporPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/pago periodo peq.png"))); // NOI18N
        btnPagosporPeriodo.setText("Pagos por Periodo");
        btnPagosporPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosporPeriodoActionPerformed(evt);
            }
        });

        boxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblimagenProveedor.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblimagenProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblimagenProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/proveedor peq.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha Final");
        jLabel2.setMaximumSize(new java.awt.Dimension(69, 15));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha Inicio");
        jLabel4.setMaximumSize(new java.awt.Dimension(69, 15));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("  Total de Pagos");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setMaximumSize(new java.awt.Dimension(69, 15));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pagos");
        jLabel6.setMaximumSize(new java.awt.Dimension(69, 15));

        lblimagenProductos1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblimagenProductos1.setForeground(new java.awt.Color(255, 255, 255));
        lblimagenProductos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/productopeq.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(317, 317, 317)
                        .addComponent(lblPago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(42, 42, 42))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMontoPago)
                                    .addComponent(lbPagoID)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblimagenProveedor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblProveedor)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addComponent(lblimagenProductos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAcciones)
                        .addGap(22, 22, 22)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(54, 54, 54))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPagosaProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                            .addGap(111, 111, 111)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPagoaProveedor)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPagosporPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPagosporPeriodo)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPago, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblimagenProductos1)))
                .addGap(21, 21, 21)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPagosaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbPagoID)
                                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblProveedor)
                                        .addComponent(boxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblimagenProveedor))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMontoPago)
                                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnPagoaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPagosporPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPagosporPeriodo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnBuscar)
                                    .addComponent(btnLimpiar)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAcciones)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)
                        .addGap(29, 29, 29)
                        .addComponent(btnActualizar)
                        .addGap(30, 30, 30)
                        .addComponent(btnEliminar)
                        .addGap(29, 29, 29)
                        .addComponent(btnRefrescar)))
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        llenarComboBoxProveedor();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        List<Proveedor> listaProveedor = proveedorDAO.ListarProveedor();
        int monto = Integer.parseInt(txtPago.getText());
        String nombreProveedor = (String) boxProveedor.getSelectedItem(); 
        LocalDate fechaActual = LocalDate.now();
        int idProveedorSeleccionado = ProveedorDAO.obtenerIdPorDescripcionp(nombreProveedor, listaProveedor);
        try {
            pagoDAO.insertarPago(idProveedorSeleccionado, monto, fechaActual);
            limpiarCampos();
            listar();
            llenarComboBoxProveedor();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Por favor, intente de nuevo.");
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        dispose();
        JFPrincipal principal = new JFPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnPagoaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoaProveedorActionPerformed
        // TODO add your handling code here:
        String idProveedorStr = txtProveedor.getText();
        if (!idProveedorStr.isEmpty()) {
            int idProveedor = Integer.parseInt(idProveedorStr);
            PagoDAO pagoDAO = new PagoDAO();
            int totalPagos = pagoDAO.obtenerPagosProveedor(idProveedor);
            txtPagosaProveedor.setText(String.valueOf(totalPagos));
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el ID del proveedor.");
        }
    }//GEN-LAST:event_btnPagoaProveedorActionPerformed

    private void btnPagosporPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosporPeriodoActionPerformed
        // TODO add your handling code here:
        try {
            Date fechaInicio = Date.valueOf(txtFechaInicio.getText());
            Date fechaFin = Date.valueOf(txtFechaFin.getText());

            PagoDAO pagoDAO = new PagoDAO();
            int totalPagos = pagoDAO.obtenerPagosPorPeriodo(fechaInicio, fechaFin);
            txtPagosporPeriodo.setText(String.valueOf(totalPagos));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Ingrese las fechas en formato yyyy-mm-dd", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPagosporPeriodoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tablaPago.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener el ID del cliente seleccionado en la tabla
            int idProducto = Integer.parseInt(tablaPago.getValueAt(filaSeleccionada, 0).toString());
            
            // Llamar al método eliminarCliente con el ID del cliente seleccionado
            pagoDAO.eliminarPago(idProducto);
            listar();
            limpiarCampos();
            llenarComboBoxProveedor();
            // Opcionalmente, mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Pago eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un pago primero");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagoMouseClicked
        //  Obtiene el índice de la fila seleccionada en la tabla
        int filaSeleccionada = tablaPago.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Se obtiene datos del empleado seleccionado desde la tabla
            int pago = (int) tablaPago.getValueAt(filaSeleccionada, 2);
            int idProveedor = (int) tablaPago.getValueAt(filaSeleccionada, 1);
            List<Proveedor> listaProveedor = proveedorDAO.ListarProveedor();

            txtPago.setText(String.valueOf(pago));
            String descripcionProveedor = ProveedorDAO.obtenerDescripcionProveedorPorID(idProveedor, listaProveedor);
            boxProveedor.setSelectedItem(descripcionProveedor);
        }
    }//GEN-LAST:event_tablaPagoMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int filaSeleccionada = tablaPago.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int idPago = (int) tablaPago.getValueAt(filaSeleccionada, 0);
            List<Proveedor> listaProveedor = proveedorDAO.ListarProveedor();
            // Obtener datos modificados del empleado desde los campos de texto y combobox
            int monto = Integer.parseInt(txtPago.getText());
            String nombreProveedor = (String) boxProveedor.getSelectedItem();
            int idProveedor = ProveedorDAO.obtenerIdPorDescripcionp(nombreProveedor, listaProveedor);
            // Llamar al método para actualizar el empleado
            pagoDAO.actualizarPago(idPago, idProveedor, monto);

            // Actualizar la tabla después de la actualización
            JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente");
            listar();
            limpiarCampos();
            llenarComboBoxProveedor();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un empleado primero");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    public final void listar(){
        /*Llama al método ListarCliente de la clase cliente_DAO para obtener la
        lista de clientes desde la DB.*/
        List<Pago> lista = pagoDAO.ListarPago();
        /*Inicializa un nuevo modelo de tabla DefaultTableModel, se 
        utilizará para almacenar los datos de la tabla antes de mostrarlos en la interfaz de usuario*/
        modelo = new DefaultTableModel();
        /*Agregar nombres de columna que coincidan con las columnas de salida 
        del procedimiento aunque se puede hacer directo en tabla*/
        modelo.addColumn("COD_Pago");
        modelo.addColumn("ID_Proveedor");
        modelo.addColumn("Monto");
        modelo.addColumn("Fecha");
        /*Crea un nuevo array de objetos con una longitud de 6 atributosm que se utiliza 
        para almacenar los datos de cada cliente antes de agregarlos al modelo de la tabla*/
        Object[] pago = new Object[4];
        /*Itera sobre la lista de clientes recuperados de la base de datos*/
        for(int i = 0; i < lista.size(); i++){
            /*Toma los atributos de cada cliente de la lista y los asigna al array client en las posiciones correspondientes*/
            pago[0] = lista.get(i).getCod_Pago();
            pago[1] = lista.get(i).getID_Proveedor();
            pago[2] = lista.get(i).getMonto();
            pago[3] = lista.get(i).getFecha();

            /*Agrega una fila al modelo de tabla utilizando los datos almacenados en el array client*/
            modelo.addRow(pago);
        }
        /*Establece el modelo de tabla creado antes como el modelo de datos
        para la tabla tablaClientes,que actualiza la interfaz de usuario para mostrar
        los datos de los clientes en la tabla*/
        tablaPago.setModel(modelo);
    }
    
    public final void llenarComboBoxProveedor() {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        // Obtener lista de puestos
        List<Proveedor> proveedores = proveedorDAO.ListarProveedor();
        // Agregar ítem por defecto al modelo del JComboBox
        comboBoxModel.addElement("Seleccione un Proveedor");
        // Agregar puestos al modelo del JComboBox
        for (Proveedor proveedor : proveedores) {
            comboBoxModel.addElement(proveedor.getNombre_Proveedor());
        }
        // Establecer el modelo en el JComboBox
        boxProveedor.setModel(comboBoxModel);
    }
    
    private void limpiarCampos() {
        txtPago.setText("");
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
            java.util.logging.Logger.getLogger(JFPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(JFPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(JFPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(JFPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxProveedor;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPagoaProveedor;
    private javax.swing.JButton btnPagosporPeriodo;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPagoID;
    private javax.swing.JLabel lblAcciones;
    private javax.swing.JLabel lblMontoPago;
    private javax.swing.JLabel lblPago;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblimagenProductos;
    private javax.swing.JLabel lblimagenProductos1;
    private javax.swing.JLabel lblimagenProveedor;
    private javax.swing.JTable tablaPago;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtPagosaProveedor;
    private javax.swing.JTextField txtPagosporPeriodo;
    private javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables
}

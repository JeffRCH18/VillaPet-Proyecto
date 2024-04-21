package Swing;

import Clases.PuestoDAO;
import Clases.Venta;
import Clases.VentaDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class JFVenta_Lista extends javax.swing.JFrame {
    DefaultTableModel modelo;
    VentaDAO ventaDAO = new VentaDAO();
    public JFVenta_Lista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblPuesto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnPromedioSalarioporPuesto = new javax.swing.JButton();
        lblmenuVentas3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        lblTitulo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Villa Pet");

        lblPuesto.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblPuesto.setForeground(new java.awt.Color(255, 255, 255));
        lblPuesto.setText("LISTA DE VENTAS");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaVenta.setForeground(new java.awt.Color(0, 0, 0));
        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVenta);

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

        btnPromedioSalarioporPuesto.setBackground(new java.awt.Color(204, 204, 204));
        btnPromedioSalarioporPuesto.setForeground(new java.awt.Color(0, 0, 0));
        btnPromedioSalarioporPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/pago peq.png"))); // NOI18N
        btnPromedioSalarioporPuesto.setText("Promedio Salario por Puesto");
        btnPromedioSalarioporPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromedioSalarioporPuestoActionPerformed(evt);
            }
        });

        lblmenuVentas3.setBackground(new java.awt.Color(255, 255, 255));
        lblmenuVentas3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lblmenuVentas3.setForeground(new java.awt.Color(255, 255, 255));
        lblmenuVentas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contents/sucursalpeq.png"))); // NOI18N

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
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(371, 371, 371)
                                .addComponent(lblmenuVentas3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPromedioSalarioporPuesto))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(334, 334, 334)
                                        .addComponent(lblPuesto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                                        .addComponent(lblTitulo)))
                                .addGap(46, 46, 46))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(lblPuesto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblmenuVentas3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnPromedioSalarioporPuesto)
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();

        JFPrincipal principal = new JFPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnPromedioSalarioporPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromedioSalarioporPuestoActionPerformed
        // TODO add your handling code here:
        PuestoDAO puestoDAO = new PuestoDAO();
        String listaPromediosSalarios = puestoDAO.promedioSalarioPorPuesto();
        JOptionPane.showMessageDialog(this, listaPromediosSalarios, "Promedio de Salario por Puesto", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnPromedioSalarioporPuestoActionPerformed

    public void listar(){
        /*Llama al método ListarCliente de la clase cliente_DAO para obtener la
        lista de clientes desde la DB.*/
        List<Venta> lista = ventaDAO.ListarVenta();
        /*Inicializa un nuevo modelo de tabla DefaultTableModel, se 
        utilizará para almacenar los datos de la tabla antes de mostrarlos en la interfaz de usuario*/
        modelo = new DefaultTableModel();
        /*Agregar nombres de columna que coincidan con las columnas de salida 
        del procedimiento aunque se puede hacer directo en tabla*/
        modelo.addColumn("ID_Venta");
        modelo.addColumn("ID_Cliente");
        modelo.addColumn("ID_Sucursal");
        modelo.addColumn("Monto Total");
        modelo.addColumn("Fecha");
        /*Crea un nuevo array de objetos con una longitud de 6 atributosm que se utiliza 
        para almacenar los datos de cada cliente antes de agregarlos al modelo de la tabla*/
        Object[] venta = new Object[5];
        /*Itera sobre la lista de clientes recuperados de la base de datos*/
        for(int i = 0; i < lista.size(); i++){
            /*Toma los atributos de cada cliente de la lista y los asigna al array client en las posiciones correspondientes*/
            venta [0] = lista.get(i).getNum_Factura();
            venta [1] = lista.get(i).getID_Cliente();
            venta [2] = lista.get(i).getID_Sucursal();
            venta [3] = lista.get(i).getMonto_Venta();
            venta [4] = lista.get(i).getFecha();

            /*Agrega una fila al modelo de tabla utilizando los datos almacenados en el array client*/
            modelo.addRow(venta);
        }
        /*Establece el modelo de tabla creado antes como el modelo de datos
        para la tabla tablaClientes,que actualiza la interfaz de usuario para mostrar
        los datos de los clientes en la tabla*/
        tablaVenta.setModel(modelo);
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
            java.util.logging.Logger.getLogger(JFVenta_Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(JFVenta_Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(JFVenta_Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(JFVenta_Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVenta_Lista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromedioSalarioporPuesto;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblmenuVentas3;
    private javax.swing.JTable tablaVenta;
    // End of variables declaration//GEN-END:variables
}

package interfaz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Consulta_BD_RH extends javax.swing.JFrame {

    public Consulta_BD_RH() {
        initComponents();
          this.setLocationRelativeTo(null);
          
         try{
            DefaultTableModel modelo = new DefaultTableModel();
            tabla1.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet resultado1 = null; 
            Conexion conn = new Conexion();
            Connection con =conn.getConexion();

            String buscar = caja1.getText();
            
            String sql = "SELECT Numero_de_Empleado, Nombre, Apellidos, Fecha_de_Nacimiento, CURP, RFC, Sueldo_bruto, Puesto, Sucursal, Fecha_de_Ingreso FROM personal "; 

            ps = con.prepareStatement(sql);
            resultado1=ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData)resultado1.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Numero_Empleado");
            modelo.addColumn("Nombre"); 
            modelo.addColumn("Apellido");
            modelo.addColumn("Fecha_de_Nacimiento");
            modelo.addColumn("CURP");
            modelo.addColumn("RFC");
            modelo.addColumn("Sueldo bruto");
            modelo.addColumn("Puesto");
            modelo.addColumn("Sucursal");
            modelo.addColumn("Fecha de Ingreso");


            while(resultado1.next()){
                    Object[]  filas = new Object[cantidadColumnas];
                    for(int i=0; i<cantidadColumnas; i++){
                    filas[i] = resultado1.getObject(i+1);
                }
                    modelo.addRow(filas);

                }




            }catch(SQLException error){
             System.out.println("Error3");
             System.err.println(error.toString());
            }

        
        
        
          
          
          
          
          
          
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        caja1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Consulta Base de datos Personal");

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de empleado", "Nombre", "Apellido", "Fecha de Nacimiento", "CURP", "RFC", "Sueldo Bruto", "Puesto", "Sucursal", "Fecha de Ingreso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla1);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Por favor ingrese el nombre de la persona que desea buscar: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(caja1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caja1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // Ejecución Botón Buscar
       DefaultTableModel modelo = new DefaultTableModel();
       tabla1.setModel(modelo);
       
       try{
            PreparedStatement ps = null;
            ResultSet resultado1 = null; 
            Conexion conn = new Conexion();
            Connection con =conn.getConexion();
            ps=con.prepareStatement("SELECT Numero_de_Empleado, Nombre, Apellidos, Fecha_de_Nacimiento, CURP, RFC, Sueldo_bruto, Puesto, Sucursal, Fecha_de_Ingreso FROM personal WHERE Nombre = ?");
            ps.setString(1, caja1.getText());
            resultado1=ps.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData)resultado1.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            if(resultado1.next()){
                
                
                
                modelo.addColumn("Numero_Empleado");
                modelo.addColumn("Nombre"); 
                modelo.addColumn("Apellido");
                modelo.addColumn("Fecha_de_Nacimiento");
                modelo.addColumn("CURP");
                modelo.addColumn("RFC");
                modelo.addColumn("Sueldo bruto");
                modelo.addColumn("Puesto");
                modelo.addColumn("Sucursal");
                modelo.addColumn("Fecha de Ingreso");
                resultado1=ps.executeQuery();


            while(resultado1.next()){
                    Object[]  filas = new Object[cantidadColumnas];
                    for(int i=0; i<cantidadColumnas; i++){
                    filas[i] = resultado1.getObject(i+1);
                }
                    modelo.addRow(filas);

                }

                
                
                
                
                
                
                
                
                
                
                
            }
            
            
       }catch(SQLException error){
             System.out.println("Error3");
             System.err.println(error.toString());
            }

      
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_BD_RH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField caja1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}

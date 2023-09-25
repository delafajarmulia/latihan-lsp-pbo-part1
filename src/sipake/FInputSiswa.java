

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sipake;
import javax.swing.*; 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Siswa
 */
public class FInputSiswa extends javax.swing.JFrame {
        
    /**
     * Creates new form FInputSiswa
     */
    static final DateFormat MYSQL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private DefaultTableModel siswa;
    Connection con;
    Koneksi getCon = new Koneksi();
    ResultSet res;
    Statement stm;
    String sql, nis;
    
    public FInputSiswa() {
        initComponents();
        
        loadData();
    }
    
    private void loadData(){
        siswa = new DefaultTableModel();
        table_siswa.setModel(siswa);
        siswa.addColumn("NIS");
        siswa.addColumn("Nama");
        siswa.addColumn("Tempat Lahir");
        siswa.addColumn("Tanggal Lahir");
        siswa.addColumn("Jenis Kelamin");
        
        try {
            tampilData(); //Logger.getLogger(FInputSiswa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FInputSiswa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FInputSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clear(){
        txt_nis.setText("");
        txt_nama.setText("");
        txt_tempat.setText("");
        
        // untuk set tanggal saat ini
        date_lahir.setDate(new Date());
        
        // untuk set default data in cmb
        cmb_jk.setSelectedItem("Laki-laki");
    }
    
    private void tampilData() throws SQLException, ClassNotFoundException{
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        siswa.getDataVector().removeAllElements();
        siswa.fireTableDataChanged();
        
        try{
            stm = (Statement) Koneksi.getKoneksiDB().createStatement();
            sql = "SELECT * FROM siswa";
            
            res = stm.executeQuery(sql);
            
            while(res.next()){
                Object[] data = new Object[5];
                data[0] = res.getString("nis");
                data[1] = res.getString("nama_siswa");
                data[2] = res.getString("tempat_lahir");
                data[3] = res.getString("tanggal_lahir");
                data[4] = res.getString("jenis_kelamin");
                siswa.addRow(data);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error data " + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        txt_nis = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_tempat = new javax.swing.JTextField();
        cmb_jk = new javax.swing.JComboBox<>();
        btn_add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_siswa = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        date_lahir = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("FORM DATA SISWA");

        jLabel2.setText("NIS");

        jLabel3.setText("Nama");

        jLabel4.setText("Tempat Lahir");

        jLabel5.setText("Tanggal Lahir");

        jLabel6.setText("Jenis Kelamin");

        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_edit.setText("EDIT");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        cmb_jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        table_siswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIS", "Nama", "Tempat Lahir", "Tanggal Lahir", "Jenis Kelamin"
            }
        ));
        table_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_siswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_siswa);

        jLabel7.setText("cari data");

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(btn_simpan)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(32, 32, 32)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(date_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_nis)
                                                .addComponent(txt_nama)
                                                .addComponent(txt_tempat)
                                                .addComponent(cmb_jk, 0, 192, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cari)))))
                        .addGap(5, 5, 5)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txt_nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_tempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(date_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(cmb_jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_simpan)
                            .addComponent(btn_add)
                            .addComponent(btn_edit)
                            .addComponent(btn_hapus))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7))
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed

        String newNIS = txt_nis.getText();
        String nama = txt_nama.getText();
        String tempat = txt_tempat.getText();
        String tanggal = MYSQL_DATE_FORMAT.format(date_lahir.getDate());
        String jk = cmb_jk.getSelectedItem().toString();
        
        try{
            con = null;
            con = getCon.getKoneksiDB();
            
            sql = "UPDATE siswa SET nis='"+newNIS+"', "
                    + "nama_siswa='"+nama+"',"
                    + "tempat_lahir='"+tempat+"',"
                    + "tanggal_lahir='"+tanggal+"',"
                    + "jenis_kelamin='"+jk+"'"
                    + " WHERE nis='"+nis+"'";
            
            stm = con.createStatement();
            stm.executeUpdate(sql);
            
            loadData();
            JOptionPane.showMessageDialog(this, "Data berhasil di ubah");
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        String nis = txt_nis.getText();
        String nama = txt_nama.getText();
        String tempat = txt_tempat.getText();
        String tanggal = MYSQL_DATE_FORMAT.format(date_lahir.getDate());
        String jk = cmb_jk.getSelectedItem().toString();
        
        try{
            con = getCon.getKoneksiDB();
            sql = "INSERT INTO siswa(nis, nama_siswa, tempat_lahir, tanggal_lahir, jenis_kelamin) VALUES('"+nis+"','"+nama+"','"+tempat+"','"+tanggal+"','"+jk+"')";
            
            stm = con.createStatement();
            stm.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan data");
            loadData();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FInputSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_addActionPerformed

    private void table_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_siswaMouseClicked
        int number = table_siswa.getSelectedRow();
            
        txt_nis.setText(table_siswa.getValueAt(number, 0).toString());
        txt_nama.setText(table_siswa.getValueAt(number, 1).toString());
        txt_tempat.setText(table_siswa.getValueAt(number,2).toString());
        
        String tanggal = table_siswa.getValueAt(number, 3).toString();
        try {
            date_lahir.setDate(MYSQL_DATE_FORMAT.parse(tanggal));
        } catch (ParseException ex) {
            Logger.getLogger(FInputSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cmb_jk.setSelectedItem(table_siswa.getValueAt(number, 4));
        
        nis = txt_nis.getText();
        //System.out.print(nis);
    }//GEN-LAST:event_table_siswaMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        var jawab = JOptionPane.showConfirmDialog(this, "Yakin akan menghapus siswa dengan NIS " + nis +"?", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            try{
                con = null;
                con = getCon.getKoneksiDB();
                sql = "DELETE FROM siswa WHERE nis='"+nis+"'";
                
                stm = con.createStatement();
                stm.executeUpdate(sql);
                clear();
                loadData();
                
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, "Ada kesalahan input", "Konfirmasi", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btn_hapusActionPerformed

    private void cariData(String key){
        try{
            con = null;
            con = getCon.getKoneksiDB();
            
            sql = "SELECT * FROM siswa WHERE nama_siswa LIKE '%"+key+"%'";
            siswa.getDataVector().removeAllElements();
            
            stm = con.createStatement();
            res = stm.executeQuery(sql);
            
            while(res.next()){
                Object[] data = {
                    res.getString("nis"),
                    res.getString("nama_siswa"),
                    res.getString("tempat_lahir"),
                    res.getString("tanggal_lahir"),
                    res.getString("jenis_kelamin")
                };
                siswa.addRow(data);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
        // TODO add your handling code here:
        String key = txt_cari.getText();
        cariData(key);
    }//GEN-LAST:event_txt_cariKeyPressed

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
            java.util.logging.Logger.getLogger(FInputSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FInputSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FInputSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FInputSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FInputSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> cmb_jk;
    private com.toedter.calendar.JDateChooser date_lahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_siswa;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nis;
    private javax.swing.JTextField txt_tempat;
    // End of variables declaration//GEN-END:variables

    
}

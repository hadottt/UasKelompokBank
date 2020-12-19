package bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import sql.koneksi;


public class cicilan extends javax.swing.JPanel {
    private Vector<Vector<String>> db = new Vector();
    private Vector<Vector<String>> db1 = new Vector();


    private Connection con;
    private koneksi K = new koneksi();
    public cicilan() {
        initComponents();
        con = K.getCon();
        bacaData();
        date();
    }

    private void bacaData() {
        db.removeAll(db);
        try {
            Connection c = K.getCon();
            Statement s = c.createStatement();
            String sql = "Select * from saldo";
            ResultSet r = s.executeQuery(sql);
            String tem;
            while (r.next()) {
                Object[] o = new Object[3];
                o[0] = r.getString("no_rek");
                o[1] = r.getString("nama");
                o[2] = r.getString("jml_saldo");
                Vector<String> tmp2 = new Vector();
                tmp2.add((String) o[0]);
                tmp2.add((String) o[1]);
                tmp2.add((String) o[2]);
                db.add(tmp2);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void baca() {
        db1.removeAll(db1);
        try {
            Connection c = K.getCon();
            Statement s = c.createStatement();
            String sql = "Select * from tagihan";
            ResultSet r = s.executeQuery(sql);
            String tem;
            while (r.next()) {
                Object[] o = new Object[3];
                o[0] = r.getString("id_pel");
                o[1] = r.getString("nama");
                o[2] = r.getString("jml_tag");
                Vector<String> tmp2 = new Vector();
                tmp2.add((String) o[0]);
                tmp2.add((String) o[1]);
                tmp2.add((String) o[2]);
                db1.add(tmp2);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        lblnama.setText("Nama Tertanda");
        txtnom.setText("");

    }

    public void date() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat contoh4 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String Tanggal = contoh4.format(cal.getTime());
        tgl.setText(Tanggal);
    }
    public void pesancicil() {
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gatot!!!");
        }
        JOptionPane.showMessageDialog(null, "Sukses!!!");
    }

    public void Cicilan() {
        pesancicil();
        String norek = txtnorek.getText();
        String saldo = lblsaldo.getText();
        String nom = txtnom.getText();
        String tg = tgl.getText();
        String nama = lblnama.getText();
        String ket = "bayar cicilan";
        String status = "K";
        String rek = "kosong";

        int upsaldo = Integer.parseInt(lblsaldo.getText()) - Integer.parseInt(txtnom.getText());
        String us = "" + upsaldo;

        if (Integer.parseInt(lblsaldo.getText()) > Integer.parseInt(txtnom.getText())) {
            try {
                Connection con = K.getCon();
                Statement stat = con.createStatement();
                try {
                    String sql = "INSERT INTO transaksi VALUES('"+tg+"','"+norek+"','"+nama+"','"+ rek+"','"+ status+"','"+ ket+"','"+nom+"','"+saldo+"');";
                    String sql1 = "UPDATE `saldo` SET `jml_saldo` = '" + us + "' WHERE `no_rek` = '" + txtnorek.getText() + "';";
                    stat.execute(sql);
                    stat.execute(sql1);
                    stat.close();

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } catch (SQLException ex) {
            }
            lblsaldo.setText(".....................................");
        }else{
            JOptionPane.showMessageDialog(null, "Jumlah Saldo Anda Kurang!!!");
            txtnom.setText("");
        }
        bacaData();
        baca();
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblsaldo = new javax.swing.JLabel();
        txtnorek = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtkontrak = new javax.swing.JTextField();
        lblnama = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnom = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox();

        jPanel1.setBackground(new java.awt.Color(64, 227, 245, 255));

        jPanel2.setBackground(new java.awt.Color(64, 227, 245, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Pembayaran Cicilan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)

                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()

                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addContainerGap())
        );

        tgl.setText("Tanggal");

        jLabel3.setText("No Rek");

        jLabel4.setText("Saldo");

        lblsaldo.setText("...............................................");

        jButton1.setText("Cek");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cek");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtkontrak.setEditable(false);

        lblnama.setText("Atas Nama");

        jLabel6.setText("No Kontrak");

        jLabel9.setText("Nama Kontrak");

        jLabel7.setText("Tagihan");

        txtnom.setText("..............................................");

        jButton3.setText("Bayar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Jenis Pembayaran");

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih Jenis -", "visa", "uob", "MC" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(

                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel9))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(181, 181, 181)
                                                                .addComponent(jButton2))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtnom)
                                                                        .addComponent(lblnama)))))

                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3))
                                        .addComponent(tgl)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtnorek, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(28, 28, 28)
                                                .addComponent(lblsaldo))
                                        .addGroup(jPanel1Layout.createSequentialGroup()

                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtkontrak, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tgl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtnorek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(lblsaldo))

                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)

                                                        .addComponent(lblnama))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)


                                                        .addComponent(txtnom)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton2)
                                                .addComponent(txtkontrak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(jButton3)
                                .addGap(0, 72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        bacaData();
        for (int i = 0; i < db.size(); i++) {
            if (txtnorek.getText().equals(db.get(i).get(0))) {
                System.out.print("ada");
                lblsaldo.setText(db.get(i).get(2));
                break;
            } else {
                lblsaldo.setText("NoRek Salah");
            }
        }
        System.out.println(lblsaldo.getText());
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        baca();
        for (int i = 0; i < db1.size(); i++) {
            if (txtkontrak.getText().equals(db1.get(i).get(0))) {
                System.out.print("ada");
                lblnama.setText(db1.get(i).get(1));
                txtnom.setText(db1.get(i).get(2));
                break;
            } else {
                txtnom.setText("No Kontrak Salah");
            }
        }
        System.out.println(txtnom.getText());
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Cicilan();
    }

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(combo.getSelectedItem().equals("visa")){
            txtkontrak.setEditable(true);
        }
        else if(combo.getSelectedItem().equals("uob")){
            txtkontrak.setEditable(true);
        }
        else if(combo.getSelectedItem().equals("MC")){
            txtkontrak.setEditable(true);
        }

    }



    private javax.swing.JComboBox combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblnama;
    private javax.swing.JLabel lblsaldo;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField txtkontrak;
    private javax.swing.JLabel txtnom;
    private javax.swing.JTextField txtnorek;



}

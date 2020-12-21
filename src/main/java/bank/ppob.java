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


public class ppob extends javax.swing.JPanel {
    private Vector<Vector<String>> db = new Vector();
    private Vector<Vector<String>> db1 = new Vector();


    private Connection con;
    private koneksi K = new koneksi();
    public ppob() {
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

    public void pesantag() {

        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Bayar");
        }
        JOptionPane.showMessageDialog(null, "Sukses bayar tagihan");
    }

    public void Tagihan() {

        pesantag();
        String norek = txtnorek.getText();
        String saldo = lblsaldo.getText();
        String nom = txtnom.getText();
        String tg = tgl.getText();
        String nama = lblnama.getText();
        String ket = "bayar listrik";
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
            JOptionPane.showMessageDialog(null, "Saldo anda kurang");
            txtnom.setText("");
        }

        bacaData();

        baca();
    }




    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnorek = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblsaldo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtnom = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblnama = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(64, 227, 245, 255));

        jPanel2.setBackground(new java.awt.Color(64, 227, 245, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tgl.setText("Tanggal");

        jLabel3.setText("No Rek");

        jButton1.setText("Cek");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Saldo");

        lblsaldo.setText("...............................................");

        jLabel6.setText("ID Pel");

        jButton2.setText("Cek");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Tagihan");

        txtnom.setText("..............................................");

        jLabel9.setText("Nama Pel");

        lblnama.setText("Atas Nama");

        jButton3.setText("Bayar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 20));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Bayar Tagihan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel11)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);


        jPanel1Layout.setHorizontalGroup(

                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)

                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                        .addComponent(tgl)

                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)

                                                .addGap(18, 18, 18)
                                                .addComponent(txtnorek, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1))

                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)

                                                        .addComponent(jLabel4)

                                                        .addComponent(jLabel9))

                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblnama)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jButton2))
                                                        .addComponent(lblsaldo)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton3)

                                                        .addComponent(txtnom))))

                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()

                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
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
                                .addGap(27, 27, 27)

                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton2))
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(lblnama))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)

                                        .addComponent(txtnom))
                                .addGap(31, 31, 31)


                                .addComponent(jButton3)

                                .addGap(0, 49, Short.MAX_VALUE))

        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                lblsaldo.setText("No Rekening Salah");
            }
        }
        System.out.println(lblsaldo.getText());
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        baca();
        for (int i = 0; i < db1.size(); i++) {

            if (txtid.getText().equals(db1.get(i).get(0))) {
                System.out.print("ada");
                lblnama.setText(db1.get(i).get(1));
                txtnom.setText(db1.get(i).get(2));
                break;
            } else {

                txtnom.setText("ID Pelanggan Salah");
            }
        }
        System.out.println(txtnom.getText());
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Tagihan();
    }



    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txtid;
    private javax.swing.JLabel txtnom;
    private javax.swing.JTextField txtnorek;




}

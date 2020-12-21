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


public class tarik extends javax.swing.JPanel {

    private Vector<Vector<String>> db = new Vector();
    private Vector<Vector<String>> db1 = new Vector();



    private Connection con;
    private koneksi K = new koneksi();
    public tarik() {
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
                Object[] o = new Object[5];
                o[0] = r.getString("nama");
                o[1] = r.getString("no_rek");
                o[2] = r.getString("jml_saldo");
                Vector<String> tmp2 = new Vector();

                tmp2.add((String) o[0]);
                tmp2.add((String) o[1]);
                tmp2.add((String) o[2]);

                db.add(tmp2);
            }
            r.close();

            s.close();
        } catch (Exception e)
        {

            System.out.println(e.getMessage());
        }

    }

    public void date() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat contoh4 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String Tanggal = contoh4.format(cal.getTime());
        tgl.setText(Tanggal);
    }

    public void Tarik() {
        pesantarik();

        String norek = txtnorek.getText();
        String saldo = lblsaldo.getText();
        String nom = txtnom.getText();
        String tg = tgl.getText();
        String nama = lblnama.getText();
        String ket = "tarik";
        String status = "K";
        String rek = " - ";


        int upsaldo = Integer.parseInt(lblsaldo.getText()) - Integer.parseInt(txtnom.getText());

        String us = "" + upsaldo;

        if (Integer.parseInt(lblsaldo.getText()) > Integer.parseInt(txtnom.getText())) {
            try {
                Connection con = K.getCon();
                Statement stat = con.createStatement();

                try {
                    String sql = "INSERT INTO transaksi VALUES('"+tg+"','"+norek+"','"+nama+"','"+rek+"','"+ status+"','"+ ket+"','"+nom+"','"+saldo+"');";
                    String sql1 = "UPDATE `saldo` SET `jml_saldo` = '" + us + "' WHERE `no_rek` = '" + txtnorek.getText() + "';";
                    stat.execute(sql);
                    stat.execute(sql1);
                    stat.close();
                } catch (SQLException ex)

                {
                    System.out.println(ex);
                }
            } catch (SQLException ex) {
            }
            lblnama.setText("Nama Tertanda");
            txtnom.setText("");
            lblsaldo.setText(".....................................");
        }else{

            JOptionPane.showMessageDialog(null, "Saldo Anda Kurang!");

            txtnom.setText("");
        }

        bacaData();

    }


    public void pesantarik() {
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Tarik TUNAI");
        }
        JOptionPane.showMessageDialog(null, "SUKSES TARIK TUNAI");
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnorek = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblsaldo = new javax.swing.JLabel();
        lblnama = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();


        jPanel1.setBackground(new java.awt.Color(64, 227, 245, 255));


        jPanel2.setBackground(new java.awt.Color(64, 227, 245, 255));


        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);




        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(

                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(

                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 20));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tarik Tunai");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(8, 8, 8))
        );

        tgl.setText("Tanggal");

        jLabel4.setText("No Rek");

        jButton1.setText("Cek");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblsaldo.setText(".......................................................");

        lblnama.setText("Nama Tertanda");

        jLabel5.setText("Saldo Awal");

        jLabel7.setText("Atas Nama");

        jLabel9.setText("Nominal");

        jButton2.setText("Proses");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()

                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tgl)

                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel9))

                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblnama)
                                                        .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)

                                                        .addComponent(jLabel4))

                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblsaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtnorek, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1)))

                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(

                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()


                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)

                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)

                                .addComponent(tgl)

                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtnorek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(lblsaldo))
                                .addGap(18, 18, 18)

                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)

                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(lblnama))
                                .addGap(34, 34, 34)

                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(39, Short.MAX_VALUE))
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
            if (txtnorek.getText().equals(db.get(i).get(1))) {
                System.out.print("ADA");
                lblsaldo.setText(db.get(i).get(2));
                lblnama.setText(db.get(i).get(0));
                break;
            } else {
                lblsaldo.setText("NoReK Salah");
            }
        }
        System.out.println(lblsaldo.getText());
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Tarik();
    }



    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblnama;
    private javax.swing.JLabel lblsaldo;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnorek;


}

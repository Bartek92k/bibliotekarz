package gui2;

// @author bartek
import static gui2.Studenci.aktualizuj;
//import static gui2.Studenci.dodaj;
import static gui2.Studenci.tabelka;
import static gui2.Studenci.wyswietlDane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class RamkaDodajOsobe extends javax.swing.JFrame {

    public RamkaDodajOsobe() {

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imie = new javax.swing.JTextField();
        nazwisko = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        LImie = new javax.swing.JLabel();
        LNazwisko = new javax.swing.JLabel();
        LEmail = new javax.swing.JLabel();
        LTelefon = new javax.swing.JLabel();
        telefon = new javax.swing.JTextField();
        BDodaj = new javax.swing.JButton();
        BWyczysc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Miejscowosc = new javax.swing.JTextField();
        KodPocztowy = new javax.swing.JTextField();
        Ulica = new javax.swing.JTextField();
        NrDomu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(750, 0, 0, 0));

        imie.setToolTipText("Imie");

        nazwisko.setToolTipText("nazwisko");

        email.setToolTipText("e-mail");

        LImie.setText("Imie");

        LNazwisko.setText("Nazwisko");

        LEmail.setText("E-mail");

        LTelefon.setText("Telefon");

        telefon.setToolTipText("telefon");

        BDodaj.setText("Dodaj");
        BDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDodajActionPerformed(evt);
            }
        });

        BWyczysc.setText("Wyczyść");
        BWyczysc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BWyczyscActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel1.setText("Dodaj czytelnika");

        jLabel2.setText("Miejscowosc");

        jLabel3.setText("Kod Pocztowy");

        jLabel4.setText("Ulica");

        jLabel5.setText("Nr domu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LNazwisko)
                            .addComponent(LEmail)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LImie)
                                        .addGap(34, 34, 34)
                                        .addComponent(BWyczysc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(LTelefon)
                                                .addGap(18, 18, 18)
                                                .addComponent(telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(imie, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(115, 115, 115)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)))))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Ulica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(KodPocztowy, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Miejscowosc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NrDomu)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LImie)
                    .addComponent(jLabel2)
                    .addComponent(Miejscowosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNazwisko)
                    .addComponent(jLabel3)
                    .addComponent(KodPocztowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LEmail)
                    .addComponent(jLabel4)
                    .addComponent(Ulica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NrDomu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LTelefon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BWyczysc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BWyczyscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BWyczyscActionPerformed
        imie.setText("");
        nazwisko.setText("");
        email.setText("");
        telefon.setText("");
        Miejscowosc.setText("");
        KodPocztowy.setText("");
        Ulica.setText("");
        NrDomu.setText("");
    }//GEN-LAST:event_BWyczyscActionPerformed

    private void BDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDodajActionPerformed

        String kom1 = telefon.getText();
        int kom = Integer.parseInt(kom1);
        String nrdomu1 = NrDomu.getText();
        int nrDomu = Integer.parseInt(nrdomu1);

//        String plec1 = (String) plec.getSelectedItem();
//        dodaj(imie.getText(),
//                nazwisko.getText(),
//                email.getText(),
//                plec1,
//                kom,
//                Miejscowosc.getText(),
//                KodPocztowy.getText(),
//                Ulica.getText(),
//                nrDomu);

        wyswietlDane();
        setVisible(false);
        tabelka();

    }                   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-LAST:event_BDodajActionPerformed
                       
//------------------------------------------------------------------------------------------------

    public static void setImie(String i) {
        // System.out.println(i);
        imie.setText(i);
    }

    public static void setNazwisko(String n) {
        nazwisko.setText(n);
    }

    public static void setEmail(String e) {
        email.setText(e);
    }
//public void setPlec(String p){
    //  plec.setText(p);
//}

    public static void setMiejscowosc(String m) {
        Miejscowosc.setText(m);
    }

    public static void setTelefon(int t) {
        String t1 = "" + t;
        telefon.setText(t1);
    }

    public static void setKodPocztowy(String kp) {
        KodPocztowy.setText(kp);
    }

    public static void setUlica(String u) {
        Ulica.setText(u);
    }

    public static void setNrDomu(int nd) {
        NrDomu.setText(Integer.toString(nd));
    }

    public static String getKodPocztowy() {
        return KodPocztowy.getText();
    }

    public static String getMiejscowosc() {
        return Miejscowosc.getText();
    }

    public static String getNrDomu() {
        return NrDomu.getText();

    }

    public static String getUlica() {
        return Ulica.getText();
    }

    public static String getEmail() {
        return email.getText();
    }

    public static String getImie() {
        return imie.getText();
    }

    public static String getNazwisko() {
        return nazwisko.getText();
    }

    public static int getTelefon() {
        String kom1 = telefon.getText();
        int kom = Integer.parseInt(kom1);
        System.out.println(kom);
        return kom;

    }

//    public static String getPlec() {
//        String plec1 = (String) plec.getSelectedItem();
//        return plec1;
//    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        System.out.println(imie);//nazwisko,email,telefon,Miejscowosc,KodPocztowy,Ulica,NrDomu);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RamkaDodajOsobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RamkaDodajOsobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RamkaDodajOsobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RamkaDodajOsobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BDodaj;
    private javax.swing.JButton BWyczysc;
    protected static javax.swing.JTextField KodPocztowy;
    private javax.swing.JLabel LEmail;
    private javax.swing.JLabel LImie;
    private javax.swing.JLabel LNazwisko;
    private javax.swing.JLabel LTelefon;
    protected static javax.swing.JTextField Miejscowosc;
    protected static javax.swing.JTextField NrDomu;
    protected static javax.swing.JTextField Ulica;
    protected static javax.swing.JTextField email;
    protected static javax.swing.JTextField imie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    protected static javax.swing.JTextField nazwisko;
    protected static javax.swing.JTextField telefon;
    // End of variables declaration//GEN-END:variables
}

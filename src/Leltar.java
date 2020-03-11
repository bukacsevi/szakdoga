
import java.awt.Frame;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import newpackage.DbKapcsolat;
import newpackage.Raktár;
import newpackage.Termék;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kicsi
 */
public class Leltar extends javax.swing.JDialog {

    DbKapcsolat db;
    private Raktár kijeloltRaktar = null;
    private int kijeloltRaktarId = 0;
    private Vector<Termék> termekek;

    public Leltar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        db = ((frame) parent).getDbKapcsolat();
        raktarLista.setModel(new DefaultComboBoxModel(db.getRaktarak()));
        szoveg.setText("Leltár:\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        raktarLista = new javax.swing.JComboBox();
        termekLista = new javax.swing.JComboBox();
        darab = new javax.swing.JTextField();
        rogzitGomb = new javax.swing.JButton();
        raktarValasztGomb = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        szoveg = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rogzitGomb.setText("Rögzít");
        rogzitGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rogzitGombActionPerformed(evt);
            }
        });

        raktarValasztGomb.setText("jButton2");
        raktarValasztGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raktarValasztGombActionPerformed(evt);
            }
        });

        szoveg.setColumns(20);
        szoveg.setRows(5);
        jScrollPane1.setViewportView(szoveg);

        jButton1.setText("Mentés");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(rogzitGomb)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(raktarLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(termekLista, 0, 169, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(darab, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(raktarValasztGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raktarLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raktarValasztGomb))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(termekLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(darab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(rogzitGomb)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void raktarValasztGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raktarValasztGombActionPerformed
        kijeloltRaktar = (Raktár) raktarLista.getSelectedItem();
        kijeloltRaktarId = kijeloltRaktar.getRaktarId();

        //raktarban levő termek lista szűrése
        db.raktarTermekLista(kijeloltRaktarId);
        termekek = db.getTermekekAdottRaktarban();
        termekLista.setModel(new DefaultComboBoxModel(termekek));
        szoveg.append(kijeloltRaktar.getRaktarNev()+"\n");
    }//GEN-LAST:event_raktarValasztGombActionPerformed

    private void rogzitGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rogzitGombActionPerformed
        int leltarDb = Integer.parseInt(darab.getText());
        Termék termek = (Termék) termekLista.getSelectedItem();
        int raktarbanDarab = db.lekerdezesLeltar(kijeloltRaktarId, termek.getMegnevezes(), termek.getCikkszam());

        if (leltarDb == raktarbanDarab) {
            szoveg.append(termek.getCikkszam() + " " + termek.getMegnevezes() + " rögzítve:  " + leltarDb + " darab\n");
            termekek.remove(termek);
            termekLista.setModel(new DefaultComboBoxModel(termekek));
        } else {
            LeltarElteres elteres = new LeltarElteres((Frame) this.getParent(), true,leltarDb-raktarbanDarab);
            
            elteres.setVisible(true);
            if (elteres.rogzit()) {
                szoveg.append(termek.getCikkszam() + " " + termek.getMegnevezes() + " rögzítve:  " + leltarDb + " darab     Eltérés: " +(leltarDb-raktarbanDarab)+"\n");
                termekek.remove(termek);
                termekLista.setModel(new DefaultComboBoxModel(termekek));
            }
            
        }
    }//GEN-LAST:event_rogzitGombActionPerformed

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
            java.util.logging.Logger.getLogger(Leltar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leltar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leltar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leltar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Leltar dialog = new Leltar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField darab;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox raktarLista;
    private javax.swing.JButton raktarValasztGomb;
    private javax.swing.JButton rogzitGomb;
    private javax.swing.JTextArea szoveg;
    private javax.swing.JComboBox termekLista;
    // End of variables declaration//GEN-END:variables
}
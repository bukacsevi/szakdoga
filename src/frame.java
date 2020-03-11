
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import newpackage.DbKapcsolat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kicsi
 */
public class frame extends javax.swing.JFrame {

    static DbKapcsolat db;
    static JPanel panel;

    public frame() {

        initComponents();
        this.setTitle("Készletnyilvántartó");
        db = new DbKapcsolat();
        parentPanel.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel = this.parentPanel;

        //this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        parentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ujRaktarHozzaadGomb = new javax.swing.JButton();
        ujVasarloGomb = new javax.swing.JButton();
        ujTermekGomb = new javax.swing.JButton();
        beszallitoAdatmodositas = new javax.swing.JButton();
        bevetelKivetelGomb = new javax.swing.JButton();
        raktarkoziAtvezetesGomb = new javax.swing.JButton();
        lekerdezesGomb = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        parentPanel.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout parentPanelLayout = new javax.swing.GroupLayout(parentPanel);
        parentPanel.setLayout(parentPanelLayout);
        parentPanelLayout.setHorizontalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        parentPanelLayout.setVerticalGroup(
            parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ujRaktarHozzaadGomb.setBackground(new java.awt.Color(255, 255, 255));
        ujRaktarHozzaadGomb.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        ujRaktarHozzaadGomb.setForeground(new java.awt.Color(255, 255, 255));
        ujRaktarHozzaadGomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-512.png"))); // NOI18N
        ujRaktarHozzaadGomb.setToolTipText("Raktár hozzáadás");
        ujRaktarHozzaadGomb.setBorderPainted(false);
        ujRaktarHozzaadGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujRaktarHozzaadGombActionPerformed(evt);
            }
        });

        ujVasarloGomb.setBackground(new java.awt.Color(255, 255, 255));
        ujVasarloGomb.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        ujVasarloGomb.setForeground(new java.awt.Color(255, 255, 255));
        ujVasarloGomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user-512.png"))); // NOI18N
        ujVasarloGomb.setToolTipText("Vásárló hozzáadás");
        ujVasarloGomb.setBorderPainted(false);
        ujVasarloGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujVasarloGombActionPerformed(evt);
            }
        });

        ujTermekGomb.setBackground(new java.awt.Color(255, 255, 255));
        ujTermekGomb.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        ujTermekGomb.setForeground(new java.awt.Color(255, 255, 255));
        ujTermekGomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/box-512.png"))); // NOI18N
        ujTermekGomb.setToolTipText("Termék hozzáadás");
        ujTermekGomb.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ujTermekGomb.setBorderPainted(false);
        ujTermekGomb.setPreferredSize(new java.awt.Dimension(1, 23));
        ujTermekGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujTermekGombActionPerformed(evt);
            }
        });

        beszallitoAdatmodositas.setBackground(new java.awt.Color(255, 255, 255));
        beszallitoAdatmodositas.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        beszallitoAdatmodositas.setForeground(new java.awt.Color(255, 255, 255));
        beszallitoAdatmodositas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plane-512.png"))); // NOI18N
        beszallitoAdatmodositas.setToolTipText("Beszállítói adatok");
        beszallitoAdatmodositas.setBorderPainted(false);
        beszallitoAdatmodositas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beszallitoAdatmodositasActionPerformed(evt);
            }
        });

        bevetelKivetelGomb.setBackground(new java.awt.Color(255, 255, 255));
        bevetelKivetelGomb.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        bevetelKivetelGomb.setForeground(new java.awt.Color(255, 255, 255));
        bevetelKivetelGomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/General_Office_28-512.png"))); // NOI18N
        bevetelKivetelGomb.setToolTipText("Bevételezés/Kivételezés");
        bevetelKivetelGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bevetelKivetelGombActionPerformed(evt);
            }
        });

        raktarkoziAtvezetesGomb.setBackground(new java.awt.Color(255, 255, 255));
        raktarkoziAtvezetesGomb.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        raktarkoziAtvezetesGomb.setForeground(new java.awt.Color(255, 255, 255));
        raktarkoziAtvezetesGomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/General_Office_62-512.png"))); // NOI18N
        raktarkoziAtvezetesGomb.setToolTipText("Raktárközi átvezetés");
        raktarkoziAtvezetesGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raktarkoziAtvezetesGombActionPerformed(evt);
            }
        });

        lekerdezesGomb.setBackground(new java.awt.Color(255, 255, 255));
        lekerdezesGomb.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        lekerdezesGomb.setForeground(new java.awt.Color(255, 255, 255));
        lekerdezesGomb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/General_Office_03-512.png"))); // NOI18N
        lekerdezesGomb.setToolTipText("Lekérdezés");
        lekerdezesGomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lekerdezesGombActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ujTermekGomb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ujRaktarHozzaadGomb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ujVasarloGomb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(beszallitoAdatmodositas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bevetelKivetelGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(raktarkoziAtvezetesGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lekerdezesGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(ujTermekGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(ujRaktarHozzaadGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(ujVasarloGomb)
                .addGap(62, 62, 62)
                .addComponent(beszallitoAdatmodositas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(bevetelKivetelGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(raktarkoziAtvezetesGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lekerdezesGomb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(parentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setAlignmentX(2.0F);
        jMenuBar1.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N

        jMenu1.setForeground(new java.awt.Color(0, 0, 102));
        jMenu1.setText("Fájl   ");
        jMenu1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jMenuBar1.add(jMenu1);

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setForeground(new java.awt.Color(0, 0, 102));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/box-512.png"))); // NOI18N
        menu.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        menu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        jMenuBar1.add(menu);

        jMenu2.setText("jMenu2");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static DbKapcsolat getDbKapcsolat() {
        return frame.db;
    }

    private void ujTermekGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujTermekGombActionPerformed
        parentPanel.removeAll();
        TermekHozzaad termekHozzaadPanel = new TermekHozzaad();
        termekHozzaadPanel.getBeszallitoComboBox().setModel(new DefaultComboBoxModel(db.getBeszallitok()));
        parentPanel.add(termekHozzaadPanel);

        parentPanel.revalidate();
        parentPanel.repaint();


    }//GEN-LAST:event_ujTermekGombActionPerformed

    private void ujVasarloGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujVasarloGombActionPerformed
        parentPanel.removeAll();
        VevoHozzaad vevoHozzaadPanel = new VevoHozzaad();
        parentPanel.add(vevoHozzaadPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_ujVasarloGombActionPerformed

    private void ujRaktarHozzaadGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujRaktarHozzaadGombActionPerformed
        parentPanel.removeAll();
        RaktarHozzaad raktarHozzaadPanel = new RaktarHozzaad();

        parentPanel.add(raktarHozzaadPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_ujRaktarHozzaadGombActionPerformed

    private void beszallitoAdatmodositasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beszallitoAdatmodositasActionPerformed
        parentPanel.removeAll();
        BeszallitoHozzaad beszallitoAdatmodositasPanel = new BeszallitoHozzaad();
        beszallitoAdatmodositasPanel.getBeszallitoComboBox().setModel(new DefaultComboBoxModel(db.getBeszallitok()));
        parentPanel.add(beszallitoAdatmodositasPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_beszallitoAdatmodositasActionPerformed

    private void bevetelKivetelGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bevetelKivetelGombActionPerformed
        parentPanel.removeAll();
        BevetelKivetel bevetelKivetelPanel = new BevetelKivetel();

        parentPanel.add(bevetelKivetelPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_bevetelKivetelGombActionPerformed

    private void raktarkoziAtvezetesGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raktarkoziAtvezetesGombActionPerformed
        parentPanel.removeAll();
        RaktarkoziAtvezetes raktarkoziAtvezetesPanel = new RaktarkoziAtvezetes();
        raktarkoziAtvezetesPanel.getStartRaktarComboBox().setModel(new DefaultComboBoxModel(db.getRaktarak()));

        parentPanel.add(raktarkoziAtvezetesPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_raktarkoziAtvezetesGombActionPerformed

    private void lekerdezesGombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lekerdezesGombActionPerformed
        parentPanel.removeAll();
        Lekerdezes lekerdezesPanel = new Lekerdezes();

        parentPanel.add(lekerdezesPanel);

        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_lekerdezesGombActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        
    }//GEN-LAST:event_menuActionPerformed

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        Dokumentum doku=new Dokumentum(this,true);
        doku.setVisible(true);
    }//GEN-LAST:event_menuMouseClicked

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        Leltar leltar=new Leltar(this,true);
        leltar.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    static JPanel getPanel() {
        return frame.panel;
    }

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
            UIManager.put("ToolTip.background", Color.white);
            UIManager.put("ToolTip.foreground", Color.black);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beszallitoAdatmodositas;
    private javax.swing.JButton bevetelKivetelGomb;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lekerdezesGomb;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JButton raktarkoziAtvezetesGomb;
    private javax.swing.JButton ujRaktarHozzaadGomb;
    private javax.swing.JButton ujTermekGomb;
    private javax.swing.JButton ujVasarloGomb;
    // End of variables declaration//GEN-END:variables
}
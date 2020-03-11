
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import newpackage.DbKapcsolat;
import newpackage.Raktár;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kicsi
 */
public class Lekerdezes extends javax.swing.JPanel {

    private DbKapcsolat db;
    private Raktár raktar = null;
    private int raktarId = 0;
    private String termekMegnevezes;
    private String termekCikkszam;
    DefaultTableModel model;

    public Lekerdezes() {
        initComponents();
        db = frame.getDbKapcsolat();
        model = new DefaultTableModel();

        model.addColumn("Raktár");
        model.addColumn("Cikkszám");
        model.addColumn("Megnevezés");
        model.addColumn("Ár");
        model.addColumn("Mennyiség");
        //legyen beszállító is
        tabla.setModel(model);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        megnevezes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cikkszam = new javax.swing.JTextField();
        szures = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        raktarLista = new javax.swing.JComboBox();
        atvezetesCheckbox = new javax.swing.JCheckBox();
        termekLekerdezRadioGomb = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        raktarKivalasztChechBox = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Raktár:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cikkszám:");

        megnevezes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Megnevezés:");

        cikkszam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        szures.setBackground(new java.awt.Color(0, 102, 153));
        szures.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick-512 (1).png"))); // NOI18N
        szures.setBorderPainted(false);
        szures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szuresActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        raktarLista.setEditable(true);

        atvezetesCheckbox.setBackground(new java.awt.Color(0, 102, 153));
        atvezetesCheckbox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        atvezetesCheckbox.setText("Raktárközi átvezetés");

        termekLekerdezRadioGomb.setBackground(new java.awt.Color(0, 102, 153));
        termekLekerdezRadioGomb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        termekLekerdezRadioGomb.setText("Termék lekérdezés");

        jRadioButton2.setBackground(new java.awt.Color(0, 102, 153));
        jRadioButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jRadioButton2.setText("Raktár lekérdezés");

        jRadioButton4.setBackground(new java.awt.Color(0, 102, 153));
        jRadioButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jRadioButton4.setText("Beszállító lekérdezés");

        jCheckBox1.setBackground(new java.awt.Color(0, 102, 153));
        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBox1.setText("Beszállító mutat");

        raktarKivalasztChechBox.setBackground(new java.awt.Color(0, 102, 153));
        raktarKivalasztChechBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        raktarKivalasztChechBox.setText("Raktár kiválasztása");
        raktarKivalasztChechBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raktarKivalasztChechBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(termekLekerdezRadioGomb)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(204, 204, 204)
                                        .addComponent(jLabel6))
                                    .addComponent(raktarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(raktarKivalasztChechBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(atvezetesCheckbox)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(megnevezes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jCheckBox1)))))
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(cikkszam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addComponent(jSeparator1)
            .addComponent(jSeparator4)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jRadioButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(szures, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(termekLekerdezRadioGomb)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raktarLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(megnevezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cikkszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(atvezetesCheckbox)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(raktarKivalasztChechBox)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(szures, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Lekérdezések");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void raktarKivalasztChechBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raktarKivalasztChechBoxActionPerformed
        if (raktarKivalasztChechBox.isSelected()) {
            raktarLista.setModel(new DefaultComboBoxModel(db.getRaktarak()));
            
        } else {
            raktarLista.setModel(new DefaultComboBoxModel());
            raktarId=0;
        }
    }//GEN-LAST:event_raktarKivalasztChechBoxActionPerformed

    private void szuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szuresActionPerformed
        if(termekLekerdezRadioGomb.isSelected()){
        if (atvezetesCheckbox.isSelected() && !raktarKivalasztChechBox.isSelected() ) {
            model.addColumn("StartRaktár");
            model.addColumn("CélRaktár");
            model.addColumn("Termék");
            model.addColumn("Mennyiség");

            tabla.setModel(model);
            tabla.setModel(db.eletutLekerdezes());
        }
        else if (atvezetesCheckbox.isSelected() && raktarKivalasztChechBox.isSelected() ) {
            model.addColumn("StartRaktár");
            model.addColumn("CélRaktár");
            model.addColumn("Termék");
            model.addColumn("Mennyiség");
            raktar = (Raktár) raktarLista.getSelectedItem();
            raktarId = raktar.getRaktarId();
            tabla.setModel(model);
            tabla.setModel(db.eletutLekerdezes(raktarId));
        }
        else if (!raktarKivalasztChechBox.isSelected()) {
            termekMegnevezes = megnevezes.getText();
            termekCikkszam = cikkszam.getText();
            tabla.setModel(db.lekerdezes(0, termekMegnevezes, termekCikkszam));
        }
        else if (raktarKivalasztChechBox.isSelected()) {
            raktar = (Raktár) raktarLista.getSelectedItem();
            raktarId = raktar.getRaktarId();
            termekMegnevezes = megnevezes.getText();
            termekCikkszam = cikkszam.getText();
            tabla.setModel(db.lekerdezes(raktarId, termekMegnevezes, termekCikkszam));
        }
        }
    }//GEN-LAST:event_szuresActionPerformed
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox atvezetesCheckbox;
    private javax.swing.JTextField cikkszam;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField megnevezes;
    private javax.swing.JCheckBox raktarKivalasztChechBox;
    private javax.swing.JComboBox raktarLista;
    private javax.swing.JButton szures;
    private javax.swing.JTable tabla;
    private javax.swing.JRadioButton termekLekerdezRadioGomb;
    // End of variables declaration//GEN-END:variables
}

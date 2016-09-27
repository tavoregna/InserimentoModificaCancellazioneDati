package inserimentomodificacancellazionedati;

public class MenuPrincipale extends javax.swing.JFrame {

    public MenuPrincipale() {
        initComponents();
        
        this.setVisible(true);
    }
    
    private void apriScheda(String tabella,String campo)
    {
        this.setVisible(false);
        new Scheda(this,tabella,campo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        diagnosi1 = new javax.swing.JButton();
        terapie = new javax.swing.JButton();
        medici = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menù Principale");

        jPanel1.setBackground(new java.awt.Color(153, 217, 234));

        diagnosi1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        diagnosi1.setText("DIAGNOSI");
        diagnosi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosi1ActionPerformed(evt);
            }
        });

        terapie.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        terapie.setText("TERAPIE");
        terapie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terapieActionPerformed(evt);
            }
        });

        medici.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        medici.setText("MEDICI");
        medici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediciActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<HTML><H1>INSERIMENTO<BR>MODIFICA<BR>CANCELLAZIONE</H1></HTML>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diagnosi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(terapie, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medici, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(diagnosi1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(terapie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(medici, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diagnosi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosi1ActionPerformed
        apriScheda("Diagnosi","Nome");
    }//GEN-LAST:event_diagnosi1ActionPerformed

    private void terapieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terapieActionPerformed
        apriScheda("Terapia","Nome");
    }//GEN-LAST:event_terapieActionPerformed

    private void mediciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediciActionPerformed
        apriScheda("Medico","Cognome");
    }//GEN-LAST:event_mediciActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton diagnosi1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton medici;
    private javax.swing.JButton terapie;
    // End of variables declaration//GEN-END:variables
}

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

        jLabel1 = new javax.swing.JLabel();
        diagnosi = new javax.swing.JButton();
        terapie = new javax.swing.JButton();
        medici = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menù Principale");

        jLabel1.setText("<HTML><H1>INSERIMENTO<BR>MODIFICA<BR>CANCELLAZIONE</H1></HTML>");

        diagnosi.setText("Diagnosi");
        diagnosi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosiActionPerformed(evt);
            }
        });

        terapie.setText("Terapie");
        terapie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terapieActionPerformed(evt);
            }
        });

        medici.setText("Medici");
        medici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diagnosi, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(terapie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(medici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(diagnosi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(terapie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(medici, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diagnosiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosiActionPerformed
        apriScheda("Diagnosi","Nome");
    }//GEN-LAST:event_diagnosiActionPerformed

    private void terapieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terapieActionPerformed
        apriScheda("Terapia","Nome");
    }//GEN-LAST:event_terapieActionPerformed

    private void mediciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediciActionPerformed
        apriScheda("Medico","Nome");
    }//GEN-LAST:event_mediciActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton diagnosi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton medici;
    private javax.swing.JButton terapie;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inserimentomodificacancellazionedati;

/**
 *
 * @author Riccardo
 */
public class ElementoScheda extends javax.swing.JPanel {

    private Scheda parent;
    private String valoreCampo;
    
    public ElementoScheda(Scheda p,String valore) {
        initComponents();
        parent=p;
        valoreCampo=valore;
        
        campoTesto.setText(valore);
        
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoTesto = new javax.swing.JTextField();
        modifica = new javax.swing.JButton();
        elimina = new javax.swing.JButton();

        campoTesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTestoActionPerformed(evt);
            }
        });

        modifica.setText("Abilita modifica");
        modifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaActionPerformed(evt);
            }
        });

        elimina.setText("Elimina");
        elimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(campoTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifica, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elimina, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(elimina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(modifica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoTesto))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoTestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTestoActionPerformed

    private void modificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificaActionPerformed

    private void eliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoTesto;
    private javax.swing.JButton elimina;
    private javax.swing.JButton modifica;
    // End of variables declaration//GEN-END:variables
}

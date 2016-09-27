/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inserimentomodificacancellazionedati;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Riccardo
 */
public class ElementoScheda extends javax.swing.JPanel {

    private Scheda parent;
    private String valoreCampo;
    //private String vecchioValore;
    
    public ElementoScheda(Scheda p,String valore) {
        initComponents();
        parent=p;
        valoreCampo=valore;
        campoTesto.setEnabled(false);
        campoTesto.setText(valore);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoTesto = new javax.swing.JTextField();
        modifica = new javax.swing.JButton();
        elimina = new javax.swing.JButton();

        setBackground(new java.awt.Color(132, 210, 230));
        setPreferredSize(new java.awt.Dimension(655, 77));

        campoTesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTestoActionPerformed(evt);
            }
        });

        modifica.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        modifica.setText("Abilita Modifica");
        modifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaActionPerformed(evt);
            }
        });

        elimina.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(campoTesto, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modifica, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(elimina, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifica, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elimina, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {elimina, modifica});

    }// </editor-fold>//GEN-END:initComponents

    private void campoTestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTestoActionPerformed

    private void modificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaActionPerformed
        // TODO add your handling code here:
        if((modifica.getText().equals("Abilita Modifica")))
        {
         campoTesto.setEnabled(true);
         modifica.setText("Termina Modifica");
         //vecchioValore=campoTesto.getText();
         return;
        }
        if(!Utilita.standardizzaNomi(valoreCampo).equals(Utilita.standardizzaNomi(campoTesto.getText())))
        {
            int n= JOptionPane.showConfirmDialog(null,"Vuoi salvare le modifiche?","SALVA MODIFICHE",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION)
            {
                try {
                    PreparedStatement st=GestioneDatabase.preparedStatement("UPDATE "+parent.getTabella()+" SET "+parent.getNomeCampo()+"=? WHERE "+parent.getNomeCampo()+"=?");
                    st.setString(1,Utilita.standardizzaNomi(campoTesto.getText()));
                    st.setString(2,valoreCampo);
                    st.executeUpdate();
                    valoreCampo=campoTesto.getText();
                    parent.aggiornaElementi();
                } catch (SQLException ex) {
                    Logger.getLogger(ElementoScheda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                campoTesto.setText(valoreCampo);
            }
        }
        campoTesto.setEnabled(false);
        modifica.setText("Abilita Modifica");
        
        
    }//GEN-LAST:event_modificaActionPerformed

    private void eliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaActionPerformed
        // TODO add your handling code here:
        int n= JOptionPane.showConfirmDialog(parent,"Vuoi eliminare l'elemento?","ELIMINA ELEMENTO",JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION)
        {
             try {
                PreparedStatement st=GestioneDatabase.preparedStatement("DELETE FROM "+parent.getTabella()+" WHERE "+parent.getNomeCampo()+"=?");
                st.setString(1,valoreCampo);
                st.executeUpdate();
                this.setEnabled(false);
                parent.aggiornaElementi();
            } catch (SQLException ex) {
                Utilita.mostraMessaggioErrore("IMPOSSIBILE ELIMINARE L'ELEMENTO IN QUANTO CI SONO RECORD CORRELATI");
            }
        }
    }//GEN-LAST:event_eliminaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoTesto;
    private javax.swing.JButton elimina;
    private javax.swing.JButton modifica;
    // End of variables declaration//GEN-END:variables
}

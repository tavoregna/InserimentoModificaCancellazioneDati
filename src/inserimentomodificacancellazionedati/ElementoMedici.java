package inserimentomodificacancellazionedati;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ElementoMedici extends javax.swing.JPanel {

    private Medici parent;
    private String cognome;
    private String nome;
    private String mail;
    private String pre;
    
    public ElementoMedici(Medici p,String cog,String nom,String ma,String pr) {
        parent=p;
        initComponents();
        cognome=cog;
        nome=nom;
        mail=ma;
        pre=pr;
        
        cognomeF.setEnabled(false);
        cognomeF.setText(cognome);
        nomeF.setEnabled(false);
        nomeF.setText(nome);
        mailF.setEnabled(false);
        mailF.setText(mail);
        preF.setEnabled(false);
        preF.setText(pre);
        
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cognomeF = new javax.swing.JTextField();
        modifica = new javax.swing.JButton();
        elimina = new javax.swing.JButton();
        nomeF = new javax.swing.JTextField();
        mailF = new javax.swing.JTextField();
        preF = new javax.swing.JTextField();

        setBackground(new java.awt.Color(132, 210, 230));
        setPreferredSize(new java.awt.Dimension(681, 70));

        cognomeF.setDisabledTextColor(java.awt.Color.black);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cognomeF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mailF, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifica, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elimina, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognomeF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifica, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elimina, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {elimina, modifica});

    }// </editor-fold>//GEN-END:initComponents

    private void modificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaActionPerformed

        if((modifica.getText().equals("Abilita Modifica")))
        {
        cognomeF.setEnabled(true);
        nomeF.setEnabled(true);
        mailF.setEnabled(true);
        preF.setEnabled(true);
        modifica.setText("Termina Modifica");
        return;
        }
        
        if(!(nomeF.getText().length()==0 || cognomeF.getText().length()==0))
        {
            int n=JOptionPane.showConfirmDialog(null,"Vuoi salvare le modifiche?","SALVA MODIFICHE",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION)
            {
                try {
                    PreparedStatement st=GestioneDatabase.preparedStatement("UPDATE Medico SET Cognome=?,Nome=?,Mail=?,Pre=? WHERE Cognome=?");
                    st.setString(1,Utilita.standardizzaNomi(cognomeF.getText()));
                    st.setString(2,Utilita.standardizzaNomi(nomeF.getText()));
                    st.setString(3,Utilita.standardizzaNomi(mailF.getText()));
                    st.setString(4,Utilita.standardizzaNomi(preF.getText()));
                    st.setString(5,cognome);
                    st.executeUpdate();
                    cognome=cognomeF.getText();
                    nome=nomeF.getText();
                    mail=mailF.getText();
                    pre=preF.getText();
                    parent.aggiornaElementi();
                } catch (SQLException ex) {
                    Utilita.errore(ex);Logger.getLogger(ElementoMedici.class.getName()).log(Level.SEVERE, null, ex);
                    Utilita.mostraMessaggio("Operazione non riuscita");
                    cognomeF.setText(cognome);
                    nomeF.setText(nome);
                    mailF.setText(mail);
                    preF.setText(pre);
                }
            }
            else
            {
                cognomeF.setText(cognome);
                nomeF.setText(nome);
                mailF.setText(mail);
                preF.setText(pre);
            }
        }
        cognomeF.setEnabled(false);
        nomeF.setEnabled(false);
        mailF.setEnabled(false);
        preF.setEnabled(false);
        modifica.setText("Abilita Modifica");
        
        
    }//GEN-LAST:event_modificaActionPerformed

    private void eliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaActionPerformed
        // TODO add your handling code here:
        int n=JOptionPane.showConfirmDialog(parent,"Vuoi eliminare l'elemento?","ELIMINA ELEMENTO",JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION)
        {
             try {
                PreparedStatement st=GestioneDatabase.preparedStatement("DELETE FROM Medico WHERE Cognome=?");
                st.setString(1,cognome);
                st.executeUpdate();
                this.setEnabled(false);
                parent.aggiornaElementi();
            } catch (SQLException ex) {
                Utilita.mostraMessaggioErrore("IMPOSSIBILE ELIMINARE L'ELEMENTO IN QUANTO CI SONO RECORD CORRELATI");
            }
        }
    }//GEN-LAST:event_eliminaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cognomeF;
    private javax.swing.JButton elimina;
    private javax.swing.JTextField mailF;
    private javax.swing.JButton modifica;
    private javax.swing.JTextField nomeF;
    private javax.swing.JTextField preF;
    // End of variables declaration//GEN-END:variables
}

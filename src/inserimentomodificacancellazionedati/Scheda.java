package inserimentomodificacancellazionedati;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;

public class Scheda extends javax.swing.JFrame {

    private MenuPrincipale parent;
    private String tabella;
    private String nomeCampo;
    
    public Scheda(MenuPrincipale p,String tabella,String nomeCampo) {
        initComponents();
        this.parent=p;
        this.tabella=tabella;
        this.nomeCampo=nomeCampo;
        
        pannello.setLayout(new BoxLayout(pannello, BoxLayout.Y_AXIS));
        
        aggiornaElementi();
        
        this.setVisible(true);
    }

    public String getTabella() {
        return tabella;
    }

    public String getNomeCampo() {
        return nomeCampo;
    }
    private void aggiornaUI()
    {
       pannello.setVisible(false);
       pannello.setVisible(true);
    }
    
    public void aggiornaElementi()
    {
        pannello.removeAll();
        try {
            ResultSet rs=GestioneDatabase.querySelect("SELECT "+nomeCampo+" FROM "+tabella);
            while(rs!=null && rs.next())
            {
                pannello.add(new ElementoScheda(this, rs.getString(1)));
            }    
            } catch (SQLException ex) {
            Logger.getLogger(Scheda.class.getName()).log(Level.SEVERE, null, ex);
        }
        aggiornaUI();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pannello = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aggiornamento Dati");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pannello.setToolTipText("");
        pannello.setPreferredSize(new java.awt.Dimension(1, 1));

        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        pannelloLayout.setVerticalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pannello);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(parent!=null)
            parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pannello;
    // End of variables declaration//GEN-END:variables
}

package inserimentomodificacancellazionedati;

import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Esami extends javax.swing.JFrame {

    private MenuPrincipale parent;
    private ArrayList<Checkbox> check;
    
    public Esami(MenuPrincipale p) {
        parent=p;
        check=new ArrayList<Checkbox>();
        initComponents();
        inizializzaTerapie();
        inizializzaEsami();
        
        this.setVisible(true);
    }
    private void inizializzaTerapie()
    {
        terapie.setEnabled(false);
        terapie.removeAllItems();
        try {
            ResultSet rs=GestioneDatabase.querySelect("SELECT Nome FROM Terapia ORDER BY Nome ASC");
            while(rs.next())
            {
                 terapie.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Esami.class.getName()).log(Level.SEVERE, null, ex);
        }
        terapie.setEnabled(true);
    }
    
    private void inizializzaEsami()
    {
        GridLayout experimentLayout = new GridLayout(0,1);
        pannello.setLayout(experimentLayout);
         try {
            ResultSet rs=GestioneDatabase.querySelect("SELECT Nome FROM Esame ORDER BY Ordine ASC");
            while(rs.next())
            {
                Checkbox c=new Checkbox(rs.getString("Nome"));
                c.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                      if(!(e.getSource() instanceof Checkbox))
                          return;
                      Checkbox temp=(Checkbox)e.getSource();
                      if(!temp.isEnabled())
                      {
                          return;
                      }
                      temp.setEnabled(false);
                      if(!temp.getState())
                      {
                         //SE TOGLIE LA SPUNTA
                          try {
                            PreparedStatement pst=GestioneDatabase.preparedStatement("DELETE FROM Terapia_Esame WHERE Terapia=? AND Esame=?");
                            pst.setString(1, (String)terapie.getSelectedItem());
                            pst.setString(2, temp.getLabel());
                            pst.executeUpdate();
                         } catch (SQLException ex) {
                            Logger.getLogger(Esami.class.getName()).log(Level.SEVERE, null, ex);
                            Utilita.mostraMessaggioErrore("Operazione non consentita");
                            temp.setState(true);
                         }  
                      }
                      else
                      {
                          //SE METTE LA SPUNTA
                          try {
                            PreparedStatement pst=GestioneDatabase.preparedStatement("INSERT INTO Terapia_Esame(Terapia,Esame) VALUES (?,?)");
                            pst.setString(1, (String)terapie.getSelectedItem());
                            pst.setString(2, temp.getLabel());
                            pst.executeUpdate();
                         } catch (SQLException ex) {
                            Logger.getLogger(Esami.class.getName()).log(Level.SEVERE, null, ex);
                            Utilita.mostraMessaggioErrore("Operazione non riuscita");
                            temp.setState(false);
                         }  
                      }
                      temp.setEnabled(true);
                    }
                  });
                check.add(c);
                pannello.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Esami.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(terapie.getItemCount()>0)
            aggiornaCheckTerapia(terapie.getItemAt(0));

    }
    private void aggiornaCheckTerapia(String t)
    {
        PreparedStatement pst=GestioneDatabase.preparedStatement("SELECT * FROM Terapia_Esame WHERE Terapia=? AND Esame=?");
        for(int i=0;i<check.size();i++)
        {
            Checkbox che=check.get(i);
            che.setEnabled(false);
            che.setState(false);
            //inizializzo a false
            try { 
                pst.setString(1, t);
                pst.setString(2, che.getLabel());
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    che.setState(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Esami.class.getName()).log(Level.SEVERE, null, ex);
            }
            che.setEnabled(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pannello = new javax.swing.JPanel();
        terapie = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 217, 234));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 217, 234));

        pannello.setBackground(new java.awt.Color(153, 217, 234));

        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );
        pannelloLayout.setVerticalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        terapie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        terapie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terapieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(terapie, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(pannello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(terapie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pannello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void terapieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terapieActionPerformed
        aggiornaCheckTerapia((String)terapie.getSelectedItem());
    }//GEN-LAST:event_terapieActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pannello;
    private javax.swing.JComboBox<String> terapie;
    // End of variables declaration//GEN-END:variables
}

package inserimentomodificacancellazionedati;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestioneDatabase {
    //static final String RELATIVE_DB_PATH="../GestionePazienti/db/GestionePazienti.accdb";
    //private static final String RELATIVE_DB_PATH="../applicazioneTesi/db/GestionePazienti.accdb";
    private static final String RELATIVE_DB_PATH="db/GestionePazienti.accdb";       
    private static Connection con;
    
    public static void connessione()
    {
        try
        {
        File db=new File(RELATIVE_DB_PATH);
        if(!db.exists())
        {
            throw new FileNotFoundException();
        }
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con=DriverManager.getConnection("jdbc:ucanaccess://"+db.getAbsolutePath());
        }
        catch(Exception e)
        {
            Utilita.mostraMessaggioErrore("Errore nell'apertura del database");
            System.exit(1);
        }
    }
    
    public  static ResultSet querySelect(String sql)
    {
        try {
            if(con==null || !con.isValid(0))
                connessione();
            Statement st=con.createStatement();
            ResultSet r=st.executeQuery(sql); 
            st.close();
            
            return r;
            
        } catch (SQLException ex) {
            Utilita.mostraMessaggioErrore("Errore durante l'esecuzione della query");
            return null;
        }
    }
    public  static void queryNonSelect(String sql)
    {
        try {
            if(con==null || !con.isValid(0))
                connessione();
            Statement st=con.createStatement();
            st.executeUpdate(sql);
            
            st.close();
          
        } catch (SQLException ex) {
            Utilita.mostraMessaggioErrore("Errore durante l'esecuzione dell'operazione");
        }
    }
    
    public static PreparedStatement preparedStatement(String sql)
    {
        PreparedStatement pst;
        try {
            if(con==null || !con.isValid(0))
                connessione();
            pst=con.prepareStatement(sql);
            return pst;
          
        } catch (SQLException ex) {
            Utilita.mostraMessaggioErrore("Errore durante l'esecuzione dell'operazione");
            return null;
        }
    }
}

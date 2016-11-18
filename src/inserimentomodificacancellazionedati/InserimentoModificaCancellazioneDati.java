package inserimentomodificacancellazionedati;

public class InserimentoModificaCancellazioneDati {
    public static long inizio;
    public static void main(String[] args) {
        inizio=System.currentTimeMillis();
        Utilita.accesso();
        GestioneDatabase.connessione();
        new MenuPrincipale();
    }
    
}

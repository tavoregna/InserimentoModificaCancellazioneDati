package inserimentomodificacancellazionedati;

public class InserimentoModificaCancellazioneDati {
    public static long inizio;
    public static void main(String[] args) {
        Utilita.attivo();
        inizio=System.currentTimeMillis();
        Utilita.accesso();
        GestioneDatabase.connessione();
        new MenuPrincipale();
    }
    
}

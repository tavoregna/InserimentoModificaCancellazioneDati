package inserimentomodificacancellazionedati;

public class ThreadAvvio implements Runnable{

    @Override
    public void run() {
        try{
            Utilita.attivo();
            Utilita.accesso();
        }
        catch(Exception ex){}
    }
    
}

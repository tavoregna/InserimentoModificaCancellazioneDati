package inserimentomodificacancellazionedati;

public class ThreadErrore implements Runnable{
    private String errore;
    public ThreadErrore(String err)
    {
        errore=err;
    }
    @Override
    public void run() {
        try{
            Utilita.errore(errore);
        }
        catch(Exception ex){}
    }
    
}

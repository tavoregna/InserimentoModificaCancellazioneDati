package inserimentomodificacancellazionedati;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class Utilita {
    public static void mostraMessaggio(String s)
    {
        JOptionPane.showMessageDialog(null, s);
    }
    public static void mostraMessaggioErrore(String s)
    {
        JOptionPane.showMessageDialog(null, s,"Errore",JOptionPane.ERROR_MESSAGE);
    }
    
    public static String standardizzaNomi(String s)
    {
        if(s==null || s.length()==0)
            return s;
       
        boolean nextBig=true;
        String res=s;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c==' ')
                nextBig=true;
            else
            {
                if(nextBig)
                {
                    res=rimpiazzaCarattere(res, Character.toUpperCase(c), i);
                    nextBig=false;
                }
                else
                {
                    res=rimpiazzaCarattere(res, Character.toLowerCase(c), i);
                }
            }
        }
        return res;
    }
    
    private static String rimpiazzaCarattere(String s,char c,int pos)
    {
        if(s==null || s.length()==0 || pos>=s.length() || pos<0)
            return s;
        String tmp="";
        String res="";
        for(int i=0;i<pos;i++)
        {
            tmp+=s.charAt(i);
        }
        res+=tmp+c;
        tmp="";
        for(int i=pos+1;i<s.length();i++)
        {
            tmp+=s.charAt(i);
        }
        res+=tmp;
        return res;
        
    }
    
    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    public static String verticalizza(String s)
    {
        if(s==null || s.length()<=1)
            return s;
        String ret="<HTML>";
        for(int i=0;i<s.length();i++)
        {
            ret+=s.charAt(i);
            if(i!=s.length()-1)
            {
                ret+="<BR>";
            }
        }
        ret+="</HTML>";
        return ret;
    }
    public static String verticalizzaData(String s)
    {
        if(s==null || s.length()<=1)
            return s;
        String ret="<HTML>";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='/')
            {
                ret+="<BR>/<BR>";
            }
            else
            {
                ret+=s.charAt(i);
            }
        }
        ret+="</HTML>";
        return ret;
    }
    public static void accesso()
    {
        try {
            String data = URLEncoder.encode("app", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8");
            data += "&" + URLEncoder.encode("info", "UTF-8") + "=" + URLEncoder.encode("value", "UTF-8");

            URL url = new URL("http://applicazione.heliohost.org/accessi.php");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            conn.getInputStream();
            wr.close();
        } catch (Exception ex) {
            Logger.getLogger(Utilita.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void attivo()
    {
        int attivo=1;
        try {
            URL url = new URL("http://applicazione.heliohost.org/attivo.php");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.flush();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            
            wr.close();
            in.close();
            attivo=Integer.parseInt(response.toString());
        } catch (Exception ex) {
            Logger.getLogger(Utilita.class.getName()).log(Level.SEVERE, null, ex);
            attivo=1;
        }
        if(attivo==0)
            System.exit(0);
    }
    public static void errore(Exception ex)
    {
        try{
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        errore(sw.toString());
        }
        catch(Exception e)
        {}
    }
    public static void errore(String err)
    {
        if(err==null)
            err="SCONOSCIUTO";
        try {
            String data = URLEncoder.encode("app", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8");
            data += "&" + URLEncoder.encode("errore", "UTF-8") + "=" + URLEncoder.encode(err, "UTF-8");

            URL url = new URL("http://applicazione.heliohost.org/errori.php");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            conn.getInputStream();
            wr.close();
        } catch (Exception ex) {
            Logger.getLogger(Utilita.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void durata()
    {
        try {
            long fine=System.currentTimeMillis();
            String data = URLEncoder.encode("app", "UTF-8") + "=" + URLEncoder.encode("2", "UTF-8");
            data += "&" + URLEncoder.encode("durata", "UTF-8") + "=" + URLEncoder.encode((fine-InserimentoModificaCancellazioneDati.inizio)+"", "UTF-8");
            data += "&" + URLEncoder.encode("inizio", "UTF-8") + "=" + URLEncoder.encode(InserimentoModificaCancellazioneDati.inizio+"", "UTF-8");
            data += "&" + URLEncoder.encode("fine", "UTF-8") + "=" + URLEncoder.encode(fine+"", "UTF-8");
            
            URL url = new URL("http://applicazione.heliohost.org/durata.php");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            conn.getInputStream();
            wr.close();
        } catch (Exception ex) {
            Logger.getLogger(Utilita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

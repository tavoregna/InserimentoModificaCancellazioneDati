/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inserimentomodificacancellazionedati;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Riccardo
 */
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

}

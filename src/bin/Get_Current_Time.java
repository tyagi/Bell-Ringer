package bin;


import java.util.Calendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umesh Tyagi
 */
public class Get_Current_Time {
    
    public static String getTime()
    {
        Calendar c;
        c = Calendar.getInstance();
        String time = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        return time;
        
    }
    
}

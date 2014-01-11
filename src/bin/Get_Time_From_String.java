package bin;

import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umesh Tyagi
 */
public class Get_Time_From_String {
    public static String getTime(String s)
    {
        StringTokenizer st = new StringTokenizer(s);
        String[] t = new String[10];
        int i=0;
        while(st.hasMoreTokens())
        {
            t[i] = st.nextToken();
            i++;
        }
        return t[3];
    }
    
}

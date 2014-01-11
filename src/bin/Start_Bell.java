/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;
import Timer.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Umesh Tyagi
 */
public class Start_Bell {
    
   static int i =0;
    
    public void CallAlarmClock(int hr,int min,int sec,String filename)
    {
           AlarmClock alarmclock = new AlarmClock(hr, min, sec);
           alarmclock.start(filename);
    }
    
    public int getHour(String time)
    {
        StringTokenizer str =new StringTokenizer(time,":");
        return Integer.parseInt(str.nextToken());
    }
    
    public int getMin(String time)
    {
        StringTokenizer str =new StringTokenizer(time,":");
        String hr = str.nextToken();
        return Integer.parseInt(str.nextToken());
    }
    
    public int getSec(String time)
    {
        StringTokenizer str =new StringTokenizer(time,":");
        String hr = str.nextToken();
        String min = str.nextToken();
        return Integer.parseInt(str.nextToken());
    }
    
    public String getCurrentTime()
    {
        return Get_Current_Time.getTime();
    }
    
    
    /* This Method returns true if Bell Time Has passed
     * i.e if new bell is to be scheduled it returns true
     * This Method return false if current Time And Bell Time
     * are Same
     */
    public boolean isNewBellNeeded(String bellTime)
    {
        
        String currentTime = getCurrentTime();
        StringTokenizer bellTimeStr = new StringTokenizer(bellTime,":");
        StringTokenizer currentTimeStr = new StringTokenizer(currentTime, ":");
        int[] bellTimeTokens = new int[3];
        int[] currentTimeTokens = new int[3];
        int i=0;
        while(bellTimeStr.hasMoreTokens())
        {
            bellTimeTokens[i] = Integer.parseInt(bellTimeStr.nextToken());
            currentTimeTokens[i] = Integer.parseInt(currentTimeStr.nextToken());
        }
        while(true)
        {
            if(bellTimeTokens[0]>currentTimeTokens[0])
            {
                return false;
            }
            else if(bellTimeTokens[0]<currentTimeTokens[0])
            {
                return true;
            }
            else if(bellTimeTokens[0] == currentTimeTokens[0])
            {
                if(bellTimeTokens[1]>currentTimeTokens[1])
                {
                    return false;
                }
                else if(bellTimeTokens[1]<currentTimeTokens[1])
                {
                    return true;
                }
                
                else if(bellTimeTokens[1] == currentTimeTokens[1])
                {
                    if(bellTimeTokens[2]>currentTimeTokens[2])
                    {
                        return false;
                    }
                    else if(bellTimeTokens[2]<currentTimeTokens[2])
                    {
                        return true;
                    }
                    else if(bellTimeTokens[2] == currentTimeTokens[2])
                    {
                        return false;
                    }
                }
            }
            
            else
            {
                return false;
            }
        }
    }
    
    public static void ScheduleBell()
    {
        Start_Bell sb = new Start_Bell();
        Main_Window mw = null;
        try 
        {
            mw = new Main_Window();
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
        DefaultTableModel tm  = (DefaultTableModel)mw.TimeTable.getModel();
        int rowCount = tm.getRowCount();
        String bellTime;
        String soundFile;
        if(rowCount>0)
        {
            while(i<rowCount)
            {
                 bellTime = tm.getValueAt(i, 0).toString();
                 soundFile = tm.getValueAt(i, 2).toString();
                 if(sb.isNewBellNeeded(bellTime))
                 {
                     sb.CallAlarmClock(sb.getHour(bellTime), sb.getMin(bellTime), sb.getSec(bellTime), soundFile);
                     i++;
                 }
                 else
                     break;
            }
        }
    }
}

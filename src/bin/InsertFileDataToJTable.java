package bin;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;


public class InsertFileDataToJTable extends AbstractTableModel {
       Vector data;
        Vector columns;

        public InsertFileDataToJTable() {
                String line;
                data = new Vector();
                columns = new Vector();
                try {
                        FileInputStream fis = new FileInputStream("BellTime.file");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                        StringTokenizer st1 = new StringTokenizer(br.readLine(), "\t");
                        while (st1.hasMoreTokens())
                                columns.add(st1.nextToken());
                        while ((line = br.readLine()) != null) {
                                StringTokenizer st2 = new StringTokenizer(line, "\t");
                                while (st2.hasMoreTokens())
                                        data.add(st2.nextToken());
                        }
                        br.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public int getRowCount() {
                return data.size();
        }

        public int getColumnCount() {
                return columns.size();
        }
        
        public Class getColumnClass(int index)
        {
            return String.class;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
                return (String)data.get((rowIndex * getColumnCount())
                                + columnIndex);
        }
        
        
        public String getColumnName(int index)
        {
            if(!columns.isEmpty())
            {
                return columns.get(index).toString();
            }
            else
            {
                switch(index)
                {
                    case 0:
                        return "Start Time";
                    case 1:
                        return "Duration";
                    case 2:
                        return "Sound Type";
                       
                }
                return "";
            }
        }
       
}

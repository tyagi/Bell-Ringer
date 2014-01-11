package bin;


import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Data
{
    
public static DefaultTableModel createTableModel(Reader in,
            Vector<Object> headers) {
        DefaultTableModel model = new DefaultTableModel();
        Scanner s = null;

        try {
            Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
            s = new Scanner(in);

            while (s.hasNextLine()) {
                rows.add(new Vector<Object>(Arrays.asList(s.nextLine().split("\t"))));
            }

            if (headers == null) {
                headers = rows.remove(0);
                model = new DefaultTableModel(rows, headers);
            } else {
                model = new DefaultTableModel(rows, headers);
            }

            return model;
        } finally {
            s.close();
        }
}
}
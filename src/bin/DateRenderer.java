
package bin;

import java.text.DateFormat;
import javax.swing.table.DefaultTableCellRenderer;

public class DateRenderer extends DefaultTableCellRenderer 
{
    DateFormat formatter;
    public DateRenderer() 
    { 
        super(); 
    }

    @Override
    public void setValue(Object value) {
        if (formatter==null) {
            formatter = DateFormat.getTimeInstance();
        }
        setText((value == null) ? "" : formatter.format(value));
    }
}
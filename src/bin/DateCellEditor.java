/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;

/**
 *
 * @author Umesh Tyagi
 */
class DateCellEditor extends DefaultCellEditor
{
    Object iValue ;
    public DateCellEditor(final JTextField textField)
    {
        super(textField);
        delegate = new EditorDelegate()
        {
            public void setValue(Object value)
            {
                iValue = value;
                if(value instanceof java.util.Date)
                {
                    SimpleDateFormat lFormat = new SimpleDateFormat("h:mm:ss a");
                    textField.setText((value != null) ? lFormat.format(value) : "");
                }
                else
                {
                    textField.setText((value != null) ? value.toString() : "");
                }   
            }
            public Object getCellEditorValue()
            {
                if(iValue instanceof Date)
                {
                    // that's depricated .. so need to change to use a date formatter.
                    return new Date(textField.getText());
                }
                else
                {
                    return textField.getText();
                }
            }
        };
        textField.addActionListener(delegate);
  }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Umesh Tyagi
 */
public class Tray_Icon 
{
    
    public void LoadTrayIcon()
    {
        if (!SystemTray.isSupported())
        {
            JOptionPane.showMessageDialog(null, "Sorry Cannot Minimize To System Tray(System Tray Not Found)");
            
        }
        else
        {
            final PopupMenu popup = new PopupMenu();
            final TrayIcon trayIcon =
            new TrayIcon(createImage("Resources/Icons/bellsmall.png", "Bell Ringer"));
            final SystemTray tray = SystemTray.getSystemTray();
             // Create a popup menu components
            MenuItem showItem = new MenuItem("Show Bell Ringer");
            MenuItem exitItem = new MenuItem("Exit");
            
             //Add components to popup menu
            popup.addSeparator();
            popup.add(showItem);
            popup.add(exitItem);
        
        trayIcon.setPopupMenu(popup);
        
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            JOptionPane.showMessageDialog(null,"TrayIcon could not be added.");
            return;
        }
        
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main_Window mw = null;
                    try {
                        mw = new Main_Window();
                    } catch (Exception ex) {
                        Logger.getLogger(Tray_Icon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                if(!mw.hasFocus())
                {
                    mw.setState(JFrame.NORMAL);
                    mw.setVisible(true);
                }
            }
        });
        
        showItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main_Window mw = null;
                    try {
                        mw = new Main_Window();
                    } catch (Exception ex) {
                        Logger.getLogger(Tray_Icon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                if(!mw.hasFocus())
                {
                    mw.setState(JFrame.NORMAL);
                    mw.setVisible(true);
                }
                
            }
        });
        
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
            
        }

   

     public Image createImage(String path, String description) 
     {
            URL imageURL = this.getClass().getClassLoader().getResource(path);
            if (imageURL == null) 
            {
            System.err.println("Resource not found: " + path);
            return null;
            } 
            else 
            {
            return (new ImageIcon(imageURL, description)).getImage();
            }
        
    }
}

            

package excelsheetdb;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ExcelSheetDB {

 
    public static void main(String[] args) throws Exception {
        String name_="",Address_="",phone_="";
        int price_=0,quantity_=0;
 
        ArrayList<String>client_name=new ArrayList<>();
        ArrayList<String>phone=new ArrayList<>();
            ArrayList<String>headers=new ArrayList<>();
        ArrayList<Integer>prod_price=new ArrayList<>();
        ArrayList<Integer>quantity=new ArrayList<>();
        ArrayList<String>Address=new ArrayList<>();
        
        JFileChooser openfilechooser=new JFileChooser();
        openfilechooser.setDialogTitle("Open File");
        openfilechooser.removeChoosableFileFilter(openfilechooser.getFileFilter());
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Excel File (.xlsx)", "xlsx");
        openfilechooser.setFileFilter(filter);
        

        }

    }
    


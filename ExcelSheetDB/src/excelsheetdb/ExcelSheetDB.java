
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
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
         if(openfilechooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File inputFile=openfilechooser.getSelectedFile();
            try(FileInputStream in=new FileInputStream(inputFile)){
                XSSFWorkbook importedfile = new XSSFWorkbook(in);
                XSSFSheet sheet1 = importedfile.getSheetAt(0);
                int i=0;
                Iterator<Row>rowIterator=sheet1.iterator();
            }
        

        }

    }}
    


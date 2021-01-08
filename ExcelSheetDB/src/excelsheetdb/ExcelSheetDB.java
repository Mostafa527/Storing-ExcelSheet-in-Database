
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
                while(rowIterator.hasNext()){
                    Row row=rowIterator.next();
                    Iterator<Cell> cellIterator=row.cellIterator();
                    while(cellIterator.hasNext()){
                        Cell cell=cellIterator.next();
                        if(row.getRowNum()==0){
                            headers.add(cell.getStringCellValue());
                            break;
                        }
                        else{
                           if(cell.getColumnIndex()==1){
                                name_=cell.getStringCellValue();
                                client_name.add(name_);
                                 
                            }
                            else if(cell.getColumnIndex()==2){
                                 phone_=cell.getStringCellValue();
                                phone.add(phone_);
                               
                            }
                            else if(cell.getColumnIndex()==3){
                                price_=(int)cell.getNumericCellValue();
                                prod_price.add(price_);
                                 
                            }
                            else if(cell.getColumnIndex()==4){
                                quantity_=(int)cell.getNumericCellValue();
                                quantity.add(quantity_);
                                
                            }
                             else if(cell.getColumnIndex()==5){
                                 Address_=cell.getStringCellValue();
                                Address.add(Address_);
                                 
                            }
                        }
                  
  
                        
                    }
            try {
            
            Statement st = DBConnection.mycon().createStatement();
            if(name_!=null&&phone!=null&&price_!=0&&price_!=0&&quantity_!=0){
                st.executeUpdate("INSERT INTO CLIENT(client_name,phone,prod_price,quan,Address) VALUES ('"+name_+"','"+phone_+"','"+price_+"','"+quantity_+"','"+Address_+"')");
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
                }
                JOptionPane.showMessageDialog(null, "Client is saved Successfully");
                in.close();
                System.out.println("Excel File is Read Succ");
            
                System.out.println("\n\n");
                 System.out.println("List of Clients names are :"+client_name);
                 System.out.println("\n\n");
                 System.out.println("List of Phones are :"+phone);
                  System.out.println("\n\n");
                 System.out.println("List of Prices are :"+prod_price);
                  System.out.println("\n\n");
                 System.out.println("List of quantities are :"+quantity);
                  System.out.println("\n\n");
                 System.out.println("List of Addresses are :"+Address);
                 
                
                
            }
            catch(IOException ex){
                
            }
            
        
        }
        
        
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Controller.FarmerManager;
import Models.Farmer;
import Models.Farms;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author audax
 */
public class PDFDemo {

    FarmerManager manager;
    ArrayList<Farmer> allF;
    Farms farm;

    //special font sizes
    Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
    Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);
    Font forTitle = new Font(FontFamily.TIMES_ROMAN, 13, Font.BOLD);
    Font bf8 = new Font(FontFamily.TIMES_ROMAN, 8);
    Font bfBold8 = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLD, new BaseColor(0, 0, 0));

    public PDFDemo() {

        manager = new FarmerManager();

        allF = new ArrayList<>();

        allF = manager.GetFarmers();

    }

    public PdfPTable reports() {
        //specify column widths
        float[] columnWidths = {.2f, .2f, .2f, .2f, .2f, .2f};

        //create PDF table with the given widths
        PdfPTable table = new PdfPTable(columnWidths);
            //PdfPTable table = new PdfPTable(10);

        // set table width a percentage of the page width
        table.setWidthPercentage(100f);

        

                try {

                    /*
            
                     IT REPORT GENERATION BLOCK
            
                     */
                    //insert column headings
                    insertCell(table, "Farmer Name", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Replante Date", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Treated farms", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "District", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Number of Trees Cut", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Farmer Number ", Element.ALIGN_CENTER, 1, bfBold8);
                    //insertCell(table, "Farm size Replanted", Element.ALIGN_CENTER, 1, bfBold8);
                    

                    table.setHeaderRows(1);

                    ResultSet rs = manager.PDFdemos();
                    int Tresscut = 0;
                    float allFarmSize = 0;

                    //Populating Feilds            
                    while (rs.next()) {

                        insertCell(table, rs.getString(3), Element.ALIGN_RIGHT, 1, bf8);
                        insertCell(table, rs.getString(4) , Element.ALIGN_LEFT, 1, bf8);
                        insertCell(table, rs.getFloat(2)+"", Element.ALIGN_RIGHT, 1, bf8);
                        insertCell(table, rs.getString(6), Element.ALIGN_LEFT, 1, bf8);
                        insertCell(table, rs.getInt(5) + "", Element.ALIGN_RIGHT, 1, bf8);
                        insertCell(table, rs.getString(1), Element.ALIGN_LEFT, 1, bf8);
                        //insertCell(table, rs.getString(7) + "", Element.ALIGN_RIGHT, 1, bf8);
                     

                        allFarmSize += rs.getFloat(2);
                        Tresscut += rs.getInt(5);
                    }
                    
                    insertCell(table, "TOTAL FARMS TREATED:         "+manager.totalReports(), Element.ALIGN_CENTER, 2, bfBold12);
                    insertCell(table,  "Total Treated Farm Size:       "+String.format("%.2f", allFarmSize), Element.ALIGN_CENTER, 2, bfBold8);
                    insertCell(table,  "Total Treescut:    "+Tresscut +"", Element.ALIGN_CENTER, 2, bfBold8);
                    //insertCell(table, "        ", Element.ALIGN_CENTER, 3, bfBold8);
                    //insertCell(table, "         ", Element.ALIGN_CENTER, 1, bfBold8);
                    //insertCell(table, "          ", Element.ALIGN_CENTER, 1, bfBold8);
                    //insertCell(table,  "Total Treated Farm Size:       "+String.format("%.2f", allFarmSize), Element.ALIGN_CENTER, 1, bfBold8);
                    
                    
                    

                } //Try ends here
                catch (SQLException ex) {
                    Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
                

        return table;
    }

    public void cretePDF(String name, String rpor) throws FileNotFoundException {

        try {

            //Create document for pdf
            Document doc = new Document();

            //PDF writer to write into document
            PdfWriter docwriter = null;

            DecimalFormat df = new DecimalFormat("0.00");

            try {
                // //file path
                //String path = "docs/" + name;
                docwriter = PdfWriter.getInstance(doc, new FileOutputStream(rpor+".pdf"));
            } catch (DocumentException ex) {
                Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
            }

            //document header attributes
            doc.addAuthor("CHED CU");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("Grant Monitor");
            doc.addTitle(rpor);
            doc.setPageSize(PageSize.A4.rotate());      //This sets page size to A4 and orientation to Landscape
            //doc.setPageSize(PageSize.A4);
            doc.setMargins(30f, 30f, 20f, 20f);

            //open document
            doc.open();

            //Creating a paragraphs and chunks
            Paragraph pp = new Paragraph("Cocoa Health And Extension", forTitle);
            pp.setAlignment(Element.ALIGN_CENTER);

            Paragraph palaglapgh = new Paragraph("(Cocobod)", bfBold12);
            palaglapgh.setAlignment(Element.ALIGN_CENTER);

            Chunk chk = new Chunk("From GIS Office, Accra", bfBold12);
            chk.setUnderline(.1f, -2f);     // 0.1 thickness and -2 position
            Paragraph underText = new Paragraph(chk);
            underText.setAlignment(Element.ALIGN_CENTER);

            Chunk chuk1 = new Chunk("Lot No:", bfBold12);
            chuk1.setUnderline(.1f, -2f);
            Chunk chuk2 = new Chunk(name, bfBold12);

            Paragraph regionText = new Paragraph(rpor, bfBold12);
            regionText.setAlignment(Element.ALIGN_CENTER);
             String rporx = "";
//            ResultSet dir = manager.PDFdemos(name);
//            try {
//                if (dir.next()) {
//                    rporx = dir.getString(12);
//
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
//            }

            Paragraph regionTexts = new Paragraph(rporx, bfBold12);
            regionText.setAlignment(Element.ALIGN_CENTER);
            //add the PDF table to the paragraph
            //palaglapgh.add(table);
            //Table Generation block
            regionText.add(reports());

            //SECTION TO ADD ELEMENTS TO PDF
            // add the paragraph to the document
            doc.add(pp);
            //doc.add(Chunk.NEWLINE);       //Adds a new blank line
            doc.add(palaglapgh);
            doc.add(underText);

            doc.add(chuk1);
            doc.add(chuk2);

            //Current Date and time insertion
            Paragraph newDate = new Paragraph(new Date().toString(), bf12);
            newDate.setAlignment(Element.ALIGN_RIGHT);
            doc.add(newDate);
            doc.add(regionTexts);
            doc.add(regionText);
            

            //close the document
            doc.close();

            //close the writer
            docwriter.close();

        } catch (DocumentException ex) {
            Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));

        //set the cell alignment
        cell.setHorizontalAlignment(align);

        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);

        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

    public static void main(String[] args) {

        PDFDemo demo = new PDFDemo();

        try {
        demo.cretePDF("________","TR_Report");
         } catch (FileNotFoundException ex) {
           Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
//        
//        FarmerManager man = new FarmerManager();
//         ArrayList<Farmer> allB = man.GetFarmers();
//         
//         for( Farmer t : allB){
//             
//             System.out.println(t.getFarmerSName());
//             
//             
//         }
//         
    }

}

package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.FarmerManager;
import Models.Farmer;
import Models.Farms;
import Utility.PDFDemo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author audax
 */
public class ReportsServlet extends HttpServlet {

    FarmerManager manager;
    ArrayList<Farmer> allF;
    Farms farm;

    //special font sizes
    Font bfBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
    Font bf12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
    Font forTitle = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
    Font forTitle2 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
    Font bf8 = new Font(Font.FontFamily.TIMES_ROMAN, 10);
    Font bf8small = new Font(Font.FontFamily.TIMES_ROMAN, 8);
    Font bfBold8 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, new BaseColor(0, 0, 0));
    Font bfBold8small = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, new BaseColor(0, 0, 0));

    //Float for Borders
    float borderA[];
    float borderB[];

    //borderA = new float[]{3f,0f,3f,0f}     //This is why you use inside the table,
    //It goes {left,right,top,bottom}
    //Date
    Date today = new Date();

    //formatting date in Java using SimpleDateFormat
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    String date = DATE_FORMAT.format(today);

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        manager = new FarmerManager();

        allF = new ArrayList<>();

        allF = manager.GetFarmers();

    }

    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));

        //set the cell alignment
        cell.setHorizontalAlignment(align);

        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);

        //Set padding
        cell.setPadding(3f);

        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

    //Insert Borders into cells method
    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font, float bord[]) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));

        //set the cell alignment
        cell.setHorizontalAlignment(align);

        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);

        //Set padding
        cell.setPadding(3f);

        //Setting cell Borders
        // cell.setBorderWidth(3f);         // sets border width to 3 units
        cell.setBorderWidthLeft(bord[0]);
        cell.setBorderWidthRight(bord[1]);
        cell.setBorderWidthTop(bord[2]);
        cell.setBorderWidthBottom(bord[3]);

        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

    //This inserts 2 different feilds in a cell
    private void insertCell(PdfPTable table, String text, String text2, int align, int colspan, Font font, Font font2) {

        Phrase fText = new Phrase(text + "\n", font);

        Phrase sText = new Phrase(text2, font2);

        Paragraph cellPara = new Paragraph();
        cellPara.add(fText);
        cellPara.add(sText);
        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(cellPara);

        //set the cell alignment
        cell.setHorizontalAlignment(align);

        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);

        //Set padding
        cell.setPadding(3f);

        //in case there is no text and you wan to create an empty row
//        if (text.trim().equalsIgnoreCase("")||text2.trim().equalsIgnoreCase("")) {
//            cell.setMinimumHeight(10f);
//        }
        //add the call to the table
        table.addCell(cell);

    }

    //This inserts 2 different feilds in a cell with bordrs too
    private void insertCell(PdfPTable table, String text, String text2, int align, int colspan, Font font, Font font2, float bord[]) {

        Phrase fText = new Phrase(text + "\n", font);

        Phrase sText = new Phrase(text2, font2);

        Paragraph cellPara = new Paragraph();
        cellPara.add(fText);
        cellPara.add(sText);
        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(cellPara);

        //set the cell alignment
        cell.setHorizontalAlignment(align);

        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);

        //Set padding
        cell.setPadding(3f);

        //Setting cell Borders
        // cell.setBorderWidth(3f);         // sets border width to 3 units
        cell.setBorderWidthLeft(bord[0]);
        cell.setBorderWidthRight(bord[1]);
        cell.setBorderWidthTop(bord[2]);
        cell.setBorderWidthBottom(bord[3]);

        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

    public PdfPTable reports(String lotnum, String reportName, float cSize) {
        //specify column widths
        float[] columnWidths = {.12f, .14f, .18f, .25f, .08f, .1f, .1f, .1f, .15f, cSize};

        //create PDF table with the given widths
        PdfPTable table = new PdfPTable(columnWidths);
            //PdfPTable table = new PdfPTable(10);

        // set table width a percentage of the page width
        table.setWidthPercentage(100f);

        switch (reportName) {

            case "IT Report":

                try {

                    /*
            
                     IT REPORT GENERATION BLOCK
            
                     */
                    //insert column headings
                    insertCell(table, "IT GP No", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "TR No and IT Date", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Farmer's Name\n and ID", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Farm Ref No.\n (New and Old)", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Farm Size", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Trees Cut ", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Expected Trees ", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Treated Area", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "IT Grant Payable", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Remarks", Element.ALIGN_CENTER, 1, bfBold8);

                    table.setHeaderRows(1);

                    ResultSet rs = manager.PDFdemos(lotnum);
                    float totalFarmsSize = 0;
                    int totalTreesCut = 0;
                    int totalExpectedTrees = 0;
                    float totalTreatedArea = 0;
                    float totalITGrantPayabe = 0;
                    //Populating Feilds            
                    while (rs.next()) {

                        insertCell(table, rs.getString(7), Element.ALIGN_RIGHT, 1, bfBold8);
                        insertCell(table, rs.getString(8), rs.getDate(9) + "", Element.ALIGN_LEFT, 1, bfBold8, bf8);
                        insertCell(table, rs.getString(5), rs.getString(6), Element.ALIGN_LEFT, 1, bfBold8small, bf8);
                        insertCell(table, rs.getString(1), rs.getString(11), Element.ALIGN_LEFT, 1, bfBold8, bf8);
                        insertCell(table, String.format("%.2f", rs.getFloat(2)) + "", Element.ALIGN_RIGHT, 1, bf8);
                        insertCell(table, rs.getInt(3) + "", Element.ALIGN_LEFT, 1, bf8);
                        int itExpectedTrees = (int) (rs.getFloat(4) * 1100);
                        insertCell(table, itExpectedTrees + "", Element.ALIGN_LEFT, 1, bf8);
                        insertCell(table, String.format("%.2f", rs.getFloat(4)) + "", Element.ALIGN_RIGHT, 1, bf8);
                        insertCell(table, String.format("%.2f", rs.getFloat(10)) + "", Element.ALIGN_LEFT, 1, bf8);
                        insertCell(table, "                  ", Element.ALIGN_RIGHT, 1, bf8);

                        totalFarmsSize = totalFarmsSize + rs.getFloat(2);
                        totalTreesCut = totalTreesCut + rs.getInt(3);
                        totalExpectedTrees = totalExpectedTrees + itExpectedTrees;
                        totalTreatedArea = totalTreatedArea + rs.getFloat(4);
                        totalITGrantPayabe = totalITGrantPayabe + rs.getFloat(10);

                    }

                    insertCell(table, manager.totalFarms(lotnum) + " treated farms                                        Totals", Element.ALIGN_RIGHT, 4, bfBold8);

                    insertCell(table, String.format("%.2f", totalFarmsSize) + "", Element.ALIGN_RIGHT, 1, bfBold8);
                    insertCell(table, totalTreesCut + "", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, totalExpectedTrees + "", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, String.format("%.2f", totalTreatedArea) + "", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, String.format("%.2f", totalITGrantPayabe) + "", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "                  ", Element.ALIGN_CENTER, 1, bfBold8);
                } //Try ends here
                catch (SQLException ex) {
                    Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "TR Report":

                try {

                    /*
            
                     TR REPORT GENERATION BLOCK
            
                     */
                    //insert column headings
                    insertCell(table, "IT GP No", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "TR No and IT Date", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Farmer's Name", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Farm Ref No.\n (New and Old)", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Farm Size", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Trees Cut ", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, "Expected Trees ", Element.ALIGN_CENTER, 1, bfBold8small);
                    insertCell(table, "Estimated Trees", Element.ALIGN_CENTER, 1, bfBold8small);
                    insertCell(table, "Treated Area", Element.ALIGN_CENTER, 1, bfBold8small);
                    insertCell(table, "TR Payable", Element.ALIGN_CENTER, 1, bfBold8small);

                    table.setHeaderRows(1);

                    ResultSet rs = manager.TRReportPDF(lotnum);

                    float totalFarmsSize = 0;
                    int totalTreesCut = 0;
                    int totalExpectedTrees = 0;
                    float totalTreatedArea = 0;
                    float totalITGrantPayabe = 0;
                    int totalEstimated = 0;

                    //Populating Feilds            
                    while (rs.next()) {

                        insertCell(table, rs.getString(7), Element.ALIGN_LEFT, 1, bf8);
                        insertCell(table, rs.getString(8), rs.getDate(9) + "", Element.ALIGN_LEFT, 1, bfBold8, bf8);
                        insertCell(table, rs.getString(6), Element.ALIGN_LEFT, 1, bfBold8small);
                        insertCell(table, rs.getString(1), rs.getString(11), Element.ALIGN_LEFT, 1, bfBold8small, bf8);

                        insertCell(table, String.format("%.2f", rs.getFloat(2)) + "", Element.ALIGN_RIGHT, 1, bf8);
                        insertCell(table, rs.getInt(3) + "", Element.ALIGN_LEFT, 1, bf8);
                        int trExpected = (int) (rs.getFloat(4) * 1100);
                        insertCell(table, trExpected + "", Element.ALIGN_LEFT, 1, bf8);
                        insertCell(table, rs.getInt(5) + "", Element.ALIGN_RIGHT, 1, bf8);
                        insertCell(table, String.format("%.2f", rs.getFloat(4)) + "", Element.ALIGN_LEFT, 1, bf8);
                        insertCell(table, String.format("%.2f", rs.getFloat(10)) + "", Element.ALIGN_RIGHT, 1, bf8);

                        totalFarmsSize += rs.getFloat(2);
                        totalTreesCut += rs.getInt(3);
                        totalExpectedTrees += trExpected;
                        totalEstimated += rs.getInt(5);
                        totalTreatedArea += rs.getFloat(4);
                        totalITGrantPayabe += rs.getFloat(10);

                    }

                    insertCell(table, manager.totalFarms(lotnum) + " treated farms                                        Totals", Element.ALIGN_RIGHT, 4, bfBold8);

                    insertCell(table, String.format("%.2f", totalFarmsSize) + "", Element.ALIGN_RIGHT, 1, bfBold8);
                    insertCell(table, totalTreesCut + "", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, totalExpectedTrees + "", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, totalEstimated + "", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, totalTreatedArea + "", Element.ALIGN_CENTER, 1, bfBold8);
                    insertCell(table, String.format("%.2f", totalITGrantPayabe) + "", Element.ALIGN_CENTER, 1, bfBold8small);

                } //Try ends here
                catch (SQLException ex) {
                    Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "RP Report":

                break;
            case "Rehab Report":

                break;
            default:
                break;
            //Switch ends here
        }

        return table;
    }

    public PdfPTable reports(String rehLot) {
        //specify column widths
        float[] columnWidths = {.2f, .18f, .2f, .4f, .3f,.2f, .2f, .2f, .2f, .15f, .2f};

        //create PDF table with the given widths
        PdfPTable table = new PdfPTable(columnWidths);
            //PdfPTable table = new PdfPTable(10);

        // set table width a percentage of the page width
        table.setWidthPercentage(100f);

        try {

            //insert column headings
            insertCell(table, "TR Voucher No", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "TR Date", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "Farmer's Name", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "Farm number", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "Contractor ", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "Farmer's Size", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "Cocoa Condition", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "Treated Area", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "No of Trees Cut", Element.ALIGN_LEFT, 1, bfBold8);

            insertCell(table, "Exp Trees", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, "TR Payable", Element.ALIGN_LEFT, 1, bfBold8);
            table.setHeaderRows(1);

            //Merge cells to input title ie. Region names
            // insertCell(table, "Bawdua", Element.ALIGN_CENTER, 10, bfBold12);
            ResultSet rs = manager.PDFRehab(rehLot);

            float totalFarmSizeReh = 0;
            float totalTreatedAreaReh = 0;
            float totalTRpayableReh = 0;
            int totalExpectedTreesReh = 0;
            int totalNumberOfTrees = 0;
            
            
            while (rs.next()) {
                try {
                    insertCell(table, rs.getString(6), Element.ALIGN_LEFT, 1, bf8);
                    insertCell(table, rs.getString(18), Element.ALIGN_LEFT, 1, bf8);
                    insertCell(table, rs.getString(4) + "", Element.ALIGN_LEFT, 1, bf8);
                    insertCell(table, rs.getString(1), rs.getString(13), Element.ALIGN_LEFT, 1, bfBold8, bf8);
                    insertCell(table, rs.getString(15), Element.ALIGN_RIGHT, 1, bf8);
                    insertCell(table, rs.getFloat(7) + "", Element.ALIGN_RIGHT, 1, bf8);
                    insertCell(table, rs.getString(17), rs.getString(16), Element.ALIGN_LEFT, 1, bfBold8, bf8);
                    insertCell(table, rs.getFloat(8) + "", Element.ALIGN_RIGHT, 1, bf8);
                    insertCell(table, rs.getInt(11) + "", Element.ALIGN_LEFT, 1, bf8);
                    int Rehab_trExpected = (int) (rs.getFloat(7) * 1100);
                    insertCell(table, Rehab_trExpected + "", Element.ALIGN_RIGHT, 1, bf8);
                    insertCell(table, rs.getFloat(20)+"", Element.ALIGN_LEFT, 1, bf8);
                    
                    totalFarmSizeReh += rs.getFloat(7);
                    totalTRpayableReh += rs.getFloat(20);
                    totalTreatedAreaReh += rs.getFloat(8);
                    totalNumberOfTrees += rs.getInt(11);
                    totalExpectedTreesReh += Rehab_trExpected;

                } catch (SQLException ex) {
                    Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            insertCell(table,"Total Farms in the Region                      " +manager.allRehabFarms(rehLot), Element.ALIGN_LEFT, 4, bfBold8);
//            insertCell(table, rs.getString(18), Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, rs.getString(4) + "", Element.ALIGN_LEFT, 1, bf8);
            insertCell(table, "TOTALS", Element.ALIGN_LEFT, 1, bfBold8);

            insertCell(table,String.format("%.2f", totalFarmSizeReh), Element.ALIGN_RIGHT, 1, bfBold8);
            insertCell(table, " ", Element.ALIGN_LEFT, 1, bfBold8);
            insertCell(table, String.format("%.2f", totalTreatedAreaReh), Element.ALIGN_RIGHT, 1, bfBold8);
            insertCell(table, totalNumberOfTrees+"", Element.ALIGN_LEFT, 1, bfBold8);
            
            insertCell(table, ""+totalExpectedTreesReh, Element.ALIGN_RIGHT, 1, bfBold8);
            insertCell(table, String.format("%.2f", totalTRpayableReh), Element.ALIGN_LEFT, 1, bfBold8);
            
            
            
            
            
            
            //Merge cells for Contractor area
//            insertCell(table, "Details of Tree Removal in favour of Contractor:                                  "
//                    + "Omenaaba Company Limited", Element.ALIGN_LEFT, 6, bfBold8);
//
//            //Dummy data
//            insertCell(table, "10010", Element.ALIGN_RIGHT, 1, bf8);
//            insertCell(table, "ABC00", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//
//            //Merge cells for District Total
//            insertCell(table, "District Total", Element.ALIGN_LEFT, 4, bfBold8);
//
//            //Dummy data
//            insertCell(table, "10010", Element.ALIGN_RIGHT, 1, bf8);
//            insertCell(table, "      ", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//
//            //Merge cells for Region Total
//            insertCell(table, "Region Total", Element.ALIGN_LEFT, 4, bfBold8);
//
//            //Dummy data
//            insertCell(table, "10010", Element.ALIGN_RIGHT, 1, bf8);
//            insertCell(table, "      ", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
//            insertCell(table, "C00", Element.ALIGN_LEFT, 1, bf8);
        } catch (SQLException ex) {
            Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return table;
    }

    public PdfPTable RPreport(String lotnum) {
        //specify column widths
        float[] columnWidths = {.18f, .18f, .25f, .27f, .1f, .1f, .12f,
            .1f, .15f, .1f, .1f, .1f, .1f, .1f, .1f, .1f, .15f};

        //create PDF table with the given widths
        PdfPTable table = new PdfPTable(columnWidths);
            //PdfPTable table = new PdfPTable(10);

        // set table width a percentage of the page width
        table.setWidthPercentage(100f);

        try {

            /*
            
             Replanting REPORT GENERATION BLOCK
            
             */
            //insert column headings
            insertCell(table, "RP GP No\nand RP Date", Element.ALIGN_CENTER, 1, bfBold8);
            insertCell(table, "IT No \nand IT Date", Element.ALIGN_CENTER, 1, bfBold8);
            insertCell(table, "Farmer's Name\n and ID", Element.ALIGN_CENTER, 1, bfBold8);
            insertCell(table, "Farm Ref No.\n (New and Old)", Element.ALIGN_CENTER, 1, bfBold8);
            insertCell(table, "Farm Size", Element.ALIGN_CENTER, 1, bfBold8);
            insertCell(table, "Treated Area ", Element.ALIGN_CENTER, 1, bfBold8small);
            insertCell(table, "IT Grant Paid", Element.ALIGN_CENTER, 1, bfBold8small);
            insertCell(table, "Area Repl", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{3f, .1f, .1f, .1f});
            insertCell(table, "Gross RP", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});

            insertCell(table, "Seeds\nQty Prev Purch", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, "Seeds\nQty Supl Free", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, "Fert\nQty Alloc(Bags)", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, "Fert\nQty Purch", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, "Deduc's\nCost of Seed", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, "Deduc's\nCost of Fert Alloc", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, "Deduc's\nTotal Deduct", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, "Net RP Payable", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, 3f, .1f, .1f});

            table.setHeaderRows(1);

            ResultSet rs = manager.PDFreplants(lotnum);
            float totalFsize = 0;
            float totalTarea = 0;
            float totalITPay = 0;
            float totalAreaRpl = 0;
            float totalGross = 0;
            int totalQpp = 0;
            int totalQsp = 0;
            int totalQsf = 0;
            int totalQalloc = 0;
            int totalQpurchase = 0;
            float totalCostSeed = 0;
            float totalCostFert = 0;
            float totalDeduct = 0;
            float totalNet = 0;
            //Populating Feilds            
            while (rs.next()) {

                insertCell(table, rs.getString(10), rs.getString(11), Element.ALIGN_LEFT, 1, bfBold8, bf8);
                insertCell(table, rs.getString(7) + "\n" + rs.getString(8), Element.ALIGN_LEFT, 1, bf8);
                insertCell(table, rs.getString(5), rs.getString(6), Element.ALIGN_LEFT, 1, bfBold8small, bf8);
                insertCell(table, rs.getString(1), rs.getString(2), Element.ALIGN_LEFT, 1, bfBold8small, bf8);
                insertCell(table, rs.getFloat(3) + "", Element.ALIGN_LEFT, 1, bf8);
                insertCell(table, rs.getFloat(4) + "", Element.ALIGN_CENTER, 1, bf8);
                insertCell(table, rs.getFloat(9) + "", Element.ALIGN_CENTER, 1, bf8);

                insertCell(table, rs.getFloat(12) + "", Element.ALIGN_CENTER, 1, bf8, borderA = new float[]{3f, .1f, .1f, .1f});
                insertCell(table, rs.getFloat(15) + "", Element.ALIGN_CENTER, 1, bf8);

                insertCell(table, rs.getInt(19) + "", Element.ALIGN_CENTER, 1, bf8);
                insertCell(table, rs.getInt(13) + "", Element.ALIGN_CENTER, 1, bf8);
                insertCell(table, rs.getInt(20) + "", Element.ALIGN_CENTER, 1, bf8);
                insertCell(table, rs.getInt(18) + "", Element.ALIGN_CENTER, 1, bf8);
                insertCell(table, rs.getFloat(21) + "", Element.ALIGN_CENTER, 1, bf8);
                insertCell(table, rs.getFloat(14) + "", Element.ALIGN_CENTER, 1, bf8);
                insertCell(table, rs.getFloat(16) + "", Element.ALIGN_CENTER, 1, bf8);
                insertCell(table, rs.getFloat(17) + "", Element.ALIGN_CENTER, 1, bf8, borderB = new float[]{.1f, 3f, .1f, .1f});

                totalFsize = totalFsize + rs.getFloat(3);
                totalTarea = totalTarea + rs.getFloat(4);
                totalITPay = totalITPay + rs.getFloat(9);
                totalAreaRpl = totalAreaRpl + rs.getFloat(12);
                totalGross = totalGross + rs.getFloat(15);
                totalQpp = totalQpp + rs.getInt(19);
                totalQsf = totalQsf + rs.getInt(13);
                totalQalloc = totalQalloc + rs.getInt(14);
                totalQpurchase = totalQpurchase + rs.getInt(18);
                totalCostSeed = totalCostSeed + rs.getFloat(21);
                totalCostFert = totalCostFert + rs.getFloat(20);
                totalDeduct = totalDeduct + rs.getFloat(16);
                totalNet = totalNet + rs.getFloat(17);

            }

            //Totals
            insertCell(table, manager.totalFarmsReplant(lotnum) + " Replanted Farms                                                Totals", Element.ALIGN_RIGHT, 4, bfBold8);
            insertCell(table, String.format("%.2f", totalFsize) + "", Element.ALIGN_CENTER, 1, bfBold8);
            insertCell(table, String.format("%.2f", totalTarea) + "", Element.ALIGN_CENTER, 1, bfBold8small);
            insertCell(table, String.format("%.2f", totalITPay) + "", Element.ALIGN_CENTER, 1, bfBold8small);
            insertCell(table, String.format("%.2f", totalAreaRpl) + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{3f, .1f, .1f, .1f});
            insertCell(table, String.format("%.2f", totalGross) + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});

            insertCell(table, totalQpp + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, totalQsf + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, totalCostFert + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, totalQpurchase + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, totalCostSeed + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, totalQalloc + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, totalDeduct + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, .1f, .1f, .1f});
            insertCell(table, String.format("%.2f", totalNet) + "", Element.ALIGN_CENTER, 1, bfBold8small, borderA = new float[]{.1f, 3f, 3f, .1f});

        } //Try ends here
        catch (SQLException ex) {
            Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return table;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Paragraph pp;
            Paragraph palaglapgh, signParagraph, dateParagrapgh;
            Chunk chk;
            Paragraph underText;
            Chunk chuk1;
            Chunk chuk2;
            Paragraph regionText;
            String x;
            ResultSet dir;
            Paragraph regionTexts;
            String repLot;
            repLot = request.getParameter("report");

            String repNum = request.getParameter("ITLot");
            Paragraph newDate;
            response.setContentType("application/pdf");
            OutputStream out = response.getOutputStream();

            //Create document for pdf
            Document doc = new Document();

            //PDF writer to write into document
            PdfWriter docwriter = null;

            DecimalFormat df = new DecimalFormat("0.00");

            switch (repLot) {
                default:

                    break;
                case "IT Report":

                    //Copied code start from here
                    try {
                        // //file path
                        //String path = "docs/" + "Name";
                        docwriter = PdfWriter.getInstance(doc, out);
                    } catch (DocumentException ex) {
                        Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //document header attributes
                    doc.addAuthor("CHED CU");
                    doc.addCreationDate();
                    doc.addProducer();
                    doc.addCreator("Grant Monitor");
                    doc.addTitle(repLot);
                    doc.setPageSize(PageSize.A4.rotate());      //This sets page size to A4 and orientation to Landscape
                    //doc.setPageSize(PageSize.A4);
                    doc.setMargins(20f, 20f, 10f, 10f);

                    //open document
                    doc.open();

                    //Creating a paragraphs and chunks
                    pp = new Paragraph("Cocoa Health And Extension Division", forTitle);
                    pp.setAlignment(Element.ALIGN_CENTER);

                    palaglapgh = new Paragraph("(Cocobod)", bfBold12);
                    palaglapgh.setAlignment(Element.ALIGN_CENTER);

                    signParagraph = new Paragraph("Sign: ..............", bfBold12);
                    signParagraph.setAlignment(Element.ALIGN_LEFT);

                    dateParagrapgh = new Paragraph("Date: ...........", bfBold12);

                    chk = new Chunk("From GIS Office, Accra", bfBold12);
                    chk.setUnderline(.1f, -2f);     // 0.1 thickness and -2 position
                    underText = new Paragraph(chk);
                    underText.setAlignment(Element.ALIGN_CENTER);

                    chuk1 = new Chunk("Lot No:", forTitle2);
                    chuk1.setUnderline(.1f, -2f);
                    chuk2 = new Chunk(repNum.toUpperCase(), forTitle2);

                    regionText = new Paragraph(repLot, forTitle2);
                    regionText.setAlignment(Element.ALIGN_CENTER);
                    x = "";
                    dir = manager.PDFdemos(repNum);
                    try {
                        if (dir.next()) {
                            x = dir.getString(12);

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    regionTexts = new Paragraph(x, forTitle2);
                    regionText.setAlignment(Element.ALIGN_CENTER);
                    //add the PDF table to the paragraph
                    //palaglapgh.add(table);
                    //Table Generation block
                    regionText.add(reports(repNum, repLot, .25f));

                    //SECTION TO ADD ELEMENTS TO PDF
                    // add the paragraph to the document
                    doc.add(pp);
                    //doc.add(Chunk.NEWLINE);       //Adds a new blank line
                    doc.add(palaglapgh);
                    doc.add(underText);

                    doc.add(chuk1);
                    doc.add(chuk2);

                    //Current Date and time insertion
                    newDate = new Paragraph(date, bf12);
                    newDate.setAlignment(Element.ALIGN_RIGHT);
                    doc.add(newDate);
                    doc.add(regionTexts);
                    doc.add(regionText);

                    doc.add(Chunk.NEWLINE);       //Adds a new blank line
                    doc.add(Chunk.NEWLINE);

                    doc.add(signParagraph);
                    doc.add(dateParagrapgh);

                    //close the document
                    doc.close();

                    //close the writer
                    docwriter.close();

                    out.close();

                    break;

                case "TR Report":

                    //Copied code start from here
                    try {
                        // //file path
                        //String path = "docs/" + "Name";
                        docwriter = PdfWriter.getInstance(doc, out);
                    } catch (DocumentException ex) {
                        Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //document header attributes
                    doc.addAuthor("CHED CU");
                    doc.addCreationDate();
                    doc.addProducer();
                    doc.addCreator("Grant Monitor");
                    doc.addTitle(repLot);
                    //doc.setPageSize(PageSize.A4.rotate());      //This sets page size to A4 and orientation to Landscape
                    doc.setPageSize(PageSize.A4);
                    doc.setMargins(30f, 30f, 20f, 20f);

                    //open document
                    doc.open();

                    //Creating a paragraphs and chunks
                    pp = new Paragraph("Cocoa Health And Extension Division", forTitle);
                    pp.setAlignment(Element.ALIGN_CENTER);

                    palaglapgh = new Paragraph("(Cocobod)", bfBold12);
                    palaglapgh.setAlignment(Element.ALIGN_CENTER);

                    signParagraph = new Paragraph("Sign: ..............", bfBold12);
                    signParagraph.setAlignment(Element.ALIGN_LEFT);

                    dateParagrapgh = new Paragraph("Date: ...........", bfBold12);

                    chk = new Chunk("From GIS Office, Accra", bfBold12);
                    chk.setUnderline(.1f, -2f);     // 0.1 thickness and -2 position
                    underText = new Paragraph(chk);
                    underText.setAlignment(Element.ALIGN_CENTER);

                    chuk1 = new Chunk("Lot No:", forTitle2);
                    chuk1.setUnderline(.1f, -2f);       // 0.1 thickness and -2 position
                    chuk2 = new Chunk(repNum.toUpperCase(), forTitle2);

                    regionText = new Paragraph(repLot, forTitle2);
                    regionText.setAlignment(Element.ALIGN_CENTER);

                    x = "";
                    dir = manager.PDFdemos(repNum);
                    try {
                        if (dir.next()) {
                            x = dir.getString(12);

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    regionTexts = new Paragraph(x, forTitle2);
                    regionText.setAlignment(Element.ALIGN_CENTER);
                    //add the PDF table to the paragraph
                    //palaglapgh.add(table);
                    //Table Generation block
                    regionText.add(reports(repNum, repLot, .1f));

                    //SECTION TO ADD ELEMENTS TO PDF
                    // add the paragraph to the document
                    doc.add(pp);
                    //doc.add(Chunk.NEWLINE);       //Adds a new blank line
                    doc.add(palaglapgh);
                    doc.add(underText);

                    doc.add(chuk1);
                    doc.add(chuk2);

                    //Current Date and time insertion
                    newDate = new Paragraph(date, bf12);
                    newDate.setAlignment(Element.ALIGN_RIGHT);
                    doc.add(newDate);
                    doc.add(regionTexts);
                    doc.add(regionText);

                    doc.add(Chunk.NEWLINE);       //Adds a new blank line
                    doc.add(Chunk.NEWLINE);

                    doc.add(signParagraph);
                    doc.add(dateParagrapgh);

                    //close the document
                    doc.close();

                    //close the writer
                    docwriter.close();

                    out.close();

                    break;

                case "RP Report":

                    //Copied code start from here
                    try {
                        // //file path
                        //String path = "docs/" + "Name";
                        docwriter = PdfWriter.getInstance(doc, out);
                    } catch (DocumentException ex) {
                        Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //document header attributes
                    doc.addAuthor("CHED CU");
                    doc.addCreationDate();
                    doc.addProducer();
                    doc.addCreator("Grant Monitor");
                    doc.addTitle(repLot);
                    doc.setPageSize(PageSize.A4.rotate());      //This sets page size to A4 and orientation to Landscape
                    //doc.setPageSize(PageSize.A4);
                    doc.setMargins(30f, 30f, 20f, 20f);

                    //open document
                    doc.open();

                    //Creating a paragraphs and chunks
                    pp = new Paragraph("Cocoa Health And Extension Division", forTitle);
                    pp.setAlignment(Element.ALIGN_CENTER);

                    palaglapgh = new Paragraph("(Cocobod)", bfBold12);
                    palaglapgh.setAlignment(Element.ALIGN_CENTER);

                    signParagraph = new Paragraph("Sign: ..............", bfBold12);
                    signParagraph.setAlignment(Element.ALIGN_LEFT);

                    dateParagrapgh = new Paragraph("Date: ...........", bfBold12);

                    chk = new Chunk("From GIS Office, Accra", bfBold12);
                    chk.setUnderline(.1f, -2f);     // 0.1 thickness and -2 position
                    underText = new Paragraph(chk);
                    underText.setAlignment(Element.ALIGN_CENTER);

                    chuk1 = new Chunk("RP Lot No:", forTitle2);
                    chuk1.setUnderline(.1f, -2f);
                    chuk2 = new Chunk(repNum.toUpperCase(), forTitle2);

                    regionText = new Paragraph(repLot, forTitle2);
                    regionText.setAlignment(Element.ALIGN_CENTER);
                    x = "";
                    dir = manager.PDFreplants(repNum);
                    try {
                        if (dir.next()) {
                            x = dir.getString(22);

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    regionTexts = new Paragraph(x, forTitle2);
                    regionText.setAlignment(Element.ALIGN_CENTER);
                    //add the PDF table to the paragraph
                    //palaglapgh.add(table);
                    //Table Generation block
                    regionText.add(RPreport(repNum));

                    //SECTION TO ADD ELEMENTS TO PDF
                    // add the paragraph to the document
                    doc.add(pp);
                    //doc.add(Chunk.NEWLINE);       //Adds a new blank line
                    doc.add(palaglapgh);
                    doc.add(underText);

                    doc.add(chuk1);
                    doc.add(chuk2);

                    //Current Date and time insertion
                    newDate = new Paragraph(date, bf12);
                    newDate.setAlignment(Element.ALIGN_RIGHT);
                    doc.add(newDate);
                    doc.add(regionTexts);
                    doc.add(regionText);

                    doc.add(Chunk.NEWLINE);       //Adds a new blank line
                    doc.add(Chunk.NEWLINE);

                    doc.add(signParagraph);
                    doc.add(dateParagrapgh);

                    //close the document
                    doc.close();

                    //close the writer
                    docwriter.close();

                    out.close();

                    break;

                case "Rehab Report":

                    //Copied code start from here
                    try {
                        // //file path
                        //String path = "docs/" + "Name";
                        docwriter = PdfWriter.getInstance(doc, out);
                    } catch (DocumentException ex) {
                        Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //document header attributes
                    doc.addAuthor("CHED CU");
                    doc.addCreationDate();
                    doc.addProducer();
                    doc.addCreator("Grant Monitor");
                    doc.addTitle(repLot);
                    doc.setPageSize(PageSize.A4.rotate());      //This sets page size to A4 and orientation to Landscape
                    //doc.setPageSize(PageSize.A4);
                    doc.setMargins(5f, 5f, 3f, 3f);

                    //open document
                    doc.open();

                    //Creating a paragraphs and chunks
                    pp = new Paragraph("Cocoa Health And Extension Division", forTitle);
                    pp.setAlignment(Element.ALIGN_CENTER);

                    palaglapgh = new Paragraph("(Cocobod)", bfBold12);
                    palaglapgh.setAlignment(Element.ALIGN_CENTER);

                    signParagraph = new Paragraph("Sign: ..............", bfBold12);
                    signParagraph.setAlignment(Element.ALIGN_LEFT);

                    dateParagrapgh = new Paragraph("Date: ...........", bfBold12);

                    chk = new Chunk("Component 1 Rehabilitation Tree Removal Cost From GIS Office, Accra", bfBold12);
                    chk.setUnderline(.1f, -2f);     // 0.1 thickness and -2 position
                    underText = new Paragraph(chk);
                    underText.setAlignment(Element.ALIGN_CENTER);

                    chuk1 = new Chunk("RP Lot No:", bfBold12);
                    chuk1.setUnderline(.1f, -2f);
                    chuk2 = new Chunk(repNum, bfBold12);

                    regionText = new Paragraph(repLot, forTitle2);
                    regionText.setAlignment(Element.ALIGN_CENTER);
                    x = "";
                    dir = manager.PDFRehab(repNum);//SHOULD BE CHANGED!!!!
                    try {
                        if (dir.next()) {
                            x = dir.getString(21);

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(PDFDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    regionTexts = new Paragraph(x, forTitle2);
                    regionText.setAlignment(Element.ALIGN_CENTER);
                    //add the PDF table to the paragraph
                    //palaglapgh.add(table);
                    //Table Generation block
                    regionText.add(reports(repNum));

                    //SECTION TO ADD ELEMENTS TO PDF
                    // add the paragraph to the document
                    doc.add(pp);
                    //doc.add(Chunk.NEWLINE);       //Adds a new blank line
                    doc.add(palaglapgh);
                    doc.add(underText);

                    doc.add(chuk1);
                    doc.add(chuk2);

                    //Current Date and time insertion
                    newDate = new Paragraph(date, bf12);
                    newDate.setAlignment(Element.ALIGN_RIGHT);
                    doc.add(newDate);
                    doc.add(regionTexts);
                    doc.add(regionText);

                    doc.add(Chunk.NEWLINE);       //Adds a new blank line
                    doc.add(Chunk.NEWLINE);

                    doc.add(signParagraph);
                    doc.add(dateParagrapgh);

                    //close the document
                    doc.close();

                    //close the writer
                    docwriter.close();

                    out.close();

                    //Copied CODES
                    break;

            }

        } catch (DocumentException ex) {
            Logger.getLogger(ReportsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

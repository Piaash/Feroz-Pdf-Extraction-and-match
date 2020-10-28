/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.extraction;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author USER
 */
public class PdfExtraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File file = new File("G://CTG-A.pdf");
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        System.out.println(text);
        System.out.println(text.length());
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        Pattern pattern1 = Pattern.compile("(?<=\\bDebit: CIBTA\\s)(\\D*)(?=\\()");
        Pattern pattern2 = Pattern.compile("(?<=\\bAdvice No: AC\\s)(\\d+)");
        Pattern pattern3 = Pattern.compile("(?<=\\bOriginating Date:\\s)(\\d+)\\/(\\d+)\\/(\\d+)");
        Pattern pattern4 = Pattern.compile("(?:\\d+,)*\\d+\\.\\d+(?=\\s+In Word : Taka)");   
        Matcher match1 = pattern1.matcher(text);
        Matcher match2 = pattern2.matcher(text);
        Matcher match3 = pattern3.matcher(text);
        Matcher match4 = pattern4.matcher(text);
        String test;
        while(match1.find())
        {
            test = match1.group();
            System.out.println(test);
            count1++;
        }
        while(match2.find())
        {
            test = match2.group();
            System.out.println(test);
            count2++;
        }
        while(match3.find())
        {
            test = match3.group();
            System.out.println(test);
            count3++;
        }
        System.out.println("TKTKTKTKTKYKTK");
        while(match4.find())
        {
            test = match4.group();
            System.out.println(test);
            count4++;
        }
       // System.out.println(count1);
        //System.out.println(count2);
        //System.out.println(count3);
        //System.out.println(count4);
        //
    }
    
}

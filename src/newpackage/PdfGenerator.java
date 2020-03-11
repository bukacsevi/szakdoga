/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Vector;

/**
 *
 * @author kicsi
 */
public class PdfGenerator {

    Paragraph cim;
    Paragraph elso;
    Paragraph masodik;
    Paragraph harmadik;
    Paragraph vege;
    Paragraph ft;
    private float osszesen = 0;

    public PdfGenerator(String filenev, Vevő vevo, Vector<Termék> termekek) {
        Document dokumentum = new Document();

        try {
            PdfWriter.getInstance(dokumentum, new FileOutputStream("C:\\Users\\kicsi\\"+filenev+".pdf"));
            dokumentum.open();
            //  Paragraph p = new Paragraph("\t\t\tÁrajáalt", FontFactory.getFont("betutipus", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
           // C:\Users\kicsi\Documents\NetBeansProjects\Ujkinezet
            cim = new Paragraph();
            elso = new Paragraph();
            masodik = new Paragraph();

            cim.setTabSettings(new TabSettings(220f));
            cim.add(Chunk.TABBING);
            cim.add(new Chunk("Árajánlat\n\n\n\n______________________________________________________________________________\n"));

            dokumentum.add(cim);

            elso.add(new Chunk("Ajánlat kiállító adatai:"));
            elso.setTabSettings(new TabSettings(300f));
            elso.add(Chunk.TABBING);

            elso.add(new Chunk("Ajánlatkérő adatai:\n______________________________________________________________________________\n"));
            dokumentum.add(elso);

            masodik.setTabSettings(new TabSettings(300f));

            masodik.add("Kitalalt Proba Kft.");
            masodik.add(Chunk.TABBING);
            masodik.add(new Chunk(vevo.getVezetekNev() + " " + vevo.getKeresztNev() + "\n"));

            masodik.add("1204 Budapest");
            masodik.add(Chunk.TABBING);
            masodik.add(new Chunk(vevo.getVevoCim() + "\n"));

            masodik.add("Valahol utca 88.");
            masodik.add(Chunk.TABBING);
            masodik.add(new Chunk("Telefonszám: " + vevo.getVevoTelefonSzam() + "\n"));

            masodik.add("Adószám: 12345678");
            masodik.add(Chunk.TABBING);
            masodik.add(new Chunk("E-mail:" + vevo.getVevoEmailCim() + "\n"));

            masodik.add("Telefonszám: +36 30 123 34 56\n");
            masodik.add("E-mail: kitalaltprobakft@gmail.com\n______________________________________________________________________________\n");

            dokumentum.add(masodik);

            harmadik = new Paragraph();
            harmadik.setTabSettings(new TabSettings(110f));

            harmadik.add(new Chunk("Cikkszám"));
            harmadik.add(Chunk.TABBING);

            harmadik.add(new Chunk("Megnevezés"));
            harmadik.add(Chunk.TABBING);

            harmadik.add(new Chunk("Mennyiség"));
            harmadik.add(Chunk.TABBING);

            harmadik.add(new Chunk("Nettó ár"));
            harmadik.add(Chunk.TABBING);

            harmadik.add(new Chunk("Bruttó ár"));

            harmadik.add(Chunk.NEWLINE);

            dokumentum.add(harmadik);

            for (int i = 0; i < termekek.size(); i++) {
                harmadik = new Paragraph();
                harmadik.setTabSettings(new TabSettings(110f));                

                Termék termek = (Termék) termekek.get(i);

                harmadik.add(new Chunk(termek.getCikkszam()));
                harmadik.add(Chunk.TABBING);

                harmadik.add(new Chunk(termek.getMegnevezes()));
                harmadik.add(Chunk.TABBING);

                harmadik.add(new Chunk(String.valueOf(termek.getRendeltMennyiseg())));
                harmadik.add(Chunk.TABBING);

                harmadik.add(new Chunk(String.valueOf(termek.getAr()))); //nettoar
                harmadik.add(Chunk.TABBING);           
                                                 
                harmadik.add(new Chunk(String.valueOf(termek.getAr() * 1.27))); //brutto ar
                harmadik.add(Chunk.TABBING);  

                harmadik.add(Chunk.NEWLINE);
                dokumentum.add(harmadik);
                
                osszesen = osszesen + (float) (termek.getAr() * 1.27);
            }
            vege = new Paragraph();
            vege.add("______________________________________________________________________________\n");

            vege.setTabSettings(new TabSettings(440f));
            vege.add(Chunk.TABBING);
            vege.add(new Chunk(String.valueOf(osszesen) + " Ft"));
            dokumentum.add(vege);

        } catch (Exception e) {

        }
        dokumentum.close();
    }

}

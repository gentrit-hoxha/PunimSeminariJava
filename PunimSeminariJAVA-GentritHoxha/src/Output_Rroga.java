import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.text.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.Color;

/** Klase view e cila sherben per vizualizimin e te dhenave ne nje dritare 
* JFrame duke perdorur klasen Input_Rroga dhe Modeli_Rroges */

public class Output_Rroga  extends JPanel
{     

   //Krijimi i bojektit te nje klases Input_Rroga 
    Input_Rroga hyrja = new Input_Rroga(); 
  
   /* Ketu kemi krijuar nje objekt te klases Modeli_Rroges 
     i cili inicializohet me vlera te Input_Rroga  */
   Modeli_Rroges model = hyrja.model;
     
   public Output_Rroga (){
      
     //Inicializimi i madhesive te kornizes
      model.gjeresia = 1000;
      model.lartesia = 700;
   
     //metodat te cilat kontrollojne kushtet per rroge,takse, dhe pension
      model.llogaritja_rroges();
      model.taksa_dhe_pensioni();
      
      //krijimi i nje dritare JFrame dhe vendosja grafike nga paintComponent
      JFrame obj = new JFrame();
      obj.setSize(model.gjeresia,model.lartesia);
      obj.setTitle("Punim Seminari ne JAVA - Llogaritja e pages javore");
      obj.setVisible(true);
      obj.getContentPane().add(this);
   }  
     
   
   //metode e cila permban gjithe permbajten e nevojshme per shfaqjen e te dhenave 
   public void paintComponent(Graphics g)
   {
       
      //Krijimi i nje objekti te DateTimeFormatter pe te marre kohen sipas vitit muajit dites ores minutit e sekondit  
      DateTimeFormatter c = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");  
      LocalDateTime now = LocalDateTime.now();
      
      //DecimalFormat per ta ndryshuar presjen dhjetore
      DecimalFormat formatter = new DecimalFormat("0.00");
         
      //dimensionet e panelit
      model.gjeresia = 985;
      model.lartesia = 662;
     
                 
      g.setColor(Color.black);
      g.fillRect(0, 0, model.gjeresia, model.lartesia);
         
      g.setColor(new Color(230,230,250));
      g.fillRect(10, 10 , model.gjeresia-20, model.lartesia-20);  
        
      g.setColor(Color.black);
      g.setFont(new Font("Segoe UI Black", Font.BOLD,40));
      g.drawString("Tabela e pages Javore", 250,50);
         
      g.setFont(new Font("Aharoni",Font.BOLD,24));
        
          
      g.drawString("Emri :         " + model.emri,40,90);
      g.drawString("Mbiemri :   " + model.mbiemri, 40,120);
      g.drawString("Pozita :      " + model.pozita, 40,150);
        
      //Ndryshimi i fontit dhe madhesia 
      g.setFont(new Font("Century Gothic",Font.BOLD,20));
      //Koha dhe data e shfaqur
      g.drawString((c.format(now)),750,100);
         
      //Ndryshimi i fontit dhe madhesia   
      g.setFont(new Font("Century Gothic",Font.BOLD,20));
      g.drawString("- Ora e Regullt: " + model.paga_rregullt +"€",40,180);
      g.drawString("- Ora Shtese: " + model.paga_rregullt*1.5 + "€",40,200);
         
         
      g.drawString("- Brenda Orarit: " + ((model.ora_rregullt)-(model.ora_shtese)) + " ore ",40,225);
      g.drawString("- Jashte Orarit: " + model.ora_shtese + " ore ",40,245);
         
      g.drawString("- Brenda orarit: " + ((model.ora_rregullt)-(model.ora_shtese)) + "*" + model.paga_rregullt + "€ = " +   model.rroga_rregullt + "€" ,40,270);
      g.drawString("- Jashte orarit: " + model.ora_shtese + "*" + ((model.paga_rregullt)*1.5) + "€ = "+ model.rroga_shtese + "€" ,40,290);
      
      //Ndryshimi i fontit dhe madhesia   
      g.setFont(new Font("Segoe UI Black",Font.BOLD,25));
      g.drawString("BRUTO: " + model.totali + "€" ,50,330);
         
      //Ndryshimi i fontit dhe madhesia  
      g.setFont(new Font("Centhury Gothic",Font.BOLD,20));
      g.drawString("Taksa 20% (0-30 ore) = " + formatter.format(model.taksa1) + "€",70,370);
      g.drawString("Taksa 25% (30-40 ore) = " + formatter.format(model.taksa2) + "€",70,390);
      g.drawString("Taksa 28% (>40 ore)= " + formatter.format(model.taksa3) + "€",70,410);
      g.drawString("Kontributi Pensional = " + formatter.format(model.pensioni) + "€",70,430);
      
      //Ndryshimi i fontit dhe madhesia
      g.setFont(new Font("Sans Serif Plain",Font.BOLD,22));
      g.drawString("Pensioni dhe Taksa = " + model.pensioni + "+" + formatter.format(model.taksa1+model.taksa2 + model.taksa3) + "=" + formatter.format( model.pensioni+model.taksa1+model.taksa2 + model.taksa3)+"€",70,455);
           
      g.setFont(new Font("Segoe UI Black",Font.BOLD,25));
      g.drawString("NETO: " + formatter.format(model.totali) + "€ - " + formatter.format( model.pensioni+model.taksa1+model.taksa2 + model.taksa3) + "=" + formatter.format(model.totali - (model.pensioni+model.taksa1+model.taksa2 + model.taksa3) ) ,50,485);
         
      // Neshkrimi i Pageses nga menaxheri fonti dhe madhesia e fontit 
      g.drawLine(40, 550, 290, 550);
      g.setFont(new Font("Century Gothic",Font.BOLD,20));
      g.drawString("Nenshkrimi Menaxherit",40,570);
         
      // Neshkrimi i Pageses nga punetori fonti dhe madhesia e fontit
      g.drawLine(700, 550, 950, 550);
      g.setFont(new Font("Century Gothic",Font.BOLD,20));
      g.drawString(model.emri + " " + model.mbiemri,730,570);
   
                 
   }
}
     
     
     
     

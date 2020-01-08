/**Klasa modeluese e cila ben kalkulimet e duhura per rroge takse dhe pension
* Pastaj keto variabla do ti inicializoj Input_Rroga dhe i dergon ne Output_Rroga
* ora_rregullt   - varibale tregon oret e rregullta te punes
* ora_shtese     - variabel tregon oret shtese te punes 
* gjeresia       - gjeresine e dritares JFrame
* gjeresia       - lartesine e dritares JFrame
* paga_rregullt  - paga rregullt brenda orarit per ore 
* paga_shtese    - paga shtese jashte orarit per ore
* rroga_rregullt - totali rroges rregullt brenda orarit 
* rroga_shtese   - totali rroges shtese jashte orarit
* totali         - totali rroges
* taksa1,taksa2,taksa3 - taksa e rroges ne varesi te oreve te punes 
* pensioni       - pensioni qe eshte 5% e totali */

public class Modeli_Rroges {

   public  int ora_rregullt, ora_shtese , gjeresia , lartesia;  
   public double paga_rregullt,rroga_rregullt,rroga_shtese,totali,taksa1,taksa2,taksa3,pensioni;
   public String emri,mbiemri,pozita;  
  
   //Metode e cila ben llogaritjen e pages ne varesi te oreve te punuara 
   public void llogaritja_rroges(){
   
      if( ora_rregullt>0 && ora_rregullt<30){
         rroga_rregullt = ora_rregullt*paga_rregullt;
         totali = rroga_rregullt;
      }
      
      else if (ora_rregullt>30 && ora_rregullt<40){
         rroga_rregullt = ora_rregullt*paga_rregullt;
         totali = rroga_rregullt; 
      }     
      else if (ora_rregullt>=40) {
         rroga_rregullt = 40*paga_rregullt;
         ora_shtese = ora_rregullt-40;
         rroga_shtese = ora_shtese*paga_rregullt*1.5;
         totali = rroga_rregullt + rroga_shtese;
      }
      else  { totali = 0; ora_rregullt=0; ora_shtese=0; }   
   
   } 
   
   //Metode e cila ben llogaritjen e takses dhe pensionit te totalit te rroges
   public void taksa_dhe_pensioni (){
   
      if(ora_rregullt>0 && ora_rregullt<30){
         taksa1 = 0.20 * totali;
         pensioni = 0.05*totali;}
      
      else if (ora_rregullt>30 && ora_rregullt<40){ 
         taksa2= 0.25 * totali;
         pensioni = 0.05*totali;}
      else if (ora_rregullt>40){
         taksa3 = 0.28*totali;
         pensioni = 0.05*totali;}
      else {totali = 0;
         ora_rregullt=0;
         ora_shtese=0;}
   } 
   
   /*kontrollon stringun per emer, mbiemer dhe poziten te mos jene bosh
   *dhe pastaj mos ta lejon te shkoj me tutje por te mbyllet programi*/
   public void kontrolla_inputit (){
   
      if (emri == null || emri.equals("") ){
         System.exit(0);
      }  
      
      else if (mbiemri == null || mbiemri.equals("") ){
         System.exit(0);
      }
      
      else if (pozita == null || pozita.equals("") ){
         System.exit(0);
      }
      
      else {
 
      }
   }
   
   
}
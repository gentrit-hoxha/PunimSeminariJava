import javax.swing.*;
/** Input_Rroga eshte klase view e cila inicializon variblat
* duke shfrytezuar klasen Model_Rroga */
public class Input_Rroga{

  //Eshte krijuar nje objekt i klases modeluese per ti inicializuar variablat  
   
   Modeli_Rroges model = new Modeli_Rroges();

  /** Konstruktor qe permban instrusionet per ti inicializuar variablat nga klasa modeluese*/
   public  Input_Rroga(){
    
      model.emri = JOptionPane.showInputDialog("Shenoni emrin tuaj: ");
      model.mbiemri = JOptionPane.showInputDialog("Shenoni mbiemrin tuaj: ");
      model.pozita = JOptionPane.showInputDialog("Shenoni poziten tuaj te punes: "); 
     
       model.kontrolla_inputit();
      //Eshte perdoruar try dhe catch qe vlerat si input te jene vetem numra 
      //ndersa nese shtyp ndonje karakter tjeter atehere te kthen nje messageDialog "shenoni nje numer"
      //Dhe prape shfaqe dritaren per te shkruar nje numer 
      try{
         String paga_per_ore_rregullt = JOptionPane.showInputDialog("Sa eshte paga per 1 ore pune te rregullt: ");
         model.paga_rregullt = new Double( paga_per_ore_rregullt).doubleValue();
      }
      catch(Exception e){
         JOptionPane.showMessageDialog(null,"GABIM: Ju lutem shenoni nje numer ");
         String paga_per_ore_rregullt = JOptionPane.showInputDialog("Sa eshte paga per 1 ore pune te rregullt: ");
         model.paga_rregullt   = new Double( paga_per_ore_rregullt).doubleValue();
      }
     
      try{
         String  ore_pune = JOptionPane.showInputDialog("Sa ore keni punuar gjate kesaj jave:  ");
         model.ora_rregullt   = new Integer(ore_pune).intValue();
      }
      catch(Exception e){
         JOptionPane.showMessageDialog(null,"GABIM:Ju lutem shenoni nje numer: ");
         String  ore_pune = JOptionPane.showInputDialog("Sa ore keni punuar gjate kesaj jave:   ");
         model.ora_rregullt   = new Integer(ore_pune).intValue();
      }
   
   }
}

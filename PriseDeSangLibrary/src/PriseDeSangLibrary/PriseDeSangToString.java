/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriseDeSangLibrary;

/**
 *
 * @author 'Toine
 */
public class PriseDeSangToString {
    public static String toString(Object o){
        String str = "erreur";
        switch(o.getClass().getSimpleName()){
            case "Analyse":
                Analyse a = (Analyse)o;
                str = "id  = "+a.getIdAnalyse()+" "+a.getItem()+" "+a.getValeur()+"";
                break;
            case "Demande":
                Demande d = (Demande)o;
                str = "id = "+d.getIdDemande()+" "+d.getDateHeureDemande()+" "+d.getUrgent()+" Medecin: "+d.getRefMedecin()+" Patient:"+d.getRefPatient();
                break;
            case "Medecin":
                Medecin m = (Medecin)o;
                str = "id = "+m.getIdMedecin()+" "+m.getNom()+" "+m.getPrenom();
                break;
            case "Patient":
                Patient p = (Patient)o;
                str = "id = "+p.getIdPatient()+" "+p.getNom()+" "+p.getPrenom();
                break;
        }
        return str;
    }
    
    public static String demandeToString(Demande e){
        return ""+e.getIdDemande()+":"+e.getDateHeureDemande()+" "+(e.getUrgent()==0 ? "pas urgent":"URGENT")+"";
    }
}

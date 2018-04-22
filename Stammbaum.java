public class Stammbaum {
    Baumelem erster;
    
    Stammbaum() {
        Baumelem[] ar1 = { new Abschluss(), new Abschluss(), new Abschluss() };
        Baumelem[] ar2 = { new Datenknoten("Lukas", ar1) , new Abschluss(), new Abschluss() };
        Baumelem[] ar3 = { new Datenknoten("Andreas", ar2), new Abschluss(), new Abschluss() };
        
        this.erster = new Datenknoten("Josef", ar3);
    }
   
    boolean enthaelt(String name) {
        return erster.enthaelt(name);
    }
    
    int generationssuche(String name) {
        return this.erster.generationssuche(name);
    }
}
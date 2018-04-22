public class Datenknoten extends Baumelem {
    String name;
    Baumelem[] kinder;
    
    Datenknoten(String name, Baumelem[] b) {
        this.name = name;
        this.kinder = b;
    }

    boolean enthaelt(String name) {
        if (this.name == name) { return true; }
        for (int i = 0; i < kinder.length; i++) {
            if (kinder[i].enthaelt(name)) {
                return true;
            }
        }
        
        return false;
    }
    
    int generationssuche(String name) {
        // Falls das aktuelle Objekt nicht das Gesuchte ist
        if (this.name != name) { 
            for (int i = 0; i < kinder.length; i++) {
                // Falls das Kind das Objekt enthaelt
                if (this.kinder[i].enthaelt(name)) { 
                    return 1 + this.kinder[i].generationssuche(name);
                }
            }
        }
        
        // Das aktuelle Objekt ist das Gesuchte
        return 0;
    }
    
}
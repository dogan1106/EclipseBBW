import javax.swing.JFrame;

public class MeinFenster extends JFrame {
    public MeinFenster() {
        setTitle("Mein Fenster"); // Titel des Fensters festlegen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Verhalten beim Schließen des Fensters
        setSize(500, 300); // Größe des Fensters festlegen
        setLocationRelativeTo(null); // Fenster zentriert auf dem Bildschirm anzeigen
        
        // Weitere Komponenten und Konfigurationen können hier hinzugefügt werden
        
        setVisible(true); // Fenster sichtbar machen
    }
    
    public static void main(String[] args) {
        new MeinFenster();
    }
}
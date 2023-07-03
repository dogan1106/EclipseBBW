package Trading;
//https://finance.yahoo.com/quote/MSFT/history?p=MSFT

//Dieser aktualisierte Code liest die CSV-Datei mit Börsendaten ein und 
// * berechnet den Durchschnittspreis der Schlusspreise. 
//und die Volatilität der Börsendaten. 




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BörsendatenAnalyse {
    public static void main(String[] args) {
    	 // Pfad zur CSV-Datei
        String csvFile = "C:\\Users\\D.Dogan\\boersendaten.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	/*Diese Anweisung stellt sicher, dass die Ressource ordnungsgemäß 
        	freigegeben wird, unabhängig davon, ob eine Ausnahme auftritt oder nicht.
        	Innerhalb des Ressourcenblocks wird eine Instanz der Klasse 
        	BufferedReader erstellt und mit dem Konstruktor 
        	new BufferedReader(new FileReader(csvFile)) initialisiert. 
        	Der BufferedReader wird verwendet, um den Inhalt der CSV-Datei
        	zu lesen.*/
            br.readLine();
            //Diese Methode liest die nächste Zeile des Textes aus der Datei und 
            //gibt sie als String zurück.

            double summeSchlusspreise = 0.0;
            int anzahlDatensätze = 0;
            double hochwert = Double.MIN_VALUE;
            double tiefwert = Double.MAX_VALUE;
            // Iteriere über jede Zeile der CSV-Datei
            while ((line = br.readLine()) != null) {
            	 // Teile die Zeile in einzelne Werte auf
                String[] daten = line.split(csvSplitBy);
                //Mit dieser Zeile Code werden also die Daten einer Zeile aus einer 
                //CSV-Datei in separate Teilstrings aufgeteilt und in einem Array (daten) 
                //gespeichert. 

                // Annahme: Schlusspreis ist an Index 4 in der CSV
                double schlusspreis = Double.parseDouble(daten[4]);
                summeSchlusspreise += schlusspreis;
                anzahlDatensätze++;

                // Volatilität berechnen
                double hoch = Double.parseDouble(daten[2]); // Annahme: Hoch ist an Index 2 in der CSV
                double tief = Double.parseDouble(daten[3]); // Annahme: Tief ist an Index 3 in der CSV
                if (hoch > hochwert) {
                    hochwert = hoch;
                }
                if (tief < tiefwert) {
                    tiefwert = tief;
                }
            }
         // Durchschnittspreis berechnen
            double durchschnittspreis = summeSchlusspreise / anzahlDatensätze;
            System.out.println("Durchschnittspreis: " + durchschnittspreis);
            
            /* Volatilität berechnen
            Volatilität ist ein Begriff, der in der Finanzwelt verwendet wird, 
            um die Schwankungsbreite oder die Preisbewegung eines Finanzinstruments über einen 
            bestimmten Zeitraum zu beschreiben. 
            Es misst die Stärke und das Ausmaß der Preisschwankungen eines Vermögenswerts wie Aktien, 
            Währungen, Rohstoffen oder Anleihen.
             */
            //Die Volatilität wird in diesem Code als die Differenz zwischen dem Höchstwert und dem Tiefstwert berechnet.
            double volatilität = hochwert - tiefwert;
            System.out.println("Volatilität: " + volatilität);

            // Handelsmuster identifizieren
            // Hier können Sie Ihre eigenen Funktionen implementieren, um Handelsmuster zu identifizieren
            // basierend auf den analysierten Daten.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

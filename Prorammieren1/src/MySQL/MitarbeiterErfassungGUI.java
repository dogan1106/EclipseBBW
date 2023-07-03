package MySQL;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MitarbeiterErfassungGUI extends JFrame implements ActionListener {
    // GUI-Komponenten
    private JTextField txtVorname, txtNachname, txtAdresse, txtGeburtsdatum;
    private JButton btnSpeichern;

    public MitarbeiterErfassungGUI() {
        // Fenster-Setup
        setTitle("Mitarbeiter erfassen");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GUI-Komponenten initialisieren
        JLabel lblVorname = new JLabel("Vorname:");
        txtVorname = new JTextField(20);
        JLabel lblNachname = new JLabel("Nachname:");
        txtNachname = new JTextField(20);
        JLabel lblAdresse = new JLabel("Adresse:");
        txtAdresse = new JTextField(20);
        JLabel lblGeburtsdatum = new JLabel("Geburtsdatum:");
        txtGeburtsdatum = new JTextField(20);
        btnSpeichern = new JButton("Speichern");
        btnSpeichern.addActionListener(this);

        // GUI-Komponenten platzieren
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(lblVorname);
        panel.add(txtVorname);
        panel.add(lblNachname);
        panel.add(txtNachname);
        panel.add(lblAdresse);
        panel.add(txtAdresse);
        panel.add(lblGeburtsdatum);
        panel.add(txtGeburtsdatum);
        panel.add(new JLabel()); // Leerzeile
        panel.add(btnSpeichern);
        add(panel);

        // Fenster anzeigen
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSpeichern) {
            try {
                // Verbindung zur MySQL-Datenbank herstellen
            	
            	String url = "jdbc:mysql://localhost:3306/unternehmen";
            	String user = "root";
            	String password = "BuchS78!#";
            	Connection con = DriverManager.getConnection(url, user, password);

        

                // Informationen des Mitarbeiters aus GUI-Komponenten auslesen
                String vorname = txtVorname.getText();
                String nachname = txtNachname.getText();
                String adresse = txtAdresse.getText();
                String geburtsdatum = txtGeburtsdatum.getText(); //Format "YYYY-MM-DD" 

                // SQL-Abfrage zum Einfügen des Mitarbeiters in die Tabelle Mitarbeiter
                String sql = "INSERT INTO Mitarbeiter (vorname, nachname, adresse, geburtsdatum) VALUES (?, ?, ?, ?)";

                // Vorbereiten der SQL-Abfrage
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, vorname);
                pst.setString(2, nachname);
                pst.setString(3, adresse);
                pst.setString(4, geburtsdatum);

                // Ausführen der SQL-Abfrage
                int rowsAffected = pst.executeUpdate();
                JOptionPane.showMessageDialog(this, rowsAffected + " Mitarbeiter wurden eingefügt.");

                // Schließen der Verbindung zur Datenbank
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }
    
  


    public static void main(String[] args) {
        new MitarbeiterErfassungGUI();
    }
}


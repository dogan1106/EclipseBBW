package TICTACTOE;

//Importiere notwendige Bibliotheken test1333

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Definiere eine Klasse namens TicTacToeGUI, die das Tic-Tac-Toe-Spiel in einer GUI ermöglicht
public class TicTacToeGUI extends JFrame implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Erstelle eine 3x3-Matrix von Schaltflächen, um das Tic-Tac-Toe-Spielbrett zu repräsentieren
private JButton[][] buttons = new JButton[3][3];
//Erstelle eine boolesche Variable, um den Spieler zu verfolgen (true für Spieler X, false für Spieler O)
private boolean playerX = true;
//Erstelle ein Label, um anzuzeigen, welcher Spieler gerade an der Reihe ist
private JLabel playerLabel = new JLabel("Spieler X ist dran");
//Erstelle eine boolesche Variable, um zu verfolgen, ob das Spiel gewonnen wurde
private boolean gameWon = false;
//Definiere den Konstruktor für die TicTacToeGUI-Klasse
public TicTacToeGUI() {
//Rufe den Konstruktor der übergeordneten JFrame-Klasse auf und stelle ein Titel für das Fenster ein
super("Tic Tac Toe");
//Setze die Aktion, die beim Klicken auf den Schließen-Button des Fensters ausgeführt werden soll
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Setze die Größe des Fensters auf 300x300 Pixel
setSize(300, 300);
//Setze ein BorderLayout als Layout-Manager für das Fenster
setLayout(new BorderLayout());
//Erstelle ein JPanel für die Schaltflächen des Tic-Tac-Toe-Spielbretts und setze ein GridLayout als Layout-Manager
JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new GridLayout(3, 3));
//Fülle die 3x3-Matrix von Schaltflächen mit neuen Schaltflächen und füge sie dem JPanel hinzu
for (int i = 0; i < buttons.length; i++) {
for (int j = 0; j < buttons[i].length; j++) {
buttons[i][j] = new JButton("");
buttons[i][j].addActionListener(this);
buttonPanel.add(buttons[i][j]);
}
}
//Füge das JPanel mit den Schaltflächen dem BorderLayout des Fensters hinzu
add(buttonPanel, BorderLayout.CENTER);
//Füge das Label für den aktuellen Spieler dem BorderLayout des Fensters hinzu
add(playerLabel, BorderLayout.SOUTH);
//Setze das Fenster sichtbar
setVisible(true);
}
//Definiere die actionPerformed-Methode, die aufgerufen wird, wenn eine Schaltfläche geklickt wird
public void actionPerformed(ActionEvent e) {
//Überprüfe, ob das Spiel bereits gewonnen wurde, und wenn ja, kehre zurück und tue nichts
if (gameWon) {
return;
}
//Konvertiere das ActionEvent-Objekt in ein JButton-Objekt
JButton button = (JButton)e.getSource();
//Überprüfe, ob die Schaltfläche bereits geklickt wurde, und wenn nicht, setze das entsprech
//ende Symbol (X oder O) auf der Schaltfläche und ändere das Label für den aktuellen Spieler
if (button.getText().equals("")) {
if (playerX) {
button.setText("X");
playerLabel.setText("Spieler O ist dran");
} else {
button.setText("O");
playerLabel.setText("Spieler X ist dran");
}
//Überprüfe, ob einer der Spieler das Spiel gewonnen hat
if (checkForWin()) {
gameWon = true;
JOptionPane.showMessageDialog(this, "Spieler " + (playerX ? "X" : "O") + " hat gewonnen!");
}
//Wechsle den Spieler (X zu O oder umgekehrt)
playerX = !playerX;
}
//Überprüfe, ob das Spiel unentschieden ist
boolean tie = true;
for (int i = 0; i < buttons.length; i++) {
for (int j = 0; j < buttons[i].length; j++) {
if (buttons[i][j].getText().equals("")) {
tie = false;
break;
}
}
}
if (tie) {
JOptionPane.showMessageDialog(this, "Unentschieden!");
}
}
//Definiere eine Methode, um zu überprüfen, ob einer der Spieler das Spiel gewonnen hat
private boolean checkForWin() {
//Überprüfe Zeilen
for (int i = 0; i < buttons.length; i++) {
if (!buttons[i][0].getText().equals("") &&
buttons[i][0].getText().equals(buttons[i][1].getText()) &&
buttons[i][1].getText().equals(buttons[i][2].getText())) {
return true;
}
}
//Überprüfe Spalten
for (int j = 0; j < buttons[0].length; j++) {
if (!buttons[0][j].getText().equals("") &&
buttons[0][j].getText().equals(buttons[1][j].getText()) &&
buttons[1][j].getText().equals(buttons[2][j].getText())) {
return true;
}
}
//Überprüfe Diagonalen
if (!buttons[0][0].getText().equals("") &&
buttons[0][0].getText().equals(buttons[1][1].getText()) &&
buttons[1][1].getText().equals(buttons[2][2].getText())) {
return true;
}
if (!buttons[0][2].getText().equals("") &&
buttons[0][2].getText().equals(buttons[1][1].getText()) &&
buttons[1][1].getText().equals(buttons[2][0].getText())) {
return true;
}
//Wenn kein Spieler gewonnen hat, gib false zurück
return false;
}
//Definiere die main-Methode, um das Programm auszuführen
public static void main(String[] args) {
new TicTacToeGUI();
}
}
/*
Der Code beginnt mit dem Import der notwendigen Bibliotheken: `java.awt.*` und `javax.swing.*`. Die `java.awt.*`-Bibliothek enthält Klassen für die Erstellung von GUI-Komponenten wie Fenstern, Schaltflächen und Labels, während `javax.swing.*` eine erweiterte Sammlung von GUI-Komponenten bereitstellt.
Die eigentliche TicTacToeGUI-Klasse enthält den Konstruktor, der das Fenster und die GUI-Komponenten initialisiert und konfiguriert. Der Konstruktor beginnt damit, ein neues JFrame-Objekt zu erstellen und es als Hauptfenster des Spiels zu verwenden. Das JFrame wird konfiguriert, um eine feste Größe von 300x300 Pixeln zu haben und beim Schließen des Fensters das Programm zu beenden.
Als nächstes wird ein JPanel erstellt, um die Schaltflächen anzuzeigen. Der JPanel wird als GridLayout mit 3 Zeilen und 3 Spalten konfiguriert, um die neun Schaltflächen anzuordnen. Die Schaltflächen werden in einer Schleife erstellt und im JPanel platziert.
Ein ActionListener wird definiert, um auf Klicks auf die Schaltflächen zu reagieren. Wenn eine Schaltfläche geklickt wird, überprüft der ActionListener, ob das Spiel bereits gewonnen wurde oder unentschieden ist. Wenn das Spiel noch nicht vorbei ist, wird das Symbol (X oder O) auf der Schaltfläche angezeigt und der aktuelle Spieler gewechselt. Dann wird überprüft, ob einer der Spieler das Spiel gewonnen hat, indem die Schaltflächen in Zeilen, Spalten und Diagonalen überprüft werden.
Schließlich wird die main-Methode definiert, um das Programm auszuführen. Sie erstellt einfach eine neue TicTacToeGUI-Instanz, um das Spiel zu starten.
Dies ist eine grundlegende Einführung in die Implementierung eines TicTacToe-Spiels in Java mit einer GUI. Es gibt viele Möglichkeiten, dieses Spiel zu erweitern und zu verbessern, aber dieser Code bietet eine solide Grundlage für Anfänger, die die Grundlagen von Java und GUI-Programmierung lernen möchten.
*/



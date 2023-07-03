package Memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MemoryGame {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> cards = new ArrayList<String>();
    ArrayList<String> revealedCards = new ArrayList<String>();
    int pairsFound = 0;
    
    // Add animal cards to the deck
    cards.add("cat");
    cards.add("dog");
    cards.add("fish");
    cards.add("bird");
    cards.add("lion");
    cards.add("tiger");
    cards.add("elephant");
    cards.add("monkey");
    
    // Shuffle the deck
    Collections.shuffle(cards);
    
    // Display instructions
    System.out.println("Welcome to Memory Game! Try to find all the matching pairs.");
    System.out.println("Enter the number of the first card to reveal it.");
    System.out.println("Enter the number of the second card to see if it matches.");
    
    while (pairsFound < 4) {
      // Display the current state of the game board
      System.out.println("\n-------------");
      for (int i = 0; i < cards.size(); i++) {
        if (revealedCards.contains(Integer.toString(i))) {
          System.out.print(cards.get(i) + " ");
        } else {
          System.out.print(i + " ");
        }
      }
      System.out.println("\n-------------");
      
      // Ask the user to reveal two cards
      System.out.print("Enter the number of the first card to reveal: ");
      int card1 = scanner.nextInt();
      while (revealedCards.contains(Integer.toString(card1))) {
        System.out.println("That card has already been revealed. Please choose another.");
        System.out.print("Enter the number of the first card to reveal: ");
        card1 = scanner.nextInt();
      }
      System.out.print("Enter the number of the second card to reveal: ");
      int card2 = scanner.nextInt();
      while (revealedCards.contains(Integer.toString(card2)) || card2 == card1) {
        if (card2 == card1) {
          System.out.println("You can't reveal the same card twice. Please choose another.");
        } else {
          System.out.println("That card has already been revealed. Please choose another.");
        }
        System.out.print("Enter the number of the second card to reveal: ");
        card2 = scanner.nextInt();
      }
      
      // If the cards match, mark them as revealed and increment the pairs found counter
      if (cards.get(card1).equals(cards.get(card2))) {
        System.out.println("You found a matching pair!");
        revealedCards.add(Integer.toString(card1));
        revealedCards.add(Integer.toString(card2));
        pairsFound++;
      } else {
        System.out.println("Sorry, those cards don't match.");
      }
    }
    
    // Game over
    System.out.println("\nCongratulations, you found all the pairs!");
  }
}

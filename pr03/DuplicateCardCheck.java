import java.util.Objects;

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return Objects.equals(rank, card.rank) && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

public class DuplicateCardCheck {
    public static void main(String[] args) {
        Card[] cardStream = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("10", "Diamonds"),
            new Card("Ace", "Spades"),
            new Card("Queen", "Clubs")
        };

        Card[] seen = new Card[cardStream.length];
        int count = 0;

        for (Card current : cardStream) {
            boolean duplicate = false;
            for (int i = 0; i < count; i++) {
                if (current.equals(seen[i])) {
                    System.out.println("Duplicate found: " + current);
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                seen[count++] = current;
                System.out.println("Added: " + current);
            }
        }
    }
}

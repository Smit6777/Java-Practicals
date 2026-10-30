import java.util.Random;
import java.util.Scanner;

public class RPSLS {
    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    public static int winner(Move a, Move b) {
        if (a == b) return 0;

        return switch (a) {
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;
            case PAPER    -> (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;
            case ROCK     -> (b == Move.LIZARD || b == Move.SCISSORS) ? 1 : -1;
            case LIZARD   -> (b == Move.SPOCK || b == Move.PAPER) ? 1 : -1;
            case SPOCK    -> (b == Move.SCISSORS || b == Move.ROCK) ? 1 : -1;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Move[] moves = Move.values();

        int playerWins = 0;
        int computerWins = 0;

        System.out.println("Playing 5 rounds of Rock-Paper-Scissors-Lizard-Spock!\n");

        for (int round = 1; round <= 5; round++) {
            System.out.println("--- Round " + round + " ---");

            Move computerMove = moves[random.nextInt(moves.length)];

            Move playerMove = null;
            while (playerMove == null) {
                System.out.print("Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
                String input = scanner.next().toUpperCase();
                try {
                    playerMove = Move.valueOf(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid move. Try again.");
                }
            }

            System.out.println("Computer chose: " + computerMove);
            int result = winner(playerMove, computerMove);

            if (result == 1) {
                System.out.println("Result: You win this round!");
                playerWins++;
            } else if (result == -1) {
                System.out.println("Result: Computer wins this round!");
                computerWins++;
            } else {
                System.out.println("Result: It's a tie!");
            }
            System.out.println();
        }

        System.out.println("=== Final Results ===");
        if (playerWins > computerWins) {
            System.out.println("You win " + playerWins + "–" + computerWins);
        } else if (computerWins > playerWins) {
            System.out.println("Computer wins " + computerWins + "–" + playerWins);
        } else {
            System.out.println("Overall series ended in a tie! " + playerWins + "–" + computerWins);
        }

        scanner.close();
    }
}
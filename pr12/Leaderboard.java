
import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("dev", 95);
        scores.put("Smit", 100);
        scores.put("mahek", 95);
        scores.put("divy", 85);
        scores.put("Jay", 100);

        int topN = 3;

        List<Map.Entry<String, Integer>> players = new ArrayList<>(scores.entrySet());

        players.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());

            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }

            return result;
        });

        System.out.println("Top " + topN + " Players:");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                    player.getKey() + " - " + player.getValue());
        }
    }
}

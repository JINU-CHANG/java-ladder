package ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private static final String ALL_RESULT = "all";
    private static final String DELIMITER = " : ";
    private static final String NEXT_LINE = "\n";

    private Map<Player, DrawResult> results;

    GameResult(Map results) {
        this.results = results;
    }

    public String getResult(String message) {
        if (message.equals(ALL_RESULT)) {
            return this.toString();
        }
        return results.keySet()
                .stream()
                .filter(player -> player.isSameName(message))
                .map(player -> results.get(player).getResult())
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        results.keySet()
                .forEach(player -> stringBuilder.append(player.getName())
                        .append(DELIMITER)
                        .append(results.get(player).getResult())
                        .append(NEXT_LINE));
        return stringBuilder.toString();
    }
}
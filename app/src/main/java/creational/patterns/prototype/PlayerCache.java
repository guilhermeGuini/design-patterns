package creational.patterns.prototype;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PlayerCache {

    private static final Map<String, Player> playersCache = new HashMap<>();

    public static void loadCache() {
        CounterTerrorist ct = new CounterTerrorist();
        ct.setMoney(BigDecimal.valueOf(16000));
        ct.setPosX(0);
        ct.setPosY(0);

        playersCache.put("CT", ct);

        Terrorist terror = new Terrorist();
        terror.setMoney(BigDecimal.valueOf(16000));
        terror.setPosX(0);
        terror.setPosY(0);

        playersCache.put("TR", terror);
    }

    public static Player getPlayer(String type) {
        if (!playersCache.containsKey(type)) {
            throw new IllegalArgumentException("Type " + type + " not found.");
        }

        Player player = playersCache.get(type);
        return player.clone();
    }
}

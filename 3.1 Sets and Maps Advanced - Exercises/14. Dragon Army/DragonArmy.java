import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int count = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap();

        while (count-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");

            String type = tokens[0];
            String name = tokens[1];

            int damage = tokens[2].equals("null") ?
                    45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ?
                    250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ?
                    10 : Integer.parseInt(tokens[4]);

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>() {{
                    put(name, new int[]{damage, health, armor});
                }});
            } else {
                if (!dragons.get(type).containsKey(name)) {
                    dragons.get(type).put(name, new int[]{damage, health, armor});
                } else {
                    dragons.get(type).get(name)[0] = damage;
                    dragons.get(type).get(name)[1] = health;
                    dragons.get(type).get(name)[2] = armor;
                }
            }
        }

        dragons.entrySet().forEach(entry -> {

            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;

            int[] aggregatedData = new int[3];

            entry.getValue().entrySet().stream().forEach(innerEntry -> {
                int damage = innerEntry.getValue()[0];
                int health = innerEntry.getValue()[1];
                int armor = innerEntry.getValue()[2];

                aggregatedData[0] += damage;
                aggregatedData[1] += health;
                aggregatedData[2] += armor;

            });

            int dragonsCount = entry.getValue().size();

            avgDamage = aggregatedData[0] / (dragonsCount * 1.0);
            avgHealth = aggregatedData[1] / (dragonsCount * 1.0);
            avgArmor = aggregatedData[2] / (dragonsCount * 1.0);

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                    entry.getKey(),
                    avgDamage,
                    avgHealth,
                    avgArmor
            ));

            entry.getValue().entrySet().stream().forEach(dragon -> {

                System.out.println(String.format(
                        "-%s -> damage: %d, health: %d, armor: %d",
                        dragon.getKey(),
                        dragon.getValue()[0],
                        dragon.getValue()[1],
                        dragon.getValue()[2]
                ));
            });
        });
    }
}

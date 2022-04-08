package lld.snakeladder.service;

import java.util.HashSet;
import java.util.Random;

public class PositionHelper {

    private static HashSet<Integer> snakeLadderPositions;

    private static Random random;

    static {
        snakeLadderPositions = new HashSet<>();
        random = new Random();
    }

    public static int getUniquePosition(int maxLimit) {
        int position;
        while (true) {
            position = random.nextInt(maxLimit-1);
            if (!snakeLadderPositions.contains(position) && position>0) {
                snakeLadderPositions.add(position);
                break;
            }
        }
        return position;
    }

}

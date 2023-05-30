package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Feelings {
    private static final Set<Integer> OK_FEELINGS = Set.of(-1, 0, 1);


    public int findSadFeeling(final List<Integer> feelings, final int offset) {
        validateFeelings(feelings);
        validatePosition(feelings, offset);

        for (var i = offset; i < feelings.size(); i++) {
            if (feelings.get(i) == -1) {
                return i;
            }
        }

        return -1;
    }

    public boolean checkNeighbours(final List<Integer> feelings, final int position) {
        validateFeelings(feelings);
        validatePosition(feelings, position);

        var current = feelings.get(position);
        if (current != -1) {
            return true;
        }

        if (position == 0 || position == feelings.size() - 1) {
            return false;
        }

        var left = feelings.get(position - 1);
        var right = feelings.get(position + 1);

        return left == 1 && right == 1;
    }

    public void insertHappyFeelings(final List<Integer> feelings, final int position) {
        validateFeelings(feelings);
        validatePosition(feelings, position);

        feelings.add(position + 1, 1);
        feelings.add(position, 1);
    }

    public List<Integer> beHappy(final List<Integer> feelings) {
        final var result = new ArrayList<>(feelings);

        var i = 0;
        i = findSadFeeling(feelings, i);

        while (i != -1) {
            if (!checkNeighbours(result, i)) {
                insertHappyFeelings(result, i);
            }
            i = findSadFeeling(result, i + 2);
        }

        return result;
    }

    private static void validateFeelings(final List<Integer> feelings) {
        feelings.forEach(feeling -> {
            if (!OK_FEELINGS.contains(feeling)) {
                throw new RuntimeException("Invalid feeling " + feeling + " found in the array of feelings: " + feelings);
            }
        });
    }

    private static <T> void validatePosition(final List<T> feelings, final int position) {
        if (position < 0 || position >= feelings.size()) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }
}

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MainTest {
    private final Feelings feelings = new Feelings();

    @Test
    public void EC_1() {
        List<Integer> feelingsList = List.of(0, 1, -1);
        int expectedPosition = 2;

        int result = this.feelings.findSadFeeling(feelingsList, 0);

        Assertions.assertEquals(result, expectedPosition);
    }

    @Test
    public void EC_2() {
        List<Integer> feelingsList = List.of(0, 2, 1);

        Assertions.assertThrows(RuntimeException.class, () -> feelings.findSadFeeling(feelingsList, 1));
    }

    @Test
    public void EC_3() {
        List<Integer> feelingsList = List.of(-1, 0, 1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> feelings.findSadFeeling(feelingsList, -5));
    }

    @Test
    public void EC_4() {
        List<Integer> feelingsList = List.of(-1, 0, 1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> feelings.findSadFeeling(feelingsList, 3));
    }

    @Test
    public void BVC_1() {
        List<Integer> feelingsList = List.of(0, 1, -1);
        int expectedPosition = 2;

        int result = this.feelings.findSadFeeling(feelingsList, 0);

        Assertions.assertEquals(result, expectedPosition);
    }

    @Test
    public void BVC_2() {
        List<Integer> feelingsList = List.of(-1, 0, 1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> feelings.findSadFeeling(feelingsList, -1));
    }

    @Test
    public void BVC_3() {
        List<Integer> feelingsList = List.of(-1, -1);
        int expectedPosition = 0;

        int result = this.feelings.findSadFeeling(feelingsList, 0);

        Assertions.assertEquals(expectedPosition, result);
    }

    @Test
    public void BVC_4() {
        List<Integer> feelingsList = List.of(-1, 0, 1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> feelings.findSadFeeling(feelingsList, 3));
    }

    @Test
    public void BVC_5() {
        List<Integer> feelingsList = List.of(1, 1, 1, 1);
        int expectedResult = -1;

        int result = this.feelings.findSadFeeling(feelingsList, 3);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void check_neighbours_1() {
        List<Integer> feelingsList = List.of(0, -1, 1);
        boolean expectedOutput = true;

        boolean result = this.feelings.checkNeighbours(feelingsList, 0);

        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void check_neighbours_2() {
        List<Integer> feelingsList = List.of(0, -1, 1);
        boolean expectedOutput = false;

        boolean result = this.feelings.checkNeighbours(feelingsList, 1);

        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void check_neighbours_3() {
        List<Integer> feelingsList = List.of(-1);
        boolean expectedOutput = false;

        boolean result = this.feelings.checkNeighbours(feelingsList, 0);

        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void check_neighbours_4() {
        List<Integer> feelingsList = List.of(1, -1, 0);
        boolean expectedOutput = false;

        boolean result = this.feelings.checkNeighbours(feelingsList, 1);

        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void bigBang() {
        List<Integer> feelingsList = List.of(-1,-1,0,0,1,1,-1,1,0,-1,1,0,1,1,-1, 0,1,1);
        List<Integer> expectedResult = List.of(1, -1, 1, 1, -1, 1, 0, 0, 1, 1, -1, 1, 0, 1, -1, 1, 1, 0, 1, 1, 1, -1, 1, 0, 1, 1);

        var result = this.feelings.beHappy(feelingsList);

        Assertions.assertEquals(expectedResult, result);
    }
}
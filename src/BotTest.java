import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {
    private Cubick cubick1 = new Cubick();
    private Cubick cubick2 = new Cubick();
    private Cubick cubick3 = new Cubick();
    private Cubick cubick4 = new Cubick();
    private Cubick cubick5 = new Cubick();


    private boolean assertWhiteCrossWithYellowCenter(Cubick cubick, String other) {
        return cubick.getCubick(0, 1, 1).equals("y") && cubick.getCubick(0, 0, 1).equals(other) &&
                cubick.getCubick(0, 1, 0).equals(other) && cubick.getCubick(0, 2, 1).equals(other) &&
                cubick.getCubick(0, 1, 2).equals(other);
    }

    private Cubick whiteCrossWithYellowCenter(Cubick cubick) {
        cubick = Bot.upYellowCenter(cubick);
        cubick = Bot.whiteCrossWithYellowCenter(cubick);
        return cubick;
    }

    private boolean assertWhiteCrossFull(Cubick cubick, String side) {
        return cubick.getCubick(2, 1, 1).equals(side) && cubick.getCubick(2, 0, 1).equals("w") &&
                cubick.getCubick(2, 1, 0).equals("w") && cubick.getCubick(2, 2, 1).equals("w") &&
                cubick.getCubick(2, 1, 2).equals("w");
    }

    private boolean assertFirstLayer(Cubick cubick) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!cubick.getCubick(2, 1, 1).equals(cubick.getCubick(2, i, j))) return false;
            }
        }
        for (int i = 1; i < 6; i++) {
            if (i != 3) {
                for (int j = 0; j < 3; j++) {
                    if (!cubick.getCubick(i, 1, 1).equals(cubick.getCubick(i, 2, j))) return false;
                }
            }
        }
        return true;
    }

    private boolean assertSecondLayer(Cubick cubick) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!cubick.getCubick(2, 1, 1).equals(cubick.getCubick(2, i, j))) return false;
            }
        }
        for (int i = 1; i < 6; i++) {
            if (i != 3) {
                for (int j = 0; j < 3; j++) {
                    if (!cubick.getCubick(i, 1, 1).equals(cubick.getCubick(i, 2, j))) return false;
                }
            }
        }
        for (int i = 1; i < 6; i++) {
            if (i != 3) {
                for (int j = 0; j < 3; j++) {
                    if (!cubick.getCubick(i, 1, 1).equals(cubick.getCubick(i, 1, j))) return false;
                }
            }
        }
        return true;
    }

    private boolean assertYellowSide(Cubick cubick) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!cubick.getCubick(0, 1, 1).equals(cubick.getCubick(0, i, j))) return false;
            }
        }
        return true;
    }

    private boolean assertFullCubick(Cubick cubick) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (!cubick.getCubick(i, 1, 1).equals(cubick.getCubick(i, j, k))) return false;
                }
            }
        }
        return true;
    }

    @Test
    void TestCubick() {
        cubick1.mix(cubick1);
        cubick2.mix(cubick2);
        cubick3.mix(cubick3);
        cubick4.mix(cubick4);
        cubick5.mix(cubick5);
        assertFalse(assertFullCubick(cubick1));
        assertFalse(assertFullCubick(cubick2));
        assertFalse(assertFullCubick(cubick3));
        assertFalse(assertFullCubick(cubick4));
        assertFalse(assertFullCubick(cubick5));

        //Проверяем собран ли белый крест с желтым верхом
        cubick1 = whiteCrossWithYellowCenter(cubick1);
        cubick2 = whiteCrossWithYellowCenter(cubick2);
        cubick3 = whiteCrossWithYellowCenter(cubick3);
        cubick4 = whiteCrossWithYellowCenter(cubick4);
        cubick5 = whiteCrossWithYellowCenter(cubick5);
        assertTrue(assertWhiteCrossWithYellowCenter(cubick1, "w"));
        assertTrue(assertWhiteCrossWithYellowCenter(cubick2, "w"));
        assertTrue(assertWhiteCrossWithYellowCenter(cubick3, "w"));
        assertTrue(assertWhiteCrossWithYellowCenter(cubick4, "w"));
        assertTrue(assertWhiteCrossWithYellowCenter(cubick5, "w"));
        assertFalse(assertWhiteCrossWithYellowCenter(cubick5, "g"));

        //Проверка собран ли полностью белый крест
        cubick1 = Bot.whiteCrossFull(cubick1);
        cubick2 = Bot.whiteCrossFull(cubick2);
        cubick3 = Bot.whiteCrossFull(cubick3);
        cubick4 = Bot.whiteCrossFull(cubick4);
        cubick5 = Bot.whiteCrossFull(cubick5);
        assertTrue(assertWhiteCrossFull(cubick1, "w"));
        assertTrue(assertWhiteCrossFull(cubick2, "w"));
        assertTrue(assertWhiteCrossFull(cubick3, "w"));
        assertTrue(assertWhiteCrossFull(cubick4, "w"));
        assertTrue(assertWhiteCrossFull(cubick5, "w"));
        assertFalse(assertWhiteCrossFull(cubick5, "y"));

        //Провера собран ли первый слой
        cubick1 = Bot.firstLayer(cubick1);
        cubick2 = Bot.firstLayer(cubick2);
        cubick3 = Bot.firstLayer(cubick3);
        cubick4 = Bot.firstLayer(cubick4);
        cubick5 = Bot.firstLayer(cubick5);
        assertTrue(assertFirstLayer(cubick1));
        assertTrue(assertFirstLayer(cubick2));
        assertTrue(assertFirstLayer(cubick3));
        assertTrue(assertFirstLayer(cubick4));
        assertTrue(assertFirstLayer(cubick5));

        //Проверка собраны ли 2 слоя
        cubick1 = Bot.secondLayer(cubick1);
        cubick2 = Bot.secondLayer(cubick2);
        cubick3 = Bot.secondLayer(cubick4);
        cubick4 = Bot.secondLayer(cubick3);
        cubick5 = Bot.secondLayer(cubick5);
        assertTrue(assertSecondLayer(cubick1));
        assertTrue(assertSecondLayer(cubick2));
        assertTrue(assertSecondLayer(cubick3));
        assertTrue(assertSecondLayer(cubick4));
        assertTrue(assertSecondLayer(cubick5));

        //Проверка собран ли желтый крест
        cubick1 = Bot.yellowCross(cubick1);
        cubick2 = Bot.yellowCross(cubick2);
        cubick3 = Bot.yellowCross(cubick3);
        cubick4 = Bot.yellowCross(cubick4);
        cubick5 = Bot.yellowCross(cubick5);
        assertTrue(assertWhiteCrossWithYellowCenter(cubick1, "y"));
        assertTrue(assertWhiteCrossWithYellowCenter(cubick2, "y"));
        assertTrue(assertWhiteCrossWithYellowCenter(cubick3, "y"));
        assertTrue(assertWhiteCrossWithYellowCenter(cubick4, "y"));
        assertTrue(assertWhiteCrossWithYellowCenter(cubick5, "y"));
        assertFalse(assertWhiteCrossWithYellowCenter(cubick5, "g"));

        //Проверка собраана ли желтая сторона
        cubick1 = Bot.yellowCornersIntoPlace(cubick1);
        cubick1 = Bot.yellowSide(cubick1);
        cubick2 = Bot.yellowCornersIntoPlace(cubick2);
        cubick2 = Bot.yellowSide(cubick2);
        cubick3 = Bot.yellowCornersIntoPlace(cubick3);
        cubick3 = Bot.yellowSide(cubick3);
        cubick4 = Bot.yellowCornersIntoPlace(cubick4);
        cubick4 = Bot.yellowSide(cubick4);
        cubick5 = Bot.yellowCornersIntoPlace(cubick5);
        cubick5 = Bot.yellowSide(cubick5);
        assertTrue(assertYellowSide(cubick1));
        assertTrue(assertYellowSide(cubick2));
        assertTrue(assertYellowSide(cubick3));
        assertTrue(assertYellowSide(cubick4));
        assertTrue(assertYellowSide(cubick5));

        //Проверка собран кубик или нет
        cubick1 = Bot.fullCubick(cubick1);
        cubick2 = Bot.fullCubick(cubick2);
        cubick3 = Bot.fullCubick(cubick3);
        cubick4 = Bot.fullCubick(cubick4);
        cubick5 = Bot.fullCubick(cubick5);
        assertTrue(assertFullCubick(cubick1));
        assertTrue(assertFullCubick(cubick2));
        assertTrue(assertFullCubick(cubick3));
        assertTrue(assertFullCubick(cubick4));
        assertTrue(assertFullCubick(cubick5));
    }
}
public class Bot {
    //Stage 1
    public static Cubick upYellowCenter(Cubick cubick) {
        if (cubick.getCubick(0, 1, 1).equals("y")) {
            return cubick;
        }
        if (cubick.getCubick(1, 1, 1).equals("y")) {
            cubick.turnX(1, 1);
            return cubick;
        }
        if (cubick.getCubick(2, 1, 1).equals("y")) {
            cubick.turnX(1, 1);
            cubick.turnX(1, 1);
            return cubick;
        }
        if (cubick.getCubick(3, 1, 1).equals("y")) {
            cubick.turnX(1, 1);
            cubick.turnX(1, 1);
            cubick.turnX(1, 1);
            return cubick;
        }
        if (cubick.getCubick(4, 1, 1).equals("y")) {
            cubick.turnY(1, 0);
            return cubick;
        }
        if (cubick.getCubick(5, 1, 1).equals("y")) {
            cubick.turnY(1, 1);
            return cubick;
        }
        return cubick;
    }

    private static Cubick rightAlgorithm(Cubick cubick) {
        cubick.turnX(2, 1);
        cubick.turnZ(0, 0);
        cubick.turnX(2, 0);
        cubick.turnZ(0, 1);
        return cubick;
    }

    private static Cubick leftAlgorithm(Cubick cubick) {
        cubick.turnX(0, 1);
        cubick.turnZ(0, 1);
        cubick.turnX(0, 0);
        cubick.turnZ(0, 0);
        return cubick;
    }

    private static Cubick cubeMoietyCross(Cubick cubick, int pos) {
        int count;
        cubick = turn(cubick, 1, pos);
        count = 0;
        if (cubick.getCubick(1, 1, pos).equals("w") || cubick.getCubick(4, 1, pos).equals("w")
                || cubick.getCubick(5, 1, pos).equals("w") || cubick.getCubick(2, 1, pos).equals("w")
                || cubick.getCubick(3, 1, pos).equals("w")) {
            while (!cubick.getCubick(1, 1, pos).equals("w")) {
                cubick.turnZ(1, 1);
                count++;
                if (count == 4) {
                    break;
                }
            }
            cubick.turnX(pos, 1);
        }
        return cubick;
    }

    private static Cubick turn(Cubick cubick, int first, int second) {
        int count = 0;
        while (cubick.getCubick(0, first, second).equals("w")) {
            count++;
            cubick.turnZ(0, 1);
            if (count == 4) {
                break;
            }
        }
        return cubick;
    }

    private static Cubick cubeMoietyCross(Cubick cubick) {
        if (cubick.getCubick(2, 0, 1).equals("w") || cubick.getCubick(2, 2, 1).equals("w")) {
            cubick.turnZ(2, 1);
            return cubick;
        }
        if (cubick.getCubick(5, 0, 1).equals("w") || cubick.getCubick(5, 2, 1).equals("w")) {
            cubick = turn(cubick, 1, 2);
            cubick.turnX(2, 1);
            return cubick;
        }
        if (cubick.getCubick(4, 0, 1).equals("w") || cubick.getCubick(4, 2, 1).equals("w")) {
            cubick = turn(cubick, 1, 0);
            cubick.turnX(0, 1);
            return cubick;
        }
        if (cubick.getCubick(1, 0, 1).equals("w") || cubick.getCubick(1, 2, 1).equals("w")) {
            cubick = turn(cubick, 2, 1);
            cubick.turnY(2, 1);
            return cubick;
        }
        if (cubick.getCubick(3, 0, 1).equals("w") || cubick.getCubick(3, 2, 1).equals("w")) {
            cubick = turn(cubick, 0, 1);
            cubick.turnY(0, 1);
            return cubick;
        }
        return cubick;
    }

    private static boolean checkOne(Cubick cubick, int pos1, int pos) {
        return !cubick.getCubick(1, pos1, pos).equals("w") && !cubick.getCubick(4, pos1, pos).equals("w")
                && !cubick.getCubick(5, pos1, pos).equals("w") && !cubick.getCubick(2, pos1, pos).equals("w")
                && !cubick.getCubick(3, pos1, pos).equals("w");
    }

    public static Cubick whiteCrossWithYellowCenter(Cubick cubick) {
        while (!(Bot.checkOne(cubick, 1, 0) && Bot.checkOne(cubick, 1, 2)) ||
                !(Bot.checkOne(cubick, 0, 1) && Bot.checkOne(cubick, 2, 1))) {
            while (!(Bot.checkOne(cubick, 1, 0) && Bot.checkOne(cubick, 1, 2))) {
                for (int i = 0; i < 4; i++) {
                    cubick = Bot.cubeMoietyCross(cubick, 0);
                }
                for (int i = 0; i < 4; i++) {
                    cubick = Bot.cubeMoietyCross(cubick, 2);
                }
            }
            if (!(Bot.checkOne(cubick, 0, 1) && Bot.checkOne(cubick, 2, 1))) {
                cubick = Bot.cubeMoietyCross(cubick);
            }
        }
        return cubick;
    }

    //Stage 1.2
    public static Cubick whiteCrossFull(Cubick cubick) {
        while (!cubick.getCubick(1, 1, 1).equals(cubick.getCubick(1, 0, 1))) {
            cubick.turnZ(1, 1);
        }
        cubick.turnY(2, 1);
        cubick.turnY(2, 1);
        while (!cubick.getCubick(4, 1, 1).equals(cubick.getCubick(4, 0, 1)) ||
                !cubick.getCubick(0, 1, 0).equals("w")) {
            cubick.turnZ(0, 1);
        }
        cubick.turnX(0, 1);
        cubick.turnX(0, 1);
        while (!cubick.getCubick(5, 1, 1).equals(cubick.getCubick(5, 0, 1)) ||
                !cubick.getCubick(0, 1, 2).equals("w")) {
            cubick.turnZ(0, 1);
        }
        cubick.turnX(2, 1);
        cubick.turnX(2, 1);
        while (!cubick.getCubick(0, 0, 1).equals("w")) {
            cubick.turnZ(0, 1);
        }
        cubick.turnY(0, 1);
        cubick.turnY(0, 1);
        return cubick;
    }

    public static Cubick firstLayer(Cubick cubick) {
        int vix = 0;
        while (!cubick.getCubick(2, 0, 0).equals("w") || !cubick.getCubick(2, 0, 2).equals("w") ||
                !cubick.getCubick(2, 2, 0).equals("w") || !cubick.getCubick(2, 2, 2).equals("w")) {
            int count = 0;
            while (!cubick.getCubick(0, 2, 2).equals("w") && !cubick.getCubick(5, 0, 0).equals("w")
                    && !cubick.getCubick(1, 0, 2).equals("w")) {
                count++;
                if (count == 6) {
                    cubick = rightAlgorithm(cubick);
                    break;
                }
                cubick.turnZ(0, 0);
            }
            for (int i = 0; i < 5; i++) {
                if ((cubick.getCubick(0, 2, 2).equals(cubick.getCubick(1, 1, 1)) ||
                        cubick.getCubick(1, 0, 2).equals(cubick.getCubick(1, 1, 1)) ||
                        cubick.getCubick(5, 0, 0).equals(cubick.getCubick(1, 1, 1))) &&
                        (cubick.getCubick(0, 2, 2).equals(cubick.getCubick(5, 1, 1)) ||
                                cubick.getCubick(1, 0, 2).equals(cubick.getCubick(5, 1, 1)) ||
                                cubick.getCubick(5, 0, 0).equals(cubick.getCubick(5, 1, 1)))) {
                    break;
                }
                cubick.turnZ(1, 1);
                cubick.turnZ(2, 1);
            }
            while (!cubick.getCubick(2, 0, 2).equals("w") || !cubick.getCubick(1, 2, 2).equals(cubick.getCubick(1, 1, 1)) ||
                    !cubick.getCubick(5, 2, 0).equals(cubick.getCubick(5, 1, 1))) {
                cubick = rightAlgorithm(cubick);
            }
            vix++;
            if (vix == 40) {
                cubick.turnZ(1, 1);
                cubick.turnZ(2, 1);
                vix = 0;
            }
        }
        return cubick;
    }

    private static Cubick rightleftAlgorithm(Cubick cubick) {
        cubick.turnZ(0, 0);

        cubick = rightAlgorithm(cubick);

        cubick.turnZ(0, 0);
        cubick.turnZ(1, 0);
        cubick.turnZ(2, 0);

        cubick = leftAlgorithm(cubick);
        return cubick;
    }

    private static Cubick leftrightAlgorithm(Cubick cubick) {
        cubick.turnZ(0, 1);

        cubick = leftAlgorithm(cubick);

        cubick.turnZ(0, 1);
        cubick.turnZ(1, 1);
        cubick.turnZ(2, 1);

        cubick = rightAlgorithm(cubick);
        return cubick;
    }

    private static boolean checkTwo(Cubick cubick) {
        return !cubick.getCubick(1, 1, 1).equals(cubick.getCubick(1, 1, 2)) ||
                !cubick.getCubick(1, 1, 1).equals(cubick.getCubick(1, 1, 0)) ||
                !cubick.getCubick(5, 1, 1).equals(cubick.getCubick(5, 1, 2)) ||
                !cubick.getCubick(5, 1, 1).equals(cubick.getCubick(5, 1, 0)) ||
                !cubick.getCubick(4, 1, 1).equals(cubick.getCubick(4, 1, 2)) ||
                !cubick.getCubick(4, 1, 1).equals(cubick.getCubick(4, 1, 0)) ||
                !cubick.getCubick(3, 1, 1).equals(cubick.getCubick(3, 1, 2)) ||
                !cubick.getCubick(3, 1, 1).equals(cubick.getCubick(3, 1, 0));
    }

    public static Cubick secondLayer(Cubick cubick) {
        while (checkTwo(cubick)) {
            for (int i = 0; i < 10; i++) {
                if (cubick.getCubick(1, 0, 1).equals(cubick.getCubick(1, 1, 1)) &&
                        !cubick.getCubick(0, 2, 1).equals("y")) {
                    if (cubick.getCubick(0, 2, 1).equals(cubick.getCubick(5, 1, 1))) {
                        cubick = rightleftAlgorithm(cubick);
                    } else {
                        cubick = leftrightAlgorithm(cubick);
                    }
                }
                for (int j = 0; j < 5; j++) {
                    if (cubick.getCubick(0, 2, 1).equals("y") || cubick.getCubick(1, 0, 1).equals("y")) {
                        cubick.turnZ(0, 1);
                    } else {
                        break;
                    }
                }
                cubick.turnZ(1, 1);
                cubick.turnZ(2, 1);
            }
            if (checkTwo(cubick)) {
                while (cubick.getCubick(1, 1, 2).equals(cubick.getCubick(1, 1, 1)) &&
                        cubick.getCubick(5, 1, 0).equals(cubick.getCubick(5, 1, 1))) {
                    cubick.turnZ(1, 1);
                    cubick.turnZ(2, 1);
                }
                cubick = rightleftAlgorithm(cubick);
            }
        }
        return cubick;
    }

    private static Cubick yellowCrossHelps(Cubick cubick) {
        cubick.turnY(2, 0);
        cubick.turnX(2, 1);
        cubick.turnZ(0, 0);
        cubick.turnX(2, 0);
        cubick.turnZ(0, 1);
        cubick.turnY(2, 1);
        return cubick;
    }

    public static Cubick yellowCross(Cubick cubick) {
        while (!cubick.getCubick(0, 0, 1).equals("y") || !cubick.getCubick(0, 1, 0).equals("y")
                || !cubick.getCubick(0, 1, 2).equals("y") || !cubick.getCubick(0, 2, 1).equals("y")) {
            for (int i = 0; i < 4; i++) {
                if (cubick.getCubick(0, 1, 0).equals("y") && cubick.getCubick(0, 1, 1).equals("y")
                        && cubick.getCubick(0, 1, 2).equals("y")) {
                    cubick = yellowCrossHelps(cubick);
                    break;
                }
                if (cubick.getCubick(0, 1, 0).equals("y") && cubick.getCubick(0, 0, 1).equals("y")
                        && cubick.getCubick(0, 1, 1).equals("y") && !cubick.getCubick(0, 2, 1).equals("y")
                        && !cubick.getCubick(0, 1, 2).equals("y")) {
                    cubick = yellowCrossHelps(cubick);
                    cubick = yellowCrossHelps(cubick);
                    break;
                }
                cubick.turnZ(0, 1);
            }
            if (!cubick.getCubick(0, 1, 0).equals("y") && !cubick.getCubick(0, 1, 2).equals("y")
                    && !cubick.getCubick(0, 0, 1).equals("y") && !cubick.getCubick(0, 2, 1).equals("y")) {
                cubick = yellowCrossHelps(cubick);
                cubick = yellowCrossHelps(cubick);
            }

        }
        return cubick;
    }

    private static Cubick threeRightThreeleftAlgorithms(Cubick cubick) {
        cubick = rightAlgorithm(cubick);

        cubick = rightAlgorithm(cubick);

        cubick = rightAlgorithm(cubick);

        cubick.turnZ(0, 0);
        cubick.turnZ(1, 0);
        cubick.turnZ(2, 0);

        cubick = leftAlgorithm(cubick);

        cubick = leftAlgorithm(cubick);

        cubick = leftAlgorithm(cubick);
        return cubick;
    }

    private static Cubick checkOnTheGroundAnglesOrNot(Cubick cubick) {
        int c;
        while (true) {
            c = 0;
            for (int i = 0; i < 4; i++) {
                c = 0;
                if (checkAngleZeroFourTree(cubick)) {
                    c++;
                }
                if (checkAngleZeroFourOne(cubick)) {
                    c++;
                }
                if (c == 2) {
                    break;
                }
                cubick.turnZ(0, 1);
            }
            if (c == 2) {
                break;
            }
            cubick.turnZ(2, 1);
            cubick.turnZ(1, 1);
        }
        return cubick;
    }

    private static boolean checkAngleZeroFourOne(Cubick cubick) {
        return (cubick.getCubick(0, 2, 0).equals(cubick.getCubick(0, 1, 1)) ||
                cubick.getCubick(0, 2, 0).equals(cubick.getCubick(4, 1, 1)) ||
                cubick.getCubick(0, 2, 0).equals(cubick.getCubick(1, 1, 1))) &&
                (cubick.getCubick(1, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(1, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                        cubick.getCubick(1, 0, 0).equals(cubick.getCubick(1, 1, 1))) &&
                (cubick.getCubick(4, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(4, 0, 2).equals(cubick.getCubick(4, 1, 1)) ||
                        cubick.getCubick(4, 0, 2).equals(cubick.getCubick(1, 1, 1)));
    }

    private static boolean checkAngleZeroFourTree(Cubick cubick) {
        return (cubick.getCubick(0, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                cubick.getCubick(0, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                cubick.getCubick(0, 0, 0).equals(cubick.getCubick(3, 1, 1))) &&
                (cubick.getCubick(4, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(4, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                        cubick.getCubick(4, 0, 0).equals(cubick.getCubick(3, 1, 1))) &&
                (cubick.getCubick(3, 2, 0).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(3, 2, 0).equals(cubick.getCubick(4, 1, 1)) ||
                        cubick.getCubick(3, 2, 0).equals(cubick.getCubick(3, 1, 1)));
    }

    private static boolean checkAngleZeroFiveTree(Cubick cubick) {
        return (cubick.getCubick(0, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                cubick.getCubick(0, 0, 2).equals(cubick.getCubick(5, 1, 1)) ||
                cubick.getCubick(0, 0, 2).equals(cubick.getCubick(3, 1, 1))) &&
                (cubick.getCubick(5, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(5, 0, 2).equals(cubick.getCubick(5, 1, 1)) ||
                        cubick.getCubick(5, 0, 2).equals(cubick.getCubick(3, 1, 1))) &&
                (cubick.getCubick(3, 2, 2).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(3, 2, 2).equals(cubick.getCubick(5, 1, 1)) ||
                        cubick.getCubick(3, 2, 2).equals(cubick.getCubick(3, 1, 1)));
    }

    private static boolean checkAngleZeroOneFive(Cubick cubick) {
        return (cubick.getCubick(0, 2, 2).equals(cubick.getCubick(0, 1, 1)) ||
                cubick.getCubick(0, 2, 2).equals(cubick.getCubick(5, 1, 1)) ||
                cubick.getCubick(0, 2, 2).equals(cubick.getCubick(1, 1, 1))) &&
                (cubick.getCubick(1, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(1, 0, 2).equals(cubick.getCubick(5, 1, 1)) ||
                        cubick.getCubick(1, 0, 2).equals(cubick.getCubick(1, 1, 1))) &&
                (cubick.getCubick(5, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(5, 0, 0).equals(cubick.getCubick(5, 1, 1)) ||
                        cubick.getCubick(5, 0, 0).equals(cubick.getCubick(1, 1, 1)));
    }

    public static Cubick yellowCornersIntoPlace(Cubick cubick) {
        int count = 0;
        int count1 = 0;
        int countgl;
        while (count != 2 && count1 != 2) {
            for (int i = 0; i < 4; i++) {
                count = 0;
                count1 = 0;
                countgl = 0;
                if (checkAngleZeroOneFive(cubick)) {
                    countgl++;
                }
                if (checkAngleZeroFiveTree(cubick)) {
                    count1++;
                    countgl++;
                }
                if (checkAngleZeroFourTree(cubick)) {
                    count++;
                    countgl++;
                }
                if (checkAngleZeroFourOne(cubick)) {
                    count++;
                    count1++;
                    countgl++;
                }
                if (countgl == 4) {
                    return cubick;
                }
                if (count1 == 2 || count == 2) {
                    break;
                }
                cubick.turnZ(0, 1);
            }
            if (count1 == 2 && count == 2) {
                break;
            }
            cubick.turnZ(1, 1);
            cubick.turnZ(2, 1);
        }
        if (count == 2) {
            cubick = threeRightThreeleftAlgorithms(cubick);
            cubick = checkOnTheGroundAnglesOrNot(cubick);
        }
        if (count1 == 2) {
            cubick = threeRightThreeleftAlgorithms(cubick);
            cubick = checkOnTheGroundAnglesOrNot(cubick);
            cubick = threeRightThreeleftAlgorithms(cubick);
        }
        cubick = checkOnTheGroundAnglesOrNot(cubick);
        return cubick;
    }

    private static Cubick twoTurnX(Cubick cubick) {
        cubick.turnX(0, 0);
        cubick.turnX(1, 0);
        cubick.turnX(2, 0);
        cubick.turnX(0, 0);
        cubick.turnX(1, 0);
        cubick.turnX(2, 0);
        return cubick;
    }

    public static Cubick yellowSide(Cubick cubick) {
        cubick = twoTurnX(cubick);
        while (!cubick.getCubick(2, 0, 2).equals("y") || !cubick.getCubick(2, 0, 0).equals("y")
                || !cubick.getCubick(2, 2, 2).equals("y") || !cubick.getCubick(2, 2, 0).equals("y")) {
            while (!cubick.getCubick(1, 2, 2).equals("y") && !cubick.getCubick(5, 2, 0).equals("y")) {
                cubick.turnZ(2, 0);
            }
            while (!cubick.getCubick(2, 0, 2).equals("y")) {
                cubick = rightAlgorithm(cubick);
            }
            cubick.turnZ(2, 0);
        }
        while (!cubick.getCubick(1, 2, 2).equals(cubick.getCubick(1, 1, 1))) {
            cubick.turnZ(2, 0);
        }
        cubick = twoTurnX(cubick);
        return cubick;
    }

    private static Cubick finalAlg(Cubick cubick) {
        cubick = rightAlgorithm(cubick);
        cubick = leftAlgorithm(cubick);
        cubick = rightAlgorithm(cubick);
        cubick = rightAlgorithm(cubick);
        cubick = rightAlgorithm(cubick);
        cubick = rightAlgorithm(cubick);
        cubick = rightAlgorithm(cubick);
        cubick = leftAlgorithm(cubick);
        cubick = leftAlgorithm(cubick);
        cubick = leftAlgorithm(cubick);
        cubick = leftAlgorithm(cubick);
        cubick = leftAlgorithm(cubick);
        return cubick;
    }

    private static Cubick finalAlgSecond(Cubick cubick) {
        for (int i = 0; i < 4; i++) {
            if (cubick.getCubick(1, 1, 1).equals(cubick.getCubick(1, 0, 1))) {
                while (!cubick.getCubick(1, 1, 1).equals(cubick.getCubick(1, 0, 1)) ||
                        !cubick.getCubick(4, 1, 1).equals(cubick.getCubick(4, 0, 1))) {
                    cubick = finalAlg(cubick);
                }
                return cubick;
            }
            cubick.turnZ(0, 1);
            cubick.turnZ(1, 1);
            cubick.turnZ(2, 1);
        }
        return cubick;
    }

    public static Cubick fullCubick(Cubick cubick) {
        cubick = finalAlgSecond(cubick);
        cubick = finalAlg(cubick);
        cubick = finalAlgSecond(cubick);
        return cubick;
    }
}
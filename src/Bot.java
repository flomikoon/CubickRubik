public class Bot {
    //Stage 1
    public static Cubick UpYellowCenter(Cubick cubick) {
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

    private static Cubick CubPolCross(Cubick cubick, int pos) {
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

    private static Cubick CubPolCross(Cubick cubick) {
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

    private static boolean prov(Cubick cubick, int pos1, int pos) {
        return !cubick.getCubick(1, pos1, pos).equals("w") && !cubick.getCubick(4, pos1, pos).equals("w")
                && !cubick.getCubick(5, pos1, pos).equals("w") && !cubick.getCubick(2, pos1, pos).equals("w")
                && !cubick.getCubick(3, pos1, pos).equals("w");
    }

    public static Cubick Cross(Cubick cubick) {
        while (!(Bot.prov(cubick, 1, 0) && Bot.prov(cubick, 1, 2)) ||
                !(Bot.prov(cubick, 0, 1) && Bot.prov(cubick, 2, 1))) {
            while (!(Bot.prov(cubick, 1, 0) && Bot.prov(cubick, 1, 2))) {
                for (int i = 0; i < 4; i++) {
                    cubick = Bot.CubPolCross(cubick, 0);
                }
                for (int i = 0; i < 4; i++) {
                    cubick = Bot.CubPolCross(cubick, 2);
                }
            }
            if (!(Bot.prov(cubick, 0, 1) && Bot.prov(cubick, 2, 1))) {
                cubick = Bot.CubPolCross(cubick);
            }
        }
        return cubick;
    }

    //Stage 1.2
    public static Cubick CrossFull(Cubick cubick) {
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

    public static Cubick OneSlou(Cubick cubick) {
        int vix = 0;
        while (!cubick.getCubick(2, 0, 0).equals("w") || !cubick.getCubick(2, 0, 2).equals("w") ||
                !cubick.getCubick(2, 2, 0).equals("w") || !cubick.getCubick(2, 2, 2).equals("w")) {
            int count = 0;
            while (!cubick.getCubick(0, 2, 2).equals("w") && !cubick.getCubick(5, 0, 0).equals("w")
                    && !cubick.getCubick(1, 0, 2).equals("w")) {
                count++;
                if (count == 6) {
                    cubick.turnX(2, 1);
                    cubick.turnZ(0, 0);
                    cubick.turnX(2, 0);
                    cubick.turnZ(0, 1);
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
                cubick.turnX(2, 1);
                cubick.turnZ(0, 0);
                cubick.turnX(2, 0);
                cubick.turnZ(0, 1);
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

    private static Cubick RightAlg(Cubick cubick) {
        cubick.turnZ(0, 0);
        cubick.turnX(2, 1);
        cubick.turnZ(0, 0);
        cubick.turnX(2, 0);
        cubick.turnZ(0, 1);
        cubick.turnZ(0, 0);
        cubick.turnZ(1, 0);
        cubick.turnZ(2, 0);
        cubick.turnX(0, 1);
        cubick.turnZ(0, 1);
        cubick.turnX(0, 0);
        cubick.turnZ(0, 0);
        return cubick;
    }

    private static Cubick LeftAlg(Cubick cubick) {
        cubick.turnZ(0, 1);
        cubick.turnX(0, 1);
        cubick.turnZ(0, 1);
        cubick.turnX(0, 0);
        cubick.turnZ(0, 0);
        cubick.turnZ(0, 1);
        cubick.turnZ(1, 1);
        cubick.turnZ(2, 1);
        cubick.turnX(2, 1);
        cubick.turnZ(0, 0);
        cubick.turnX(2, 0);
        cubick.turnZ(0, 1);
        return cubick;
    }

    private static boolean prov2(Cubick cubick) {
        return !cubick.getCubick(1, 1, 1).equals(cubick.getCubick(1, 1, 2)) ||
                !cubick.getCubick(1, 1, 1).equals(cubick.getCubick(1, 1, 0)) ||
                !cubick.getCubick(5, 1, 1).equals(cubick.getCubick(5, 1, 2)) ||
                !cubick.getCubick(5, 1, 1).equals(cubick.getCubick(5, 1, 0)) ||
                !cubick.getCubick(4, 1, 1).equals(cubick.getCubick(4, 1, 2)) ||
                !cubick.getCubick(4, 1, 1).equals(cubick.getCubick(4, 1, 0)) ||
                !cubick.getCubick(3, 1, 1).equals(cubick.getCubick(3, 1, 2)) ||
                !cubick.getCubick(3, 1, 1).equals(cubick.getCubick(3, 1, 0));
    }

    public static Cubick SecondSide(Cubick cubick) {
        while (prov2(cubick)) {
            for (int i = 0; i < 10; i++) {
                if (cubick.getCubick(1, 0, 1).equals(cubick.getCubick(1, 1, 1)) &&
                        !cubick.getCubick(0, 2, 1).equals("y")) {
                    if (cubick.getCubick(0, 2, 1).equals(cubick.getCubick(5, 1, 1))) {
                        cubick = RightAlg(cubick);
                    } else {
                        cubick = LeftAlg(cubick);
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
            if (prov2(cubick)) {
                while (cubick.getCubick(1, 1, 2).equals(cubick.getCubick(1, 1, 1)) &&
                        cubick.getCubick(5, 1, 0).equals(cubick.getCubick(5, 1, 1))) {
                    cubick.turnZ(1, 1);
                    cubick.turnZ(2, 1);
                }
                cubick = RightAlg(cubick);
            }
        }
        return cubick;
    }

    private static Cubick CrossOne(Cubick cubick) {
        cubick.turnY(2, 0);
        cubick.turnX(2, 1);
        cubick.turnZ(0, 0);
        cubick.turnX(2, 0);
        cubick.turnZ(0, 1);
        cubick.turnY(2, 1);
        return cubick;
    }

    public static Cubick YellowCross(Cubick cubick) {
        while (!cubick.getCubick(0, 0, 1).equals("y") || !cubick.getCubick(0, 1, 0).equals("y")
                || !cubick.getCubick(0, 1, 2).equals("y") || !cubick.getCubick(0, 2, 1).equals("y")) {
            for (int i = 0; i < 4; i++) {
                if (cubick.getCubick(0, 1, 0).equals("y") && cubick.getCubick(0, 1, 1).equals("y")
                        && cubick.getCubick(0, 1, 2).equals("y")) {
                    cubick = CrossOne(cubick);
                    break;
                }
                if (cubick.getCubick(0, 1, 0).equals("y") && cubick.getCubick(0, 0, 1).equals("y")
                        && cubick.getCubick(0, 1, 1).equals("y") && !cubick.getCubick(0, 2, 1).equals("y")
                        && !cubick.getCubick(0, 1, 2).equals("y")) {
                    cubick = CrossOne(cubick);
                    cubick = CrossOne(cubick);
                    break;
                }
                cubick.turnZ(0, 1);
            }
            if (!cubick.getCubick(0, 1, 0).equals("y") && !cubick.getCubick(0, 1, 2).equals("y")
                    && !cubick.getCubick(0, 0, 1).equals("y") && !cubick.getCubick(0, 2, 1).equals("y")) {
                cubick = CrossOne(cubick);
                cubick = CrossOne(cubick);
            }

        }
        return cubick;
    }

    private static Cubick Pov(Cubick cubick) {
        cubick.turnX(2, 1);
        cubick.turnZ(0, 0);
        cubick.turnX(2, 0);
        cubick.turnZ(0, 1);

        cubick.turnX(2, 1);
        cubick.turnZ(0, 0);
        cubick.turnX(2, 0);
        cubick.turnZ(0, 1);

        cubick.turnX(2, 1);
        cubick.turnZ(0, 0);
        cubick.turnX(2, 0);
        cubick.turnZ(0, 1);

        cubick.turnZ(0, 0);
        cubick.turnZ(1, 0);
        cubick.turnZ(2, 0);

        cubick.turnX(0, 1);
        cubick.turnZ(0, 1);
        cubick.turnX(0, 0);
        cubick.turnZ(0, 0);

        cubick.turnX(0, 1);
        cubick.turnZ(0, 1);
        cubick.turnX(0, 0);
        cubick.turnZ(0, 0);

        cubick.turnX(0, 1);
        cubick.turnZ(0, 1);
        cubick.turnX(0, 0);
        cubick.turnZ(0, 0);
        return cubick;
    }

    private static Cubick Full(Cubick cubick) {
        int c;
        while (true) {
            c = 0;
            for (int i = 0; i < 4; i++) {
                c = 0;
                if ((cubick.getCubick(0, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(0, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                        cubick.getCubick(0, 0, 0).equals(cubick.getCubick(3, 1, 1))) &&
                        (cubick.getCubick(4, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(4, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                                cubick.getCubick(4, 0, 0).equals(cubick.getCubick(3, 1, 1))) &&
                        (cubick.getCubick(3, 2, 0).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(3, 2, 0).equals(cubick.getCubick(4, 1, 1)) ||
                                cubick.getCubick(3, 2, 0).equals(cubick.getCubick(3, 1, 1)))) {
                    c++;
                }
                if ((cubick.getCubick(0, 2, 0).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(0, 2, 0).equals(cubick.getCubick(4, 1, 1)) ||
                        cubick.getCubick(0, 2, 0).equals(cubick.getCubick(1, 1, 1))) &&
                        (cubick.getCubick(1, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(1, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                                cubick.getCubick(1, 0, 0).equals(cubick.getCubick(1, 1, 1))) &&
                        (cubick.getCubick(4, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(4, 0, 2).equals(cubick.getCubick(4, 1, 1)) ||
                                cubick.getCubick(4, 0, 2).equals(cubick.getCubick(1, 1, 1)))) {
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

    public static Cubick YellowUgl(Cubick cubick) {
        int count = 0;
        int count1 = 0;
        int countgl;
        while (count != 2 && count1 != 2) {
            for (int i = 0; i < 4; i++) {
                count = 0;
                count1 = 0;
                countgl = 0;
                if ((cubick.getCubick(0, 2, 2).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(0, 2, 2).equals(cubick.getCubick(5, 1, 1)) ||
                        cubick.getCubick(0, 2, 2).equals(cubick.getCubick(1, 1, 1))) &&
                        (cubick.getCubick(1, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(1, 0, 2).equals(cubick.getCubick(5, 1, 1)) ||
                                cubick.getCubick(1, 0, 2).equals(cubick.getCubick(1, 1, 1))) &&
                        (cubick.getCubick(5, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(5, 0, 0).equals(cubick.getCubick(5, 1, 1)) ||
                                cubick.getCubick(5, 0, 0).equals(cubick.getCubick(1, 1, 1)))) {
                    countgl++;
                }
                if ((cubick.getCubick(0, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(0, 0, 2).equals(cubick.getCubick(5, 1, 1)) ||
                        cubick.getCubick(0, 0, 2).equals(cubick.getCubick(3, 1, 1))) &&
                        (cubick.getCubick(5, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(5, 0, 2).equals(cubick.getCubick(5, 1, 1)) ||
                                cubick.getCubick(5, 0, 2).equals(cubick.getCubick(3, 1, 1))) &&
                        (cubick.getCubick(3, 2, 2).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(3, 2, 2).equals(cubick.getCubick(5, 1, 1)) ||
                                cubick.getCubick(3, 2, 2).equals(cubick.getCubick(3, 1, 1)))) {
                    count1++;
                    countgl++;
                }
                if ((cubick.getCubick(0, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(0, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                        cubick.getCubick(0, 0, 0).equals(cubick.getCubick(3, 1, 1))) &&
                        (cubick.getCubick(4, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(4, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                                cubick.getCubick(4, 0, 0).equals(cubick.getCubick(3, 1, 1))) &&
                        (cubick.getCubick(3, 2, 0).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(3, 2, 0).equals(cubick.getCubick(4, 1, 1)) ||
                                cubick.getCubick(3, 2, 0).equals(cubick.getCubick(3, 1, 1)))) {
                    count++;
                    countgl++;
                }
                if ((cubick.getCubick(0, 2, 0).equals(cubick.getCubick(0, 1, 1)) ||
                        cubick.getCubick(0, 2, 0).equals(cubick.getCubick(4, 1, 1)) ||
                        cubick.getCubick(0, 2, 0).equals(cubick.getCubick(1, 1, 1))) &&
                        (cubick.getCubick(1, 0, 0).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(1, 0, 0).equals(cubick.getCubick(4, 1, 1)) ||
                                cubick.getCubick(1, 0, 0).equals(cubick.getCubick(1, 1, 1))) &&
                        (cubick.getCubick(4, 0, 2).equals(cubick.getCubick(0, 1, 1)) ||
                                cubick.getCubick(4, 0, 2).equals(cubick.getCubick(4, 1, 1)) ||
                                cubick.getCubick(4, 0, 2).equals(cubick.getCubick(1, 1, 1)))) {
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
            cubick = Pov(cubick);
            cubick = Full(cubick);
        }
        if (count1 == 2) {
            cubick.prin();
            cubick = Pov(cubick);
            cubick = Full(cubick);
            cubick.prin();
            cubick = Pov(cubick);
        }
        cubick = Full(cubick);
        return cubick;
    }
}
public class Bot {
    //Stage 1
    public static Cubick UpWhiteCenter(Cubick cubick) {
        if (cubick.getCubick(0, 1, 1).equals("w")) {
            return cubick;
        }
        if (cubick.getCubick(1, 1, 1).equals("w")) {
            cubick.turnX(1, 1);
            return cubick;
        }
        if (cubick.getCubick(2, 1, 1).equals("w")) {
            cubick.turnX(1, 1);
            cubick.turnX(1, 1);
            return cubick;
        }
        if (cubick.getCubick(3, 1, 1).equals("w")) {
            cubick.turnX(1, 1);
            cubick.turnX(1, 1);
            cubick.turnX(1, 1);
            return cubick;
        }
        if (cubick.getCubick(4, 1, 1).equals("w")) {
            cubick.turnY(1, 0);
            return cubick;
        }
        if (cubick.getCubick(5, 1, 1).equals("w")) {
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

    //Stage 2
    public static Cubick CrossFull(Cubick cubick) {

        return cubick;
    }
}
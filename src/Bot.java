import java.util.Random;

public class Bot {
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


    private static Cubick CubPolCre(Cubick cubick, int pos) {
        int count = 0;
        while (cubick.getCubick(0, 1, pos).equals("w")) {
            count++;
            cubick.turnZ(0, 1);
            if (count == 4) {
                break;
            }
        }
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

    private static Cubick CubPolCrest(Cubick cubick) {
        int count = 0;
        if (cubick.getCubick(2, 0, 1).equals("w") || cubick.getCubick(2, 2, 1).equals("w")) {
            cubick.turnZ(2, 1);
            return cubick;
        }
        if (cubick.getCubick(5, 0, 1).equals("w") || cubick.getCubick(5, 2, 1).equals("w")) {
            while (cubick.getCubick(0, 1, 2).equals("w")) {
                count++;
                cubick.turnZ(0, 1);
                if (count == 4) {
                    break;
                }
            }
            cubick.turnX(2, 1);
            return cubick;
        }
        if (cubick.getCubick(4, 0, 1).equals("w") || cubick.getCubick(4, 2, 1).equals("w")) {
            while (cubick.getCubick(0, 1, 0).equals("w")) {
                count++;
                cubick.turnZ(0, 1);
                if (count == 4) {
                    break;
                }
            }
            cubick.turnX(0, 1);
            return cubick;
        }
        if (cubick.getCubick(1, 0, 1).equals("w") || cubick.getCubick(1, 2, 1).equals("w")) {
            while (cubick.getCubick(0, 2, 1).equals("w")) {
                count++;
                cubick.turnZ(0, 1);
                if (count == 4) {
                    break;
                }
            }
            cubick.turnY(2, 1);
            return cubick;
        }
        if (cubick.getCubick(3, 0, 1).equals("w") || cubick.getCubick(3, 2, 1).equals("w")) {
            while (cubick.getCubick(0, 0, 1).equals("w")) {
                count++;
                cubick.turnZ(0, 1);
                if (count == 4) {
                    break;
                }
            }
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
   /* private static boolean prov2(Cubick cubick , int pos){
        return !cubick.getCubick(1, pos, 1).equals("w") && !cubick.getCubick(4, pos, 1).equals("w")
                && !cubick.getCubick(5, pos, 1).equals("w") && !cubick.getCubick(2, pos, 1).equals("w")
                && !cubick.getCubick(3, pos, 1).equals("w");
    }*/

    public static Cubick Crest(Cubick cubick) {
        int count;
        while (!(Bot.prov(cubick, 1, 0) && Bot.prov(cubick, 1, 2)) || !(Bot.prov(cubick, 0, 1) && Bot.prov(cubick, 2, 1))) {
            while (!(Bot.prov(cubick, 1, 0) && Bot.prov(cubick, 1, 2))) {
                count = 0;
                while (count != 5) {
                    cubick = Bot.CubPolCre(cubick, 0);
                    count++;
                }
                count = 0;
                while (count != 5) {
                    cubick = Bot.CubPolCre(cubick, 2);
                    count++;
                }
            }
            if (!(Bot.prov(cubick, 0, 1) && Bot.prov(cubick, 2, 1))) {
                cubick = Bot.CubPolCrest(cubick);
            }
            cubick.prin();
        }
        return cubick;
    }
}


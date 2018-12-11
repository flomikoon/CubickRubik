import java.util.Random;

public class Cubick {
    private String[][][] cubick;

    Cubick() {
        cubick = new String[6][3][3];
        String[] mas = new String[]{"o", "w", "r", "y", "g", "b"};
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cubick[i][j][k] = mas[i];
                }
            }
        }
    }

    public String getCubick(int first, int two, int free) {
        return cubick[first][two][free];
    }

    private void runbokan(int line) {
        String cubcop2 = cubick[line][0][1];
        String cubcop3 = cubick[line][0][0];
        cubick[line][0][0] = cubick[line][0][2];
        cubick[line][0][1] = cubick[line][1][2];
        cubick[line][0][2] = cubick[line][2][2];
        cubick[line][1][2] = cubick[line][2][1];
        cubick[line][2][2] = cubick[line][2][0];
        cubick[line][2][1] = cubick[line][1][0];
        cubick[line][2][0] = cubcop3;
        cubick[line][1][0] = cubcop2;
    }

    private void runbokpo(int line) {
        String cubcop2 = cubick[line][0][1];
        String cubcop3 = cubick[line][0][2];
        cubick[line][0][2] = cubick[line][0][0];
        cubick[line][0][0] = cubick[line][2][0];
        cubick[line][0][1] = cubick[line][1][0];
        cubick[line][1][0] = cubick[line][2][1];
        cubick[line][2][0] = cubick[line][2][2];
        cubick[line][2][1] = cubick[line][1][2];
        cubick[line][1][2] = cubcop2;
        cubick[line][2][2] = cubcop3;
    }

    private void runlineXpoCh(int line) {
        String cubcop1 = cubick[0][0][line];
        String cubcop2 = cubick[0][1][line];
        String cubcop3 = cubick[0][2][line];
        for (int i = 3; i >= 0; i--) {
            int copi = i;
            if (i == 3) {
                copi = -1;
            }
            cubick[copi + 1][2][line] = cubick[i][2][line];
            cubick[copi + 1][1][line] = cubick[i][1][line];
            cubick[copi + 1][0][line] = cubick[i][0][line];
        }
        cubick[1][2][line] = cubcop3;
        cubick[1][1][line] = cubcop2;
        cubick[1][0][line] = cubcop1;
    }

    private void runlineXanCh(int line) {
        String cubcop1 = cubick[0][0][line];
        String cubcop2 = cubick[0][1][line];
        String cubcop3 = cubick[0][2][line];
        cubick[0][2][line] = cubick[1][2][line];
        cubick[0][1][line] = cubick[1][1][line];
        cubick[0][0][line] = cubick[1][0][line];

        cubick[1][2][line] = cubick[2][2][line];
        cubick[1][1][line] = cubick[2][1][line];
        cubick[1][0][line] = cubick[2][0][line];

        cubick[2][2][line] = cubick[3][2][line];
        cubick[2][1][line] = cubick[3][1][line];
        cubick[2][0][line] = cubick[3][0][line];

        cubick[3][2][line] = cubcop3;
        cubick[3][1][line] = cubcop2;
        cubick[3][0][line] = cubcop1;
    }


    public void turnX(int line, int napravl) {
        if (napravl == 1) {
            if (line == 1) {
                runlineXanCh(1);
            }
            if (line == 0) {
                runlineXanCh(0);
                runbokan(4);
            }
            if (line == 2) {
                runlineXanCh(2);
                runbokpo(5);
            }
        } else {
            if (line == 1) {
                runlineXpoCh(1);
            }
            if (line == 0) {
                runlineXpoCh(0);
                runbokpo(4);
            }
            if (line == 2) {
                runlineXpoCh(2);
                runbokan(5);
            }
        }
    }

    private void runlineZpoCh(int line) {
        int licop = 1;
        if (line == 2) {
            licop = 0;
        }
        if (line == 0) {
            licop = 2;
        }
        String cubcop1 = cubick[1][line][0];
        String cubcop2 = cubick[1][line][1];
        String cubcop3 = cubick[1][line][2];
        cubick[1][line][2] = cubick[5][line][2];
        cubick[1][line][1] = cubick[5][line][1];
        cubick[1][line][0] = cubick[5][line][0];

        cubick[5][line][2] = cubick[3][licop][0];
        cubick[5][line][1] = cubick[3][licop][1];
        cubick[5][line][0] = cubick[3][licop][2];

        cubick[3][licop][2] = cubick[4][line][0];
        cubick[3][licop][1] = cubick[4][line][1];
        cubick[3][licop][0] = cubick[4][line][2];

        cubick[4][line][2] = cubcop3;
        cubick[4][line][1] = cubcop2;
        cubick[4][line][0] = cubcop1;
    }

    private void runlineZanCh(int line) {
        int licop = 1;
        if (line == 2) {
            licop = 0;
        }
        if (line == 0) {
            licop = 2;
        }
        String cubcop1 = cubick[1][line][0];
        String cubcop2 = cubick[1][line][1];
        String cubcop3 = cubick[1][line][2];
        cubick[1][line][2] = cubick[4][line][2];
        cubick[1][line][1] = cubick[4][line][1];
        cubick[1][line][0] = cubick[4][line][0];

        cubick[4][line][2] = cubick[3][licop][0];
        cubick[4][line][1] = cubick[3][licop][1];
        cubick[4][line][0] = cubick[3][licop][2];

        cubick[3][licop][2] = cubick[5][line][0];
        cubick[3][licop][1] = cubick[5][line][1];
        cubick[3][licop][0] = cubick[5][line][2];

        cubick[5][line][2] = cubcop3;
        cubick[5][line][1] = cubcop2;
        cubick[5][line][0] = cubcop1;
    }

    public void turnZ(int line, int napravl) {
        if (napravl == 1) {
            if (line == 1) {
                runlineZanCh(1);
            }
            if (line == 0) {
                runlineZanCh(0);
                runbokan(0);
            }
            if (line == 2) {
                runlineZanCh(2);
                runbokpo(2);
            }
        } else {
            if (line == 1) {
                runlineZpoCh(1);
            }
            if (line == 0) {
                runlineZpoCh(0);
                runbokpo(0);
            }
            if (line == 2) {
                runlineZpoCh(2);
                runbokan(2);
            }
        }
    }

    private void runlineYpoCh(int line) {
        int licop = 1;
        if (line == 2) {
            licop = 0;
        }
        if (line == 0) {
            licop = 2;
        }
        String cubcop1 = cubick[0][line][0];
        String cubcop2 = cubick[0][line][1];
        String cubcop3 = cubick[0][line][2];
        cubick[0][line][2] = cubick[4][0][line];
        cubick[0][line][1] = cubick[4][1][line];
        cubick[0][line][0] = cubick[4][2][line];

        cubick[4][2][line] = cubick[2][licop][2];
        cubick[4][1][line] = cubick[2][licop][1];
        cubick[4][0][line] = cubick[2][licop][0];

        cubick[2][licop][2] = cubick[5][0][licop];
        cubick[2][licop][1] = cubick[5][1][licop];
        cubick[2][licop][0] = cubick[5][2][licop];

        cubick[5][0][licop] = cubcop1;
        cubick[5][1][licop] = cubcop2;
        cubick[5][2][licop] = cubcop3;
    }

    private void runlineYanCh(int line) {
        int licop = 1;
        if (line == 2) {
            licop = 0;
        }
        if (line == 0) {
            licop = 2;
        }
        String cubcop1 = cubick[0][line][0];
        String cubcop2 = cubick[0][line][1];
        String cubcop3 = cubick[0][line][2];
        cubick[0][line][2] = cubick[5][2][licop];
        cubick[0][line][1] = cubick[5][1][licop];
        cubick[0][line][0] = cubick[5][0][licop];

        cubick[5][2][licop] = cubick[2][licop][0];
        cubick[5][1][licop] = cubick[2][licop][1];
        cubick[5][0][licop] = cubick[2][licop][2];

        cubick[2][licop][0] = cubick[4][0][line];
        cubick[2][licop][1] = cubick[4][1][line];
        cubick[2][licop][2] = cubick[4][2][line];

        cubick[4][0][line] = cubcop3;
        cubick[4][1][line] = cubcop2;
        cubick[4][2][line] = cubcop1;
    }

    public void turnY(int line, int napravl) {
        if (napravl == 1) {
            if (line == 1) {
                runlineYanCh(1);
            }
            if (line == 0) {
                runlineYanCh(0);
                runbokpo(3);
            }
            if (line == 2) {
                runlineYanCh(2);
                runbokan(1);
            }
        } else {
            if (line == 1) {
                runlineYpoCh(1);
            }
            if (line == 0) {
                runlineYpoCh(0);
                runbokan(3);
            }
            if (line == 2) {
                runlineYpoCh(2);
                runbokpo(1);
            }
        }
    }

    public void mix(Cubick cubick) {
        int count = 500;
        while (count > 0) {
            Random random = new Random();
            int turns = (random.nextInt(3));
            int turns1 = (random.nextInt(2));
            cubick.turnZ(turns, turns1);
            cubick.turnY(turns, turns1);
            cubick.turnX(turns, turns1);
            count--;
        }
    }

    public String toString() {
        for (int j = 0; j < 3; j++) {
            System.out.print("   ");
            for (int k = 0; k < 3; k++) {
                System.out.print(cubick[0][j][k]);
            }
            System.out.print("\n");
        }
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                System.out.print(cubick[4][j][k]);
            }
            for (int k = 0; k < 3; k++) {
                System.out.print(cubick[1][j][k]);
            }
            for (int k = 0; k < 3; k++) {
                System.out.print(cubick[5][j][k]);
            }
            System.out.print("\n");
        }
        for (int j = 0; j < 3; j++) {
            System.out.print("   ");
            for (int k = 0; k < 3; k++) {
                System.out.print(cubick[2][j][k]);
            }
            System.out.print("\n");
        }
        for (int j = 0; j < 3; j++) {
            System.out.print("   ");
            for (int k = 0; k < 3; k++) {
                System.out.print(cubick[3][j][k]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        return "";
    }
}
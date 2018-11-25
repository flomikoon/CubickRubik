import java.util.Random;

public class Bot {
    private Cubick cubick;
    Bot(){
        this.cubick = new Cubick();
    }

    public Cubick mixCube(){
        int count = 100;
        while (count > 0) {
            Random random = new Random();
            int turns = (random.nextInt(3));
            int turns1 = (random.nextInt(3));
            cubick.turnZ(turns , turns1);
            cubick.turnY(turns , turns1);
            cubick.turnX(turns , turns1);
            count--;
        }
        return cubick;
    }

    public void prin(){
        for (int j= 0 ; j < 3 ; j++) {
            System.out.print("   ");
            for ( int k = 0 ; k < 3 ; k++) {
                System.out.print(cubick.getCubick(0 , j , k));
            }
            System.out.print("\n");
        }
        for (int j= 0 ; j < 3 ; j++) {
            for ( int k = 0 ; k < 3 ; k++) {
                System.out.print(cubick.getCubick(4 , j , k));
            }
            for ( int k = 0 ; k < 3 ; k++) {
                System.out.print(cubick.getCubick(1 , j , j));
            }
            for ( int k = 0 ; k < 3 ; k++) {
                System.out.print(cubick.getCubick(5 , j , k));
            }
            System.out.print("\n");
        }
        for (int j= 0 ; j < 3 ; j++) {
            System.out.print("   ");
            for ( int k = 0 ; k < 3 ; k++) {
                System.out.print(cubick.getCubick(2 , j , k));
            }
            System.out.print("\n");
        }
        for (int j= 0 ; j < 3 ; j++) {
            System.out.print("   ");
            for ( int k = 0 ; k < 3 ; k++) {
                System.out.print(cubick.getCubick(3, j , k));
            }
            System.out.print("\n");
        }
    }
}


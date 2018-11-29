public class BotMain {
    public static void main(String[] args){
        Cubick b = new Cubick();
        b.mix(b);
        System.out.print("Stage: 0 \n");
        b.prin();
        b = Bot.UpWhiteCenter(b);
        b = Bot.Cross(b);
        System.out.print("Stage: 1 \n");
        b.prin();

        System.out.print("Stage: 2 \n");
        b.prin();
        System.out.print("\n");
    }
}

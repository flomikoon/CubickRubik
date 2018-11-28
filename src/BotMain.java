public class BotMain {
    public static void main(String[] args){
        Cubick b = new Cubick();
        b.mix(b);
        b = Bot.UpWhiteCenter(b);
        b = Bot.Crest(b);
        b.prin();
        System.out.print("\n");
    }
}

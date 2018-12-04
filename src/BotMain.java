public class BotMain {
    public static void main(String[] args){
        Cubick b = new Cubick();
        b.mix(b);
        System.out.print("Stage: 0 \n");
        b.prin();
        b = Bot.UpYellowCenter(b); //Поднимаем на верх желтый центр
        b = Bot.Cross(b);//Собираем белый крест вокруг желтого центра
        System.out.print("Stage: 1 \n");
        b.prin();
        b = Bot.CrossFull(b);//Перемещаем белый крест на нижню грань , при этом на боковых гранях элементы (* , 0 , 1) и (* , 1 , 1) должны совпадать
        System.out.print("Stage: 1.2 \n");
        b.prin();
        System.out.print("Stage: 2 \n");//Собираем полностью белую грань с низу ,путем постановки белых углов на правильные места,что бы цвет сосед сторон совпадал с центрами
        b = Bot.OneSlou(b);
        b.prin();
        System.out.print("Stage: 2.1 \n");//Собираем первые два слоя
        b = Bot.SecondSide(b);
        b.prin();
        System.out.print("Stage: 3 \n");//Собираем желтый крест на верху
        b = Bot.YellowCross(b);
        b.prin();
        System.out.print("Stage: 3.1 \n");//Ставим верхнии углы на свои места
        b = Bot.YellowUgl(b);
        b.prin();
        System.out.print("\n");
    }
}

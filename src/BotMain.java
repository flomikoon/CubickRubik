public class BotMain {
    public static void main(String[] args){
        Cubick b = new Cubick();
        b.mix(b);
        System.out.print("Stage: 0 \n");
        System.out.print(b.toString());
        b = Bot.upYellowCenter(b); //Поднимаем на верх желтый центр
        b = Bot.whiteCrossWithYellowCenter(b);//Собираем белый крест вокруг желтого центра
        System.out.print("Stage: 1 \n");
        b = Bot.whiteCrossFull(b);//Перемещаем белый крест на нижню грань , при этом на боковых гранях элементы (* , 0 , 1) и (* , 1 , 1) должны совпадать
        System.out.print(b.toString());
        System.out.print("Stage: 2 \n");//Собираем полностью белую грань с низу ,путем постановки белых углов на правильные места,что бы цвет сосед сторон совпадал с центрами
        b = Bot.firstLayer(b);
        b = Bot.secondLayer(b);//Собираем первые два слоя,полностью собраны белая сторона и два слоя
        System.out.print(b.toString());
        System.out.print("Stage: 3 \n");//Собираем желтый крест на верху
        b = Bot.yellowCross(b);
        b = Bot.yellowCornersIntoPlace(b);//Ставим верхнии углы на свои места
        b = Bot.yellowSide(b);//Переворачиваем желтые углы в парвильное положение,на этой стадии собрано все кроме серидин 3 стороны
        b = Bot.fullCubick(b);//Кубик полностью собран
        System.out.print("\n");
        System.out.print(b.toString());
    }
}

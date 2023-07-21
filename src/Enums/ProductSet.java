package Enums;

import java.util.Random;

public enum ProductSet {
    BREAD,
    SUGAR,
    VODKA,
    MILK,
    SALO,
    SOLT,
    EGGS,
    LIMON,
    WHISKEY;

    private static final Random random = new Random();

    //метод для рандомного выбора Продукта из предложенного списка
    public static ProductSet randomSet() {
        ProductSet[] directions = values();
        return directions[random.nextInt(directions.length)];
    }
}

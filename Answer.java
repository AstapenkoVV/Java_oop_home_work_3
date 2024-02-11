package ru.gb.oop.dz_task_3;

public class Answer {
    private int cowsCount;
    private int bullsCount;
    private Integer tryCount;

    public Answer(int cowsCount, int bullsCount, Integer tryCount) {
        this.cowsCount = cowsCount;
        this.bullsCount = bullsCount;
        this.tryCount = tryCount;
    }

    @Override
    public String toString() {
        return "Вывод " +
        "Коров " + cowsCount +
                ", Быков " + bullsCount +
                ", Осталось попыток " + tryCount;
    }
}

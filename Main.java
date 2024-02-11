package ru.gb.oop.dz_task_3;
/**
 * Дописать игру быки-коровы
 * - на русском и английском алфавите
 * - сделать логирование действий и по запросу пользователя посмотреть всю историю игры
 * - * реализовать перезапуск игры
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer sizeWord = 5;
        Integer tryCount = 3;
        AbstractGame ag = new NumberGame();
        Scanner scanner = new Scanner(System.in);
        String answerValue = "";
        System.out.println("Выберите режим игры: " +
                "1 - цыфры; " +
                "2 - русские буквы; " +
                "3 - английские буквы");
        String mode = scanner.nextLine();
        ag.start(sizeWord, tryCount, mode);
        List<String> listAnswer = new ArrayList<>();
        while (!ag.gameStatus.equals(GameStatus.EXIT)) {
            if (ag.gameStatus.equals(GameStatus.START)) {
                System.out.println("Введите ваш вариант: ");
                answerValue = scanner.nextLine();
                Answer answerNum = ag.inputValue(answerValue);
                listAnswer.add(answerValue);
                System.out.println(answerNum);
                if (ag.gameStatus.equals(GameStatus.WIN)) {
                    System.out.println("Вы победили");
                }
                if (ag.gameStatus.equals(GameStatus.LOOST)) {
                    System.out.println("Вы проиграли");
                }
            } else if (!ag.gameStatus.equals(GameStatus.START)) {
                ag.start(sizeWord, tryCount, mode);
                System.out.println("Выберите действие с игрой: " +
                        "\n1 - посмотреть всю историю игры; " +
                        "2 - перезапуск игры; " +
                        "3 - выйти из игры");
                ag.inputMode(scanner.nextLine());
            }
            ag.setAnswerList(listAnswer);
        }
    }
}


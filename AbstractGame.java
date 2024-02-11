package ru.gb.oop.dz_task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class AbstractGame implements Game {
    abstract List<String> generateNumberList();

    abstract List<String> generateRuList();

    abstract List<String> generateEnList();

    private String word;
    String modeValue;
    Integer tryCount;
    List answerList = new ArrayList();
    GameStatus gameStatus = GameStatus.INIT;

    public List getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List answerList) {
        this.answerList = answerList;
    }

    private String generateWord(Integer sizeWord, String mode) {
        Random random = new Random();
        String str = "";
        switch (mode) {
            case "1":
                List<String> alphabet = generateNumberList();
                for (int i = 0; i < sizeWord; i++) {
                    int randomIndex = random.nextInt(0, alphabet.size());
                    str += alphabet.get(randomIndex);
                    alphabet.remove(randomIndex);
                }
                return str;
            case "2":
                List<String> ruString = generateRuList();
                for (int i = 0; i < sizeWord; i++) {
                    int randomIndex = random.nextInt(0, ruString.size());
                    str += ruString.get(randomIndex);
                    ruString.remove(randomIndex);
                }
                return str;
            case "3":
                List<String> enString = generateEnList();
                for (int i = 0; i < sizeWord; i++) {
                    int randomIndex = random.nextInt(0, enString.size());
                    str += enString.get(randomIndex);
                    enString.remove(randomIndex);
                }
                return str;
        }
        return str;
    }

    /**
     * @apiNote Запуск игры
     * @param sizeWord Размер генерации значения (набор цыфр, набор букв)
     * @param tryCount Количество попыток
     * @param mode Выбор генерации (цыфры, русские буквы, английские буквы)
     */
    @Override
    public void start(Integer sizeWord, Integer tryCount, String mode) {
        this.modeValue = mode;
        word = generateWord(sizeWord, mode);
        this.tryCount = tryCount;
        gameStatus = gameStatus.START;
    }

    /**
     * @apiNote Метод подсчета количества совпадений символов
     * @param value значение введеное пользователем
     * @return ответ совпвдений и количество попыток
     */
    @Override
    public Answer inputValue(String value) {
        if (!getGameStatus().equals(GameStatus.START)) {
            throw new RuntimeException("Игра не запустилась!");
        }
        int cowsCount = 0;
        int bullsCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (value.charAt(i) == word.charAt(i)) {
                cowsCount++;
                bullsCount++;
            } else if (word.contains(String.valueOf(value.charAt(i)))) {
                cowsCount++;
            }
        }
        this.tryCount--;
        if (tryCount == 0) {
            gameStatus = gameStatus.LOOST;
        }
        if (bullsCount == word.length()) {
            gameStatus = GameStatus.WIN;
        }
        return new Answer(cowsCount, bullsCount, tryCount);
    }

    /**
     * @apiNote Метод выбора режима продолжения игры (история ввода, перезапуск, выход)
     * @param mode выбор режима игры
     * @return возвращает статус игры
     */
    @Override
    public GameStatus inputMode(String mode) {
        switch (mode) {
            case ("1"):
                List<String> answerlist = getAnswerList();
                for (String str : answerlist) {
                    System.out.println(str);
                }
                gameStatus = GameStatus.LOOST;
                break;
            case ("2"):
                Scanner scanner = new Scanner(System.in);
                System.out.println("Выберите режим игры: " +
                        "1 - цыфры; " +
                        "2 - русские буквы; " +
                        "3 - английские буквы");
                this.modeValue = scanner.nextLine();
                break;
            case ("3"):
                gameStatus = GameStatus.EXIT;
                System.out.println("Игра окончена!");
                break;
        }
        return GameStatus.EXIT;
    }

    /**
     * @apiNote Метод возвращает статус игры
     * @return статус игры
     */
    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
}

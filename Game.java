package ru.gb.oop.dz_task_3;

public interface Game {

    void start(Integer sizeWord, Integer tryCount, String mode);

    Answer inputValue(String value);
    GameStatus inputMode(String mode);
    GameStatus getGameStatus();
}

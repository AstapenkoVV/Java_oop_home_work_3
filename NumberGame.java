package ru.gb.oop.dz_task_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberGame extends AbstractGame{
    @Override
    List<String> generateNumberList() {
        return new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));
    }

    @Override
    List<String> generateRuList() {
        return new ArrayList<>(Arrays.asList
                (
                        "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й",
                        "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф",
                        "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"
                ));
    }

    @Override
    List<String> generateEnList() {
        return new ArrayList<>(Arrays.asList
                (
                        "a", "b", "c", "d", "e", "f", "g", "h", "i",
                        "j", "k", "l", "m", "n", "o", "p", "q", "r",
                        "s", "t", "u", "v", "w", "x", "y", "z"
                ));
    }
}

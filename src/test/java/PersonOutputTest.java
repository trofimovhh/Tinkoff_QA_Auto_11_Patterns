import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class PersonOutputTest {

    private final InputProcessor processor = new InputProcessor();


    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "1", "12", "123", "12345", "123a", "1 2"})
    void processInputInvalid(final String input) {
        assertEquals("Неверный ввод.", processor.processInput(input));
    }

    @Test
    @DisplayName("0000")
    void processInputMin() {
        assertEquals("0000\n"
                        + "Аксёнова Алиса Алексеевна\n"
                        + "Возраст:10\n"
                        + "Вес:30 кг\n"
                        + "Рост:1.0 м\n"
                        + "Глаза:голубые\n"
                        + "Волосы:нет\n"
                        + "Телефона нет",
                processor.processInput("0000").replaceAll("[\r\t]", ""),
                "Неверный вывод при 0000");
    }


    @Test
    @DisplayName("9999")
    void processInputMax() {
        assertEquals("9999\n"
                        + "Щукина Юлия Ярославовна\n"
                        + "Возраст:100\n"
                        + "Вес:120 кг\n"
                        + "Рост:1.9 м\n"
                        + "Глаза:разные\n"
                        + "Волосы:длинные, синие\n"
                        + "Телефона нет",
                processor.processInput("9999").replaceAll("[\r\t]", ""),
                "Неверный вывод при 9999");
    }

    @Test
    @DisplayName("2379")
    void processInputRandom() {
        String testString = processor.processInput("2379").replaceAll("[\r\t]", "");
        assertAll("2379",
                () -> assertEquals("2379\n"
                                + "Путин Геннадий Рамзанович\n"
                                + "Возраст:40\n"
                                + "Вес:60 кг\n"
                                + "Рост:1.3 м\n"
                                + "Глаза:серые\n"
                                + "Волосы:длинные, зелёные\n",
                        testString.substring(0, testString.indexOf("Телефон"))),
                () -> assertEquals("2379",
                        testString.substring(testString.length() - 4))
        );
    }
}

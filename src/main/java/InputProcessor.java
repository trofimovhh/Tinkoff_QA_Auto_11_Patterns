import generators.AppearanceGenerator;
import generators.FioGenerator;
import generators.PhoneGenerator;
import generators.PhysGenerator;
import person.Fio;
import person.Person;
import person.Phone;
import person.Physical;
import person.appearance.Appearance;

public final class InputProcessor {
    private static InputProcessor instance;

    InputProcessor() {
    }

    public static InputProcessor getInstance() {
        if (instance == null) {
            instance = new InputProcessor();
        }
        return instance;
    }

    public String processInput(final String input) {
        String result;

        if (input.trim().matches("\\d{4}")) {
            // Создаём Person
            final int intCode = Integer.parseInt(input);

            final FioGenerator fioGenerator = new FioGenerator();
            fioGenerator.generateParams(intCode);
            final Fio fio = fioGenerator.buildResponse();

            final PhysGenerator physGenerator = new PhysGenerator();
            physGenerator.generateParams(intCode);
            final Physical physical = physGenerator.buildResponse();

            final AppearanceGenerator appearanceGenerator = new AppearanceGenerator();
            appearanceGenerator.generateParams(intCode);
            final Appearance appearance = appearanceGenerator.buildResponse();

            Phone phone = null;
            // добавляем телефон, только если введённый код не палиндром
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                final PhoneGenerator phoneGenerator = new PhoneGenerator();
                phoneGenerator.generateParams(intCode);
                phone = phoneGenerator.buildResponse();
            }
            Person person = new Person.Builder(input)
                    .withFirstName(fio.getFirstName())
                    .withLastName(fio.getLastName())
                    .withMiddleName(fio.getMiddleName())
                    .withPhys(physical)
                    .withAppearance(appearance)
                    .withPhone(phone)
                    .build();
            result = person.toString();
        } else {
            result = "Неверный ввод.";
        }
        return result;
    }
}

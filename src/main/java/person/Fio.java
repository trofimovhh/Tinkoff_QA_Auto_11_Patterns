package person;

public class Fio {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public Fio(final String lastName, final String firstName, final String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getMiddleName() {
        return middleName;
    }
}

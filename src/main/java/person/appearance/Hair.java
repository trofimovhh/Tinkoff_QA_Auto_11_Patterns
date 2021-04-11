package person.appearance;

public class Hair {
    private final String color;
    private final String hairLength;

    public Hair(final int length, final String color) {
        this.color = color;
        if (length > 0) {
            if (length > 4) {
                this.hairLength = "длинные";
            } else {
                this.hairLength = "короткие";
            }
        } else {
            this.hairLength = "нет";
        }
    }

    public final String toString() {
        if (hairLength.equals("нет")) {
            return hairLength;
        } else {
            return hairLength + ", " + color;
        }
    }
}
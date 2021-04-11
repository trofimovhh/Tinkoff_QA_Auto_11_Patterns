package person;

import person.appearance.Appearance;

public class Person {

    private String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;

    public static class Builder {
        private String id;
        private String lastName;
        private String firstName;
        private String middleName;
        private Physical phys;
        private Appearance appearance;
        private Phone phone;

        public Builder(final String id) {
            this.id = id;
        }

        public final Builder withLastName(final String builderLastName) {
            this.lastName = builderLastName;
            return this;
        }

        public final Builder withFirstName(final String builderFirstName) {
            this.firstName = builderFirstName;
            return this;
        }

        public final Builder withMiddleName(final String builderMiddleName) {
            this.middleName = builderMiddleName;
            return this;
        }

        public final Builder withPhys(final Physical builderPhys) {
            this.phys = builderPhys;
            return this;
        }

        public final Builder withAppearance(final Appearance builderAppearance) {
            this.appearance = builderAppearance;
            return this;
        }

        public final Builder withPhone(final Phone builderPhone) {
            this.phone = builderPhone;
            return this;
        }

        public final Person build() {
            final Person person = new Person();
            person.id = this.id;
            person.lastName = this.lastName;
            person.firstName = this.firstName;
            person.middleName = this.middleName;
            person.phys = this.phys;
            person.appearance = this.appearance;
            person.phone = this.phone;
            return person;
        }

    }


    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(String.format("%1$s %2$s %3$s", lastName, firstName, middleName)).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }
}

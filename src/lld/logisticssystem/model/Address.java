package lld.logisticssystem.model;

public class Address {

    private String line1;

    private String line2;

    private String line3;

    private String zipCode;

    private String city;

    private String country;

    private Address(String line1, String line2, String line3, String zipCode, String city, String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public static class AddressBuilder {

        private String line1;

        private String line2;

        private String line3;

        private String zipCode;

        private String city;

        private String country;

        public Address build() {
            return new Address(line1, line2, line3, zipCode, city, country);
        }

        public AddressBuilder setLine1(String line1) {
            this.line1 = line1;
            return this;
        }

        public AddressBuilder setLine2(String line1) {
            this.line2 = line2;
            return this;
        }
        public AddressBuilder setLine3(String line1) {
            this.line3 = line3;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public AddressBuilder setZipcode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                " zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

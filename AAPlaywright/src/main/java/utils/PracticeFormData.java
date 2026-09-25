package utils;

public class PracticeFormData {

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String state;
    private String city;
    private String address;

    public PracticeFormData(
            String firstName,
            String lastName,
            String email,
            String mobile,
            String state,
            String city,
            String address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.city = city;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
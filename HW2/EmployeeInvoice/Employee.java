// Fig. 10.13: Employee.java
// Employee abstract superclass that implements Payable.

public abstract class Employee implements Payable {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    // Creating Constructor
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // returns employee first name
    public String getFirstName() {
        return firstName;
    }

    // returns employee last name
    public String getLastName() {
        return lastName;
    }

    // returns employee social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // return String representation of Employee object
    @Override
    public String toString() {
        return String.format("%s %s%nSocial Security Number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    // abstract method to calculate employee earnings
    public abstract double earnings();

    // implementing getPaymentAmount here enables the entire Employee
    // class hierarchy to be used in an app that processes Payables
    public double getPaymentAmount() {
        return earnings();
    }
}
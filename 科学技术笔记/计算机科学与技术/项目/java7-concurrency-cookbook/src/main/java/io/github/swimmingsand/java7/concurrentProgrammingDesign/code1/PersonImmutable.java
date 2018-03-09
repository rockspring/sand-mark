package io.github.swimmingsand.java7.concurrentProgrammingDesign.code1;

/**
 * Created by zlq on 6/30/15.
 */
public class PersonImmutable {

    final private String firstName;
    final private String lastName;

    public PersonImmutable(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

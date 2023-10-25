package edu.hw3.task5;

import org.jetbrains.annotations.NotNull;

public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;

    public Contact(String fullName) {
        String[] firstAndLastNames = fullName.split(" ");
        firstName = firstAndLastNames[0];
        lastName = firstAndLastNames.length == 2 ? firstAndLastNames[1] : null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(@NotNull Contact o) {
        if (this.lastName == null || o.getLastName() == null) {
            return this.firstName.compareTo(o.getFirstName());
        }
        return this.lastName.compareTo(o.getLastName());
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, (lastName != null ? lastName : ""));
    }
}

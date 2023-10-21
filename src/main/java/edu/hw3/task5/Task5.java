package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task5 {
    private Task5() {

    }

    public static List<Contact> parseContacts(String[] contacts, String order) {

        List<Contact> contactsAsList = new ArrayList<>();
        try {
            for (String contactAsString : contacts) {
                contactsAsList.add(new Contact(contactAsString));
            }
            if (order.equals("ASC")) {
                Collections.sort(contactsAsList);
            } else if (order.equals("DESC")) {
                contactsAsList.sort(Collections.reverseOrder());
            }
        } catch (NullPointerException exception) {

        }
        return contactsAsList;
    }

    public static void main(String[] args) {
        System.out.println(parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
            "ASC"
        ));
        ;
    }
}

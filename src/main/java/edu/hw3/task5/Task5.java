package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Task5 {
    private static final String ASC_ORDER = "ASC";
    private static final String DESC_ORDER = "DESC";

    private Task5() {

    }

    public static List<Contact> parseContacts(String[] contacts, String order) {
        List<Contact> contactsAsList = new ArrayList<>();
        if (isInputArrayValid(contacts) && isOrderValid(order)) {
            for (String contactAsString : contacts) {
                contactsAsList.add(new Contact(contactAsString));
            }
            if (order.equalsIgnoreCase(ASC_ORDER)) {
                Collections.sort(contactsAsList);
            } else if (order.equalsIgnoreCase(DESC_ORDER)) {
                contactsAsList.sort(Collections.reverseOrder());
            }
        } else {
            throw new RuntimeException("Создание частотного словаря невозможно");
        }
        return contactsAsList;
    }

    private static boolean isOrderValid(String order) {
        return order.equalsIgnoreCase(ASC_ORDER) || order.equalsIgnoreCase(DESC_ORDER);
    }

    private static boolean isInputArrayValid(String[] contacts) {
        return contacts != null && contacts.length != 0 && noContactsAreNull(contacts);
    }

    private static boolean noContactsAreNull(String[] contacts) {
        for (String contact : contacts) {
            if (contact == null) {
                return false;
            }
        }
        return true;
    }
}

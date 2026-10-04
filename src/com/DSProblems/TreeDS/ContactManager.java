package com.DSProblems.TreeDS;

public class ContactManager {

    private BSTContactNode root;

    public ContactManager() {
        this.root = null;
    }

    public void addContact(Contact contact) {
        root = addRecursively(root, contact);
    }

    private BSTContactNode addRecursively(BSTContactNode current, Contact contact) {
        if (current == null) {
            return new BSTContactNode(contact);
        }

        if (contact.compareTo(current.contact) < 0) {
            current.left = addRecursively(current.left, contact);
        } else if (contact.compareTo(current.contact) > 0) {
            current.right = addRecursively(current.right, contact);
        } else {
            // value already exists
            return current;
        }

        return current;
    }


    public Contact searchContact(String name) {
        return searchRecursively(root, name);
    }

    private Contact searchRecursively(BSTContactNode current, String name) {
        if (current == null) {
            return null;
        }

        if (name.equals(current.contact.getName())) {
            return current.contact;
        }

        return name.compareTo(current.contact.getName()) < 0
            ? searchRecursively(current.left, name)
            : searchRecursively(current.right, name);
    }


}

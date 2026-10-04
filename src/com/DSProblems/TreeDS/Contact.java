package com.DSProblems.TreeDS;

class Contact implements Comparable<Contact> {
    String name;
    String phoneNumber;
    
    // Constructor, getters, and setters

    

    @Override
    public int compareTo(Contact other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}


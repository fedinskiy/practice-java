package models;

import java.io.Serializable;

/**
 * Created by sa on 08.02.17.
 */
public class Client implements Serializable{
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Client(String firstName, String lastName, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        return firstName.hashCode() * 21
                + lastName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if(!(obj instanceof Client)){
            return false;
        }
        Client client = (Client) obj;
        if(this.getFirstName().equals(client.getFirstName()) &&
                this.getLastName().equals(client.getLastName())){
            return true;
        }
        return false;
    }
}







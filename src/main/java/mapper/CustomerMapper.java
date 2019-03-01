/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

/**
 *
 * @author Jesper
 */
public class CustomerMapper {
    
    private String firstName, lastName;
    private int age;
    
    private int addressId;
    private String street, zip;
    private int no;

    public CustomerMapper(int addressId, String street, String zip, int no) {
        this.addressId = addressId;
        this.street = street;
        this.zip = zip;
        this.no = no;
    }

    public CustomerMapper(String firstName, String lastName, int age, int addressId, String street, String zip, int no) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.addressId = addressId;
        this.street = street;
        this.zip = zip;
        this.no = no;
    }
    
    

    public CustomerMapper(String firstName, String lastName, int age, int addressId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.addressId = addressId;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    
    
    
}

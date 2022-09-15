package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid First Name")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid Last Name")
    public String lastName;

    @Pattern(regexp = "[789]{1}[0-9]{9}", message = "Invalid Phone number")
    public String phoneNumber;

    @NotEmpty(message = "email cannot be null")
    public String email;

    @NotEmpty(message = "address cannot be null")
    public String address;

    @NotEmpty(message = "city cannot be null")
    public String city;

    @NotEmpty(message = "state cannot be null")
    public String state;

    @NotNull(message = "zip cannot be null")
    public int zip;

    public AddressBookDTO(String firstName, String lastName, String phoneNumber, String email,
                          String address, String city, String state, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

}

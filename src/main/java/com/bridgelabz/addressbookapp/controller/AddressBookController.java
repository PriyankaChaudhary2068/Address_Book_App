package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    //localhost:8080/addressBook/get
    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBookData> addressBookList = null;
        addressBookList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call Success !!!", addressBookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //localhost:8080/addressBook/get/{personId}
    @GetMapping(value = {"/get/{personId}"})
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable int personId) {
        AddressBookData addressBookData = addressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Success Call for Person Id!!!", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // localhost:8080/addressBook/create
    @PostMapping(value = {"/create"})
    public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data ADDED Successfully!!!", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // localhost:8080/addressBook/update/{personId}
    @PutMapping(value = {"/update/{personId}"})
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int personId,
                                                             @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.updateAddressBookData(personId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data UPDATED Successfully!!!", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //localhost:8080/addressBook/delete/{personId}
    @DeleteMapping(value = {"/delete/{personId}"})
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable int personId) {
        addressBookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Data DELETED Successfully!!!",
                "ID number: " + personId + " DELETED!!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}

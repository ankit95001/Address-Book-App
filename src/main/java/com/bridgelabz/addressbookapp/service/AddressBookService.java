package com.bridgelabz.addressbookapp.service;


import com.bridgelabz.addressbookapp.Model.AddressBook;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    public List<AddressBook> getAllContacts() {
        return repository.findAll();
    }

    public Optional<AddressBook> getContactById(Long id) {
        return repository.findById(id);
    }

    public AddressBook createContact(AddressBookDTO addressBookDTO) {
        return repository.save(convertDtoToEntity(addressBookDTO));
    }

    public Optional<AddressBook> updateContact(Long id, AddressBookDTO addressBookDTO) {
        return repository.findById(id).map(existingContact -> {
            // Update existing contact with new data
            existingContact.setFullname(addressBookDTO.getFullname());
            existingContact.setAddress(addressBookDTO.getAddress());
            existingContact.setCity(addressBookDTO.getCity());
            existingContact.setState(addressBookDTO.getState());
            existingContact.setZipCode(addressBookDTO.getZipCode());
            existingContact.setPhoneNumber(addressBookDTO.getPhoneNumber());

            // Save and return the updated entity
            return repository.save(existingContact);
        });
    }


    public boolean deleteContact(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public AddressBook convertDtoToEntity(AddressBookDTO dto) {
        AddressBook addressBook = new AddressBook();
        addressBook.setFullname(dto.getFullname());
        addressBook.setAddress(dto.getAddress());
        addressBook.setCity(dto.getCity());
        addressBook.setState(dto.getState());
        addressBook.setZipCode(dto.getZipCode());
        addressBook.setPhoneNumber(dto.getPhoneNumber());
        return addressBook;
    }


}


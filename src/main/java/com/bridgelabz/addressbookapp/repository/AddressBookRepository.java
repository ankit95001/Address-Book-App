package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.Model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook,Long> {
}

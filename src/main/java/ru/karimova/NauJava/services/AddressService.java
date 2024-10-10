package ru.karimova.NauJava.services;

import ru.karimova.NauJava.entity.Address;

public interface AddressService {

    void createAddress(Long id, String street, String city, String postalCode);

    Address findById(Long id);

    void deleteById(Long id);

    void updateAddress(Long id, String street, String city, String postalCode);

    String displayAddress(Long id);
}

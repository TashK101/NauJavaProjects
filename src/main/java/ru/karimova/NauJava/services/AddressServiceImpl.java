package ru.karimova.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.karimova.NauJava.repositories.AddressRepository;
import ru.karimova.NauJava.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void createAddress(Long id, String street, String city, String postalCode) {
        Address newAddress = new Address(id, street, city, postalCode);
        addressRepository.create(newAddress);
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.delete(id);
    }

    @Override
    public void updateAddress(Long id, String street, String city, String postalCode) {
        Address updatedAddress = new Address(id, street, city, postalCode);
        addressRepository.update(updatedAddress);
    }

    @Override
    public String displayAddress(Long id) {
        Address address = findById(id);
        if (address != null) {
            return String.format("Address[ID: %d, Street: %s, City: %s, Postal Code: %s]",
                    address.getId(), address.getStreet(), address.getCity(), address.getPostalCode());
        } else {
            return "No such address";
        }
    }
}

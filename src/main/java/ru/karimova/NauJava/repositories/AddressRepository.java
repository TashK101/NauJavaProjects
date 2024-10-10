package ru.karimova.NauJava.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.karimova.NauJava.entity.Address;

import java.util.List;
import java.util.Optional;

@Component
public class AddressRepository implements CrudRepository<Address, Long> {

    private final List<Address> addressContainer;

    @Autowired
    public AddressRepository(List<Address> addressContainer) {
        this.addressContainer = addressContainer;
    }

    @Override
    public Address read(Long id) {
        Optional<Address> address = addressContainer.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
        return address.orElse(null);
    }
    @Override
    public void create(Address address) {
        Address existingAddress = read(address.getId());
        if (existingAddress != null) {
            System.out.println("Address already exists");
        }
        else {
            addressContainer.add(address);
            System.out.println("Address saved.");
        }
    }

    @Override
    public void update(Address updatedAddress) {
        Address existingAddress = read(updatedAddress.getId());
        if (existingAddress != null) {
            existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setPostalCode(updatedAddress.getPostalCode());
        }
    }

    @Override
    public void delete(Long id) {
        addressContainer.removeIf(a -> a.getId().equals(id));
    }
}

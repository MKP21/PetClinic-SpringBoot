package meet.springframework.mkppetclinic.services;

import meet.springframework.mkppetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName();
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}

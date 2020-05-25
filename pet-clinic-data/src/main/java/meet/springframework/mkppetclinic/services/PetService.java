package meet.springframework.mkppetclinic.services;
import meet.springframework.mkppetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}

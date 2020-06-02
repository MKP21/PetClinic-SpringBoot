package meet.springframework.mkppetclinic.repositories;

import meet.springframework.mkppetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}

package meet.springframework.mkppetclinic.repositories;

import meet.springframework.mkppetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}

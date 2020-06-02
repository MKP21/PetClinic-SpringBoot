package meet.springframework.mkppetclinic.repositories;

import meet.springframework.mkppetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}

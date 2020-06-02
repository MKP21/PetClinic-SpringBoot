package meet.springframework.mkppetclinic.repositories;

import meet.springframework.mkppetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}

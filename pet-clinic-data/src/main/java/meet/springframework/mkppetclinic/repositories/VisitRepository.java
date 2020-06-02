package meet.springframework.mkppetclinic.repositories;

import meet.springframework.mkppetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}

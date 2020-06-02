package meet.springframework.mkppetclinic.repositories;

import meet.springframework.mkppetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}

package meet.springframework.mkppetclinic.services;

import meet.springframework.mkppetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}

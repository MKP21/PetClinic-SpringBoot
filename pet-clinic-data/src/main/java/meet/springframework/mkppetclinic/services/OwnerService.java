package meet.springframework.mkppetclinic.services;

import meet.springframework.mkppetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}

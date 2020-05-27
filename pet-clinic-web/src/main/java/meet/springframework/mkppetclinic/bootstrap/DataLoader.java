package meet.springframework.mkppetclinic.bootstrap;

import meet.springframework.mkppetclinic.model.Owner;
import meet.springframework.mkppetclinic.model.Vet;
import meet.springframework.mkppetclinic.services.OwnerService;
import meet.springframework.mkppetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setId(2L);
        o1.setFirstName("Ramesh");
        o1.setLastName("Singh");

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setId(3L);
        o2.setFirstName("Suresh");
        o2.setLastName("Salsa");

        ownerService.save(o1);

        System.out.println("Loaded owners");

        Vet v1 = new Vet();
        v1.setId(4L);
        v1.setFirstName("Bulbul");
        v1.setLastName("Bhatiya");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setId(5L);
        v2.setFirstName("Mikaela");
        v2.setLastName("Bubblegum");

        vetService.save(v2);
        System.out.println("Loaded vets");

    }
}

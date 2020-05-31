package meet.springframework.mkppetclinic.bootstrap;

import meet.springframework.mkppetclinic.model.Owner;
import meet.springframework.mkppetclinic.model.Pet;
import meet.springframework.mkppetclinic.model.PetType;
import meet.springframework.mkppetclinic.model.Vet;
import meet.springframework.mkppetclinic.services.OwnerService;
import meet.springframework.mkppetclinic.services.PetTypeService;
import meet.springframework.mkppetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedType1 = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedType2 = petTypeService.save(cat);

        System.out.println("Loaded Pet types");

        Owner o1 = new Owner();
        o1.setFirstName("Ramesh");
        o1.setLastName("Singh");
        o1.setAddress("121 bork");
        o1.setCity("Jersey");
        o1.setTelephone("9903842832");
        Pet molly = new Pet();
        molly.setPetType(savedType1);
        molly.setOwner(o1);
        molly.setName("Molly");
        molly.setBirthDate(LocalDate.now());
        o1.getPets().add(molly);

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Suresh");
        o2.setLastName("Salsa");
        o2.setAddress("311 park");
        o2.setCity("Hoboken");
        o2.setTelephone("9903842832");

        ownerService.save(o2);

        System.out.println("Loaded owners");

        Vet v1 = new Vet();
        v1.setFirstName("Bulbul");
        v1.setLastName("Bhatiya");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Mikaela");
        v2.setLastName("Bubblegum");

        vetService.save(v2);
        System.out.println("Loaded vets");

    }
}

package meet.springframework.mkppetclinic.controllers;

import meet.springframework.mkppetclinic.model.Owner;
import meet.springframework.mkppetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"/find","/find.html"})
    public String find(Model model){
        model.addAttribute("owner",new Owner());
        return "owners/findOwners";
    }

    @RequestMapping("/findResult")
    public String processFindForm(Owner owner, BindingResult bindingResult, Model model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }
        String output;
        List<Owner> result = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");

        if(result.isEmpty()){
            bindingResult.rejectValue("lastName","notFound","not found");
            output = "owners/findOwners";
        }else if(result.size() == 1){
            output = "redirect:/owners/" + result.get(0).getId();
        }else{
            model.addAttribute("selections",result);
            output = "owners/ownersList";
        }
        return output;
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
}

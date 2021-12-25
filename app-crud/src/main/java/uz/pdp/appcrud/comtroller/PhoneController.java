package uz.pdp.appcrud.comtroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appcrud.model.Phone;
import uz.pdp.appcrud.repository.PhoneRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {

    @Autowired
    PhoneRepository phoneRepository;

    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    public List<Phone> getPhone() {
        List<Phone> phones = phoneRepository.findAll();
        return phones;
    }


    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public String savePhone(@RequestBody Phone phone) {
        phoneRepository.save(phone);
        return "Phone added";
    }

    @RequestMapping(value = "/phone/{id}", method = RequestMethod.GET)
    public Phone getByIdPhone(@PathVariable Integer id) {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()) {
            Phone phone = optionalPhone.get();
            return phone;
        }

        return new Phone();
    }

    @RequestMapping(value = "/phone/{id}", method = RequestMethod.DELETE)
    public String deletePhone(@PathVariable Integer id) {
        phoneRepository.deleteById(id);
        return "deleted";
    }


    @RequestMapping(value = "/phone/{id}", method = RequestMethod.PUT)
    public String editPhone(@PathVariable Integer id, @RequestBody Phone phone) {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()) {
            Phone editPhone = optionalPhone.get();
            editPhone.setName(phone.getName());
            editPhone.setModel(phone.getModel());
            editPhone.setMacAddress(phone.getMacAddress());
            editPhone.setInfo(phone.getInfo());

            phoneRepository.save(editPhone);
            return "Phone editing";
        }
        return "phone not found";
    }

}

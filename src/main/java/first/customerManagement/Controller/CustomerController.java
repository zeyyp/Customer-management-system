package first.customerManagement.Controller;

import first.customerManagement.Entity.Customer;
import first.customerManagement.Service.PersonService;
import first.customerManagement.dto.request.CustomerSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // sen bir controllersin.
@RequestMapping("/customer")
//@RequiredArgsConstructor    // final degiskenler için constructor olusturur.
public class CustomerController {
    // client tan gelen istegi karsilar ve servise yönlendirir.

    private final PersonService personService;

    public CustomerController(PersonService personService) {
        this.personService = personService;
    }

    // veri tabanındaki bütün müsterileri cekelim
    @PostMapping("/saveCustomer")
    public ResponseEntity<Boolean> saveCustomer(@RequestBody CustomerSaveDto customerSaveDto){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}

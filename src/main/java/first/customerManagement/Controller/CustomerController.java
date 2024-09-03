package first.customerManagement.Controller;


import first.customerManagement.Entity.Customer;
import first.customerManagement.Service.CustomerService;

import first.customerManagement.dto.request.CustomerAddressUpdateDto;
import first.customerManagement.dto.request.CustomerSaveDto;
import first.customerManagement.dto.response.GetCustomerByNameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // sen bir controllersin.
@RequestMapping("/customer")
@RequiredArgsConstructor    // final degiskenler için constructor olusturur.
public class CustomerController {
    // client tan gelen istegi karsilar ve servise yönlendirir.

    private final CustomerService customerService;


    // veri tabanındaki bütün müsterileri cekelim
    @PostMapping("/saveCustomer")
    public ResponseEntity<Boolean> saveCustomer(@RequestBody CustomerSaveDto customerSaveDto){
        Boolean saveCustomer = customerService.saveCustomer(customerSaveDto);
        return new ResponseEntity<>(saveCustomer, HttpStatus.CREATED);
    }

    //  adı x olan customerlar cekelim
    @GetMapping("/getCustomerListbyName")
    public ResponseEntity<List<GetCustomerByNameDto>> getCustomerListbyName(@RequestParam String customerName){
        List<GetCustomerByNameDto> customerListbyName = customerService.getCustomerListbyName(customerName);
        return new ResponseEntity<>(customerListbyName,HttpStatus.OK);
    }


    @PutMapping("/updateCustomerAddress")
    public ResponseEntity<Boolean> updateCustomerAddress(@RequestBody CustomerAddressUpdateDto customerAddressUpdateDto){
        Boolean updateCustomerAddress = customerService.updateCustomerAddress(customerAddressUpdateDto);
        return new  ResponseEntity<>(updateCustomerAddress,HttpStatus.OK);
    }


}

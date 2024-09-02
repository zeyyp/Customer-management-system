package first.customerManagement.Service;

import first.customerManagement.Entity.Customer;
import first.customerManagement.Repository.CustomerRepository;
import first.customerManagement.dto.request.CustomerSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class PersonService {

    private CustomerRepository customerRepository;

    public void saveCustomer(CustomerSaveDto customerSaveDto) {
//        customerRepository.save(customerSaveDto);    save içine entity alır dto yu entity ye cevirmeliyiz
        Customer customer = new Customer();

       // customerRepository.save();
    }

}

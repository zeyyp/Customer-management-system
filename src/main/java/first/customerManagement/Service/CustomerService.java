package first.customerManagement.Service;

import first.customerManagement.Entity.Customer;
import first.customerManagement.Repository.CustomerRepository;
import first.customerManagement.dto.request.CustomerAddressUpdateDto;
import first.customerManagement.dto.request.CustomerSaveDto;
import first.customerManagement.dto.response.GetCustomerByNameDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public Boolean saveCustomer(CustomerSaveDto customerSaveDto) {
//      customerRepository.save(customerSaveDto);    save içine entity alır dto yu entity ye cevirmeliyiz
        Customer customer = convertToCustomerFromDto(customerSaveDto);
        customerRepository.save(customer);
        return true;
    }

    // single responsibilty
    // open closed
    private Customer convertToCustomerFromDto(CustomerSaveDto customerSaveDto) {
        return modelMapper.map(customerSaveDto, Customer.class);

        /*    Customer customer = new Customer();
          customer.setCustomerName(customerSaveDto.getCustomerName());
          customer.getIdentityNumber(customerSaveDto.getIdentityNumber()); */
    }

    public List<GetCustomerByNameDto> getCustomerListbyName(String customerName){
        List<GetCustomerByNameDto> customerByNameDtos = new ArrayList<>();
        List<Customer> customers = customerRepository.findAllByCustomerName(customerName);
        for(Customer customer : customers){
            GetCustomerByNameDto responseDto = modelMapper.map(customer, GetCustomerByNameDto.class);
            customerByNameDtos.add(responseDto);
        }

        return customerByNameDtos;
    }

    public Boolean updateCustomerAddress(CustomerAddressUpdateDto customerAddressUpdateDto){
        Long id = customerAddressUpdateDto.getId();
        String address = customerAddressUpdateDto.getCustomerAddress();

        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();// customer imizi aldık

            customer.setCustomerAddress(address);
            customerRepository.save(customer);
            return true;
        }
       return false;
    }

}

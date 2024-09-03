package first.customerManagement.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAddressUpdateDto {

    private Long id;

    private String customerAddress;
}

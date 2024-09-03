package first.customerManagement.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class GetCustomerByNameDto {
    private String customerName;

    private Long identityNumber;

    private String customerAddress;
}

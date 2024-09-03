package first.customerManagement.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerSaveDto {

    private Long identityNumber;

    private String customerName;

    private String customerAddress;


}

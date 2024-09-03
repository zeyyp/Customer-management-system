package first.customerManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor // tum fieldlar için contructor olusturu
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // idyi otomatik artırır.
    private Long id;

    @Column
    private Long identityNumber;

    @Column
    private String customerName;

    @Column
    private String customerAddress;

}

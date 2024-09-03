package first.customerManagement.Repository;

import first.customerManagement.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    // select * from where customerName= ?  işlemini yapar
    public List<Customer> findAllByCustomerName(String customerName);  // jpa ad tan yola cıkarak filtrelemeyi yapabiliyor

    // jpa nın anlayamayacagi karmasık bır filtreleme yapacaksak @Query("") ile sql sorgusunu veririz
}

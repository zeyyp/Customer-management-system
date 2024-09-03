package first.customerManagement.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/* ModelMapper sadece read only bır class dolayısyla @component ekleyıp
   sprıng bean olarak işaretleyemiyoruz ve class bazında depencenty yapamıyoruz
   modot bazında sprıng bean olarak işrateleyelim  */


@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

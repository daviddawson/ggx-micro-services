

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Grapes([
  @Grab(group='org.springframework.boot', module='spring-boot-starter-data-jpa', version='0.5.0.M6'),
  @Grab(group='org.springframework.data', module='spring-data-mongodb', version='1.3.2.RELEASE')
])
import java.util.*

@Controller
@EnableAutoConfiguration
class OrderQueryController {

//  @Autowired
 // boot.OrderRepository repository;

  @RequestMapping("/order/{orderId}")
  @ResponseBody
  public Map<String, String> search(@PathVariable("orderId") String orderId) {
   // repository.save(new boot.YummyOrder(firstName:"Hello World", lastName:"Wibble Monkey"))
  }
}


//@Configuration
//@ComponentScan
 
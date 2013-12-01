package boot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@EnableAutoConfiguration
@Configuration
@ComponentScan
@Controller
class OrderCommandController {

  @Autowired
  OrderRepository repository;

  @RequestMapping("/order/{orderId}")
  @ResponseBody
  public Map<String, String> search(@PathVariable("orderId") String orderId) {
    repository.save(new YummyOrder(orderId: orderId, something: "Wibble Monkey"))
    [message:"Hello World"]
  }
  static void main(String[] args) {
    SpringApplication.run(OrderCommandController.class, args);
  }
}

class YummyOrder {
  @Id
  String orderId

  String theId
  String something
}


interface OrderRepository extends MongoRepository<YummyOrder, String> {}

package boot
import org.hibernate.validator.constraints.NotBlank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.validation.Validator

@EnableAutoConfiguration
@Configuration
@ComponentScan
@Controller
class OrderCommandController {

  @Autowired
  OrderRepository repository

  @Autowired
  Validator validator

  @RequestMapping("/order/{orderId}")
  @ResponseBody
  public Map<String, Object> search(
    @ModelAttribute("order") YummyOrder order) {

    def violations = validator.validate(order)

    if (violations) {
      return [success:false, violations: violations.collect {
        it.message
      }]
    }

    order = repository.save(order)

    [success:true, order:order]
  }

  @ModelAttribute("order")
  public YummyOrder getOrder(){
    return new YummyOrder();
  }

  static void main(String[] args) {
    SpringApplication.run(OrderCommandController, args)
  }
}

@Document(collection = "orders")
class YummyOrder {
  @Id
  String orderId

  @NotBlank
  String address1
  @NotBlank
  String postcode
  @NotBlank
  String name
}

interface OrderRepository extends MongoRepository<YummyOrder, String> {}

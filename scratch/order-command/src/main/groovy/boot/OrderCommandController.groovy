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
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@EnableAutoConfiguration
@RestController
@ComponentScan
@Configuration
class OrderCommandController {

  @Autowired
  OrderRepository repository

  @RequestMapping("/order/{orderId}")
  @ResponseBody
  public Map<String, Object> search(
      @ModelAttribute("order") YummyOrder order) {

    repository.save(order)

    [hello:"everyone ${order.orderId}".toString()]
  }


  static void main(String[] args) {
    SpringApplication.run(OrderCommandController, args)
  }

  @ModelAttribute("order") YummyOrder order() {
    new YummyOrder()
  }






//  @ModelAttribute("order") YummyOrder order
//  @ModelAttribute("order") YummyOrder order() {
//    new YummyOrder()
//  }
  //    repository.save(order)
//  @Autowired
//  OrderRepository repository

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
}

interface OrderRepository
extends MongoRepository<OrderCommandController.YummyOrder, String>
{}
















class YummyOrder {
  String orderId

  String address1
  String postcode
  String name
}





































//@EnableAutoConfiguration
//@Controller
//static void main(String[] args) {
//  SpringApplication.run(OrderCommandController, args)
//}













/*

@EnableAutoConfiguration
@Controller
@Configuration
@ComponentScan
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


class YummyOrder {
  String orderId

  String address1
  String postcode
  String name
} */






/*
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

interface OrderRepository extends MongoRepository<YummyOrder, String> {}*/
package boot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

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
}
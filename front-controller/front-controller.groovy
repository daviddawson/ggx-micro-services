import org.springframework.http.HttpEntity
import org.springframework.http.HttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.client.RestTemplate

@Controller
@EnableAutoConfiguration
public class FrontController {

  @RequestMapping("/")
  @ResponseBody
  public ResponseEntity helloWorld(RequestMethod method, HttpEntity body) {

    RestTemplate template = new RestTemplate();
    ResponseEntity resp = template.exchange(
        "http://www.simplicityitself.com/",
        method,
        body, String)

    return resp
  }
}

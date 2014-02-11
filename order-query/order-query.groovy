
@Grab(group='org.mongodb', module='mongo-java-driver', version='2.11.3')
import com.mongodb.MongoClient
import com.mongodb.BasicDBObject

@RestController
class OrderQueryController {
  
  @Autowired
  MongoClient mongo
  
  @RequestMapping("/orders/{orderId}")
  Map<String, String> search(@PathVariable("orderId") String orderId) {
  
    def item = orders.findOne([_id:orderId] as BasicDBObject)
    
    if(item) {
      def keys = ["_id", "address1", "name"]

      item = item.findAll {
	it.key in keys
      }
      return [success:true, item:item]
    } else {
      return [success:false]
    }
  }
  
  def getOrders() {
    def db = mongo.getDB("test")
    db.getCollection("orders")
  }
  
  @Bean MongoClient client() {  
    new MongoClient() 
  }
}

package ae.etisalat.ecare.transaction.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ae.etisalat.ecare.transaction.history.persistence.ReviewRepository;




@RestController
public class TransactionHistoryController {

	
	@Autowired
	ReviewRepository reviewRepository;
	
	@GetMapping(value = "/transaction-history123",produces = "application/json")
	public String hello() {
		
		/*
		 * ProductEntity productEntity = new ProductEntity();
		 * productEntity.setName("Product1"); productEntity.setProductId(123);
		 * productEntity.setWeight(20);
		 * 
		 * productRepository.save(productEntity);
		 */
		
		return "Hello this is test transaction history service$$$$$$$$$";
	}

	
	@GetMapping(value = "/transaction-hist",produces = "application/json")
	public String hello1() {
		
		return "Hello this is test transaction history service =====";
	}
	
	
}

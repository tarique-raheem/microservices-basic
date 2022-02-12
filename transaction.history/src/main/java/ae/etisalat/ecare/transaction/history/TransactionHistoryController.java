package ae.etisalat.ecare.transaction.history;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.ReviewDTO;
import com.example.integration.IntegrationController;

import ae.etisalat.ecare.transaction.history.persistence.ReviewEntity;
import ae.etisalat.ecare.transaction.history.persistence.ReviewRepository;




@RestController
public class TransactionHistoryController {

	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	IntegrationController integrationController;
	
	
	@GetMapping(value="/reviews",produces = "application/json")
	public List<ReviewDTO> getReviews(){

		
		List<ReviewEntity> reviewEntities = (List<ReviewEntity>) reviewRepository.findAll();
		List<ReviewDTO> reviews = new ArrayList<ReviewDTO>();
		
		for(ReviewEntity re: reviewEntities) {
			
			ReviewDTO reviewDTO = new ReviewDTO();
			reviewDTO.setAuthor(re.getAuthor());
			reviewDTO.setContent(re.getContent());
			reviewDTO.setId(re.getId());
			reviewDTO.setVersion(re.getVersion());
			
			reviews.add(reviewDTO);
			
			
		}
		
		
		
		return reviews;
		
	}
	
	@GetMapping(value="/messages/send",produces="application/json")
	public String sendMessages() {
		
		integrationController.sendMessageProduct();
		integrationController.sendMessageRecommendation();
		integrationController.sendMessageReview();
		
		return "success";
	}
	
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

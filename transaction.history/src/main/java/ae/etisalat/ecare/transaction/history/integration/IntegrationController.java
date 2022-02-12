package ae.etisalat.ecare.transaction.history.integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@EnableBinding(IntegrationController.MessageSources.class)
@Component
public class IntegrationController {

	@Autowired
	private MessageSources messageSources;
	
    public interface MessageSources {

        String OUTPUT_PRODUCTS = "output-products";
		/*
		 * String OUTPUT_RECOMMENDATIONS = "output-recommendations"; String
		 * OUTPUT_REVIEWS = "output-reviews";
		 */

        @Output(OUTPUT_PRODUCTS)
        MessageChannel outputProducts();

		/*
		 * @Output(OUTPUT_RECOMMENDATIONS) MessageChannel outputRecommendations();
		 * 
		 * @Output(OUTPUT_REVIEWS) MessageChannel outputReviews();
		 */
    }
    
    public void sendMessageProduct() {
    	
		
		System.out.println("###############################################################################");
		System.out.println("Starting send product message method");
		System.out.println("messageSources: "+ messageSources);
		System.out.println("messageSources.outputProducts(): "+ messageSources.outputProducts());
		System.out.println("###############################################################################");
    	
    	messageSources.outputProducts().send(MessageBuilder.withPayload(new String("Hello Product")).build());
    }
    
    public void sendMessageRecommendation() {
 //   	messageSources.outputRecommendations().send(MessageBuilder.withPayload(new String("Hello Recommendation")).build());
    }
	
    
    public void sendMessageReview() {
//    	messageSources.outputReviews().send(MessageBuilder.withPayload(new String("Hello Review")).build());
    }
}

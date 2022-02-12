package com.example.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@EnableBinding(MessageSource.class)
@Component
public class IntegrationController {

	@Autowired
	private MessageSources messageSources;
	
    public interface MessageSources {

        String OUTPUT_PRODUCTS = "output-products";
        String OUTPUT_RECOMMENDATIONS = "output-recommendations";
        String OUTPUT_REVIEWS = "output-reviews";

        @Output(OUTPUT_PRODUCTS)
        MessageChannel outputProducts();

        @Output(OUTPUT_RECOMMENDATIONS)
        MessageChannel outputRecommendations();

        @Output(OUTPUT_REVIEWS)
        MessageChannel outputReviews();
    }
    
    public void sendMessageProduct() {
    	
    	messageSources.outputProducts().send(MessageBuilder.withPayload(new String("Hello Product")).build());
    }
    
    public void sendMessageRecommendation() {
    	messageSources.outputRecommendations().send(MessageBuilder.withPayload(new String("Hello Recommendation")).build());
    }
	
    
    public void sendMessageReview() {
    	messageSources.outputReviews().send(MessageBuilder.withPayload(new String("Hello Review")).build());
    }
}

package ae.etisalat.ecare.transaction.history;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionHistoryController {

	@GetMapping(value = "/transaction-history123",produces = "application/json")
	public String hello() {
		
		return "Hello this is test transaction history service###:::::";
	}

	
	@GetMapping(value = "/transaction-hist",produces = "application/json")
	public String hello1() {
		
		return "Hello this is test transaction history service =====";
	}
	
	
}

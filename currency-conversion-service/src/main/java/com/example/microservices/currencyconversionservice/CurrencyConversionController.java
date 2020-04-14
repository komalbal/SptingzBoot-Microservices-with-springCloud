package com.example.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion converCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVeriables = new HashMap<String, String>();
		uriVeriables.put("from", from);
		uriVeriables.put("to",to);
		ResponseEntity<CurrencyConversion> entity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVeriables);
		CurrencyConversion response = entity.getBody();
		
		return new CurrencyConversion(response.getId(), from, to, response.getConvirsionMultiple(),quantity, 
				quantity.multiply(response.getConvirsionMultiple()), response.getPort());
	}
	
	@GetMapping("/feign/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion converCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
//		Map<String, String> uriVeriables = new HashMap<String, String>();
//		uriVeriables.put("from", from);
//		uriVeriables.put("to",to);
//		ResponseEntity<CurrencyConversion> entity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVeriables);
		CurrencyConversion response = proxy.getValue(from, to);
		
		return new CurrencyConversion(response.getId(), from, to, response.getConvirsionMultiple(),quantity, 
				quantity.multiply(response.getConvirsionMultiple()), response.getPort());
	}

}

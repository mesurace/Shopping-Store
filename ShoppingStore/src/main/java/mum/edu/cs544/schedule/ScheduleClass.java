package mum.edu.cs544.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mum.edu.cs544.aspect.ControllerAdvice;
import mum.edu.cs544.model.Product;
import mum.edu.cs544.service.ProductService;

@Component
public class ScheduleClass {
	private ControllerAdvice ca= new ControllerAdvice();
	
	@Autowired
	private ProductService productService;
	
//	@Scheduled(cron = "0/1 * * * * *")
	
	@Scheduled(cron = "0 0 18 * * *")
	public void sendMailEveryHour() {
		String m="All product: \n";
		List<Product> listProduct = productService.getproducts();
		for(Product p:listProduct){
			m=m+p.toString();
		}
		System.out.println(m);
		
		try {
			ca.logMessage(m);
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}
}

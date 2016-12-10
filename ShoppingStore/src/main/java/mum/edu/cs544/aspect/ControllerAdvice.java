package mum.edu.cs544.aspect;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import mum.edu.cs544.model.Product;
import mum.edu.cs544.service.ProductService;

@Component
@Aspect
public class ControllerAdvice {
	Logger logger = Logger.getLogger("MyLog");
	private FileHandler fh = null;

	@Before("execution(* mum.edu.cs544.controller.CartController.*(..))")
	public void cartActionBefore(JoinPoint jp) {

		logMessage("A request to:" + jp.getTarget().getClass().getName() + "Method:" + jp.getSignature()
				+ " is about to process");

	}

	@After("execution(* mum.edu.cs544.controller.CartController.*(..))")
	public void cartActionAfer(JoinPoint jp) {

		// logMessage("A request to:" + jp.getTarget().getClass().getName() + "
		// Method:" + jp.getSignature() + " procesed");

	}

	@Before("execution(* mum.edu.cs544.controller.CardController.*(..))")
	public void cardActionBefore(JoinPoint jp) {

		// logMessage("A request to:" + jp.getTarget().getClass().getName() + "
		// Method:" + jp.getSignature()
		// + " is about to process");

	}

	@After("execution(* mum.edu.cs544.controller.CardController.*(..))")
	public void cardActionAfer(JoinPoint jp) {

		// logMessage(
		// "A request to:" + jp.getTarget().getClass().getName() + " Method:" +
		// jp.getSignature() + " procesed");

	}

	@After("execution(public * mum.edu.cs544.controller.BrandController.*(..)) ||execution(public * mum.edu.cs544.controller.CategoryController.*(..)) ||execution(public * mum.edu.cs544.controller.ProductController.*(..)) ")
	public void traceAfterMethod(JoinPoint joinpoint) throws IOException {
		String method = joinpoint.getSignature().getName();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("**************************************");
		logMessage(method + " action has been performed for current store at :" + dateFormat.format(date));

	}

	@Around("execution(public * mum.edu.cs544.controller.BrandController.*(..)) ||execution(public * mum.edu.cs544.controller.CategoryController.*(..)) ||execution(public * mum.edu.cs544.controller.ProductController.*(..)) ")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		 logMessage("Time to execute (in Mili second) " + "is :" + totaltime);
		return retVal;
	}

	// govinda
	@After("execution(public * mum.edu.cs544.controller.UserController.*(..))")
	public void trace1AfterMethod(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().getName();
		// logMessage( " action has been performed for current user.");
	}

	public void logMessage(String m) {
		try {
			fh = new FileHandler("/Users/sureshadhikari/Desktop/logger/shoppingstore.log");
			logger.addHandler(fh);
			// logger.setLevel(Level.ALL);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages
			// logger.info(m);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package mini_project.insurance.exception;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	private Logger logger = LoggerFactory.logger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public String hadleAE(Exception ae) {
		String message = ae.getMessage();
		logger.error(message);
		return "errorPage";
	}
}

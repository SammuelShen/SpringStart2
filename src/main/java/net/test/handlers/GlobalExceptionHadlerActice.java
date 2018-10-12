package net.test.handlers;

import net.test.entities.ErrorMessage;
import net.test.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionHadlerActice {
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ErrorMessage entityNotFoundException(HttpServletRequest request, Exception e){
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(e.getLocalizedMessage());
        errorMessage.setUrl(request.getRequestURL().toString());
        return errorMessage;
    }
}

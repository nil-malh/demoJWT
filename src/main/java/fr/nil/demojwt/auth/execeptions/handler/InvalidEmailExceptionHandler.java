package fr.nil.demojwt.auth.execeptions.handler;

import fr.nil.demojwt.auth.execeptions.InvalidEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequiredArgsConstructor
public class InvalidEmailExceptionHandler {

    @ResponseBody
    @ExceptionHandler(InvalidEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String InvalidEmailException(InvalidEmailException e){
        return e.getMessage();
    }


}

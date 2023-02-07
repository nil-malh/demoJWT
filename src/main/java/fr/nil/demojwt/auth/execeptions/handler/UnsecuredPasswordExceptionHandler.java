package fr.nil.demojwt.auth.execeptions.handler;


import fr.nil.demojwt.auth.execeptions.UnsecuredPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequiredArgsConstructor
public class UnsecuredPasswordExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UnsecuredPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String unsecuredPasswordException(UnsecuredPasswordException e){
        return e.getMessage();
    }


}

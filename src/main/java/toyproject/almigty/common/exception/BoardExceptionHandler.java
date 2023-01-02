package toyproject.almigty.common.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import toyproject.almigty.common.constants.ResponseCode;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static toyproject.almigty.common.constants.StaticValues.RESULT_CODE;
import static toyproject.almigty.common.constants.StaticValues.RESULT_MESSAGE;

@Slf4j
@RestControllerAdvice
public class BoardExceptionHandler extends ResponseEntityExceptionHandler {
    private HttpHeaders setHeaders(String responseCode, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(RESULT_CODE, responseCode);
        headers.add(RESULT_MESSAGE, URLEncoder.encode(message, StandardCharsets.UTF_8));
        return headers;
    }

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleApiExceptions(ApiException ex){
        HttpHeaders httpHeaders = setHeaders(ex.getResCode(),ex.getResMessage());
        //error 로그 찍기
        log.error("ApiException occurred!!!", ex);
        return new ResponseEntity<>(httpHeaders,ex.getHttpStatus());
    }

}

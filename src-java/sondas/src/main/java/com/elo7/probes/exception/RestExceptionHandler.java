package com.elo7.probes.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException. Exception to be thrown
     * when validation on an argument annotated with @Valid fails.
     * @param exc        the MethodArgumentNotValidException that is thrown
     *                  when @Valid fails
     *
     * @param headers   HttpHeaders
     * @param status    HttpStatus
     * @param request   WebRequest
     * @return          the ErrorResponse object
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exc,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        // Build ErrorResponse object with Http Status code and a message
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Validation error"
        );

        // Build ResponseEntity object with the errorResponse and return it
        return buildResponseEntity(errorResponse);
    }

    /**
     * Handles handleHttpMessageNotReadable. Exception to be thrown
     * by HttpMessageConverter implementations when the
     * HttpMessageConverter.read(...) method fails
     *
     * @param exc        the HttpMessageNotReadableException that is thrown
     *                  when HttpMessageConverter.read(...) fails
     * @param headers   HttpHeaders
     * @param status    HttpStatus
     * @param request   WebRequest
     * @return          the ErrorResponse object
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException exc,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        // Build ErrorResponse object with Http Status code and a message
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Malformed JSON request"
        );

        // Build ResponseEntity object with the errorResponse and return it
        return buildResponseEntity(errorResponse);
    }

    /**
     * Handles handleEntityNotFoundException. Exception to be thrown
     * when a certain searched Entity does not exist.
     *
     * @param exc   the EntityNotFoundException that is thrown when
     *              the searched Entity does not exist
     * @return      the ErrorResponse object
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFoundException exc) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                exc.getMessage()
        );

        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(MovementException.class)
    public ResponseEntity<Object> CollisionException(
            MovementException exc) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                exc.getMessage()
        );

        return buildResponseEntity(errorResponse);
    }

    /**
     * Handles Exception, i.e., a method that handles any kind of
     * exception that is thrown.
     *
     * @param exc   any Exception that is thrown
     * @return      the ErrorResponse object
     */
    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception exc) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                exc.getMessage()
        );

        return buildResponseEntity(errorResponse);
    }

    /**
     * Builds the ResponseEntity object with errorResponse as its body
     *
     * @param errorResponse     the ErrorResponse object that serves as body
     *                          of the ResponseEntity object
     * @return                  the ResponseEntity object
     */
    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}

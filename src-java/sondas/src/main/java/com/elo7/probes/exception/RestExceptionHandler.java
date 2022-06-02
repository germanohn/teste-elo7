package com.elo7.probes.exception;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // The following errors correspond to status code 400

    /**
     * Handles MethodArgumentNotValidException. Exception to be thrown
     * when validation on an argument annotated with @Valid fails.
     * @param exc       the MethodArgumentNotValidException that is thrown
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
        String message = "Validation error";

        List<String> details = new ArrayList<String>();

        // Add Field Errors
        exc.getBindingResult().getFieldErrors().forEach(error ->
                details.add(error.getField() + ": " +
                        error.getDefaultMessage()));

        // Add Global Errors
        exc.getBindingResult().getGlobalErrors().forEach(error ->
                details.add(error.getObjectName() + ": " +
                        error.getDefaultMessage()));

        // Build ErrorResponse object with Http Status code, message, and details
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                message,
                details
        );

        // Build ResponseEntity object with the errorResponse and return it
        return buildResponseEntity(errorResponse);
    }

    /**
     * Handles MissingServletRequestParameterException. Exception to be
     * thrown when a request is missing a parameter.
     *
     * @param exc       the MissingServletRequestParameterException that is
     *                  thrown when a parameter is missing
     * @param headers   HttpHeaders
     * @param status    HttpStatus
     * @param request   WebRequest
     * @return          the ErrorResponse object
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException exc,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = exc.getParameterName() + " parameter is missing";

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                message
        );

        return buildResponseEntity(errorResponse);
    }

    /**
     * Handles ConstraintViolationException. Exception that reports the
     * result of constraint violations
     *
     * @param exc   the ConstraintViolationException
     * @return      the ErrorResponse object
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException exc
    ) {
        String message = "Validation error";

        List<String> details = new ArrayList<String>();

        exc.getConstraintViolations().forEach(violation ->
                details.add(violation.getRootBeanClass().getName() + " " +
                        violation.getPropertyPath() + ": " +
                        violation.getMessage()));

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                message,
                details
        );

        return buildResponseEntity(errorResponse);
    }


    /**
     * Handles MethodArgumentTypeMismatchException. Exception to be
     * thrown when a method argument has not the expected type.
     *
     * @param exc   the MethodArgumentTypeMismatchException
     * @return      the ErrorResponse object
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exc
    ) {
        String message = exc.getName() + " parameter must be of type " +
                exc.getRequiredType().getName();

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                message
        );

        return buildResponseEntity(errorResponse);
    }


    /**
     * Handles handleHttpMessageNotReadable. Exception to be thrown
     * by HttpMessageConverter implementations when the
     * HttpMessageConverter.read(...) method fails
     *
     * @param exc       the HttpMessageNotReadableException that is thrown
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
                "Malformed JSON request",
                exc.getLocalizedMessage()
        );

        // Build ResponseEntity object with the errorResponse and return it
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

    // The following errors correspond to status code 404

    /**
     * Handles NoHandlerFoundException. Exception to be thrown when
     * a handler for a certain request is not found
     *
     * @param exc        the NoHandlerFoundException
     * @param headers   HttpHeaders
     * @param status    HttpStatus
     * @param request   WebRequest
     * @return          the ErrorResponse object
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException exc,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = "No handler found for " + exc.getHttpMethod() + " " +
                exc.getRequestURL();

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                message
        );

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
    protected ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFoundException exc) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                exc.getMessage()
        );

        return buildResponseEntity(errorResponse);
    }

    // The following error correspond to status code 405


    /**
     * Handles HttpRequestMethodNotSupportedException. Exception to be
     * thrown when a request handler does not support a specific
     * request method
     *
     * @param exc       the HttpRequestMethodNotSupportedException
     * @param headers   HttpHeaders
     * @param status    HttpStatus
     * @param request   WebRequest
     * @return          the ErrorResponse object
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException exc,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = exc.getMethod() + " method is not supported for this request";

        StringBuilder detail = new StringBuilder();

        Set<HttpMethod> httpMethods = exc.getSupportedHttpMethods();

        if (!httpMethods.isEmpty()) {
            detail.append("Supported methods are ");

            httpMethods.forEach(method -> detail.append(method + ", "));

            // remove the last comma and space
            detail.delete(detail.length() - 2, detail.length());
        } else {
            detail.append("There are no supported methods");
        }

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.METHOD_NOT_ALLOWED,
                message,
                detail.toString()
        );

        return buildResponseEntity(errorResponse);
    }

    // the following error correspond to status code 415

    /**
     * Handles HttpMediaTypeNotSupportedException. Exception to be thrown
     * when the content type of a http request is not supported.
     *
     * @param exc       the HttpMediaTypeNotSupportedException
     * @param headers   HttpHeaders
     * @param status    HttpStatus
     * @param request   WebRequest
     * @return          the ErrorResponse object
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException exc,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        String message = exc.getContentType() + " media type is not supported";

        StringBuilder detail = new StringBuilder();

        List<MediaType> mediaTypes = exc.getSupportedMediaTypes();

        if (!mediaTypes.isEmpty()) {
            detail.append("Supported media types are ");

            mediaTypes.forEach(type -> detail.append(type + ", "));

            // remove the last comma and space
            detail.delete(detail.length() - 2, detail.length());
        } else {
            detail.append("There are no supported media types");
        }

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.UNSUPPORTED_MEDIA_TYPE,
                message,
                detail.toString()
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
    @ExceptionHandler(Exception.class)
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

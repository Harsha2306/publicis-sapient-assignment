package com.harsha.backend.exception;

import com.harsha.backend.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RecipeNotFoundException.class)
  public ResponseEntity<ErrorResponseDto> handleRecipeNotFoundException(
      RecipeNotFoundException ex) {
    ErrorResponseDto errorResponseDto =
        ErrorResponseDto.builder()
            .statusCode(HttpStatus.NOT_FOUND.value())
            .message(ex.getMessage())
            .build();
    return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDto> handleGenericException(RecipeNotFoundException ex) {
    ErrorResponseDto errorResponseDto =
        ErrorResponseDto.builder()
            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message(ex.getMessage())
            .build();
    return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

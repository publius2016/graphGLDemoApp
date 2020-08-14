package com.udacity.graphDemo.service;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class DogNotFoundError extends RuntimeException implements GraphQLError {
   private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundError(String message, Long invalidDogId) {
        super(message);
        extensions.put("invalidDogId", invalidDogId);
    }

    @Override
    public List<SourceLocation> getLocations() { return null; }

    @Override
    public Map<String, Object> getExtensions() { return extensions; }

    @Override
    public ErrorType getErrorType() { return ErrorType.DataFetchingException; }
}

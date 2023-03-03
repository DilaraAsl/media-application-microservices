package com.tsg.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String  errorMessage;
    private String  details;
}

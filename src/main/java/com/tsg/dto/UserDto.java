package com.tsg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated // we have to use this for spring 2.7.8 - for jacarta no need
public class UserDto {
    private Integer id;
    @Size(min=2, message="Name should have at least two characters")
    private String name;
    @Past(message="Birth Date should be in the past")
    private LocalDate birthdate;
}

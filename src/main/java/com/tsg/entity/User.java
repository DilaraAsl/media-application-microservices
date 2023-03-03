package com.tsg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="users")
@Where(clause="is_deleted=false")
@Validated
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min=2, message="Name should have at least two characters")
    private String name;
    @Past(message="Birth Date should be in the past")
    private LocalDate birthdate;
    private boolean isDeleted;

    public User(Integer id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.isDeleted = false;
    }
}

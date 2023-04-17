package com.tsg.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction", length = 50)
    private String transaction;

    @Column(name = "datetime")
    private LocalDate datetime;

    @Column(name = "notes", length = 50)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id", referencedColumnName = "id")
    private Device assignee;

    // Constructor, getters, and setters
}
package com.wipro.DoConnect.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.wipro.DoConnect.status.Status;

import lombok.Data;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "answers")
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Lob
    @Column(name="body", length=512)
    private String body;

    private Status status;

    private Date createdDate;

    @Lob
    private byte[] img;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Questions questions;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;


   
}

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
@Table(name = "question")
@Data
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String title;

    private Status status;

    @Lob
    @Column(name="body")
    private String body;

    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "questions", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Answer> answerList;


}

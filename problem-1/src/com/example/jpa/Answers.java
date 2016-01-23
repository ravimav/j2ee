package com.example.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWERS")
@NamedQueries({
    @NamedQuery(name = "Answers.findAll", query = "SELECT a FROM Answers a"),
    @NamedQuery(name = "Answers.findById", query = "SELECT a FROM Answers a WHERE a.id = :id"),
    @NamedQuery(name = "Answers.findByText", query = "SELECT a FROM Answers a WHERE a.text = :text")})
public class Answers {
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TEXT")
    private String text;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Questions questionId;

    public Answers(Integer id,Users userId,Questions questionId,String text) {
		this.id=id;
		this.userId = userId;
        this.questionId = questionId;
        this.text= text;
	}

    public Answers(Integer id) {
        this.id = id;
    }

    public Answers(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }

    
    @Override
    public String toString() {
        return "com.example.jpa.Answers[ id=" + id + " ]";
    }
    
}

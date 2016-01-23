package com.example.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONS")
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q"),
    @NamedQuery(name = "Questions.findById", query = "SELECT q FROM Questions q WHERE q.id = :id"),
    @NamedQuery(name = "Questions.findByText", query = "SELECT q FROM Questions q WHERE q.text = :text")})
public class Questions {
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

    public Questions(Integer id, Users userid, String text) {
        this.id = id;
        this.userId = userid;
        this.text= text;
    }
	public Questions() {
        
	}

    public Questions(Integer id) {
        this.id = id;
    }

    public Questions(Integer id, String text) {
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

    @Override
    public String toString() {
        return "com.example.jpa.Questions[ id=" + id + " ]";
    }
    
}

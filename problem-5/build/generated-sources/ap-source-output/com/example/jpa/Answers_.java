package com.example.jpa;

import com.example.jpa.Questions;
import com.example.jpa.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-16T23:20:41")
@StaticMetamodel(Answers.class)
public class Answers_ { 

    public static volatile SingularAttribute<Answers, Integer> id;
    public static volatile SingularAttribute<Answers, String> text;
    public static volatile SingularAttribute<Answers, Questions> questionId;
    public static volatile SingularAttribute<Answers, Date> createdAt;
    public static volatile SingularAttribute<Answers, Users> userId;

}
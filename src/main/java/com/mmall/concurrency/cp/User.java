package com.mmall.concurrency.cp;

import javax.persistence.*;

@Entity(name = "user")
@Table(name = "t_user")
public class User {
    @Id//标明主键
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id = null;
    @Column(name = "user_name")
    private String userName = null;
    @Convert(converter = SexConverter.class)
    private SexEnum sex = null;//枚举;
    private  String note = null;

    public void setId(Long id) {
        this.id = id;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public String getNote() {
        return note;
    }
}

package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "instructor_detail")
@Data
@ToString
@NoArgsConstructor
public class InstructorDetail {

/*    annotate the class as an enity and map to db table
    define fields
    annotate the fields with db column names
    create constructor
    getters and setters
    add to string*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "youtube_channel")
    private String youtubeCannel;
    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail(String youtubeCannel, String hobby) {
        this.youtubeCannel = youtubeCannel;
        this.hobby = hobby;
    }


}

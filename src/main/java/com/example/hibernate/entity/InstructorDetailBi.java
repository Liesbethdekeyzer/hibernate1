package com.example.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "instructor_detail")
@Data
public class InstructorDetailBi {

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

    //add new field for instructor
    // add @oneToOne annotation mappedBy is the field will ref to the instructorDetailBi in instructorBi
    @OneToOne(mappedBy = "instructorDetailBi", cascade = CascadeType.ALL)
    private InstructorBi instructorBi;

    public InstructorDetailBi(String youtubeCannel, String hobby, InstructorBi instructorBi) {
        this.youtubeCannel = youtubeCannel;
        this.hobby = hobby;
    }

    public InstructorDetailBi(){
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InstructorDetailBi{");
        sb.append("id=").append(id);
        sb.append(", youtubeCannel='").append(youtubeCannel).append('\'');
        sb.append(", hobby='").append(hobby).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

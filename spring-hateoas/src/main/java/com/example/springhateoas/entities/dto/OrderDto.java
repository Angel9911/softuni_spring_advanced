package com.example.springhateoas.entities.dto;

import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "orders")
public class OrderDto {
    private Long id;
    private Long studentId;
    private Long courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}

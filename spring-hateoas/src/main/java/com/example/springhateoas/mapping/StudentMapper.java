package com.example.springhateoas.mapping;

import com.example.springhateoas.entities.Student;
import com.example.springhateoas.entities.dto.StudentDto;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto mapEntityToDto(Student student);
}

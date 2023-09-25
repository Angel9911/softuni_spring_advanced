package com.example.springhateoas.controllers;

import com.example.springhateoas.entities.Orders;
import com.example.springhateoas.entities.Student;
import com.example.springhateoas.entities.dto.OrderDto;
import com.example.springhateoas.entities.dto.StudentDto;
import com.example.springhateoas.mapping.StudentMapper;
import com.example.springhateoas.repositories.StudentsRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class StudentsController {
    private final StudentsRepository studentsRepository;
    private final StudentMapper studentMapper;

    public StudentsController(StudentsRepository studentsRepository, StudentMapper studentMapper) {
        this.studentsRepository = studentsRepository;
        //We never inject repository in controller. The repository is used only in service classes.
        //TODO : Implement service logic and insert repositories there
        this.studentMapper = studentMapper;
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDto>>> getOrders(@PathVariable("id") Long id){
        Student studentById = studentsRepository.findById(id).orElseThrow();

        List<EntityModel<OrderDto>> collect = studentById.getOrders()
                .stream()
                .map(order -> this.map(order))
                .map(dto -> EntityModel.of(dto))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(collect));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDto>> update(@PathVariable("id") Long id, @RequestBody StudentDto studentDto){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<EntityModel<StudentDto>> create(StudentDto studentDto){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students")
    public ResponseEntity<CollectionModel<EntityModel<StudentDto>>> getAllStudents(){
        List<EntityModel<StudentDto>> studentCollection = studentsRepository.findAll().stream()
                .map(studentMapper::mapEntityToDto)// entity to dto
                .map(studentDto -> EntityModel.of(studentDto,createStudentLinks(studentDto))) // dto to entityModel
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(studentCollection));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDto>> getStudentsById(@PathVariable("id") Long id){
        Optional<Student> studentById = studentsRepository.findById(id);

        StudentDto studentDto = studentById.map(studentMapper::mapEntityToDto)
                .orElseThrow();

        return ResponseEntity.ok(
                EntityModel.of(studentDto,createStudentLinks(studentDto))
        );
    }

    private OrderDto map(Orders order){
       OrderDto orderDto = new OrderDto();
       orderDto.setStudentId(order.getStudent().getId());
       orderDto.setCourseId(order.getStudent().getId());
       orderDto.setId(order.getId());

       return orderDto;
    }

    private Link[] createStudentLinks(StudentDto student){
        List<Link> result = new ArrayList<>();

        Link selfLink = linkTo(methodOn(StudentsController.class)
                        .getStudentsById(student.getId())).withSelfRel();

        Link updateLink = linkTo(methodOn(StudentsController.class)
                            .update(student.getId(),student)).withRel("update");

        /*Link createLink = linkTo(methodOn(StudentsController.class)
                            .create(student)).withRel("create");*/
        Link orderLink = linkTo(methodOn(StudentsController.class)
                        .getOrders(student.getId())).withRel("orders");

        result.add(selfLink);
        result.add(updateLink);
        result.add(orderLink);

        return result.toArray(new Link[0]);
    }
}

package com.desabi.api.source.controller;

import com.desabi.api.source.entity.PersonEntity;
import com.desabi.api.source.model.request.PersonRequest;
import com.desabi.api.source.service.PersonService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-source")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody PersonRequest personRequest) {
        return personService.create(personRequest);
    }

    @GetMapping("/person")
    public ResponseEntity<List<PersonEntity>> read() {
        return personService.read();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonEntity> read(@PathVariable("id") ObjectId personId) {
        return personService.read(personId);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<HttpStatus> update(
            @PathVariable("id") ObjectId personId,
            @Valid @RequestBody PersonRequest personRequest) {
        return personService.update(personId, personRequest);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<HttpStatus> delete( @PathVariable("id") ObjectId personId) {
        return personService.delete(personId);
    }
}

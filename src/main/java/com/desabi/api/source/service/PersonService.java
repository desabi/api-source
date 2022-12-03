package com.desabi.api.source.service;

import com.desabi.api.source.entity.PersonEntity;
import com.desabi.api.source.model.Person;
import com.desabi.api.source.model.request.PersonRequest;
import com.desabi.api.source.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<HttpStatus> create(PersonRequest personRequest) {
        try {
            PersonEntity personEntity = new PersonEntity(personRequest);
            personRepository.save(personEntity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear la persona: {}", personRequest);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PersonEntity>> read() {
        try {
            List<PersonEntity> persons = personRepository.findAll();
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener las personas: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PersonEntity> read(ObjectId personId) {
        try {
            Optional<PersonEntity> personEntityOptional = personRepository.findById(personId);
            if (personEntityOptional.isPresent()) {
                PersonEntity personEntity = personEntityOptional.get();
                return new ResponseEntity<>(personEntity,  HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error al obtener persona con id: {}", personId);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> update(ObjectId personId, PersonRequest personRequest) {
        try {
            Optional<PersonEntity> personEntityOptional = personRepository.findById(personId);

            if (personEntityOptional.isPresent()) {
                PersonEntity personEntity = personEntityOptional.get();

                personEntity.setName(personRequest.getName());
                personEntity.setAge(personRequest.getAge());
                personEntity.setInformation(personRequest.getInformation());

                personRepository.save(personEntity);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error al actualizar persona con id: {}", personId);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> delete(ObjectId personId) {
        try {
            log.info("borrar {}", personId);
            personRepository.deleteById(personId);
            log.info("borrado: {}", personId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al eliminar persona con id: {}", personId);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

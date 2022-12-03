package com.desabi.api.source.entity;

import com.desabi.api.source.model.Person;
import com.desabi.api.source.model.request.PersonRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "person")
@NoArgsConstructor // read all
@Data
@EqualsAndHashCode(callSuper=false)
public class PersonEntity extends Person {

    @Id
    @Field("_id")
    private ObjectId objectId;

    // create
    public PersonEntity(PersonRequest personRequest) {
        this.name = personRequest.getName();
        this.age = personRequest.getAge();
        this.information = personRequest.getInformation();
    }
}

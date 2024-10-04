package com.example.productserviceproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

//@entity annotation is used to mark the class as an entity class
//so that hibernate can recognize it as an entity class
//and create a table for it in the database
@Getter
@Setter
@Entity
public class Product extends BaseModel implements Serializable {


    private String title;
    private Double price;
    //Double should be Capital 'D'ouble not double

//@ManyToOne//Doesn't support MappedBy function. so MappedBy is used in Category class for OneToMany relation

    //@ManyToOne(cascade = {CascadeType.ALL})- Explaination in Error notes
    //@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToOne
    private Category category;
//if something happens to the product, do the similar thing to category.Ex- if someone deletes/update/create
// the product then do the same/cascade it to category.

    private String description;
    private String imageUrl;
//  Non-Primitive attributes are the type whose data type is another class.
//  Here comes the concept of Cardinality.

}
/*Steps to create a table in database
1)for every class create a corresponding table
2)for all the primitive attributes create a column in the table

General Ques
Q)What is the cardinality between the product and category?
A)Many to one
    1   ->   1
Product : Category
    m   ->   1
--------------------
    m   :   1

 */

/*
public class Product extends BaseModel implements Serializable
Internally redis is storing data in the form of bytes.so it needs to serialize the data.
means redis needs to convert our java object into bytes.

Serialization
->It is the process of converting an object into bytes.
->It is used to store the state of an object.
->It is used to pass the object from one network to another network.
->It is used to pass the object from one JVM to another JVM.

So when we are storing the object in redis?
Redis is a programming lang independent thing, so it does not know what is Product,
it needs to convert it into bytes.

->Serializable is a marker interface, it does not have any methods.
so redis expects that whatever class we are storing should be serializable/should implement serializable interface.
just to tell redis that this class can be converted into bytes.
 */

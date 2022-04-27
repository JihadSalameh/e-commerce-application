package edu.bzu.app.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields
@AllArgsConstructor   //automatically generates a constructor with a parameter for each field in your class
@NoArgsConstructor     // generates a constructor with no parameter

@Entity                 // specifies that the class is an entity and is mapped to a database table
@Table(  //allows you to specify the details of the table that will be used to persist the entity in the database
        name = "customers", uniqueConstraints = {@UniqueConstraint(columnNames = {"full_name"})}
)

public class Customer {

    @Id   //declare the primary key
    @GeneratedValue(
            strategy = GenerationType.IDENTITY //indicates that the persistence provider must assign primary keys for the entity using a database identity column.This means they are auto-incremented
    )
    private int id;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "country", nullable = true)
    private String country;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phone;

}

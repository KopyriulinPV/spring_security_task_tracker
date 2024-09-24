package com.example.task_tracker.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    private String id;

    private String username;

    private String email;

    private String password;

    @Field("roles")
    private Set<RoleType> roles = new HashSet<>();
}

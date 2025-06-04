package com.example.relaxer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(schema = "users_schema", name = "t_hobbies")
public class Hobby {
    @Id
    long id;

    @Column(name = "c_type")
    String type;

    @ManyToMany(mappedBy = "hobbies")
    Set<User> users;
}
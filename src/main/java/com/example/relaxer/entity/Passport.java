package com.example.relaxer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(schema = "users_schema", name = "t_passport")
public class Passport {
    @Id
    Long id;

    @Column(name = "c_number")
    String number;
}

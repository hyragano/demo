package com.example.demo.dal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity()
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="test_table")
public class Names {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @Column(name = "name")
    private String name;
}

package com.example.webassessment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private int studId;

    private String name;
    private String address;
    private String branch;
}

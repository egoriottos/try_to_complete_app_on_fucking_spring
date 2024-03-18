package com.example.dz_try2.domain.entity;

import com.example.dz_try2.domain.valueObject.TimeInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name ="users")
public class User {
    @Id
    @SequenceGenerator(name = "users_id_sequence", sequenceName = "users_id_seq",
    initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_sequence")
    private Long id;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Embedded
    private TimeInfo timeInfo;
}

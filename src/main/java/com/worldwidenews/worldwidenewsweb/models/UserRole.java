package com.worldwidenews.worldwidenewsweb.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String role;

}
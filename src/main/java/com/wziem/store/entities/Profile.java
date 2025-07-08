package com.wziem.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.text.DateFormat;
import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private DateFormat dateOfBirth;

    @Column(name = "loyalty_points")
    private Integer LoyaltyPoints;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id") // owner has join column annotation
    @MapsId //tells hibernate primary and fotrign key is the same
    private User user;

}

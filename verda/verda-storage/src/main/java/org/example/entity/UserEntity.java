package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String name;
    private String birthday;
    private String gender;
    private String investmentPropensity;
    private String number;
    private String age_range;

    @Builder
    public UserEntity(long userId, String email, String name, String birthday, String gender, String location,
                      String investmentPropensity, String number, String age_range) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.number = number;
        this.age_range = age_range;
    }
}


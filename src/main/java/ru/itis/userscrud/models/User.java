package ru.itis.userscrud.models;


import lombok.*;
import ru.itis.userscrud.dto.UserRegFormDto;
import ru.itis.userscrud.dto.UserRestDto;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq", allocationSize=50)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    private String email;
    private String password;
    private String country;
    private Character gender;
    private LocalDate birthday;

    public static User fromFormDto(UserRegFormDto userRegFormDto) {
        return User.builder().
                email(userRegFormDto.getEmail()).
                password(userRegFormDto.getPassword()).
                country(userRegFormDto.getCountry()).
                gender(userRegFormDto.getGender().charAt(0)).
                birthday(LocalDate.ofEpochDay(userRegFormDto.getBirthday().getTime()/1000/60/60/24)).
                build();
    }

    public static User fromRestDto(UserRestDto userRestDto) {
        return User.builder().
                email(userRestDto.getEmail()).
                password(userRestDto.getPassword()).
                country(userRestDto.getCountry()).
                gender(userRestDto.getGender().charAt(0)).
                birthday(LocalDate.ofEpochDay(userRestDto.getBirthday().getTime()/1000/60/60/24)).
                build();
    }
}

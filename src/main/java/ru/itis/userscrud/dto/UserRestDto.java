package ru.itis.userscrud.dto;

import lombok.*;
import ru.itis.userscrud.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRestDto {

    private Integer id;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private String country;
    @Pattern(regexp = "m|f")
    private String gender;
    @Past
    private Date birthday;


    public UserRestDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.country = user.getCountry();
        this.gender = user.getGender().toString();
        this.birthday = new Date(user.getBirthday().getYear() - 1900, user.getBirthday().getMonthValue(),
                user.getBirthday().getDayOfMonth());
    }
}

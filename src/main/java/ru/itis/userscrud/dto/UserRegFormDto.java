package ru.itis.userscrud.dto;

import lombok.*;
import ru.itis.userscrud.models.validation.UserEqualPasswords;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@UserEqualPasswords
public class UserRegFormDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String repassword;
    private String country;
    @AssertTrue
    private boolean agreement;
    @Pattern(regexp = "m|f")
    private String gender;
    @Past
    private Date birthday;
}

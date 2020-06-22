package ru.itis.userscrud.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "logging", schema = "public")
public class Logging {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="logging_generator", sequenceName = "logging_seq", allocationSize=50)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    private String message;
    private LocalDateTime dateTime;
}

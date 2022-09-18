package com.narendran.learncourses.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "res_sequence")
    @GenericGenerator(name = "res_sequence", strategy = "com.narendran.learncourses.utility.String_Id_Generator", parameters = {
            @Parameter(value = "50", name = "StringIdGenerator.INCREMENT_PARAM"),
            @Parameter(value = "DXC_ID: ", name = "StringIdGenerator.VALUE_PREFIX_PARAMETER"),
            @Parameter(value = "%05d", name = "StringIdGenerator.NUMBER_FORMAT_PARAMETER")})
    @Column(unique = true, updatable = false)
    private String learnerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private Integer age;

    @Column(unique = true)
    private String email;

    private String password;

    private String confirmPassword;

}

package com.matching.task.dto;

import lombok.*;
import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;
import net.sf.jsefa.flr.annotation.FlrDataType;
import net.sf.jsefa.xml.annotation.XmlDataType;

import java.io.Serializable;
import java.util.Objects;

@CsvDataType
@XmlDataType
@FlrDataType
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDTO implements Serializable {

    @CsvField(pos = 1)
    private String name;
    @CsvField(pos = 2)
    private String email;
    @CsvField(pos = 3)
    private String division;
    @CsvField(pos = 4)
    private Integer age;
    @CsvField(pos = 5)
    private Integer uTC;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return name.equals(personDTO.name) &&
                email.equals(personDTO.email) &&
                division.equals(personDTO.division) &&
                age.equals(personDTO.age) &&
                uTC.equals(personDTO.uTC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, division, age, uTC);
    }
}

package com.matching.task.dto;

import lombok.ToString;
@ToString
public class Pair {
    private final PersonDTO personDTO1;
    private final PersonDTO personDTO2;
    private final Integer matchScore;

    public Pair(PersonDTO personDTO1, PersonDTO personDTO2, Integer matchScore) {
        this.personDTO1 = personDTO1;
        this.personDTO2 = personDTO2;
        this.matchScore = matchScore;
    }

    public PersonDTO getPersonDTO1() {
        return personDTO1;
    }

    public PersonDTO getPersonDTO2() {
        return personDTO2;
    }

    public Integer getMatchScore() {
        return matchScore;
    }

}

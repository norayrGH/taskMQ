package com.matching.task.dto;

import lombok.ToString;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return personDTO1.equals(pair.personDTO1) &&
                personDTO2.equals(pair.personDTO2) &&
                matchScore.equals(pair.matchScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personDTO1, personDTO2, matchScore);
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

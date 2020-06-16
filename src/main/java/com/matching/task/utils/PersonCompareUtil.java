package com.matching.task.utils;

import com.matching.task.dto.PersonDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersonCompareUtil {

    private final static Map<PersonFields,Integer> PERSON_FIELDS_PERCENTAGE_MAP = new HashMap<PersonFields,Integer>(){
        {
            put(PersonFields.DIVISION,40);
            put(PersonFields.UTC,30);
            put(PersonFields.AGE,30);
        }
    };

    public static Integer pairComparePercentage(PersonDTO personDTO1,PersonDTO personDTO2){

        Integer pairComparePercentage = 0 ;

        for (PersonFields field : PersonFields.values()) {
            switch (field){
                case AGE:
                    if (ageCompare(personDTO1.getAge(),personDTO2.getAge())){
                        pairComparePercentage = pairComparePercentage + PERSON_FIELDS_PERCENTAGE_MAP.get(field);
                    }
                    break;
                case UTC:
                    if(uTCCompare(personDTO1.getUTC(),personDTO2.getUTC())){
                        pairComparePercentage = pairComparePercentage + PERSON_FIELDS_PERCENTAGE_MAP.get(field);
                    }
                    break;
                case DIVISION:
                    if(divisionCompare(personDTO1.getDivision(),personDTO2.getDivision())){
                        pairComparePercentage = pairComparePercentage + PERSON_FIELDS_PERCENTAGE_MAP.get(field);
                    }
                    break;
            }
        }

        return pairComparePercentage;
    }

    private static boolean divisionCompare(String division1, String division2) {
        return Objects.equals(division1, division2);
    }

    private static boolean uTCCompare(Integer utc1, Integer utc2) {
        return Objects.equals(utc1, utc2);
    }

    private static boolean ageCompare(Integer age1, Integer age2) {
        return Math.abs(age1 - age2) <= 5;
    }
}

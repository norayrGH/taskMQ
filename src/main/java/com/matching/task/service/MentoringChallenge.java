package com.matching.task.service;

import com.matching.task.dto.PersonDTO;
import com.matching.task.utils.SetOfPairs;

import java.util.List;

public interface MentoringChallenge {
    List<SetOfPairs> listOfMatchesWithTheHighestAverageMatchScore(List<PersonDTO> allPersons);
}

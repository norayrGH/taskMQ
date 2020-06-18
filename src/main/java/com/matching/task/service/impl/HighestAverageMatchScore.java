package com.matching.task.service.impl;

import com.matching.task.dto.Pair;
import com.matching.task.dto.PersonDTO;
import com.matching.task.service.MentoringChallenge;
import com.matching.task.utils.SetOfPairs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.matching.task.utils.PersonCompareUtil.pairComparePercentage;
@Service
public class HighestAverageMatchScore implements MentoringChallenge {

    public List<SetOfPairs> listOfMatchesWithTheHighestAverageMatchScore(List<PersonDTO> allPersons) {

        List<SetOfPairs> listSetOfPairs = new ArrayList<>();
        long setsCount = calculateSetsCount(allPersons.size()-1);
        int halfOfTheList = allPersons.size()/2;
        PersonDTO keepFirstElement = allPersons.get(0);
        allPersons.remove(0);
        for (int i = 0; i < setsCount; i++) {
            int index = i % allPersons.size();
            SetOfPairs setOfPairs = new SetOfPairs();
            setOfPairs.addPair(
                    new Pair(allPersons.get(index),keepFirstElement, pairComparePercentage(allPersons.get(index),keepFirstElement)));
            for (int other = 1; other < halfOfTheList; other++) {
                int firs = (other + i) % allPersons.size();
                int second = (i + allPersons.size() - other) % allPersons.size();
                setOfPairs.addPair(
                        new Pair(allPersons.get(firs),allPersons.get(second), pairComparePercentage(allPersons.get(firs),allPersons.get(second))));
            }
            listSetOfPairs.add(setOfPairs);
        }

        listSetOfPairs.sort(Comparator.comparing(SetOfPairs::getAverageOfPairs).reversed());
        return listSetOfPairs;
    }

    private long calculateSetsCount(int n){

        long nFact = 1;
        long nDiv = 0;
        for (int i = 2; i <= n; i++) {

            nFact = nFact * i;
            if (i == n-2){
                nDiv = nFact;
            }
        }

        return (nFact/(2*nDiv))/(n/2);
    }
}

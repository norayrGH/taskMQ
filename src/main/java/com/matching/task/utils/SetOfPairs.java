package com.matching.task.utils;

import com.matching.task.dto.Pair;

import java.util.LinkedList;
import java.util.List;

public class SetOfPairs {
    private List<Pair> pairs = new LinkedList<>() ;
    private int totalOfPairs;
    private int averageOfPairs;

    public SetOfPairs() {
    }

    public Integer getAverageOfPairs() {
        return averageOfPairs;
    }

    public void addPair(Pair pair) {
        this.pairs.add(pair);
        this.totalOfPairs += pair.getMatchScore();
        this.averageOfPairs = totalOfPairs / pairs.size();
    }

    public boolean isContainsPair(Pair pairToEquals) {
        for (Pair pair : pairs) {
            if (pair.getPersonDTO1().equals(pairToEquals.getPersonDTO1()) || pair.getPersonDTO1().equals(pairToEquals.getPersonDTO2())
            || pair.getPersonDTO2().equals(pairToEquals.getPersonDTO1()) || pair.getPersonDTO2().equals(pairToEquals.getPersonDTO2())) {
                return true;
            }
        }
        return false;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public int getTotalOfPairs() {
        return totalOfPairs;
    }
}

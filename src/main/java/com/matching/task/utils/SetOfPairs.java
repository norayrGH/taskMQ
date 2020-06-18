package com.matching.task.utils;

import com.matching.task.dto.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SetOfPairs {
    private List<Pair> pairs = new LinkedList<>() ;
    private int totalOfPairs;
    private int averageOfPairs;

    public SetOfPairs() {
    }

    public SetOfPairs(List<Pair> pairs, int averageOfPairs) {
        this.pairs = pairs;
        this.averageOfPairs = averageOfPairs;
    }

    public Integer getAverageOfPairs() {
        return averageOfPairs;
    }

    public void addPair(Pair pair) {
        this.pairs.add(pair);
        this.totalOfPairs += pair.getMatchScore();
        this.averageOfPairs = totalOfPairs / pairs.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetOfPairs that = (SetOfPairs) o;
        return averageOfPairs == that.averageOfPairs &&
                pairs.equals(that.pairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairs, averageOfPairs);
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public int getTotalOfPairs() {
        return totalOfPairs;
    }
}

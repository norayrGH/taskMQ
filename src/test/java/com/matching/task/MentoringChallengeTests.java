package com.matching.task;

import com.matching.task.dto.Pair;
import com.matching.task.dto.PersonDTO;
import com.matching.task.service.MentoringChallenge;
import com.matching.task.service.impl.HighestAverageMatchScore;
import com.matching.task.utils.SetOfPairs;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class MentoringChallengeTests {
    private static List<PersonDTO> personDTOList;
    private static List<SetOfPairs> setOfPairs;


    public MentoringChallengeTests() {
    }

    @BeforeClass
    public static void contextLoads() {

        personDTOList = new ArrayList<PersonDTO>(){{
            add(new PersonDTO("Gabrielle Clarkson","tamas@me_example.com","Accounting",25,2));
            add(new PersonDTO("Zoe Peters","gozer@icloud_example.com","Finance",30,3));
            add(new PersonDTO("Jacob Murray","lstein@me_example.com","Accounting",22,2));
            add(new PersonDTO("Nicholas Vance","saridder@outlook_example.com","Engineering",27,-3));
            add(new PersonDTO("Jason Hamilton","osaru@live_example.com","HR",35,4));
            add(new PersonDTO("Sally Bower","bulletin@att_example.com","Engineering",20,10));
        }};

        LinkedList<Pair> pairs1 = new LinkedList<Pair>(){{
            add(new Pair(personDTOList.get(2),personDTOList.get(0),100));
            add(new Pair(personDTOList.get(3),personDTOList.get(1),30));
            add(new Pair(personDTOList.get(4),personDTOList.get(5),0));
        }};

        LinkedList<Pair> pairs2 = new LinkedList<Pair>(){{
            add(new Pair(personDTOList.get(5),personDTOList.get(0),30));
            add(new Pair(personDTOList.get(1),personDTOList.get(4),30));
            add(new Pair(personDTOList.get(2),personDTOList.get(3),30));
        }};

        LinkedList<Pair> pairs3 = new LinkedList<Pair>(){{
            add(new Pair(personDTOList.get(1),personDTOList.get(0),30));
            add(new Pair(personDTOList.get(2),personDTOList.get(5),30));
            add(new Pair(personDTOList.get(3),personDTOList.get(4),0));
        }};

        LinkedList<Pair> pairs4 = new LinkedList<Pair>(){{
            add(new Pair(personDTOList.get(4),personDTOList.get(0),0));
            add(new Pair(personDTOList.get(5),personDTOList.get(3),40));
            add(new Pair(personDTOList.get(1),personDTOList.get(2),0));
        }};

        LinkedList<Pair> pairs5 = new LinkedList<Pair>(){{
            add(new Pair(personDTOList.get(3),personDTOList.get(0),30));
            add(new Pair(personDTOList.get(4),personDTOList.get(2),0));
            add(new Pair(personDTOList.get(5),personDTOList.get(1),0));
        }};

        setOfPairs = new ArrayList<SetOfPairs>(){{
            add( new SetOfPairs(pairs1,43));
            add( new SetOfPairs(pairs2,30));
            add( new SetOfPairs(pairs3,20));
            add( new SetOfPairs(pairs4,13));
            add( new SetOfPairs(pairs5,10));
        }};
    }

    @Test
    public void listOfMatchesWithTheHighestAverageMatchScoreTest() {
        MentoringChallenge mentoringChallenge = new HighestAverageMatchScore();
        List<SetOfPairs> newSetOfPairs = mentoringChallenge.listOfMatchesWithTheHighestAverageMatchScore(personDTOList);
        assertThat(newSetOfPairs).isEqualTo(setOfPairs);
    }

}

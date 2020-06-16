package com.matching.task.service.impl;

import com.matching.task.dto.Pair;
import com.matching.task.dto.PersonDTO;
import com.matching.task.service.ProcessFile;
import com.matching.task.utils.PersonCompareUtil;
import com.matching.task.utils.SetOfPairs;
import net.sf.jsefa.Deserializer;
import net.sf.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import net.sf.jsefa.csv.CsvIOFactory;
import net.sf.jsefa.csv.config.CsvConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class ProcessFileCSV implements ProcessFile {

    @Override
    public List<SetOfPairs> process(MultipartFile file) throws IOException {

        CsvConfiguration config = new CsvConfiguration();
        config.setLineFilter(new HeaderAndFooterFilter(1, false, true));
        config.setFieldDelimiter(',');
        Deserializer deserializer = CsvIOFactory.createFactory(config, PersonDTO.class).createDeserializer();

        Reader reader = new InputStreamReader(file.getInputStream());

        deserializer.open(reader);

        List<PersonDTO> personDTOS = new ArrayList<>();

        while (deserializer.hasNext()) {
            PersonDTO personDTO = deserializer.next();
            personDTOS.add(personDTO);

        }

        deserializer.close(true);

        List<SetOfPairs> setOfPairs = listOfMatchesWithTheHighestAverageMatchScore(findAllPossiblePairs(personDTOS));
        setOfPairs.sort(Comparator.comparing(SetOfPairs::getAverageOfPairs).reversed());
        return setOfPairs;


    }

    private List<SetOfPairs> listOfMatchesWithTheHighestAverageMatchScore(List<Pair> allPossiblePairs) {
        List<SetOfPairs> listSetOfPairs = new ArrayList<>();
        for (Pair pair : allPossiblePairs) {
            boolean isHasBeenSet = false;
            for (SetOfPairs setOfPair : listSetOfPairs) {
                if (!setOfPair.isContainsPair(pair)) {
                    setOfPair.addPair(pair);
                    isHasBeenSet = true;
                    break;
                }
            }
            if (!isHasBeenSet) {
                SetOfPairs setOfPair = new SetOfPairs();
                setOfPair.addPair(pair);
                listSetOfPairs.add(setOfPair);
            }
        }
        return listSetOfPairs;
    }


    private List<Pair> findAllPossiblePairs(List<PersonDTO> personDTOS){
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < personDTOS.size() - 1; i++) {
            for (int j = i + 1; j < personDTOS.size(); j++) {
                pairs.add(new Pair(personDTOS.get(i), personDTOS.get(j),
                        PersonCompareUtil.pairComparePercentage(personDTOS.get(i),personDTOS.get(j))));
            }
        }
        return pairs;
    }



}

package com.matching.task.service.impl;

import com.matching.task.dto.PersonDTO;
import com.matching.task.service.MentoringChallenge;
import com.matching.task.service.ProcessAndMentoringFacade;
import com.matching.task.service.ProcessFile;
import com.matching.task.utils.SetOfPairs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ProcessAndMentoringFacadeImpl implements ProcessAndMentoringFacade {

    private final MentoringChallenge mentoringChallenge;
    private final ProcessFile processFile;

    public ProcessAndMentoringFacadeImpl(MentoringChallenge mentoringChallenge, ProcessFile processFile) {
        this.mentoringChallenge = mentoringChallenge;
        this.processFile = processFile;
    }

    @Override
    public List<SetOfPairs> processAndMentoring(MultipartFile file) throws IOException {


        List<PersonDTO> persones = processFile.process(file);
        if (!(persones.size() % 2 ==0)) {
            throw new IllegalArgumentException("Odd numbers are not yet supported.");
        }
        return mentoringChallenge.listOfMatchesWithTheHighestAverageMatchScore(persones);
    }
}

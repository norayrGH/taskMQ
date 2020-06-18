package com.matching.task.service.impl;

import com.matching.task.dto.PersonDTO;
import com.matching.task.service.ProcessFile;
import net.sf.jsefa.Deserializer;
import net.sf.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import net.sf.jsefa.csv.CsvIOFactory;
import net.sf.jsefa.csv.config.CsvConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessFileCSV implements ProcessFile {

    @Override
    public List<PersonDTO> process(MultipartFile file) throws IOException {

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

        return personDTOS;


    }
}

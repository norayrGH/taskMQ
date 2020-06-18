package com.matching.task.service;

import com.matching.task.dto.PersonDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProcessFile {
    List<PersonDTO> process(MultipartFile file) throws IOException;

}

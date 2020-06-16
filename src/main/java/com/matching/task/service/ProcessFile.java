package com.matching.task.service;

import com.matching.task.utils.SetOfPairs;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProcessFile {
    List<SetOfPairs> process(MultipartFile file) throws IOException;

}

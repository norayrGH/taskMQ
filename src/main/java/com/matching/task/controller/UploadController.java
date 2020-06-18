package com.matching.task.controller;

import com.matching.task.service.impl.ProcessAndMentoringFacadeImpl;
import com.matching.task.utils.SetOfPairs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

    private final ProcessAndMentoringFacadeImpl processAndMentoringFacadeImpl;

    public UploadController(ProcessAndMentoringFacadeImpl processAndMentoringFacadeImpl) {
        this.processAndMentoringFacadeImpl = processAndMentoringFacadeImpl;
    }

    @GetMapping("/")
    public String uploadForm() {
        return "uploadForm";
    }

    @GetMapping("/highestAverage")
    public ModelAndView highestScores(ModelMap model,
                                      @ModelAttribute("listOfSetOfPairs") List<SetOfPairs> listOfSetOfPairs) {
        model.addAttribute("listOfSetOfPairs", listOfSetOfPairs);
        return new ModelAndView("highestAverage", model);
    }

    @PostMapping("/")
    public RedirectView uploadFileProcess(@RequestParam("file")MultipartFile file,
                                          RedirectAttributes attributes) throws IOException {

        List<SetOfPairs> listOfSetOfPairs = processAndMentoringFacadeImpl.processAndMentoring(file);
        attributes.addFlashAttribute("listOfSetOfPairs",listOfSetOfPairs);
        return new RedirectView("/highestAverage");
    }

}

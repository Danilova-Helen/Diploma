package ru.isu.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.isu.diploma.model.Desk;
import ru.isu.diploma.model.Hall;
import ru.isu.diploma.model.User;
import ru.isu.diploma.repository.DeskRepository;
import ru.isu.diploma.repository.HallRepository;
import ru.isu.diploma.repository.TimeRepository;
import ru.isu.diploma.repository.UserRepository;

@Controller
public class HomeController {
    @RequestMapping(value = "/start")
    public String start(Model model) {
        model.addAttribute("halls", hallRepository.findAll());
        return "start";
    }

    @RequestMapping(value = "/halls/{id}")
    public String smallHall(Model model, @PathVariable("id") Integer hallId) {
        Hall hall = hallRepository.findById(hallId).get();
        model.addAttribute("desks", deskRepository.getDesksByHall(hall));
        model.addAttribute("halls", hall);
        model.addAttribute("times", timeRepository.findAll());
        return "hall";
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private DeskRepository deskRepository;
}

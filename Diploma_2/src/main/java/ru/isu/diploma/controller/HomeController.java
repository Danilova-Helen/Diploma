package ru.isu.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.isu.diploma.model.User;
import ru.isu.diploma.repository.DeskRepository;
import ru.isu.diploma.repository.HallRepository;
import ru.isu.diploma.repository.TimeRepository;
import ru.isu.diploma.repository.UserRepository;

@Controller
public class HomeController {
    @RequestMapping(value = "/start")
    public String start() {
        return "start";
    }
    @RequestMapping(value = "/smallHall")
    public String smallHall() {
        return "smallHall";
    }
    @RequestMapping(value = "/bigHall")
    public String bigHall() {
        return "bigHall";
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

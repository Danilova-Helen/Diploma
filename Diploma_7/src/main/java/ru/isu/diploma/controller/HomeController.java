package ru.isu.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.isu.diploma.model.Booking;
import ru.isu.diploma.model.Hall;
import ru.isu.diploma.repository.DeskRepository;
import ru.isu.diploma.repository.HallRepository;
import ru.isu.diploma.repository.TimeRepository;
import ru.isu.diploma.repository.BookingRepository;

@Controller
public class HomeController {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private DeskRepository deskRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/map")
    public String map(Model model) {
        model.addAttribute("halls", hallRepository.findAll());
        return "map";
    }

    @RequestMapping(value = "/halls/{id}")
    public String hall(Model model, @PathVariable("id") Integer hallId) {
        Hall hall = hallRepository.findById(hallId).get();
        model.addAttribute("desks", deskRepository.getDesksByHall(hall));
        model.addAttribute("halls", hall);
        model.addAttribute("times", timeRepository.findAll());
        model.addAttribute("booking", new Booking());
        return "hall";
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public String booking(@ModelAttribute Booking booking) {
        bookingRepository.save(booking);
        return "redirect:/map";
    }

    /*@RequestMapping(value = "/reservation")
    public String reservation(Model model) {
        model.addAttribute("books", bookingRepository.findAll());
        return "reservation";
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public String reservation(Model model, @PathVariable("id") Integer bookId) {
        model.addAttribute("books", bookingRepository.findAll());
        bookingRepository.deleteById(bookId);
        return "redirect:/reservation";
    }*/
}
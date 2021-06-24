package ru.isu.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.isu.diploma.model.Booking;
import ru.isu.diploma.model.Desk;
import ru.isu.diploma.model.Hall;
import ru.isu.diploma.repository.DeskRepository;
import ru.isu.diploma.repository.HallRepository;
import ru.isu.diploma.repository.TimeRepository;
import ru.isu.diploma.repository.BookingRepository;

import java.util.List;

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
        if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return "redirect:/reservation";
        }
        else { return "login"; }
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
    @RequestMapping(value = "/desk/{id}/img", method = RequestMethod.GET)
    public @ResponseBody String getDeskImage(@PathVariable("id") Integer deskId) {
        Desk desk = deskRepository.getOne(deskId);
        return desk.getImg();
    }
    @RequestMapping(value = "/times", method = RequestMethod.POST)
    public @ResponseBody List<Booking> getTime(@RequestParam("beginTimeId") Integer beginTimeId, @RequestParam("endTimeId") Integer endTimeId) {
        List<Booking> time = bookingRepository.findBookingsByBeginTime_IdLessThanAndEndTime_IdGreaterThan(endTimeId, beginTimeId);
        return time;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public String booking(@ModelAttribute Booking booking) {
        List <Booking> time = bookingRepository.findBookingsByBeginTimeEqualsAndEndTimeEquals(booking.getBeginTime(), booking.getEndTime());
        if (time.isEmpty()) {
            bookingRepository.save(booking);
        }
        return "redirect:/map";
    }
}
package ru.isu.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.isu.diploma.model.Booking;
import ru.isu.diploma.repository.BookingRepository;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/logout")
    public String logout() {
        return "redirect:/map";
    }

    @RequestMapping(value = "/reservation")
    public String reservation(Model model) {
        model.addAttribute("books", bookingRepository.findAll());
        return "reservation";
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public @ResponseBody List<Booking> reservation() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Boolean delete(@PathVariable("id") Integer bookId) {
        bookingRepository.deleteById(bookId);
        return true;
    }
}

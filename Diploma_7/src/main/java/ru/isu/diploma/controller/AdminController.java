package ru.isu.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.isu.diploma.repository.BookingRepository;

@Controller
public class AdminController {

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/reservation")
    public String reservation(Model model) {
        model.addAttribute("books", bookingRepository.findAll());
        return "reservation";
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public String reservation(Model model, @PathVariable("id") Integer bookId) {
        model.addAttribute("books", bookingRepository.findAll());
        bookingRepository.deleteById(bookId);
        return "redirect:/reservation";
    }
}

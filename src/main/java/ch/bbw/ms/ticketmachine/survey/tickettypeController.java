package ch.bbw.ms.ticketmachine.survey;

import ch.bbw.ms.ticketmachine.survey.model.Newsletter;
import ch.bbw.ms.ticketmachine.survey.model.Ticket;
import ch.bbw.ms.ticketmachine.survey.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Objects;


@Controller
public class tickettypeController {

    @Autowired
    Ticket myTicket;

    @Autowired
    User myUser;

    @Autowired
    Newsletter myNewsletter;

    @GetMapping("/tickettypeform")
    public String tickettypeform(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("tickettypes", myTicket.getTicketTypes());
        return "tickettypeform";
    }

    @PostMapping("/tickettypeform")
    public String saveTicketType(@Valid @ModelAttribute Ticket ticket, BindingResult bindingResult) {
        myTicket = ticket;
        if(Objects.equals(myTicket.getTicketType(), "Einzelfahrt")){
            return "redirect:/ticketroute-Einzelfahrt";
        }else if(Objects.equals(myTicket.getTicketType(), "HinUndZurueck")){
            return "redirect:/ticketroute-HinUndZurueck";
        }else if(Objects.equals(myTicket.getTicketType(), "ZonenTicket")){
            return "redirect:/ticketroute-Zonen";
        }else{
            return "redirect:/ticketroute-GA";
        }
    }


    //Ticket route Mappings

    //Get and Post for Einzelfahrt Ticket
    @GetMapping("/ticketroute-Einzelfahrt")
    public String ticketRouteEiform(Model model){
        model.addAttribute("ticket", myTicket);
        return "ticketroute_Einzelfahrt";
    }

    @PostMapping("/ticketroute-Einzelfahrt")
    public String saveTicketRouteEi(@Valid @ModelAttribute Ticket ticket, BindingResult bindingResult) {
        ticket.setTicketType(myTicket.getTicketType());
        myTicket = ticket;
        System.out.println(myTicket);
        return "redirect:/ticket-options";
    }

    //Get and Post for HinUndZurueck Ticket
    @GetMapping("/ticketroute-HinUndZurueck")
    public String ticketRouteHiform(Model model){
        model.addAttribute("ticket", myTicket);
        return "ticketroute_HinUndZurueck";
    }

    @PostMapping("/ticketroute-HinUndZurueck")
    public String saveTicketRouteHi(@ModelAttribute Ticket ticket) {
        ticket.setTicketType(myTicket.getTicketType());
        myTicket = ticket;
        System.out.println(myTicket);
        return "redirect:/ticket-options";
    }


    //Get and Post for Zonen Ticket
    @GetMapping("/ticketroute-Zonen")
    public String ticketRouteZoform(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("zonenOptions", myTicket.getZonenOptions());
        return "ticketroute_Zonen";
    }

    @PostMapping("/ticketroute-Zonen")
    public String saveTicketRouteZo(@ModelAttribute Ticket ticket) {
        ticket.setTicketType(myTicket.getTicketType());
        myTicket = ticket;
        System.out.println(myTicket);
        return "redirect:/ticket-options";
    }

    //Get and Post for GA Ticket
    @GetMapping("/ticketroute-GA")
    public String ticketRouteGaform(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("gaoptions", myTicket.getGAOptions());
        return "ticketroute_GA";
    }

    @PostMapping("/ticketroute-GA")
    public String saveTicketRouteGa(@ModelAttribute Ticket ticket) {
        ticket.setTicketType(myTicket.getTicketType());
        myTicket = ticket;
        return "redirect:/ticket-options";
    }

    //Mapping for Ticket Options
    @GetMapping("/ticket-options")
    public String ticketOptionsForm(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("klassenOptions", myTicket.getKlassenOptions());
        return "ticketoptions";
    }

    @PostMapping("/ticket-options")
    public String saveTicketOptions(@ModelAttribute Ticket ticket) {
        ticket.setTicketType(myTicket.getTicketType());
        ticket.setGAOption(myTicket.getGAOption());
        ticket.setStartStation(myTicket.getStartStation());
        ticket.setEndStation(myTicket.getEndStation());
        ticket.setZonen(myTicket.getZonen());
        myTicket = ticket;
        return "redirect:/ticket-user";
    }

    //Mapping for Ticket User
    @GetMapping("/ticket-user")
    public String ticketUserForm(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("user", myUser);
        return "ticketuser";
    }
    @PostMapping("/ticket-user")
    public String saveTicketUser(@ModelAttribute Ticket ticket, @ModelAttribute User user) {
        ticket.setTicketType(myTicket.getTicketType());
        ticket.setGAOption(myTicket.getGAOption());
        ticket.setStartStation(myTicket.getStartStation());
        ticket.setEndStation(myTicket.getEndStation());
        ticket.setZonen(myTicket.getZonen());
        ticket.setKlasse(myTicket.getKlasse());
        ticket.setDate(myTicket.getDate());
        ticket.setTime(myTicket.getTime());
        ticket.setTimeSpan(myTicket.getTimeSpan());
        myTicket = ticket;
        myUser = user;
        return "redirect:/ticket-newsletter";
    }

    //Mapping for User Newsletter
    @GetMapping("/ticket-newsletter")
    public String ticketNewsletterForm(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("user", myUser);
        model.addAttribute("newsletter", myNewsletter);
        model.addAttribute("newsletterTypes", myNewsletter.getNewsletterTypes());
        model.addAttribute("newsletterIntervals", myNewsletter.getNewsletterIntervals());
        model.addAttribute("newsletterForms", myNewsletter.getNewsletterForms());
        return "ticketnewsletter";
    }

    @PostMapping("/ticket-newsletter")
    public String saveTicketNewsletter(@ModelAttribute Ticket ticket, @ModelAttribute User user, @ModelAttribute Newsletter newsletter) {
        ticket.setTicketType(myTicket.getTicketType());
        ticket.setGAOption(myTicket.getGAOption());
        ticket.setStartStation(myTicket.getStartStation());
        ticket.setEndStation(myTicket.getEndStation());
        ticket.setZonen(myTicket.getZonen());
        ticket.setKlasse(myTicket.getKlasse());
        ticket.setDate(myTicket.getDate());
        ticket.setTime(myTicket.getTime());
        ticket.setTimeSpan(myTicket.getTimeSpan());
        user.setFirstname(myUser.getFirstname());
        user.setLastname(myUser.getLastname());
        myTicket = ticket;
        myUser = user;
        myNewsletter = newsletter;
        System.out.println(myTicket);
        System.out.println(myUser);
        System.out.println(myNewsletter);
        return "redirect:/ticket-overview";
    }

    //Mapping for Overview
    @GetMapping("/ticket-overview")
    public String ticketOverview(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("user", myUser);
        model.addAttribute("newsletter", myNewsletter);
        return "ticketoverview";
    }





}

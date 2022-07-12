package ch.bbw.ms.ticketmachine.survey;

import ch.bbw.ms.ticketmachine.survey.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;


@Controller
public class tickettypeController {

    @Autowired
    Ticket myTicket;

    @GetMapping("/tickettypeform")
    public String tickettypeform(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("tickettypes", myTicket.getTicketTypes());
        return "tickettypeform";
    }

    @PostMapping("/tickettypeform")
    public String saveTicketType(@ModelAttribute Ticket ticket) {
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
    public String saveTicketRouteEi(@ModelAttribute Ticket ticket) {
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
        System.out.println(myTicket);
        return "redirect:/ticket-user";
    }

    //Mapping for Ticket User
    @GetMapping("/ticket-user")
    public String ticketUserForm(Model model){
        model.addAttribute("ticket", myTicket);
        return "ticketuser";
    }



}

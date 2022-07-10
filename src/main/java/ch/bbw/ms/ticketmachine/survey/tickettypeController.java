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

    @GetMapping("/ticketroute-Einzelfahrt")
    public String ticketRouteEiform(Model model){
        model.addAttribute("ticket", myTicket);
        return "ticketroute_Einzelfahrt";
    }

    @GetMapping("/ticketroute-HinUndZurueck")
    public String ticketRouteHiform(Model model){
        model.addAttribute("ticket", myTicket);
        return "ticketroute_HinUndZurueck";
    }

    @GetMapping("/ticketroute-Zonen")
    public String ticketRouteZoform(Model model){
        model.addAttribute("ticket", myTicket);
        return "ticketroute_Zonen";
    }
    @GetMapping("/ticketroute-GA")
    public String ticketRouteGaform(Model model){
        model.addAttribute("ticket", myTicket);
        model.addAttribute("gaoptions", myTicket.getGAOptions());
        return "ticketroute_GA";
    }

    @PostMapping("/ticketroute-GA")
    public String saveTicketRouteGa(@ModelAttribute Ticket ticket) {
        myTicket = ticket;
        System.out.println(myTicket);
        return "redirect:/index.html";

    }

}

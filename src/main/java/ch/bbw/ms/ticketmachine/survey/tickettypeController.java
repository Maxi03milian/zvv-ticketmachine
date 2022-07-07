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

}

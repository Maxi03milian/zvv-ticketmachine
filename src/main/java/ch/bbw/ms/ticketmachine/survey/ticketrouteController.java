package ch.bbw.ms.ticketmachine.survey;

import ch.bbw.ms.ticketmachine.survey.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;


@Controller
public class ticketrouteController {

    @Autowired
    Ticket myTicket;

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
        return "ticketroute_GA";
    }

}

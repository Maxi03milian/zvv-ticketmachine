package ch.bbw.ms.ticketmachine.survey;

import ch.bbw.ms.ticketmachine.survey.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ticketoptionsController {

    @Autowired
    Ticket myTicket;

    @GetMapping("/ticketoptions")
    public String ticketOptionsform(Model model){
        model.addAttribute("ticket", myTicket);
        return "ticketoptions";
    }

}

package ch.bbw.ms.ticketmachine.survey;

import ch.bbw.ms.ticketmachine.survey.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class tickettypeController {

    @Autowired
    private Ticket myTicket;

    @GetMapping("/tickettypeform")
    public String tickettypeform(Model model){
        model.addAttribute("ticket", myTicket);
        return "tickettypeform.html";
    }
}

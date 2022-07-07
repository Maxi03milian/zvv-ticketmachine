package ch.bbw.ms.ticketmachine.survey;

import ch.bbw.ms.ticketmachine.survey.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class tickettypeController {

    @Autowired
    private Ticket myTicket;

    @GetMapping("/tickettypeform")
    public String tickettypeform(Model model){
        model.addAttribute("ticket", myTicket);
        return "tickettypeform";
    }

    @PostMapping("/tickettypeform")
    public String saveActivity(@ModelAttribute Ticket ticket) {
        myTicket = ticket;
        System.out.println(ticket);
        return "redirect:/index.html";
    }
}

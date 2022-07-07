package ch.bbw.ms.ticketmachine.survey.model;

import org.springframework.stereotype.Component;

@Component
public class Ticket {
    private String ticketType;

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

}

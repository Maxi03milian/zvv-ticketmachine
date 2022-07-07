package ch.bbw.ms.ticketmachine.survey.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Ticket {
    private List<String> ticketTypes = new ArrayList<>(Arrays.asList(
            "Einzelfahrt",
            "HinUndZürück",
            "ZonenTicket",
            "GA"
    ));
    private String ticketType;

    public List<String> getTicketTypes() {
        return ticketTypes;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "Ticket [ticketType=" + ticketType + "]";
    }

}

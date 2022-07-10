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
            "HinUndZurueck",
            "ZonenTicket",
            "GA"
    ));
    private List<String> GAOptions = new ArrayList<>(Arrays.asList(
            "Normal",
            "Teenager",
            "Child",
            "Senior"
    ));
    private String ticketType;
    private String ticketRoute;

    public List<String> getTicketTypes() {
        return ticketTypes;
    }
    public List<String> getGAOptions() {return GAOptions;}

    public String getTicketType() {
        return ticketType;
    }

    public String getTicketRoute() {
        return ticketRoute;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public void setTicketRoute(String ticketRoute) {
        this.ticketRoute = ticketRoute;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                ", ticketType='" + ticketType + '\'' +
                ", ticketRoute='" + ticketRoute + '\'' +
                '}';
    }

}

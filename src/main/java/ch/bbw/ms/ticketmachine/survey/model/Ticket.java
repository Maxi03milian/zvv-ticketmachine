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
    private String GAOption;
    private String startStation;
    private String endStation;


    //Get Lists
    public List<String> getTicketTypes() {
        return ticketTypes;
    }
    public List<String> getGAOptions() {return GAOptions;}

    //Get Properties
    public String getTicketType() {
        return ticketType;
    }
    public String getGAOption() {return GAOption;}
    public String getStartStation() {return startStation;}
    public String getEndStation() {return endStation;}

    //Set Properties
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public void setGAOption(String GAOption) {this.GAOption = GAOption;}
    public void setStartStation(String startStation) {this.startStation = startStation;}
    public void setEndStation(String endStation) {this.endStation = endStation;}


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketType='" + ticketType + '\'' +
                ", GAOption='" + GAOption + '\'' +
                ", startStation='" + startStation + '\'' +
                ", endStation='" + endStation + '\'' +
                '}';
    }

}

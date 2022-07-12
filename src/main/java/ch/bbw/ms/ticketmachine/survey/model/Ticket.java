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
    private List<String> zonenOptions = new ArrayList<>(Arrays.asList(
            "110",
            "120",
            "121",
            "130",
            "131",
            "240",
            "241"
    ));
    private List<String> klassenOptions = new ArrayList<>(Arrays.asList(
            "1. Klasse",
            "2. Klasse"
    ));

    private String ticketType;
    private String GAOption;
    private String startStation;
    private String endStation;
    private String zonen;
    private String klasse;


    //Get Lists
    public List<String> getTicketTypes() {
        return ticketTypes;
    }
    public List<String> getGAOptions() {return GAOptions;}
    public List<String> getZonenOptions() {return zonenOptions;}
    public List<String> getKlassenOptions() {return klassenOptions;}

    //Get Properties
    public String getTicketType() {
        return ticketType;
    }
    public String getGAOption() {return GAOption;}
    public String getStartStation() {return startStation;}
    public String getEndStation() {return endStation;}
    public String getZonen() {return zonen;}
    public String getKlasse() {return klasse;}

    //Set Properties
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public void setGAOption(String GAOption) {this.GAOption = GAOption;}
    public void setStartStation(String startStation) {this.startStation = startStation;}
    public void setEndStation(String endStation) {this.endStation = endStation;}
    public void setZonen(String zonen) {this.zonen = zonen;}
    public void setKlasse(String klasse) {this.klasse = klasse;}


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketType='" + ticketType + '\'' +
                ", GAOption='" + GAOption + '\'' +
                ", startStation='" + startStation + '\'' +
                ", endStation='" + endStation + '\'' +
                ", zonen='" + zonen + '\'' +
                ", klassen='" + klasse + '\'' +
                '}';
    }

}

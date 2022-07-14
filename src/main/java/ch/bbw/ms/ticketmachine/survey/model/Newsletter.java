package ch.bbw.ms.ticketmachine.survey.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Newsletter {

    private List<String> newsletterTypes = new ArrayList<>(Arrays.asList(
            "Travel Tips",
            "Discounts",
            "Events",
            "Erlebnis fahrten"
    ));
    private List<String> newsletterIntervals = new ArrayList<>(Arrays.asList(
            "Wöchentlich",
            "Monatlich",
            "Alle 3 Monate",
            "Täglich"
    ));
    private List<String> newsletterForms = new ArrayList<>(Arrays.asList(
            "Post",
            "E-mail",
            "Fax"
    ));

    private String type;
    private String interval;
    private String form;

    public List<String> getNewsletterTypes() {
        return newsletterTypes;
    }

    public List<String> getNewsletterIntervals() {
        return newsletterIntervals;
    }

    public List<String> getNewsletterForms() {
        return newsletterForms;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Newsletter{" +
                ", type='" + type + '\'' +
                ", interval='" + interval + '\'' +
                ", form='" + form + '\'' +
                '}';
    }
}

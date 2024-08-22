package org.factzoopia.sonarEvents.models.enums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="emails")
public class Email {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "receiver")
    private String receiver;

    @Column (name = "info")
     private String info;

    public Email(String receiver, String info) {
        this.receiver = receiver;
        this.info = info;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    
}

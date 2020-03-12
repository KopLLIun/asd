package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ClientInformation")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientInformation {
    @XmlElement(name = "CashCard")
    private List<CashCard> cashCards;

    public void setCashCards ( List<CashCard> cashCards ) {
        this.cashCards = cashCards;
    }

    public List<CashCard> getCashCards () {
        return cashCards;
    }

    public String toString () {
        StringBuilder res = new StringBuilder();
        for ( CashCard cashCard : cashCards ) {
            res.append(cashCard.toString());
            res.append('\n');
        }
        return res.toString();
    }
}

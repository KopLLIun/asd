package com.company;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class Storage {

    public ClientInformation getClientInfo() {
        return (ClientInformation) ParserXML.getObject ( new File ( "src/main/resources/CashCard.xml" ), ClientInformation.class );
    }

    public CashCard getCashCardById(List<CashCard> cardList, String id) {
        for (CashCard cashCard : cardList) {
            if (cashCard.getId().equals(id)) {
                return cashCard;
            }
        }
        return null;
    }

}

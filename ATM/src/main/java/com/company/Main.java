package com.company;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException {
//        String path = args[0];
//        ClientInformation client = (ClientInformation) ParserXML.getObject ( new File ( "src/main/resources/CashCard.xml" ), ClientInformation.class );
//        System.out.println ( client );
/*        UserInterface userInterface = new UserInterface();
        userInterface.startProgram();*/
        String s = DialogTypes.values()[0].toString();
        System.out.println(s);
    }
}


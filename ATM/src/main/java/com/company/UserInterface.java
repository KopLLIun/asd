package com.company;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static com.company.Service.*;

public class UserInterface {

    private final Service service = new Service();
    private static int amountOfAttempts = 3;


    public void startProgram() throws IOException, JAXBException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<CashCard> cardList = service.getCardList();

        boolean exit = false;
        do {
            System.out.println("Input your credentials(id):");
            String id = reader.readLine();
            if (service.isValidId(cardList, id)) {
                CashCard cashCard = service.getCardById(cardList, id);
                while (amountOfAttempts > 0) {
                    System.out.println("Input your credentials(password):");
                    String password = reader.readLine();
                    if (service.isValidPassword(cashCard, password, amountOfAttempts)) {
                        System.out.println("1.Display the balance;\n" + "2.Take some money;\n" + "3.Add money;");
                        int choice = Integer.parseInt(reader.readLine());
                        switch (choice) {
                            case 1:
//                        System.out.println("Input password");
//                        String password = reader.readLine();
                                service.getBalanceFromCashCard(cashCard);
                                break;
                            case 2:
                                System.out.println("Add the bank note:");
                                int moneyDenomenation = Integer.parseInt(reader.readLine());
                                service.addMoneyToCashCard(cashCard, moneyDenomenation);
                                ParserXML.saveObject(new File("src/main/resources/CashCard.xml"), cashCard);
                                System.out.println("-----");
                                break;
                            case 3:
                                //add
                                System.out.println("--------");
                                break;
                            case 4:
                                exit = true;
                                System.out.println("Exit");
                                break;
                            default:
                                System.out.println("There is no such variant");
                                break;
                        }
                    } else {
                        amountOfAttempts--;
                        System.out.println("You have input incorrect password " + " Amount of attempts:" + amountOfAttempts);
                    }
                }
                if (amountOfAttempts == 0) {
                    System.out.println("Ur card is blocked");
                    return;
                }
            }
        } while (!exit);
    }
}

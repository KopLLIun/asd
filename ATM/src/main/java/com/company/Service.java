package com.company;

import javax.xml.bind.JAXBException;
import java.util.List;

public class Service {
    private Storage storage = new Storage();

    public List<CashCard> getCardList() {
        return storage.getClientInfo().getCashCards();
    }

    public CashCard getCardById(List<CashCard> cardList, String id) throws JAXBException {
        return storage.getCashCardById(cardList, id);
    }

    public boolean isValidId(List<CashCard> cashList, String id) throws JAXBException {
        for (CashCard cashCard : cashList) {
            if (cashCard.getId().equals(id)) {
                return true;
            }
        }
        System.out.println("Incorrect id");
        return false;
    }

    public boolean isValidPassword(CashCard cashCard, String password, int amountOfAttempts) {
        return password.equals(cashCard.getPassword());
    }

    public void getBalanceFromCashCard(CashCard cashCard) throws JAXBException {
        System.out.println(cashCard.getBalance());
    }

    public boolean addMoneyToCashCard(CashCard cashCard, int moneyDenomination) throws JAXBException {
        if (moneyDenomination % 10 == 0 && moneyDenomination % 100 != 10 && moneyDenomination % 100 != 30
                || moneyDenomination % 100 != 80) {
            cashCard.setBalance(cashCard.getBalance() + moneyDenomination);
            return true;
        } else {
            return false;
        }
    }


}

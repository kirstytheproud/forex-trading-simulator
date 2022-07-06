package com.company;

public class User {
    private String fullName;
    private int availableFunds;
    private int balance;


    public User(String fullName, int availableFunds, int balance) {
        this.fullName = fullName;
        this.availableFunds = availableFunds;
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAvailableFunds() {
        return availableFunds;
    }

    public double setAvailableFunds(double availableFunds) {
        this.availableFunds = (int) availableFunds;
        return availableFunds;
    }

    public int getBalance() {
        return balance;
    }

    public double setBalance(double balance) {
        this.balance = (int) balance;
        return balance;
    }
    
    public String checkCurrentPrice(Price price){
        String currentPrice = price.commission(price.getId(), price.getBidPrice(), price.getAskPrice(), price.getTime());
        return currentPrice;
    }

    public String buy(Price price, int amountToBuy) {
        double buy = price.getBidPrice() * amountToBuy;
        double newBuyRounded= (double)Math.round(buy*10000)/10000;
        double newBalance = setBalance(getBalance() + newBuyRounded);
        double newBalanceRounded= (double)Math.round(newBalance*10000)/10000;

        if (getAvailableFunds() > newBuyRounded) {
            double newAvailableFunds = setAvailableFunds(getAvailableFunds() - newBuyRounded);
            return "You paid " + newBuyRounded + " for " + price.getInstrumentName() + ". Your new currency balance is " + newBalanceRounded + " and available funds is " + newAvailableFunds ;
        }
        return "You have insufficient funds for this purchase. Your funds are " + getAvailableFunds();
    }

    public String sell(Price price, int amountToSell){
        double sell = price.getAskPrice() * amountToSell;
        double newSellRounded= (double)Math.round(sell*10000)/10000;

        if((getBalance() - newSellRounded) > 0) {
            double newBalance = setBalance(getBalance() - newSellRounded);
            double newBalanceRounded= (double)Math.round(newBalance*10000)/10000;

            return "You sold " + price.getInstrumentName() + " for " + newSellRounded + ". Your new currency balance is " + newBalanceRounded + " and available funds is " + (getAvailableFunds() + newSellRounded);
        }
        return "You have insufficient currency for this trade";
    }
}

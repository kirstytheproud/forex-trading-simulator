package com.company;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Price eurToUsd = new Price(106, "EUR/USD", 1.1000, 1.2000);
        Price eurToJpy = new Price(107, "EUR/JPY", 119.60, 119.90);
        Price gbpToUsd = new Price(108, "GBP/USD", 1.2500, 1.2560);

        // Automated FX Market Price Feed
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//              System.out.println(eurToUsd.commission(eurToUsd.getId(),eurToUsd.getBidPrice(), eurToUsd.getAskPrice(), eurToUsd.getTime()));
//              System.out.println(eurToJpy.commission(eurToJpy.getId(),eurToJpy.getBidPrice(), eurToJpy.getAskPrice(), eurToJpy.getTime()));
//              System.out.println(gbpToUsd.commission(gbpToUsd.getId(), gbpToUsd.getBidPrice(), gbpToUsd.getAskPrice(), gbpToUsd.getTime()));
                eurToUsd.commission(eurToUsd.getId(),eurToUsd.getBidPrice(), eurToUsd.getAskPrice(), eurToUsd.getTime());
                eurToJpy.commission(eurToJpy.getId(),eurToJpy.getBidPrice(), eurToJpy.getAskPrice(), eurToJpy.getTime());
                gbpToUsd.commission(gbpToUsd.getId(),gbpToUsd.getBidPrice(), gbpToUsd.getAskPrice(), gbpToUsd.getTime());
            }
        }, 1, 5000);//wait 0 ms before doing the action and do it every 5000ms (5seconds)

        // User Interaction
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi there. To start trading, please enter your full name");
        String inputfullName = scanner.nextLine();
        User user = new User(inputfullName, 0, 0);

        System.out.println("Welcome " + inputfullName + ". Would you like to add money to your account? y/n");
        String inputAnswer = scanner.nextLine();

        switch (inputAnswer) {
            case "y":
                System.out.println("How much would you like to add?");
                int inputAmount = scanner.nextInt();
                user.setAvailableFunds(inputAmount);
                System.out.println("You have " + user.getAvailableFunds() + " in available funds");
                break;
            case "n":
                System.out.println("Lets view some prices");
                break;
        }

        boolean operation = true;

        System.out.println("Welcome " + inputfullName + ". To view some prices: ");
        do {
            System.out.println("Please select from the following options:");
            System.out.println("1. EUR/USD, 2. GBP/USD, 3. EUR/JPY, 4. Check Balance/Funds, 5. Exit");

            int inputNumber = scanner.nextInt();

            switch (inputNumber) {
                case 1:
                    System.out.println(user.checkCurrentPrice(eurToUsd));
                    System.out.println("1. Buy, 2. Sell, 3. View Other Prices");
                    int inputNumberAction = scanner.nextInt();
                    switch(inputNumberAction) {
                        case 1:
                            System.out.println("How much would you like to buy?");
                            int inputBuyAmount = scanner.nextInt();
                            System.out.println(user.buy(eurToUsd, inputBuyAmount));
                            break;
                        case 2:
                            System.out.println("How much would you like to sell?");
                            int inputSellAmount = scanner.nextInt();
                            System.out.println(user.sell(eurToUsd, inputSellAmount));
                            break;
                        case 3:
                            break;
                    }
                   break;
                case 2:
                    System.out.println(user.checkCurrentPrice(gbpToUsd));
                    System.out.println("1. Buy, 2. Sell, 3. View Other Prices");
                    int inputNumberAction2 = scanner.nextInt();
                    switch(inputNumberAction2) {
                        case 1:
                            System.out.println("How much would you like to buy?");
                            int inputBuyAmount = scanner.nextInt();
                            System.out.println(user.buy(gbpToUsd, inputBuyAmount));
                            break;
                        case 2:
                            System.out.println("How much would you like to sell?");
                            int inputSellAmount = scanner.nextInt();
                            System.out.println(user.sell(gbpToUsd, inputSellAmount));
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 3:
                    System.out.println(user.checkCurrentPrice(eurToJpy));
                    System.out.println("1. Buy, 2. Sell, 3. View Other Prices");
                    int inputNumberAction3 = scanner.nextInt();
                    switch(inputNumberAction3) {
                        case 1:
                            System.out.println("How much would you like to buy?");
                            int inputBuyAmount = scanner.nextInt();
                            System.out.println(user.buy(eurToJpy, inputBuyAmount));
                            break;
                        case 2:
                            System.out.println("How much would you like to sell?");
                            int inputSellAmount = scanner.nextInt();
                            System.out.println(user.sell(eurToJpy, inputSellAmount));
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1. View Currency Balance, 2. View Available Funds");
                    int inputNumberAction4 = scanner.nextInt();
                    switch(inputNumberAction4) {
                        case 1:
                            System.out.println("Your current balance is : " + user.getBalance());
                            break;
                        case 2:
                            System.out.println("Your available funds are : " + user.getAvailableFunds());
                            System.out.println("1. Add More Funds, 2. Return");
                            int inputFundAction = scanner.nextInt();
                            switch (inputFundAction) {
                                case 1:
                                    System.out.println("Please enter amount you would like to add to your funds");
                                    int inputFundAmount = scanner.nextInt();
                                    double addFunds = user.setAvailableFunds(user.getAvailableFunds()+inputFundAmount);
                                    System.out.println("Your available funds: " + addFunds);
                                    break;
                                case 2:
                                    break;
                            }
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using our services. Have a pleasant day.");
                    return;
            }
         }while(operation = true);
    }
}

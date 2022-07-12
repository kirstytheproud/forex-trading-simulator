# Forex Trading Simulator

# Overview
Buy and trade currencies with an automated, updated FX Market Price feed. The Price feed was created using a Price class, with price adjustments added to each currency instrument, -0.1% for bid price, +0.1% for ask price. The price feed was designed with currently only 3 instruments, EUR/USD, EUR/JPY and GBP/USD. The price feed continuously adjusts and runs these prices, with an update timestamp. It will run as follows in the background, so that the console can be used for user interaction.
<br>
<br>
![fx market feed](https://user-images.githubusercontent.com/37534696/178403598-2a99a781-bbc8-4b86-8214-84bfda4a010a.gif)
<br>
<br>
In order to allow a "buy" and "sell" interaction, I have created a User class which utilises methods for these actions. I have used the term "Balance" or "Currency Balance" to signify the amount of currency that has currently been purchased, and "Funds" or "Available funds" as the amount the user has that can be used to purchase more currency. Currently, for simplicity, the balance and funds are just floating numbers, during buying and selling, there is currently no other conversion from the users funds into any currencies. This would definitely be the next step in improving this application to make it more realistic. All numbers have been adjusted to be rounded up to 4 decimal places. 
<br>
<br>
Using as series of multiple nested switch statements, a user interaction in the console has been designed in order to allow the user to add funds to their account and buy and sell currencies. The user first adds their name in order to create an instance of the User object, and can add an amount to their funds.
<br><br>![created user 1](https://user-images.githubusercontent.com/37534696/178405918-fd2014a1-7fe1-473e-84ba-491c03973409.gif)

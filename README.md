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
<br>
The user can then choose from 5 options, to pick one of the three instruments, to check their balance or funds, or to exit and terminate the application. 
<br>
If the user chooses one of the three instruments, they are presented with the current prices at the most current price stamp, and the options to either buy and sell the currency, or to go back and choose another. If Buy is selected, the user can specify what amount of their funds they would like to allocate to the purchase, and will receive an update about the amounts in their accounts after the purchase.
<br><br>
![se,e](https://user-images.githubusercontent.com/37534696/178406163-ab299a1d-d06d-43c5-9732-796086fb214b.gif)
<br><br>
The user can continuously buy and sell currencies so long as they have the available funds and balance needed. The app has been designed to also handle situtations in which the user may have insufficient amounts for their chosen transaction.<br><br>
![insufficient amounts](https://user-images.githubusercontent.com/37534696/178407252-beae3fce-1c35-4093-ab02-8562dbad42b4.gif)

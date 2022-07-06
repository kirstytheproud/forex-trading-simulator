package com.company;

import java.sql.Timestamp;
import java.util.Date;

public class Price {
    public int id;
    private String instrumentName;
    private double bidPrice;
    private double askPrice;
    private Timestamp timestamp;

    public Price() {this.timestamp = new Timestamp(new Date().getTime());
    }


    public Price(int id, String instrumentName, double bidPrice, double askPrice) {
        this.id = id;
        this.instrumentName = instrumentName;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.timestamp = this.timestamp = new Timestamp(new Date().getTime());
    }



    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
        return instrumentName;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public double setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
        return bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public double setAskPrice(double askPrice) {
        this.askPrice = askPrice;
        return askPrice;
    }


    public Timestamp getTime() {
        return timestamp = new Timestamp(new Date().getTime());
    }


    public String commission(int id, double bidPrice, double askPrice, Timestamp timestamp){
        double newBid = setBidPrice(bidPrice - (0.001* bidPrice));
        double bidCommission = (double)Math.round((newBid - (0.01/100 * newBid))*10000)/10000;
        double newAsk = setAskPrice(askPrice + (0.001* askPrice));
        double askCommission = (double)Math.round((newAsk + (0.01/100 * newAsk))*10000)/10000;
        int newId = setId(id + 3);

        return newId + "," + instrumentName + "," + String.valueOf(bidCommission+ "," + askCommission) + "," +timestamp;
    }

}

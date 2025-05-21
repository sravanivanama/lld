package service;

import enums.PaymentSource;
import exception.InvalidAmountException;
import model.Account;
import model.Wallet;
import payments.PaymentProcessor;
import payments.PaymentSourceStratgey;

public class WalletManager {
    Wallet wallet;
    public WalletManager(Wallet w){
        this.wallet = w;
    }
    public boolean loadMoney(PaymentSource src, double amount) throws Exception {
        if(amount <=0){
            throw new InvalidAmountException("Amount to be loaded should be > 0");
        }
        try {
            PaymentSourceStratgey stratgey = new PaymentSourceStratgey(src);
            PaymentProcessor paymentProcessor = stratgey.processor();
            paymentProcessor.processPayment();
            double currBalance = wallet.getBalance();
            wallet.setBalance(currBalance + amount);
            return true;
        } catch (Exception e){
            throw e;
        }
    }

    public void sendMoney(Account toAccount, double moneyToSend, PaymentSource src) throws Exception{
        if(moneyToSend <=0){
            throw new InvalidAmountException("Amount to be send should be > 0");
        }
        double currBalance = wallet.getBalance();
        if(currBalance - moneyToSend < 0 ){
            throw new InvalidAmountException("Insufficient Balance!!!");
        }
        PaymentSourceStratgey stratgey = new PaymentSourceStratgey(src);
        PaymentProcessor paymentProcessor = stratgey.processor();
        paymentProcessor.processPayment();
        wallet.setBalance(currBalance - moneyToSend);

    }
}

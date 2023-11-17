package br.com.suutz.entity;

public class FixedIncomeClient {
    
    private int id;
    private int user_id;
    private int fixed_income_id;
    private double amount;
    private double yield;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getFixedIncomeId() {
        return this.fixed_income_id;
    }

    public void setFixedIncomeId(int fixed_income_id) {
        this.fixed_income_id = fixed_income_id;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getYield() {
        return this.yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

}

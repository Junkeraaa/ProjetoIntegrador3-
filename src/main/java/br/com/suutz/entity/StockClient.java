package br.com.suutz.entity;

public class StockClient {

    private int id;
    private int user_id;
    private int stock_id;
    private int qtd;

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

    public int getStockId() {
        return this.stock_id;
    }

    public void setStockId(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getQtd() {
        return this.qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }


}

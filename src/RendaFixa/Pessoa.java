import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Pessoa {

    private String nome;
    private double saldo;

    public Pessoa(String nome) {
        this.nome = nome;
        this.saldo = 0.0;
    }

    public void adicionarSaldo(double valor) {
        saldo += valor;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }
}
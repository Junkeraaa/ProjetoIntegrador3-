import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        ArrayList<Investimento> investimentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos investimentos deseja criar? ");
        int numInvestimentos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numInvestimentos; i++) {
            System.out.print("Digite o nome do investimento " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            Investimento investimento = new Investimento(nome);
            investimentos.add(investimento);
        }

        System.out.print("Digite o nome da pessoa: ");
        String nomePessoa = scanner.nextLine();
        Pessoa pessoa = new Pessoa(nomePessoa);

        Timer timer = new Timer();
        final int intervaloEmMilissegundos = 5000; // 5 segundos em milissegundos

        TimerTask tarefa = new TimerTask() {
            public void run() {
                for (Investimento investimento : investimentos) {
                    double taxaAleatoria = Math.random() * 10;
                    investimento.setTaxa(taxaAleatoria);
                    double juros = (investimento.getTaxa() / 100.0) * pessoa.getSaldo();
                    pessoa.adicionarSaldo(juros);
                }

                System.out.println("\nSaldo atual de " + pessoa.getNome() + ": R$" + pessoa.getSaldo());
                System.out.print("Digite 'sair' para encerrar o programa ou pressione Enter para continuar: ");
                String comando = scanner.nextLine();
                if (comando.equalsIgnoreCase("sair")) {
                    timer.cancel(); // Encerra o temporizador
                }
            }
        };

        timer.scheduleAtFixedRate(tarefa, 0, intervaloEmMilissegundos);
    }
}
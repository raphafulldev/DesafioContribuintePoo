package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos contribuintes voce vai digitar? ");
        int n = sc.nextInt();
        List<TaxPayer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados do " + (i + 1) + " contribuinte:");
            System.out.print("Renda anual com salario: ");
            Double rendaAnaul = sc.nextDouble();
            System.out.print("Renda anual com pretacao de servico: ");
            Double servico = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            Double capital = sc.nextDouble();
            System.out.print("Gastos medicos: ");
            Double medico = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            Double educ = sc.nextDouble();
            System.out.println();
            list.add(new TaxPayer(rendaAnaul, servico, capital, medico, educ));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Resumo do " + (i + 1) + " contribuinte:");
            System.out.printf("Imposto bruto total: %.2f\n", list.get(i).grossTax());
            System.out.printf("Abatimento: %.2f\n", list.get(i).grossTax() - list.get(i).netTax());
            System.out.printf("Imposto devido: %.2f\n", list.get(i).netTax());
            System.out.println();
        }


        sc.close();
    }
}

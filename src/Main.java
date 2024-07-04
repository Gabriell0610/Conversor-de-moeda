import com.google.gson.Gson;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha algumas moedas abaixo para conversão");
        System.out.println("Dolar: USD \nEuro: EUR \nReal: BRL \nLibra: GBP \nPeso: MXN \nIene: JPY");
        String sigla = sc.nextLine();

        System.out.println("\nAgora escolha o valor que queira converter");
        double value = sc.nextDouble();

        GetApi conversor = new GetApi();
        Coins response = conversor.dataApi(sigla.toUpperCase());
        System.out.println(response.conversion_rates());

        ConversionRates rates = response.conversion_rates();
        System.out.println("\nConversão");
        System.out.println(String.format("Real:  %.2f",  rates.BRL() * value));
        System.out.println(String.format("Dolar: %.2f", rates.USD() * value));
        System.out.println(String.format("Euro:  %.2f",  rates.EUR() * value));
        System.out.println(String.format("Peso:  %.2f",  rates.MXN() * value));
        System.out.println(String.format("Iene:  %.2f",  rates.JPY() * value));

    }
}
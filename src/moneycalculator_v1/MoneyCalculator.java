
package moneycalculator_v1;

import java.util.Scanner;

/**
 *
 * @author FernandoSanfielReyes
 */
public class MoneyCalculator {
    
    private double amount;
    private double exchangeRate;
    String currency;

    public MoneyCalculator() {
    }
    
    public void control() {
        input();
        process();
        output();
    }

    private static Double getExchangeRate(String from, String to) {
        
        String line = "{'USD_EUR':{'val':0.860155} 'GBP_EUR':{'val':0.860155} 'CHF_EUR':{'val':0.860155}}";
        
        line = "{'".concat(line.substring(line.indexOf(from)));
        String processed_line = line.substring(line.indexOf(to) + 12, line.indexOf("}"));
        return Double.parseDouble(processed_line);
    }
    
    private void input(){
        System.out.println("Introduce una cantidad en dolares: ");
        Scanner scanner = new Scanner(System.in);
        this.amount = Double.parseDouble(scanner.next());
        
        System.out.println("Introduce una divisa: ");
        currency = scanner.next();
        scanner.close();
    }
    
    private void process(){
        this.exchangeRate = getExchangeRate(currency, "EUR");
    }
    
    private void output(){
        System.out.println(amount + ' ' + currency + " equivalen a " + amount + exchangeRate + "EUR");
    }
}

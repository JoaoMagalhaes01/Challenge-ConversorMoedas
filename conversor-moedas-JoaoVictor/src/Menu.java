
import java.util.Scanner;

public class Menu {

    public void exibir(){

        Scanner scanner = new Scanner(System.in);
        ApiClient api = new ApiClient();
        ConversorService conversor = new ConversorService();

        String json = api.buscarDados();

        while(true){

            System.out.println(
            "\n=== Conversor de Moedas ===\n" +
            "1 USD -> BRL\n" +
            "2 BRL -> USD\n" +
            "3 USD -> EUR\n" +
            "4 EUR -> USD\n" +
            "5 USD -> ARS\n" +
            "6 ARS -> USD\n" +
            "0 Sair");

            int opcao = scanner.nextInt();

            if(opcao == 0){
                break;
            }

            System.out.println("Digite o valor:");
            double valor = scanner.nextDouble();

            double resultado = switch(opcao){

                case 1 -> conversor.converter(json,"BRL",valor);
                case 2 -> conversor.converter(json,"USD",valor);
                case 3 -> conversor.converter(json,"EUR",valor);
                case 4 -> conversor.converter(json,"USD",valor);
                case 5 -> conversor.converter(json,"ARS",valor);
                case 6 -> conversor.converter(json,"USD",valor);

                default -> 0;
            };

            System.out.println("Resultado: " + resultado);
        }
    }
}

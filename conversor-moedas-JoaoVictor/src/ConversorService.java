
import com.google.gson.Gson;
import java.util.Map;

public class ConversorService {

    public double converter(String json, String moedaDestino, double valor) {

        Gson gson = new Gson();
        MoedaResponse resposta = gson.fromJson(json, MoedaResponse.class);

        Map<String, Double> taxas = resposta.conversion_rates;

        double taxa = taxas.get(moedaDestino);

        return valor * taxa;
    }
}

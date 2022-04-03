import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        httpBuilder();
    }

    private static void httpBuilder() {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");

        try {
            CloseableHttpResponse response = httpClient.execute(request);
            List<FactsCats> factsCats = mapper.readValue(
                            response.getEntity().getContent(), new TypeReference<>() {}
                    );
            Stream<FactsCats> factsCatsFilter = factsCats.stream()
                    .filter(value -> value.getUpvotes1() != null && value.getUpvotes() > 0);
            System.out.println("Список фактов о кошках:");
            factsCatsFilter.forEach(System.out::println);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

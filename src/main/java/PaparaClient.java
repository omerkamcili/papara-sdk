import com.google.gson.Gson;
import okhttp3.*;
import request.PaymentRequest;
import response.PaymentResponse;

import java.io.IOException;

public class PaparaClient {

    private final static String apiUrlTest = "https://merchantapi-test-master.papara.com";
    private final static String apiUrlLive = "https://merchant-api.papara.com";
    private String apiUrl;
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String apiKey;
    private Gson gson;

    public PaparaClient(String apiKey, Boolean isTest) throws Exception {

        this.apiKey = apiKey;
        this.gson = new Gson();

        if (isTest){
            this.apiUrl = apiUrlTest;
        }else{
            this.apiUrl = apiUrlLive;
        }
    }


    public PaymentResponse payment(PaymentRequest paymentRequest) throws IOException {

        String requestJson = this.gson.toJson(paymentRequest);
        String apiRequest = this.post(this.apiUrl + "/payments", requestJson);
        return this.gson.fromJson(apiRequest, PaymentResponse.class);

    }

    String post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .header("ApiKey", this.apiKey)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}

package response;

import com.google.gson.annotations.SerializedName;

public class PaymentResponse {

    @SerializedName("data")
    PaymentResponseData data;

    @SerializedName("succeeded")
    Boolean succeeded;

    @SerializedName("error")
    PaymentResponseError error;

}

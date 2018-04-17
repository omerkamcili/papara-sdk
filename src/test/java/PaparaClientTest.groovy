import request.PaymentRequest
import response.PaymentResponse
import spock.lang.Specification

class PaparaClientTest extends Specification{

    private PaparaClient client

    void setup(){
        String apikey = "05c3XqaVsi01xIZgfVsFhaTO015g648+oVybTxfScDtSmM9bRBO73KciTW97PYpFCynzYJet6Jn1g3qg+7kTTw=="
        Boolean isTest = true
        client = new PaparaClient(apikey, isTest)
    }

    def "create payment test"(){

        setup:
        def request = new PaymentRequest()
        request.setAmount(10.0)
        request.setReferenceId("ORDER-REFERENCE-ID-123123")
        request.setRedirectUrl("http://www.foo.bar")
        request.setNotificationUrl("http://www.foo.bar")
        request.setOrderDescription("ORDER DESCRIPTION")

        when:
        PaymentResponse response = client.payment(request)

        then:
        response != null


    }

}

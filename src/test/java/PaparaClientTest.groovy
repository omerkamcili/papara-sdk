import request.PaymentRequest
import response.PaymentResponse
import spock.lang.Specification

class PaparaClientTest extends Specification{

    private PaparaClient client

    void setup(){
        String apikey = "4u3748re9w99dsf0ds0gfg9fdh9dfg0hfd*g*ds*g0fdh9fd9hdfgh"
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

    def "check payment test"(){

        setup:
        String paymentId = "e6b601d5-d655-4845-87bd-84ff05cabaf9"

        when:
        PaymentResponse response = client.checkStatus(paymentId)

        then:
        response.succeeded != null


    }

}

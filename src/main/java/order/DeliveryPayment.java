package order;

import org.camunda.bpm.client.ExternalTaskClient;

public class DeliveryPayment
{

    public static void main(String[] args)
    {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();
        System.out.println("Not yet requests");

        // subscribe to an external task topic as specified in the process
        client.subscribe("payment")
                .lockDuration(1000)
                .handler((externalTask, externalTaskService) -> {
                    String address = externalTask.getVariable("address");
                    long zip = externalTask.getVariable("zip");
                    String city = externalTask.getVariable("city");
                    System.out.println("Delivery confirmed. \n\nPayment will now be proccesed. \n\nThe item will be delivered to\n\n" + address + "\n" + zip + " " + city);
                    externalTaskService.complete(externalTask);
                })
                .open();
    }
}
package br.univille;

public class Subscriber {
    public static void main(String[] args) {
        var servidor = "sbdas12025a.servicebus.windows.net";
        var topicName = "topic-das1-a";

        String chave = System.getenv("CHAVE");
        var subscription = "subscription-leonardolatzke";

        ServiceBusProcessorClient processorClient =
            new ServiceBusClientBuilder()
            .fullyQualifiedNamespace(servidor)
            .connectionString(chave)
            .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
            .processor()
            .topicName(tipocName)
            .subscriptionName(subscription)
            .receiveMode(ServiceBusReceiveMode.PEEK_LOCK)
            .processMessage(context -> {
                System.out.println("MSG: "+context .getMessage() .getBody() .toString());
                context.complete();
            })
            .processError(context =>{
                System.out.println("deu ruim")
            })

        .buildProcessorClient();
package io.sriharilabs;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("its going start....");
        Server server= ServerBuilder.forPort(50051).addService(new GreetingServiceImpl()).build();

        server.start();

        System.out.println("server Started....");
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("srihari.......");
            server.shutdown();

            System.out.println("shutdown successfully");
        }));

        server.awaitTermination();
    }
}

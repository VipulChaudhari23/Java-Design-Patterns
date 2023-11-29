package com.maveric.productms;

public class ClientUsage {
    public static void main(String[] args) {
        IOldProductService oldService = new OldProductServiceImpl();
        OldClient oldClient = new OldClient(oldService);
        System.out.println("Old Client - display all products----------");
        oldClient.displayAllProducts();
        System.out.println("\nOld Client - display product by id----------");
        oldClient.displayProductById(1);

        // Creating an instance of the NewClientAdapter to use the new service with the old client
        INewProductService newService = new NewProductServiceImpl();
        IOldProductService newClientAdapter = new NewClientAdapter(newService);

        OldClient newClientUsingOldService = new OldClient(newClientAdapter);
        System.out.println("\nNew Client using Old Service - display all products--------");
        newClientUsingOldService.displayAllProducts();
        System.out.println("\nNew Client using Old Service - display product by id----------");
        newClientUsingOldService.displayProductById(5);

        // New client using the new service directly
        NewClient newClient = new NewClient(newService);
        System.out.println("\nNew Client using New Service - display all products--------");
        newClient.displayAllProducts();
        System.out.println("\nNew Client using New Service - display product by id---------");
        newClient.displayProductById(1);
    }
}

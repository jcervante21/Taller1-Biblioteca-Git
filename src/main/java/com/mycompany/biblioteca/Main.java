package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Menu will go here (Phase 8)
    }

    public static void createCustomer() {
        System.out.println("--- Create Customer ---");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Customer customer = new Customer(id, name, phone, email);
        customers.add(customer);
        System.out.println("Customer created successfully.");
    }

    public static void listCustomers() {
        System.out.println("--- Customer List ---");
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public static Customer searchCustomer(String id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static void updateCustomer() {
        System.out.println("--- Update Customer ---");
        System.out.print("Enter the ID of the customer to update: ");
        String id = sc.nextLine();

        Customer customer = searchCustomer(id);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("New name (current: " + customer.getName() + "): ");
        String name = sc.nextLine();
        System.out.print("New phone (current: " + customer.getPhone() + "): ");
        String phone = sc.nextLine();
        System.out.print("New email (current: " + customer.getEmail() + "): ");
        String email = sc.nextLine();

        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
        System.out.println("Customer updated successfully.");
    }

    public static void deleteCustomer() {
        System.out.println("--- Delete Customer ---");
        System.out.print("Enter the ID of the customer to delete: ");
        String id = sc.nextLine();

        Customer customer = searchCustomer(id);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        customers.remove(customer);
        System.out.println("Customer deleted successfully.");
    }
}
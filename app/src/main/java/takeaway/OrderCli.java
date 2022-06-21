package takeaway;

import java.util.*;

public class OrderCli {

    // Use primitive `boolean` instead of `Boolean` where
    // possible to avoid null related issues
    private boolean endOfInput = false;

    private OrderBuilder order = new OrderBuilder();

    // Main loop for the CLI, we only want to expose this, nothing else
    public void call() {
        printWelcome();
        printMenu();

        Scanner reader = new Scanner(System.in);
        int input;

        while (!endOfInput) {
            System.out.println("Which item would you like?");
            input = reader.nextInt();

            MenuItem selectedItem = Menu.getMenuItemById(input);

            if (selectedItem == null) {
                System.err.println("Invalid selection, please try again.");
                continue;
            }

            order.addItem(selectedItem);

            System.out.println("Is there anything else you would like?");
            System.out.println("1. Yes (please)");
            System.out.println("2. No");

            input = reader.nextInt();
            switch (input) {
                case 1:
                    continue;
                case 2:
                    endOfInput = true;
                    break;
                default:
                    System.err.println("That was not a valid option.. But I will take it as a yes.");

            }
        }

        reader.close();

        if (order.currentOrder().size() > 0) {
            displayOrder();
            sendConfirm();
        } else {
            System.err.println("You did not choose anything.");
        }
    }

    private void printMenu() {
        List<MenuItem> menu = Menu.getMenu();

        System.out.println("---------");
        System.out.println("Our menu:");

        for (MenuItem item : menu) {
            int price = item.getPrice();
            int id = item.getItemId();
            String itemName = item.getItemName();

            System.out.printf("%d. %s - %d£\n", id, itemName, price);
        }
    }

    private void displayOrder() {
        System.out.println("Here is your current order: ");

        int total = order.summarizeOrderAmount();

        order.currentOrder().forEach(e -> {
            String name = e.getItemName();
            int price = e.getPrice();
            System.out.printf("%s - %d£\n", name, price);
        });

        System.out.printf("Your total is: %d£\n", total);
    }

    private void sendConfirm() {
        System.out.println("Confirmation sent");
        Confirmator confirmator = new Confirmator();
        confirmator.sendMessage();
    }

    private void printWelcome() {
        System.out.println(" _       __________    __________  __  _________");
        System.out.println("| |     / / ____/ /   / ____/ __ \\/  |/  / ____/");
        System.out.println("| | /| / / __/ / /   / /   / / / / /|_/ / __/   ");
        System.out.println("| |/ |/ / /___/ /___/ /___/ /_/ / /  / / /___   ");
        System.out.println("|__/|__/_____/_____/\\____/\\____/_/  /_/_____/   ");
    }
}

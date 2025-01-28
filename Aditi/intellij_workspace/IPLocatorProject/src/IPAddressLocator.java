import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPAddressLocator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println(" * Welcome to IP Address Locator !!");

        do {
            //displaying menu options dynamically  before each Input
            System.out.println("\n========== IP Address Locator ==========");
            System.out.println(" Menu Options -->> ");
            System.out.println(" I -> Find IP address for a given host name....");
            System.out.println(" A -> Find all IP addresses for a given host name.... ");
            System.out.println(" L -> Find the local host Information.... ");
            System.out.println(" E -> Exit :) ");

            //get the user's choice
            choice = scanner.nextLine().toUpperCase();

            switch(choice){
                case "i" , "I" ->{
                    System.out.print("Enter the host name : ");
                    String hostName = scanner.nextLine();
                    findIPAddress(hostName);
                }

                case "a" , "A" ->{
                    System.out.print("Enter the host name : ");
                    String domainName = scanner.nextLine();
                    findAllIPAddresses(domainName);
                }

                case "l" , "L" -> findLocalHostInfo();

                case "e" ,"E" -> System.out.println("Exiting... Thank you for using the IP Address Locator!");
                    default -> System.out.println("Invalid choice! Please try again.");

                }
            } while(!choice.equals("e") && !choice.equals("E") );

        scanner.close();

        }




        //Method to find the IP address to the given host name
        public static void findIPAddress(String hostName){
            try{
                InetAddress inetAddress = InetAddress.getByName(hostName);
                System.out.println("IP Address of " + hostName + " -> " + inetAddress.getHostAddress());
                }
            catch (UnknownHostException e) {

                System.out.println("Error: Unable to resolve hostname. Please check the input.");
            }

        }

        // Method to find all IP addresses for a given Host Name
        public static void findAllIPAddresses(String domainName){
            try {
                /*Using an array to store multiple IP addresses, as a single hostname
                can resolve to more than one IP address*/

                InetAddress[] inetAddresses = InetAddress.getAllByName(domainName);
                System.out.println(" All IP Addresses for " + domainName + ":");
                for (InetAddress inetAddress : inetAddresses) {
                    System.out.println(" - " + inetAddress.getHostAddress());
                }
            }catch(UnknownHostException e){
                    System.out.println("Error: Unable to resolve hostname. Please check the input.");
                }



        }

        // Method to find and display local host information

        private static void findLocalHostInfo(){
            try{
                InetAddress localHost = InetAddress.getLocalHost();
                System.out.println(" IP Address for " + localHost.getHostName() + " is " +  localHost.getHostAddress());
            } catch (UnknownHostException e) {
                System.out.println("Error: Unable to retrieve local host information.");
            }

        }


    }


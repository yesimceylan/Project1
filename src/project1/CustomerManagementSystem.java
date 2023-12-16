package project1;

	import java.util.ArrayList;
	import java.util.Scanner;

	public class CustomerManagementSystem {
	    private static ArrayList<Customer> customers = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        boolean quit = false;
	        while (!quit) {
	            System.out.println("1. Müşteri ekle\n2. Müşteri sil\n3. Müşteri bilgilerini görüntüle\n4. Çıkış");
	            System.out.print("Lütfen bir seçenek girin: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    addCustomer();
	                    break;
	                case 2:
	                    removeCustomer();
	                    break;
	                case 3:
	                    displayCustomerInfo();
	                    break;
	                case 4:
	                    quit = true;
	                    break;
	                default:
	                    System.out.println("Geçersiz seçenek!");
	                    break;
	            }
	        }
	    }

	    private static void addCustomer() {
	        System.out.print("Müşteri adı: ");
	        String firstName = scanner.nextLine();
	        System.out.print("Müşteri soyadı: ");
	        String lastName = scanner.nextLine();
	        System.out.print("Müşteri adresi: ");
	        String address = scanner.nextLine();
	        System.out.print("Müşteri telefon numarası: ");
	        String phoneNumber = scanner.nextLine();

	        Customer customer = new Customer(firstName, lastName, address, phoneNumber);
	        customers.add(customer);
	        System.out.println("Müşteri başarıyla eklendi!");
	    }

	    private static void removeCustomer() {
	        System.out.print("Silmek istediğiniz müşterinin adı: ");
	        String firstName = scanner.nextLine();
	        System.out.print("Silmek istediğiniz müşterinin soyadı: ");
	        String lastName = scanner.nextLine();

	        for (int i = 0; i < customers.size(); i++) {
	            Customer customer = customers.get(i);
	            if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
	                customers.remove(i);
	                System.out.println("Müşteri başarıyla silindi!");
	                return;
	            }
	        }

	        System.out.println("Müşteri bulunamadı!");
	    }

	    private static void displayCustomerInfo() {
	        for (int i = 0; i < customers.size(); i++) {
	            Customer customer = customers.get(i);
	            System.out.println("Müşteri adı: " + customer.getFirstName() + " " + customer.getLastName());
	            System.out.println("Müşteri adresi: " + customer.getAddress());
	            System.out.println("Müşteri telefon numarası: " + customer.getPhoneNumber());
	            System.out.println("Sipariş geçmişi: " + customer.getOrderHistory());
	            System.out.println();
	        }
	    }
	}

	class Customer {
	    private String firstName;
	    private String lastName;
	    private String address;
	    private String phoneNumber;
	    private ArrayList<String> orderHistory = new ArrayList<>();

	    public Customer(String firstName, String lastName, String address, String phoneNumber) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.address = address;
	        this.phoneNumber = phoneNumber;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public ArrayList<String> getOrderHistory() {
	        return orderHistory;
	    }

	    public void addOrder(String order) {
	        orderHistory.add(order);
	    }
	




	}



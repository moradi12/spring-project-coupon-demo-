package Openconnection.example.demo.clr;

/// / rest for customer


//
//            System.out.println("Posting customers to API...");
//            restTemplate.postForEntity("http://localhost:8080/api/customers", customer1, Customer.class);
//            restTemplate.postForEntity("http://localhost:8080/api/customers", customer2, Customer.class);
//            restTemplate.postForEntity("http://localhost:8080/api/customers", customer3, Customer.class);
//            restTemplate.postForEntity("http://localhost:8080/api/customers", customer4, Customer.class);
//
//            System.out.println("Getting all customers from API...");
//            System.out.println(restTemplate.getForObject("http://localhost:8080/api/customers/all", String.class));
//
//            System.out.println("Deleting customer with ID 2 from API...");
//            restTemplate.delete("http://localhost:8080/api/customers/{id}", 2);
//            System.out.println("Getting all customers after deletion from API...");
//            Customer[] customers = restTemplate.getForObject("http://localhost:8080/api/customers/all", Customer[].class);
//            if (customers != null) {
//                Arrays.stream(customers).forEach(System.out::println);
//            }
//
//            System.out.println("Getting customers by first name from API...");
//            Customer[] customersByFirstName = restTemplate.getForObject("http://localhost:8080/api/customers/byFirstName/{firstName}", Customer[].class, "Alice");
//            if (customersByFirstName != null) {
//                Arrays.stream(customersByFirstName).forEach(System.out::println);
//            }
//        } catch (Exception e) {
//            System.out.println("Error occurred: " + e.getMessage());
//        }
//    }
//}
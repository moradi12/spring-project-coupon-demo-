//package Openconnection.example.demo.clr;
//
//public class TEMPALATE {
//
//    // Posting companies to API
////            restTemplate.postForEntity("http://localhost:8080/api/companies", company1, Company.class);
////            restTemplate.postForEntity("http://localhost:8080/api/companies", company2, Company.class);
////            restTemplate.postForEntity("http://localhost:8080/api/companies", company3, Company.class);
////
////            // Getting all companies from API
////            System.out.println(restTemplate.getForObject("http://localhost:8080/api/companies/all", String.class));
////
////            // Deleting a company with ID 2 from API
////            restTemplate.delete("http://localhost:8080/api/companies/{id}", 2);
////            System.out.println("Deleting company with ID 2...");
////
////            // Getting all companies after deletion from API
////            Company[] companies = restTemplate.getForObject("http://localhost:8080/api/companies/all", Company[].class);
////            if (companies != null) {
////                Arrays.stream(companies).forEach(System.out::println);
////            }
////
////            // Getting companies by name from API
////            Company[] companiesByName = restTemplate.getForObject("http://localhost:8080/api/companies/byName/{name}", Company[].class, "Electronics Sale");
////            if (companiesByName != null) {
////                Arrays.stream(companiesByName).forEach(System.out::println);
////            }
//
//}

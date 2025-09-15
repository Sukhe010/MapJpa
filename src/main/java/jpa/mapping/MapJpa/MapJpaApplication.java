package jpa.mapping.MapJpa;

import jpa.mapping.MapJpa.entities.*;
import jpa.mapping.MapJpa.repositories.CategoryRepo;
import jpa.mapping.MapJpa.repositories.ProductRepo;
import jpa.mapping.MapJpa.repositories.StudentRepository;
import jpa.mapping.MapJpa.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j

@SpringBootApplication
public class MapJpaApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private LaptopRepository laptopRepo;

    public static void main(String[] args) {
        SpringApplication.run(MapJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //One to One mapping
       /* // create Student
        Student student = new Student();
        student.setStudentId(786);
        student.setStudentName("Selina");
        student.setAbout("I am BatWoman");

        // create Laptop
        Laptop laptop = new Laptop();
        laptop.setLaptopId(101);
        laptop.setBrand("Dell");
        laptop.setModelNumber("Inspiron 15");

        // set relationship
        laptop.setStudent(student);
        student.setLaptop(laptop);

        // save Student first (because laptop depends on it)
        Student save = studentRepo.save(student);
        log.info("Saved student: {}", save.getStudentName());

        System.out.println("Student and Laptop saved successfully!");*/

        //Retrieving the entry
        /*Student student = studentRepo.findById(786).get();
        log.info("Name: {}", student.getStudentName());

        Laptop laptop = student.getLaptop();
        log.info("Laptop: {} {}", laptop.getBrand(), laptop.getModelNumber());*/

        //One to Many
       /* Student student = new Student();
        student.setStudentId(86);
        student.setStudentName("Penguin");
        student.setAbout("I am the Boss!");

        Address a1 = new Address();
        a1.setAddressId(131);
        a1.setCity("Gotham");
        a1.setCountry("USA");
        a1.setStreet("234/335");
        a1.setStudent(student);

        Address a2 = new Address();
        a2.setAddressId(1031);
        a2.setCity("London");
        a2.setCountry("UK");
        a2.setStreet("2304/1335");
        a2.setStudent(student);

        List<Address> addressList = new ArrayList<>();
        addressList.add(a1);
        addressList.add(a2);

        student.setAddressList(addressList);
        Student save = studentRepo.save(student);
        log.info("Student created : with address");*/

        //Many to many
        /*Product product1 = new Product();
        product1.setPId("pid1");
        product1.setProductName("Realme Narzo 10");

        Product product2 = new Product();
        product2.setPId("pid2");
        product2.setProductName("Samsung s22");

        Product product3 = new Product();
        product3.setPId("pid3");
        product3.setProductName("Samsung TV");


        Category category1 = new Category();
        category1.setCId("cid1");
        category1.setTitle("Electronics");


        Category category2 = new Category();
        category2.setCId("cid2");
        category2.setTitle("Mobile phone");



        List<Product> category1Products = category1.getProducts();
        category1Products.add(product1);
        category1Products.add(product2);
        category1Products.add(product3);

        List<Product> category2Products = category2.getProducts();
        category2Products.add(product1);
        category2Products.add(product2);

        categoryRepo.save(category1);
        categoryRepo.save(category2);*/

        //Retrieving the entry
        /*Category category = categoryRepo.findById("cid1").get();
        System.out.println(category.getProducts().size());

        Category category2 = categoryRepo.findById("cid2").get();
        System.out.println(category2.getProducts().size());*/

        /* Product product = productRepo.findById("pid1").get();
        System.out.println(product.getCategories().size());*/


    }
// for many to many
/*    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;*/
}

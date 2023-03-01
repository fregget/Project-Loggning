package com.example.logging;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class User {
    //TODO validation
    private int id;
    int counter=1;

    private String firstName;

    private String lastName;
    private String username;
    private String email;
    private String password;
    private List <TimeRegistration> userTimeRegistrations;


    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastname;
        userTimeRegistrations = createTestArray();
    }

    public User(String username, String email, String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        userTimeRegistrations = createTestArray();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", counter=" + counter +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userTimeRegistrations=" + userTimeRegistrations +
                '}';
    }


    public User() {
        id=counter;
        userTimeRegistrations=createTestArray();
        counter++;
        System.out.println("Denna constructor");
    }

    public List<TimeRegistration> createTestArray() {
        List testArray = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            testArray.add(new TimeRegistration(random.nextDouble(7)+1,
                    TypeRegTime.values()[random.nextInt(4)],
                    LocalDate.now().plusDays(random.nextInt(30)+1).toString() ));
        }
        return testArray;
    }

    public List<TimeRegistration> getUserTimeRegistrations() {
        return userTimeRegistrations;
    }

    public void sortByDate() {
        userTimeRegistrations.sort(Comparator.comparing(TimeRegistration::getDate));
        System.out.println("Date");
    }

    public void sortByHours() {
        userTimeRegistrations.sort(Comparator.comparing(TimeRegistration::getTime));
        System.out.println("Hours");
    }

    public void sortByCategory() {
        userTimeRegistrations.sort(Comparator.comparing(TimeRegistration::getEnumType));
        System.out.println("Category");
    }
    public void setUserTimeRegistrations(List<TimeRegistration> userTimeRegistrations) {
        this.userTimeRegistrations = userTimeRegistrations;
    }


    public double getTotalTime(){
        return userTimeRegistrations.stream().mapToDouble(x->x.getTime()).sum();
    }
    public void addTimeRegistration(TimeRegistration timeRegistration){
        userTimeRegistrations.add(timeRegistration);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

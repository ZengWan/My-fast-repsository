package org.example.aop;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Target {

    public void sava() {
        System.out.println("sava running...");
    }
}

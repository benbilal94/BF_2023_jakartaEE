package be.bf.bf_2023_jakartaee.services;

import jakarta.ejb.Stateful;

@Stateful
public class DemoRepository {

    @Override
    public String toString() {
        return "Hello There!";
    }
}

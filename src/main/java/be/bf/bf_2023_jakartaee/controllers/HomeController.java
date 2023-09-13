package be.bf.bf_2023_jakartaee.controllers;

import java.util.Arrays;
import java.util.Map;

public class HomeController {
    public String indexAction(Map<String, Object> model) {
        model.put("user", Arrays.asList("Flavian", "Gregory", "Le Commercial"));

        return "home/index";
    }

    public String detailAction(Map<String, Object> model, int id) {
        model.put("id", id);

        return "home/detail";
    }

}

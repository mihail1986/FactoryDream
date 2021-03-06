/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.controllers;

import java.util.ArrayList;
import java.util.List;
import md.factorydream.entites.Customers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import md.factorydream.spring.service.CustomersService;
import org.apache.log4j.Logger;

/**
 *
 * @author Zaițev.Victor
 */
@Controller
public class MultiActionControllers {
    
    private static final Logger LOGGER = Logger.getLogger(MultiActionControllers.class);

    //Customers Service which will do all data retrieval/manipulation work
    @Autowired(required = true)
    @Qualifier(value = "customersService")
    private CustomersService customersService;

    //----------------------- Welcome Page ----------------------------------------------------
    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "redirect:login";
    }

    //----------------------- Login Page ----------------------------------------------------
    @RequestMapping(value = "/login")
    public ModelAndView getLoginForm(@RequestParam(required = false) String authfailed) {
        
        String message = "";
        if (authfailed != null) {
            message = "numele si parola sunt gresite";
        }
        return new ModelAndView("login", "message", message);
    }

    //----------------------- Orders Page ----------------------------------------------------
    @RequestMapping(value = "/orders")
    public String getOrders() {
        LOGGER.info("Utilizatorul: a accesat linkul \"orders\" ");
        return "ordershome";
    }

    //----------------------- Home Page ----------------------------------------------------
    @RequestMapping(value = "/home")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        List<Customers> customersListHtml = (ArrayList<Customers>) customersService.findAll();
        String firstName = customersListHtml.get(0).getName();
        model.addAttribute("name", name);
        model.addAttribute("user", firstName);
        model.addAttribute("nrConnection", name);
        
        return "home";
    }

    //----------------------- Acces is Denied ----------------------------------------------------
    @RequestMapping(value = "/403page")
    public String accessDenied(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("activeUser", name);
        return "accessDenied";
    }
    
}

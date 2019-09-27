package com.codegym.controllers;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productList;


    @GetMapping("home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("products", productList.findAll());
        return modelAndView;
    }

    @GetMapping("home/{id}/showlist")
    public ModelAndView show(@PathVariable int id){
        Product product = productList.findById(id);
        ModelAndView modelAndView = new ModelAndView("/showproduct");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("home/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        Product product = productList.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("home/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirect){
        productList.save(product);
        redirect.addFlashAttribute("message", "Modified product successfully!");
        return "redirect:/home";
    }

    @GetMapping("home/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect){
        productList.remove(id);
        redirect.addFlashAttribute("message", "Modified product successfully!");
        return "redirect:/home";
    }

    @GetMapping("home/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("id", productList.findAll().size());
        return modelAndView;
    }

    @GetMapping("/home/save")
    public String save(Product product, RedirectAttributes redirect){
        product.setId(productList.findAll().size());
        productList.add(product);
        redirect.addFlashAttribute("message", "Saved customer successfully!");
        return "redirect:/home";
    }
}

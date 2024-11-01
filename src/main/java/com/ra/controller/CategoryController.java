package com.ra.controller;

import com.ra.model.Category;
import com.ra.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String index(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "category/index";
    }
    @GetMapping("/add")
    public String add(Category category,Model model){
        model.addAttribute("category",category);
        return "category/add";
    }
    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Category category, BindingResult result){
        if(result.hasErrors()){
            return "category/add";
        }
        categoryService.save(category);
        return "redirect:/category";
    }
}

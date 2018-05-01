package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    RoomRepository roomRep;

     @RequestMapping("/")
    public  String listRoom (Model model) {
         model.addAttribute("rooms", roomRep.findAll());
       return"list" ;
     }


     @GetMapping("/add")
    public  String newRoom(Model model){
         model.addAttribute("room", new Room());
         return "form";
     }

    @RequestMapping("/save")
    public  String saveRoom (@Valid @ModelAttribute("aRoom") Room toSave, BindingResult result){
        if (result.hasErrors()){
            return"add";
        }

        roomRep.save (toSave);
        return "redirect:/";
    }

}

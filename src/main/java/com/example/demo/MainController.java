package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public  String saveRoom @Valid @ModelAttribute ("aRoom") Room room, BindingResult result){
        if (result.hasErrors()){
            return"add";
        }

        rooms.save (room);
        return "redirect:/";
    }
    
}

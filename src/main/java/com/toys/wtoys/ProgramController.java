package com.toys.wtoys;

import com.toys.wtoys.toy.ToyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgramController {

    private final ToyService toyService;

    public ProgramController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping("/")
    public String startPage() {
        return "startPage";
    }

    @GetMapping("/toysList")
    public String toysList(
            Model model
    ) {
        model.addAttribute("toys", toyService.getAllToys());
        return "toys";
    }

    @GetMapping("/addToy")
    public String addToy(
            @RequestParam(value = "name", required = false) String name
    ) {
        if (name != null) {
            toyService.addToy(name);
        }
        return "addingToy";
    }

    @GetMapping("/editToy/{id}")
    public String editToy(
            @PathVariable long id,
            Model model
    ) {
        model.addAttribute("toy", toyService.findById(id));
        return "editingToy";
    }

    @GetMapping("/saveEditedToy")
    public String saveEditedToy(
            @RequestParam(value = "id", required = false) long id,
            @RequestParam(value = "name", required = false) String name
    ) {
        toyService.editToy(id, name);
        return "redirect:/toysList";
    }

}

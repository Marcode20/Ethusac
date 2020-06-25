package pe.isil.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.model.Paradero;
import pe.isil.empresa.service.ParaderoService;
import pe.isil.empresa.service.ParaderoServiceImpl;

import javax.persistence.ConstructorResult;

@Controller
public class ParaderoController {

    @Autowired
    private ParaderoServiceImpl paraderoServiceImpl ;

    @GetMapping("/paradero")
    public String getAllParadero(Model model){
        model.addAttribute("paradero", paraderoServiceImpl.getAllParadero());
        return "paradero";
    }
    @GetMapping("/paradero/add")
    public String paraderoAdd(Model model){
        model.addAttribute("paradero", new Paradero());
        return "paradero-add";
    }
    @PostMapping("/paradero/save")
    public String parderoSave(Paradero paradero){
        paraderoServiceImpl.createParadero(paradero);
        return "redirect:/paradero";
    }
    @GetMapping("/paradero/edit/{id}")
    public String editParadero(@PathVariable Integer id, Model model){
        Paradero currentParadero = paraderoServiceImpl.getParaderoById(id);
        model.addAttribute("paradero",currentParadero);
        return "paradero-edit";
    }

    @PostMapping("/paradero/update/{id}")
    public String updateParadero(@PathVariable Integer id, Paradero paradero){
        paraderoServiceImpl.updateParadero(paradero);
        return "redirect:/paradero";
    }
    @GetMapping("paradero/delete/{id}")
    public String deleteParadero(@PathVariable Integer id){
        this.paraderoServiceImpl.deleteParadero(id);
        return "redirect:/paradero";
    }
}

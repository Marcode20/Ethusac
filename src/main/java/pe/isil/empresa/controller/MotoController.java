package pe.isil.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.model.Moto;
import pe.isil.empresa.service.ChoferServiceImpl;
import pe.isil.empresa.service.MotoService;
import pe.isil.empresa.service.MotoServiceImpl;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MotoController {

    //chofer
    @Autowired
    private MotoServiceImpl motoServiceImpl;

    @Autowired
    private MotoService motoService;

    @GetMapping("/moto/edit/{id}")
    public String editMoto(@PathVariable Integer id,Model model){
        Moto currentMoto = motoServiceImpl.getMotoById(id);
        model.addAttribute("moto",currentMoto);
        return "moto-edit";
    }

    @PostMapping("/moto/update/{id}")
    public String updateMoto(@PathVariable Integer id, Moto moto){
        motoServiceImpl.updateMoto(moto);
        return "redirect:/motos";
    }

    @GetMapping("moto/delete/{id}")
    public String deleteMoto(@PathVariable Integer id){
        this.motoServiceImpl.deleteMotor(id);
        return "redirect:/motos";
    }
//    @PostMapping("/moto/save")
//    public String motoSave(Moto moto){
//        motoServiceImpl.createMoto(moto);
//        return "redirect:/motos";
//    }
}


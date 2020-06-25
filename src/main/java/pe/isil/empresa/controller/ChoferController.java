package pe.isil.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.model.Moto;
import pe.isil.empresa.service.ChoferService;
import pe.isil.empresa.service.MotoService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ChoferController {

    //chofer
    @Autowired
    private ChoferService choferService;

    @Autowired
    private MotoService motoService;

    @GetMapping("/chofers")
    public String getAllChofer(Model model){
        model.addAttribute("chofer", choferService.getAllChofer());
        return "choferes";
    }
    @GetMapping("/chofers/add")
    public String loanAdd(Model model){
        model.addAttribute("chofersa", new Chofer());
        return "chofer-add";
    }
    @PostMapping("/chofer/save")
    public String choferSave(Chofer chofer){
        choferService.createChofer(chofer);
        return "redirect:/chofers";
    }
    @GetMapping("/chofer/edit/{id}")
    public String EditChofer(@PathVariable Integer id,Model model){
        Chofer currentChofer = choferService.getChoferById(id);
        model.addAttribute("chofer1",currentChofer);
        return "chofer-edit";
    }

    @PostMapping("/chofer/update/{id}")
    public String updatechofer(@PathVariable Integer id, Chofer chofer){
        choferService.updateChofer(chofer);
        return "redirect:/chofers";
    }
    @GetMapping("chofer/delete/{id}")
    public String deletechofer(@PathVariable Integer id){
        this.choferService.deleteChofer(id);
        return "redirect:/chofers";
    }

    //chofer + Moto
    @GetMapping("/chofer/{id}/motos")
    public String motoList(Model model, @PathVariable Integer id){
        model.addAttribute("id",id);
        Chofer current = choferService.getChoferById(id);
        model.addAttribute("motos",motoService.getMotoByIdChofer(current));
        model.addAttribute("motolist",motoService.getAllMoto());
        return "motos";
    }


    @GetMapping("/chofer/{id}/motos/add")
    public String motoAdd(Model model, @PathVariable Integer id){
        model.addAttribute("id",id);
        model.addAttribute("moto",new Moto());
        return "moto-add";
    }

    @PostMapping("/chofer/{id}/motos/save")
    public String motosave(Moto moto, @PathVariable Integer id){
        Chofer currentChofer = choferService.getChoferById(id);
        Set<Chofer> listchofer = new HashSet<>();
        listchofer.add(currentChofer);
        if(currentChofer != null){
            moto.setChofer(listchofer);
            motoService.createMoto(moto);
        }
        return "redirect:/chofer/"+id+"/motos";
    }

//    @GetMapping("/chofers/{id}")
//    public ResponseEntity<Chofer> getByIdChofer(@PathVariable Integer id){
//        return ResponseEntity.ok().body(choferServiceImpl.getChoferById(id));
//    }








//
//    @GetMapping("/chofer/delete/{id}")
//    public String deleteChofer(@PathVariable Integer id){
//        Chofer currentChofer = choferServiceImpl.deleteChofer(id);
//        if(currentChofer != null){
//            choferServiceImpl.deleteChofer(currentChofer);
//        }
//        return "redirect:/chofers";
//    }
//    @DeleteMapping("/chofers/{id}")
//    public HttpStatus deletechofer(@PathVariable Integer id){
//        choferServiceImpl.deleteChofer(id);
//        return "redirect:/chofers";
//
//    }
//    @PostMapping("/chofers")
//    public ResponseEntity<Chofer> createChofer(@RequestBody Chofer chofer){
//        return  ResponseEntity.ok().body(this.choferServiceImpl.createChofer(chofer));
//
//    }



//    @PutMapping("/chofers/{id}")
//    public ResponseEntity<Chofer> updatechofer(@PathVariable Integer id, @RequestBody Chofer chofer){
//        chofer.setChofer_id(id);
//        return  ResponseEntity.ok().body(this.choferServiceImpl.updateChofer(chofer));
//    }
//
//    @DeleteMapping("/chofers/{id}")
//    public HttpStatus deletechofer(@PathVariable Integer id){
//        this.choferServiceImpl.deleteChofer(id);
//        return HttpStatus.OK;
//    }
}

package pe.isil.empresa.service;


import pe.isil.empresa.model.Chofer;
import pe.isil.empresa.model.Moto;

import java.util.List;

public interface MotoService {


    List<Moto> getMotoByIdChofer(Chofer chofer);
    Moto createMoto(Moto moto);
    Moto updateMoto(Moto moto);
    List<Moto> getAllMoto();
    Moto getMotoById(Integer motoid);
    void deleteMotor(Integer motoid);

}

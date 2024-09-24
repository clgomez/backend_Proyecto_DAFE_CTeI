package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.services;

import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities.Proyecto;
import java.util.List;
import java.util.Optional;

public interface IProyectoService {

    public Proyecto save(Proyecto objProyecto);
    public Optional<Proyecto> findById(Long idProyecto);
    public List <Proyecto> findAll();
    public Proyecto update(Long idProyecto, Proyecto objProyecto);
    public boolean delete(Long idProyecto);
    public Proyecto parseContentToProyecto(String content);
    
}

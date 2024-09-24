package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.services;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities.Proyecto;
import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.repositories.ProyectoRepository;
import lombok.NonNull;


@Service
public class ProyectoServiceImpl  implements IProyectoService{
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
     public Proyecto save(@NonNull Proyecto objProyecto) {
        
          return this.proyectoRepository.save(objProyecto);
          
    }

    @Override
    public Optional<Proyecto> findById(@NonNull Long idProyecto) {
        return this.proyectoRepository.findById(idProyecto);
    }

    @Override
    public List<Proyecto> findAll() {
        return this.proyectoRepository.findAll();
    }

    @Override
    public Proyecto update(@NonNull Long idProyecto, Proyecto objProyecto) {
        if(this.proyectoRepository.existsById(idProyecto))
        {
            objProyecto.setId(idProyecto);
            return this.proyectoRepository.save(objProyecto);
        }
        else return null;   
    }

    @Override
    public boolean delete(@NonNull Long idProyecto) {
        Optional <Proyecto> optCliente = this.proyectoRepository.findById(idProyecto);
        if(optCliente.isPresent())
        {   this.proyectoRepository.deleteById(idProyecto);
            return true; 
        }
        return false;
    }

    
    @Override
    public Proyecto parseContentToProyecto(String content) {
       
        Proyecto proyecto = new Proyecto();
     
        // Asumamos que el contenido es una cadena con los campos separados por tabulaciones
        String[] lines = content.split("\n");
        if (lines.length > 0) {
            String[] fields = lines[1].split("\t");
            //if (fields.length > 0) proyecto.setId(Long.parseLong(fields[0]));
            if (fields.length > 1) proyecto.setTitulo(fields[1]);
            if (fields.length > 2) proyecto.setDescripcion(fields[2]);
            if (fields.length > 3) proyecto.setFechaCreacion((fields[3]));
            if (fields.length > 4) proyecto.setEstado(fields[4]);
      
        }

        return proyecto;
        
    }


    /*public void parseContentToProyecto(String content) {
       
        String[] lines = content.split("\n");
        if (lines.length > 0) {
            String[] fields = lines[1].split("\t");
            if (fields.length > 0) System.out.println(fields[0]);
            if (fields.length > 1) System.out.println(fields[1]);
            if (fields.length > 2) System.out.println(fields[2]);
            if (fields.length > 3) System.out.println(fields[3]);
            if (fields.length > 4) System.out.println(fields[4]);
      
        }
        
    }*/
    
}

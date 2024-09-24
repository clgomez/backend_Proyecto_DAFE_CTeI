package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.controllers;

import java.util.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.dtos.ProyectoDTO;
import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities.Proyecto;
import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.services.IProyectoService;


@RestController
@CrossOrigin(origins={"http://localhost:4400","http://localhost:4200"})
@RequestMapping("/api")
public class ProyectoController {

    @Autowired
    private IProyectoService proyectoService;

	@PostMapping("/proyecto")
    public ResponseEntity<?> guardar(@Valid @RequestBody ProyectoDTO objProyectoDTO){
        Map<String, Object> respuesta = new HashMap<>();
        
        try {
            Proyecto objProyecto = new Proyecto();
            Proyecto proyecto = new Proyecto();
            ProyectoDTO proyectoDTO = new ProyectoDTO();
            objProyecto.convertir_DTO_a_Proyecto(objProyectoDTO);
            proyecto = this.proyectoService.save(objProyecto);
            proyectoDTO.convertir_Proyecto_a_DTO(proyecto);
            return new ResponseEntity<ProyectoDTO>(proyectoDTO, HttpStatus.OK);
                            
        } catch (Exception e){
            respuesta.put("mensaje", "Error al realizar la inserción en la base de datos");
            //respuesta.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        
    }


	@GetMapping("/proyecto/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long idProyecto){
        Map<String, Object> respuesta = new HashMap<>();
            Proyecto proyecto = new Proyecto();
            ProyectoDTO proyectoDTO = new ProyectoDTO();
        try {
            Optional<Proyecto> optProyecto = this.proyectoService.findById(idProyecto);
            if (optProyecto.isPresent()) {
                proyecto = optProyecto.get();
                proyectoDTO.convertir_Proyecto_a_DTO(proyecto);
                                       
                return new ResponseEntity<ProyectoDTO>(proyectoDTO, HttpStatus.OK);
            } else {
                respuesta.put("mensaje", "No se encontró el proyecto");
                return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e){
            respuesta.put("mensaje", "Error al realizar la busqueda en la base de datos");
            respuesta.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/proyectos")
	public ResponseEntity<?> listar(){

        Map<String, Object> respuesta = new HashMap<>();
        //Map<String, List <ProyectoDTO>> respuesta2 = new HashMap<>();

		
        try{
            List <ProyectoDTO> ArrayProyectosDTO = new ArrayList<>();            
            List <Proyecto> proyectos = this.proyectoService.findAll();
            
            
                for(Proyecto proyecto: proyectos)
                {
                    ProyectoDTO proyectoDTO = new ProyectoDTO();
                    proyectoDTO.convertir_Proyecto_a_DTO(proyecto);
                    ArrayProyectosDTO.add(proyectoDTO);
                        
                }
                
                if(proyectos.isEmpty())
                    respuesta.put("mensaje", "No hay proyectos en la lista de proyectos");
                
                 
                respuesta.put("proyectos", ArrayProyectosDTO);
               
                return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
                
           
        }catch(Exception e)
        {
            respuesta.put("mensaje", "Error al realizar la busqueda en la base de datos");
            //respuesta.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            respuesta.put("error", e.getMessage() + " " + e.getCause());
            return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
	
	} 

	@PutMapping("/proyecto/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long idProyecto, @Valid @RequestBody ProyectoDTO objProyectoDTO){
        Map<String, Object> respuesta = new HashMap<>();
        Proyecto objProyecto = new Proyecto();
        Proyecto proyecto = new Proyecto();
        ProyectoDTO proyectoDTO = new ProyectoDTO();

        try{
            objProyecto.convertir_DTO_a_Proyecto(objProyectoDTO);
            proyecto = this.proyectoService.update(idProyecto, objProyecto);
            proyectoDTO.convertir_Proyecto_a_DTO(proyecto);
          
        }catch (Exception e){
            respuesta.put("mensaje", "Error al actualizar en la base de datos");
            //respuesta.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        respuesta.put("mensaje", "El proyecto ha sido actualizado con éxito!");
		respuesta.put("proyecto", proyectoDTO);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

	@DeleteMapping("/proyecto/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long idProyecto){
        Map<String, Object> respuesta = new HashMap<>();
        
        try {
            if(proyectoService.delete(idProyecto))
            {   respuesta.put("Exito","Se elimino correctamente");
                return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
            }
            else
            {   respuesta.put("Mensaje","el proyecto no existe");
                return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            respuesta.put("mensaje", "Error al realizar la eliminacion en la base de datos");
            //respuesta.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}

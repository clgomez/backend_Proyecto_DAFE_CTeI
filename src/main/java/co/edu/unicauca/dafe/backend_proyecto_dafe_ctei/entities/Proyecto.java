package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities;

import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.dtos.ProyectoDTO;
import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String poblacionObjetivo;
    private String justificacion;
    private String presupuesto;
    private String resultadosEsperados;
    private String observaciones;
    private String fechaCreacion;
    private String fechaActualizacion;
    private String estado;
  
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario objUsuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objProyecto")
	private List<Calificacion> calificaciones;

   
    public Proyecto() {
      
        this.calificaciones = new ArrayList<Calificacion>();
   
    }
      
    public void agregarCalificacion(Calificacion objCalificacion)
	{
		
        this.calificaciones.add(objCalificacion);
	}

    
    public Long getId() {
        return id;
    }
    public void setId(Long i) {
        this.id = i;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getPoblacionObjetivo() {
        return poblacionObjetivo;
    }
    public void setPoblacionObjetivo(String poblacionObjetivo) {
        this.poblacionObjetivo = poblacionObjetivo;
    }
    public String getJustificacion() {
        return justificacion;
    }
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    public String getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }
    public String getResultadosEsperados() {
        return resultadosEsperados;
    }
    public void setResultadosEsperados(String resultadosEsperados) {
        this.resultadosEsperados = resultadosEsperados;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Usuario getObjUsuario() {
        return objUsuario;
    }
 
    public void convertir_DTO_a_Proyecto(ProyectoDTO objProyectoDTO) {
        this.id = objProyectoDTO.getId();
        this.titulo = objProyectoDTO.getTitulo();
        this.descripcion = objProyectoDTO.getDescripcion();
        this.poblacionObjetivo = objProyectoDTO.getPoblacionObjetivo();
        this.justificacion = objProyectoDTO.getJustificacion();
        this.presupuesto = objProyectoDTO.getPresupuesto();
        this.resultadosEsperados = objProyectoDTO.getResultadosEsperados();
        this.observaciones = objProyectoDTO.getObservaciones();
        this.fechaCreacion = objProyectoDTO.getFechaCreacion();
        this.fechaActualizacion = objProyectoDTO.getFechaActualizacion();
        this.estado = objProyectoDTO.getEstado();
        this.objUsuario = new Usuario();
        this.objUsuario.setId(objProyectoDTO.getIdUsuario());
     
        
    }
    
}
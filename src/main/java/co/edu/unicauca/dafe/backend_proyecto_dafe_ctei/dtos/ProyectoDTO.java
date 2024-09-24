package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.dtos;

import java.io.Serializable;

import co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities.Proyecto;
public class ProyectoDTO implements Serializable{

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
    private Long idUsuario;
   
      
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getPoblacionObjetivo() {
        return poblacionObjetivo;
    }
    public String getJustificacion() {
        return justificacion;
    }
    public String getPresupuesto() {
        return presupuesto;
    }
    public String getResultadosEsperados() {
        return resultadosEsperados;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public String getFechaActualizacion() {
        return fechaActualizacion;
    }
    public String getEstado() {
        return estado;
    }
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPoblacionObjetivo(String poblacionObjetivo) {
        this.poblacionObjetivo = poblacionObjetivo;
    }
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }
  
    public void setResultadosEsperados(String resultadosEsperados) {
        this.resultadosEsperados = resultadosEsperados;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void convertir_Proyecto_a_DTO(Proyecto objProyecto) {
        this.id = objProyecto.getId();
        this.titulo = objProyecto.getTitulo();
        this.descripcion = objProyecto.getDescripcion();
        this.poblacionObjetivo = objProyecto.getPoblacionObjetivo();
        this.justificacion = objProyecto.getJustificacion();
        this.presupuesto = objProyecto.getPresupuesto();
        this.resultadosEsperados = objProyecto.getResultadosEsperados();
        this.fechaCreacion = objProyecto.getFechaCreacion();
        this.fechaActualizacion = objProyecto.getFechaActualizacion();
        this.estado = objProyecto.getEstado();
        this.observaciones = objProyecto.getObservaciones();
        this.idUsuario = objProyecto.getObjUsuario().getId();
   
        
    }
}
package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Calificacion")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float calificacionTitulo;
    private float calificacionDescripcion;
    private float calificacionPoblacionObjetivo;
    private float calificacionJustificacion;
    private float calificacionPresupuesto;
    private float calificacionResultadosEsperados;
    private float calificacionFinal; 
    private String fechaCalificacion;
    private float Observaciones;
    private String estado;

    @ManyToOne
    @JoinColumn(name="id_proyecto", nullable = false)
    private Proyecto objProyecto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objCalificacion")
	private List<Notificacion> notificaciones;

          
    public Calificacion() {
        this.notificaciones = new ArrayList<Notificacion>();
        
    }

    public void agregarNotificacion(Notificacion objNotificacion)
	{
		this.notificaciones.add(objNotificacion);
	}
 
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public float getCalificacionTitulo() {
        return calificacionTitulo;
    }
    public void setCalificacionTitulo(float calificacionTitulo) {
        this.calificacionTitulo = calificacionTitulo;
    }
    public float getCalificacionDescripcion() {
        return calificacionDescripcion;
    }
    public void setCalificacionDescripcion(float calificacionDescripcion) {
        this.calificacionDescripcion = calificacionDescripcion;
    }
    
    public float getCalificacionPoblacionObjetivo() {
        return calificacionPoblacionObjetivo;
    }
    public void setCalificacionPoblacionObjetivo(float calificacionPoblacionObjetivo) {
        this.calificacionPoblacionObjetivo = calificacionPoblacionObjetivo;
    }
    public float getCalificacionJustificacion() {
        return calificacionJustificacion;
    }
    public void setCalificacionJustificacion(float calificacionJustificacion) {
        this.calificacionJustificacion = calificacionJustificacion;
    }
    public float getCalificacionPresupuesto() {
        return calificacionPresupuesto;
    }
    public void setCalificacionPresupuesto(float calificacionPresupuesto) {
        this.calificacionPresupuesto = calificacionPresupuesto;
    }
    public float getCalificacionResultadosEsperados() {
        return calificacionResultadosEsperados;
    }
    public void setcResultadosEsperados(float calificacionResultadosEsperados) {
        this.calificacionResultadosEsperados = calificacionResultadosEsperados;
    }
    public float getCalificacionFinal() {
        return calificacionFinal;
    }
    public void setCalificacionFinal(float calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }
    public String getFechaCalificacion() {
        return fechaCalificacion;
    }
    public void setFechaCalificacion(String fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }
    public float getObservaciones() {
        return Observaciones;
    }
    public void setObservaciones(float observaciones) {
        Observaciones = observaciones;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    

}
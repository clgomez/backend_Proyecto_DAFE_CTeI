package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private String fechaNotificacion;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario objUsuario;

    @ManyToOne
    @JoinColumn(name="id_calificacion", nullable = false)
    private Calificacion objCalificacion;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getFechaNotificacion() {
        return fechaNotificacion;
    }
    public void setFechaNotificacion(String fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }


}

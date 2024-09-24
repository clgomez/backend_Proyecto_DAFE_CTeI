package co.edu.unicauca.dafe.backend_proyecto_dafe_ctei.entities;

import java.util.*;
import jakarta.persistence.*;


@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tipoIdentificacion;
	private Long identificacion;
	private String nombres;
	private String apellidos;
	private String direccion;
    private String telefono;
 	private String genero;
	private String fechaNacimiento;
	private String ocupacion;
	private String email;
	private String password;
    private String fechaRegistro;
	private String fechActualizacion;
	private String estado;

	
	@ManyToMany
	@JoinTable(name="UsuarioRol",
				joinColumns = @JoinColumn(name="id_persona"),
				inverseJoinColumns = @JoinColumn(name="id_rol")
			  )
	private List<Rol> roles;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "objUsuario")
	private List<Proyecto> proyectos;	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "objUsuario")
	private List<Notificacion> notificaciones;	

	public Usuario() {
		this.proyectos = new ArrayList<Proyecto>();
		this.notificaciones = new ArrayList<Notificacion>();
	}

	public void agregarProyecto(Proyecto objProyecto)
	{
		this.proyectos.add(objProyecto);
	}

	public void agregarNotificacion(Notificacion objNotificacion)
	{
		this.notificaciones.add(objNotificacion);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechActualizacion() {
		return fechActualizacion;
	}

	public void setFechActualizacion(String fechActualizacion) {
		this.fechActualizacion = fechActualizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
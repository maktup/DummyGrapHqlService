package pe.com.ibm.graphql.bean;

import io.leangen.graphql.annotations.GraphQLQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
public class Cliente{
	
	    @Id @GeneratedValue
	    @GraphQLQuery( name = "id", description = "ID DEL CLIENTE" )
	    private Long id;
	
	    @GraphQLQuery( name = "nombres", description = "NOMBRES DEL CLIENTE" )
	    private String nombres;
		    
	    @GraphQLQuery( name = "apellidos", description = "APELLIDOS DEL CLIENTE" )
	    private String apellidos;
 
	    @GraphQLQuery( name = "edad", description = "EDAD DEL CLIENTE" )
	    private String edad;  
	    
	    @GraphQLQuery( name = "dni", description = "DNI DEL CLIENTE" )
	    private String dni;  
	    
	    @GraphQLQuery( name = "direccion", description = "DIRECCION DEL CLIENTE" )
	    private String direccion;

		public Long getId() {
			   return id;
		}

		public void setId(Long id) {
			   this.id = id;
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

		public String getEdad() {
			   return edad;
		}

		public void setEdad(String edad) {
			   this.edad = edad;
		}

		public String getDni() {
			   return dni;
		}

		public void setDni(String dni) {
			   this.dni = dni;
		}

		public String getDireccion() {
			   return direccion;
		}

		public void setDireccion(String direccion) {
			   this.direccion = direccion;
		}

		@Override
		public String toString() {
			   return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + ", dni=" + dni + ", direccion=" + direccion + "]";
		} 
	    
 }

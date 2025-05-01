package pe.com.ibm.graphql.bean;

import io.leangen.graphql.annotations.GraphQLQuery;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
public class Comida{
	
	    @Id @GeneratedValue
	    @GraphQLQuery( name = "id", description = "ID DE LA COMIDA" )
	    private Long id;
	
	    @GraphQLQuery( name = "nombre", description = "NOMBRE DE LA COMIDA" )
	    private String nombre;
		    
	    @GraphQLQuery( name = "descripcion", description = "DESCRIPCION DE LA COMIDA" )
	    private String descripcion;
 
	    @GraphQLQuery( name = "categoria", description = "CATEGORIA DE LA COMIDA" )
	    private String categoria;  
	    
	    @GraphQLQuery( name = "precio", description = "PRECIO DE LA COMIDA" )
	    private String precio;  
	    
	    @GraphQLQuery( name = "ingredientes", description = "INGREDIENTES DE LA COMIDA" )
	    private String ingredientes;

		public Long getId() {
			   return id;
		}

		public void setId(Long id) {
			   this.id = id;
		}

		public String getNombre() {
			   return nombre;
		}

		public void setNombre(String nombre) {
			   this.nombre = nombre;
		}

		public String getDescripcion() {
			   return descripcion;
		}

		public void setDescripcion(String descripcion) {
			   this.descripcion = descripcion;
		}

		public String getCategoria() {
			   return categoria;
		}

		public void setCategoria(String categoria) {
			   this.categoria = categoria;
		}

		public String getPrecio() {
			   return precio;
		}

		public void setPrecio(String precio) {
			   this.precio = precio;
		}

		public String getIngredientes() {
			   return ingredientes;
		}

		public void setIngredientes(String ingredientes) {
			   this.ingredientes = ingredientes;
		}

		@Override
		public String toString() {
			   return "Comida [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precio=" + precio + ", ingredientes=" + ingredientes + "]";
		}  
	 
 }

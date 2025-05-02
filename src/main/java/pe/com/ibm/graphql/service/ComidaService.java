package pe.com.ibm.graphql.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import pe.com.ibm.graphql.bean.Comida;
import pe.com.ibm.graphql.dao.ComidaDao;
 
@Service
@GraphQLApi
public class ComidaService{
	
	    private final ComidaDao objComidaDao; 
	
	    public ComidaService( ComidaDao objComidaDao ){
	           this.objComidaDao = objComidaDao;
	    }
 
		@GraphQLQuery( name = "listarComidas" )  
	    public List<Comida> listarComidas(){
	           return this.objComidaDao.findAll();
	    }
 
	    @GraphQLQuery( name = "obtenerComidaPorId" )
	    public Comida obtenerComidaPorId( @GraphQLArgument( name = "id" ) Long id ){
	           return this.objComidaDao.findById( id ).orElse( null );
	    }
 
	    @GraphQLMutation( name = "guardarComidaPorObject" )  
		public void guardarComidaPorObject( @GraphQLArgument( name = "objComida" ) Comida objComida ){ 
	    	   this.objComidaDao.save( objComida );
		}
	    
	    @GraphQLMutation( name = "guardarComidaPorParams" )
	    public Comida guardarComidaPorParams( @GraphQLArgument( name = "nombre" ) String nombre, 
	    		                              @GraphQLArgument( name = "descripcion" ) String descripcion, 
	    		                              @GraphQLArgument( name = "categoria" ) String categoria, 
	    		                              @GraphQLArgument( name = "precio" ) String precio, 
	    		                              @GraphQLArgument( name = "ingredientes" ) String ingredientes ){
	           Comida objComida = new Comida(); 
	           objComida.setNombre( nombre );
	           objComida.setDescripcion( descripcion );
	           objComida.setCategoria( categoria );
	           objComida.setPrecio( precio );
	           objComida.setIngredientes( ingredientes );
	           
	           return this.objComidaDao.save( objComida ); 
	    }
 
	    @GraphQLMutation( name = "actualizarComida" ) 
	    public Comida actualizarComida( @GraphQLArgument( name = "id" ) Long id,
	                                    @GraphQLArgument( name = "nombre" ) String nombre,
	                                    @GraphQLArgument( name = "descripcion" ) String descripcion,
	                                    @GraphQLArgument( name = "categoria" ) String categoria,
	                                    @GraphQLArgument( name = "precio" ) String precio,
	                                    @GraphQLArgument( name = "ingredientes" ) String ingredientes ){

	        Optional<Comida> objOptional = this.objComidaDao.findById( id ); 	        
	        Comida objComidaReturn = null;
	        
	        if( objOptional != null ){	        	
	        	Comida objComida = objOptional.get(); 
		        objComida.setNombre( nombre );
		        objComida.setDescripcion( descripcion );
		        objComida.setCategoria( categoria );
		        objComida.setPrecio( precio );
		        objComida.setIngredientes( ingredientes );
		           
	        	objComidaReturn = this.objComidaDao.save( objComida ); 
	        }

	        return objComidaReturn; 
	    }
 
	    @GraphQLMutation( name = "eliminarComidaPorId" )
	    public boolean eliminarComidaPorId( @GraphQLArgument( name = "id" ) Long id ){ 
	        if( this.objComidaDao.existsById( id ) ){
	        	this.objComidaDao.deleteById( id );
	            return true;
	        }
	        else{	        	
	        	 return false;
	        }	        
	    }	    
 	    
  }


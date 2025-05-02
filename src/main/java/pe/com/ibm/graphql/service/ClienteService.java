package pe.com.ibm.graphql.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import pe.com.ibm.graphql.bean.Cliente;
import pe.com.ibm.graphql.dao.ClienteDao;

@Service
@GraphQLApi
public class ClienteService{
	
	    private final ClienteDao objClienteDao; 
	   
	    public ClienteService( ClienteDao objClienteDao ){ 
	           this.objClienteDao = objClienteDao;
	    }
	 
		@GraphQLQuery( name = "listarClientes" )  
	    public List<Cliente> listarClientes(){
	           return this.objClienteDao.findAll();
	    }
 
	    @GraphQLQuery( name = "obtenerClientePorId" )
	    public Cliente obtenerClientePorId( @GraphQLArgument( name = "id" ) Long id ){
	           return this.objClienteDao.findById( id ).orElse( null );
	    }
 
	    @GraphQLMutation( name = "guardarClientePorObject" )  
		public void guardarClientePorObject( @GraphQLArgument( name = "objCliente" ) Cliente objCliente ){ 
	    	   this.objClienteDao.save( objCliente );
		}
	    
	    @GraphQLMutation( name = "guardarClientePorParams" )
	    public Cliente guardarClientePorParams( @GraphQLArgument( name = "nombres" ) String nombres, 
	    		                                @GraphQLArgument( name = "apellidos" ) String apellidos, 
	    		                                @GraphQLArgument( name = "edad" ) String edad, 
	    		                                @GraphQLArgument( name = "dni" ) String dni, 
	    		                                @GraphQLArgument( name = "direccion" ) String direccion ){
	           Cliente objCliente = new Cliente(); 
	           objCliente.setNombres( nombres );
	           objCliente.setApellidos( apellidos );
	           objCliente.setEdad( edad );
	           objCliente.setDni( dni );
	           objCliente.setDireccion( direccion );
	           
	           return this.objClienteDao.save( objCliente ); 
	    }
 
	    @GraphQLMutation( name = "actualizarCliente" ) 
	    public Cliente actualizarCliente( @GraphQLArgument( name = "id" ) Long id,
							    		  @GraphQLArgument( name = "nombres" ) String nombres, 
						                  @GraphQLArgument( name = "apellidos" ) String apellidos, 
						                  @GraphQLArgument( name = "edad" ) String edad, 
						                  @GraphQLArgument( name = "dni" ) String dni, 
						                  @GraphQLArgument( name = "direccion" ) String direccion ) {

	        Optional<Cliente> objOptional = this.objClienteDao.findById( id ); 	        
	        Cliente objClienteReturn = null;
	        
	        if( objOptional != null ){	        	
	        	Cliente objCliente = objOptional.get(); 
		        objCliente.setNombres( nombres );
		        objCliente.setApellidos( apellidos );
		        objCliente.setEdad( edad );
		        objCliente.setDni( dni );
		        objCliente.setDireccion( direccion );
	        	
	        	objClienteReturn = this.objClienteDao.save( objCliente ); 
	        }

	        return objClienteReturn; 
	    }
 
	    @GraphQLMutation( name = "eliminarClientePorId" )
	    public boolean eliminarClientePorId( @GraphQLArgument( name = "id" ) Long id ){ 
	        if( this.objClienteDao.existsById( id ) ){
	        	this.objClienteDao.deleteById( id );
	            return true;
	        }
	        else{	        	
	        	 return false;
	        }	        
	    }	    
 	    
  } 


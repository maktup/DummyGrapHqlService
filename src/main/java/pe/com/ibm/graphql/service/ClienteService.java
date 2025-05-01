package pe.com.ibm.graphql.service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import pe.com.ibm.graphql.bean.Cliente;
import pe.com.ibm.graphql.dao.ClienteDao;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class ClienteService{
	
	    private final ClienteDao objClienteDao; 
	   
	    public ClienteService( ClienteDao objClienteDao ){ 
	           this.objClienteDao = objClienteDao;
	    }
	 
		@GraphQLQuery( name = "clientes" )  
	    public List<Cliente> getClientes(){
	           return this.objClienteDao.findAll();
	    }
	 
	    @GraphQLQuery( name = "cliente" ) 
	    public Optional<Cliente> getClienteById( @GraphQLArgument( name = "id" ) Long id ){ 
	           return this.objClienteDao.findById( id ); 
	    }
	 
	    @GraphQLMutation( name = "deleteCliente" )  
	    public void deleteCliente( @GraphQLArgument( name = "id" ) Long id ){
	    	   this.objClienteDao.deleteById( id ); 
	    }
	
	    @GraphQLQuery( name = "isGood" )  
	    public boolean isGood( @GraphQLContext Cliente objCliente ) {
	           return !Arrays.asList( "Avocado", "Spam" ).contains( objCliente.getNombres() );
	    }

	    @GraphQLMutation( name = "saveCliente" )  
		public void saveCliente( @GraphQLArgument( name = "cliente" ) Cliente objCliente ) {
	    	   this.objClienteDao.save( objCliente );
		}
 
  }


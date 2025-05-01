package pe.com.ibm.graphql.service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import pe.com.ibm.graphql.bean.Comida;
import pe.com.ibm.graphql.dao.ComidaDao;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class ComidaService{
	
	    private final ComidaDao objComidaDao; 
	
	    public ComidaService( ComidaDao objComidaDao ){
	           this.objComidaDao = objComidaDao;
	    }
 
		@GraphQLQuery( name = "comidas" )  
	    public List<Comida> getComidas(){
	           return this.objComidaDao.findAll();
	    }
	 
	    @GraphQLQuery( name = "comida" ) 
	    public Optional<Comida> getComidaById( @GraphQLArgument( name = "id" ) Long id ){
	           return this.objComidaDao.findById( id );
	    }
	 
	    @GraphQLMutation( name = "deleteComida" )  
	    public void deleteComida( @GraphQLArgument( name = "id" ) Long id ){
	    	   this.objComidaDao.deleteById( id );
	    }
	
	    @GraphQLQuery( name = "isGood" )  
	    public boolean isGood( @GraphQLContext Comida objComida ) {
	           return !Arrays.asList( "Avocado", "Spam" ).contains( objComida.getNombre() );
	    }

	    @GraphQLMutation( name = "saveComida" )  
		public void saveComida( @GraphQLArgument( name = "comida" ) Comida objComida ) { 
	    	   this.objComidaDao.save( objComida );
		}
 
  }


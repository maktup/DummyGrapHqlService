package pe.com.ibm.graphql;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.com.ibm.graphql.bean.Cliente;
import pe.com.ibm.graphql.bean.Comida;
import pe.com.ibm.graphql.service.ClienteService;
import pe.com.ibm.graphql.service.ComidaService;
 
@SpringBootApplication
public class GraphqlMain{

   /**
    * main 	
    * @param argumentos
    **/
    public static void main( String[] argumentos ){    	
           SpringApplication.run( GraphqlMain.class, argumentos );
    }

    @Bean
    ApplicationRunner init( ComidaService objComidaService, ClienteService objClienteService ){ 
         
    	return argumentos -> {  
    		
               this.cargarInicialDatos( objComidaService, objClienteService ); 
		};
    }
    
   /**
    * cargarInicialDatos  
    * @param objComidaService
    * @param objClienteService
    **/
	public void cargarInicialDatos( ComidaService objComidaService, ClienteService objClienteService ){
 
		   //-------------------------------------- [COMIDA] --------------------------------------// 
	       Comida objComida_01 = new Comida(); 	        
	       objComida_01.setId( 1L );
	       objComida_01.setNombre( "Pizza Margarita" );
	       objComida_01.setDescripcion( "Pizza clásica con salsa de tomate, mozzarella y albahaca fresca" );
	       objComida_01.setCategoria( "Almuerzo" );
	       objComida_01.setPrecio( "12.50" );
	       objComida_01.setIngredientes( "Masa, Salsa de tomate, Mozzarella, Albahaca" );
	       	        
	       Comida objComida_02 = new Comida(); 	        
	       objComida_02.setId( 2L );
	       objComida_02.setNombre( "Ensalada César" );
	       objComida_02.setDescripcion( "Lechuga romana con aderezo César, crutones y queso parmesano" );
	       objComida_02.setCategoria( "Cena" );
	       objComida_02.setPrecio( "8.90" );
	       objComida_02.setIngredientes( "Lechuga romana, Crutones, Queso parmesano, Aderezo César" );
	        	        
	       Comida objComida_03 = new Comida(); 
	       objComida_03.setId( 3L );
	       objComida_03.setNombre( "Tarta de Chocolate" );
	       objComida_03.setDescripcion( "Postre dulce con base de bizcocho y cobertura de chocolate negro" );
	       objComida_03.setCategoria( "Postre" );
	       objComida_03.setPrecio( "5.00" );
	       objComida_03.setIngredientes( "Harina, Cacao, Azúcar, Huevos, Mantequilla, Chocolate negro" );
	        	        
	       //-------------------------------------- [CLIENTE] --------------------------------------// 
	       Cliente objCliente_01 = new Cliente();
	       objCliente_01.setId( 1L );
	       objCliente_01.setNombres( "Carlos Alberto" );
	       objCliente_01.setApellidos( "Ramírez Soto" );
	       objCliente_01.setEdad( "32" );
	       objCliente_01.setDni( "12345678" );
	       objCliente_01.setDireccion( "Av. Los Olivos 123, Lima" );
	
	       Cliente objCliente_02 = new Cliente();
	       objCliente_02.setId( 2L );
	       objCliente_02.setNombres( "Lucía Fernanda" );
	       objCliente_02.setApellidos( "Torres Aguilar" );
	       objCliente_02.setEdad( "28 ");
	       objCliente_02.setDni( "87654321" );
	       objCliente_02.setDireccion( "Jr. Las Flores 456, Arequipa" );
	
	       Cliente objCliente_03 = new Cliente();
	       objCliente_03.setId( 3L );
	       objCliente_03.setNombres( "Jorge Luis" );
	       objCliente_03.setApellidos( "Mendoza Quispe" );
	       objCliente_03.setEdad( "45" );
	       objCliente_03.setDni( "11223344" );
	       objCliente_03.setDireccion( "Calle Central 789, Cusco" );	                
	
	        
	        //-------------------------------------- [GUARDANDO] --------------------------------------//  
	        objComidaService.guardarComidaPorObject( objComida_01 );  
	        objComidaService.guardarComidaPorObject( objComida_02 );	 	
	        objComidaService.guardarComidaPorObject( objComida_03 );
	        
	        objClienteService.guardarClientePorObject( objCliente_01 );
	        objClienteService.guardarClientePorObject( objCliente_02 );
	        objClienteService.guardarClientePorObject( objCliente_03 );	 
	}
	
 }


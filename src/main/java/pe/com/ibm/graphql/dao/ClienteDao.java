package pe.com.ibm.graphql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.ibm.graphql.bean.Cliente; 

@Repository
public
interface ClienteDao extends JpaRepository<Cliente, Long> {
}

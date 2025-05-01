package pe.com.ibm.graphql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.ibm.graphql.bean.Comida;

@Repository
public
interface ComidaDao extends JpaRepository<Comida, Long> {
}

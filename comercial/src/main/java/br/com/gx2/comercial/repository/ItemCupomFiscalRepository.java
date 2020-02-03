package br.com.gx2.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gx2.comercial.entity.ItemCupomFiscal;

@Repository
public interface ItemCupomFiscalRepository extends JpaRepository<ItemCupomFiscal, Long> {

	//@Query(value="select * from ")
}

package br.com.gx2.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gx2.comercial.entity.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

}

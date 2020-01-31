package br.com.gx2.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gx2.comercial.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}

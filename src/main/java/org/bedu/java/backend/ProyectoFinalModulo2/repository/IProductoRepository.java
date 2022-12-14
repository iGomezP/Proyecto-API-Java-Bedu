package org.bedu.java.backend.ProyectoFinalModulo2.repository;

import org.bedu.java.backend.ProyectoFinalModulo2.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {

	Producto findOneByName (String name);
}

package org.bedu.java.backend.ProyectoFinalModulo2.service;

import org.bedu.java.backend.ProyectoFinalModulo2.entity.Producto;

import java.util.List;

public interface IProductoService {

	List<Producto> getAll();

	Producto createProducto(Producto producto);
}

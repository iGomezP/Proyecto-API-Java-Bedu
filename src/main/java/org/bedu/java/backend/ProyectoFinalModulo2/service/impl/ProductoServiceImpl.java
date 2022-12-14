package org.bedu.java.backend.ProyectoFinalModulo2.service.impl;

import org.bedu.java.backend.ProyectoFinalModulo2.entity.Producto;
import org.bedu.java.backend.ProyectoFinalModulo2.repository.IProductoRepository;
import org.bedu.java.backend.ProyectoFinalModulo2.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

	private IProductoRepository productoRepository;

	@Autowired
	public ProductoServiceImpl (IProductoRepository productoRepository){
		this.productoRepository = productoRepository;
	}

	@Override
	public List<Producto> getAll(){
		return productoRepository.findAll();
	}

	@Override
	public Producto createProducto(Producto producto){
		Producto existeProducto = productoRepository.findOneByName(producto.getName());

		if (existeProducto == null){
			productoRepository.save(producto);
			return producto;
		}
		return existeProducto;
	}
}

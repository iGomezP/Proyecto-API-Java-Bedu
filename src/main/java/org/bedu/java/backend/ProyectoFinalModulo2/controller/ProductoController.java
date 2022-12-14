package org.bedu.java.backend.ProyectoFinalModulo2.controller;

import org.bedu.java.backend.ProyectoFinalModulo2.entity.Producto;
import org.bedu.java.backend.ProyectoFinalModulo2.service.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
	private IProductoService productoService;

	public ProductoController (IProductoService productoService){
		this.productoService = productoService;
	}

	@GetMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> getAll(){
		return productoService.getAll();
	}

	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto createProducto (@RequestBody Producto producto){
		return productoService.createProducto(producto);
	}


}

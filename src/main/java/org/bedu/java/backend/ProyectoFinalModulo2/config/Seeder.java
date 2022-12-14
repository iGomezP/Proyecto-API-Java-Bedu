package org.bedu.java.backend.ProyectoFinalModulo2.config;

import com.opencsv.bean.CsvToBeanBuilder;
import org.bedu.java.backend.ProyectoFinalModulo2.entity.Producto;
import org.bedu.java.backend.ProyectoFinalModulo2.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Seeder implements CommandLineRunner {
	private IProductoRepository productoRepository;

	@Autowired
	public Seeder(IProductoRepository productoRepository){
		this.productoRepository = productoRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		List<Producto> productos = new CsvToBeanBuilder(new FileReader("src/csv/Anime.csv"))
				.withType(Producto.class)
				.build()
				.parse();
		// System.out.println(productos);

		for (Producto producto : new ArrayList<>(productos)){
			// Buscar por nombre
			Producto existeProducto = productoRepository.findOneByName(producto.getName());
			if(existeProducto != null){
				productos.remove(producto);
			}
			//producto.setLast_update(new Date());
		}
		productoRepository.saveAll(productos);
	}
}

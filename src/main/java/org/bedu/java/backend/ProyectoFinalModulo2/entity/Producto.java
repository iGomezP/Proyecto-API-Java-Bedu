package org.bedu.java.backend.ProyectoFinalModulo2.entity;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="productos")
public class Producto{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 80)
	@CsvBindByName(column = "Nombre")
	private String name;

	@Column(name = "price", nullable = false)
	@CsvBindByName(column = "Precio")
	private int price;

	@Column(name="stock", nullable = false)
	@CsvBindByName(column = "Piezas")
	private int stock;

	@Enumerated(EnumType.STRING)
	@Column(name = "photo")
	@CsvBindByName(column = "Fotos")
	private Photo photo = Photo.NO;

	@Column(name = "layaway", nullable = false, length = 3)
	@CsvBindByName(column = "Apartado")
	private int layaway;

	@Column(name = "last_update",
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
			insertable = false,
			updatable = false)
	private LocalDate last_update;

	public enum Photo{
		SI, NO
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public int getLayaway() {
		return layaway;
	}

	public void setLayaway(int layaway) {
		this.layaway = layaway;
	}

	public LocalDate getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDate last_update) {
		this.last_update = LocalDate.now();
	}
}

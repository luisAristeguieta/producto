package com.krakedev.producto.servicio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.producto.entidades.Producto;

@Service
public class ProductoService {
	private ArrayList<Producto> productos;

	public ProductoService() {
		productos = new ArrayList<>();
	}

	// Crear producto
	public Producto crear(Producto producto) {
		Producto buscado = buscarPorCodigo(producto.getCodigo());

		if (buscado != null) {
			return null;
		}

		productos.add(producto);
		return producto;
	}

	// Listar productos
	public ArrayList<Producto> listar() {
		return productos;
	}

	// Buscar producto por código
	public Producto buscarPorCodigo(int codigo) {

		for (Producto p : productos) {

			if (p.getCodigo() == codigo) {
				return p;
			}
		}

		return null;
	}

	// Actualizar producto
	public Producto actualizar(int codigo, Producto productoActualizado) {
		Producto buscado = buscarPorCodigo(codigo);

		if (buscado != null) {
			buscado.setNombre(productoActualizado.getNombre());
			buscado.setPrecio(productoActualizado.getPrecio());

			return buscado;
		}

		return null;
	}

	// Eliminar producto
	public boolean eliminar(int codigo) {
		Producto buscado = buscarPorCodigo(codigo);

		if (buscado != null) {
			productos.remove(buscado);
			return true;
		}

		return false;
	}
}

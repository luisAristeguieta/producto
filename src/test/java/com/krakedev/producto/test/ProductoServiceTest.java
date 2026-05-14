package com.krakedev.producto.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.producto.entidades.Producto;
import com.krakedev.producto.servicio.ProductoService;

public class ProductoServiceTest {
	@Test
	public void testCrearProductoExitoso() {

		// Se espera crear correctamente el producto
		ProductoService service = new ProductoService();
		Producto producto = new Producto("Laptop Lenovo", 1, 850.50);
		Producto resultado = service.crear(producto);

		assertEquals(producto, resultado);
	}

	@Test
	public void testCrearProductoDuplicado() {

		// Se espera retornar null cuando el código ya existe
		ProductoService service = new ProductoService();

		Producto producto1 = new Producto("Laptop Lenovo", 1, 850.50);
		Producto producto2 = new Producto("Mouse Logitech", 1, 25.99);

		service.crear(producto1);
		Producto resultado = service.crear(producto2);

		assertNull(resultado);
	}

	@Test
	public void testBuscarProductoExistente() {

		// Se espera encontrar el producto por código
		ProductoService service = new ProductoService();

		Producto producto = new Producto("Teclado Redragon", 2, 45.00);

		service.crear(producto);
		Producto resultado = service.buscarPorCodigo(2);

		assertEquals(producto, resultado);
	}

	@Test
	public void testBuscarProductoNoExistente() {

		// Se espera retornar null si el producto no existe
		ProductoService service = new ProductoService();

		Producto resultado = service.buscarPorCodigo(100);

		assertNull(resultado);
	}

	@Test
	public void testListarProductos() {

		// Se espera listar todos los productos agregados
		ProductoService service = new ProductoService();

		Producto producto1 = new Producto("Monitor Samsung", 1, 220.00);
		Producto producto2 = new Producto("Impresora Epson", 2, 180.00);

		service.crear(producto1);
		service.crear(producto2);

		int cantidad = service.listar().size();

		assertEquals(2, cantidad);
	}

	@Test
	public void testActualizarProductoExistente() {

		// Se espera actualizar nombre y precio del producto
		ProductoService service = new ProductoService();

		Producto producto = new Producto("Tablet Samsung", 1, 300.00);

		service.crear(producto);

		Producto actualizado = new Producto("Tablet Samsung Pro", 1, 450.00);

		Producto resultado = service.actualizar(1, actualizado);

		assertEquals("Tablet Samsung Pro", resultado.getNombre());
		assertEquals(450.00, resultado.getPrecio());
	}

	@Test
	public void testEliminarProductoExistente() {

		// Se espera eliminar correctamente el producto
		ProductoService service = new ProductoService();

		Producto producto = new Producto("Celular Xiaomi", 1, 500.00);

		service.crear(producto);

		boolean resultado = service.eliminar(1);

		assertTrue(resultado);
	}

	@Test
	public void testEliminarProductoNoExistente() {

		// Se espera retornar false cuando el producto no existe
		ProductoService service = new ProductoService();

		boolean resultado = service.eliminar(99);

		assertFalse(resultado);
	}
}

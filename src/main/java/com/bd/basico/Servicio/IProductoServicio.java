package com.bd.basico.Servicio;

import java.util.List;

import com.bd.basico.modelo.TblProducto;

public interface IProductoServicio {

	public List<TblProducto> ListadoProductos();
	public void RegistrarProducto(TblProducto cliente);
	public TblProducto BuscarporId(Integer id);
	public void Eliminar(Integer id);
}

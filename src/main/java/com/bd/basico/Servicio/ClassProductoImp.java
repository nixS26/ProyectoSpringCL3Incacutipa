package com.bd.basico.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bd.basico.modelo.TblProducto;

import com.bd.basico.repositorio.IProductoRepositorio;

@Service
public class ClassProductoImp implements IProductoServicio{

	
	@Autowired
	private IProductoRepositorio iproductorepository;
	
	@Override
	public List<TblProducto> ListadoProductos() {
		// TODO Auto-generated method stub
		return (List<TblProducto>)iproductorepository.findAll();
	}

	@Override
	public void RegistrarProducto(TblProducto producto) {
		// TODO Auto-generated method stub
		iproductorepository.save(producto);
	}

	@Override
	public TblProducto BuscarporId(Integer id) {
		// TODO Auto-generated method stub
		return iproductorepository.findById(id).orElse(null);
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		iproductorepository.deleteById(id);
	}

	
}

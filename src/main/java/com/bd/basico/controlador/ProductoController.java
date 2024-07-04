package com.bd.basico.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.Servicio.IProductoServicio;
import com.bd.basico.modelo.TblProducto;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/vistas")
public class ProductoController {
	
	@Autowired
	private IProductoServicio iproductoservicio;

	//creamos el metodo listado..

	@GetMapping("ListadoProducto")

	public String ListadoProducto(Model modelo) {

		//recuperamos el listado de autos..

		List<TblProducto> listado=iproductoservicio.ListadoProductos();

		for(TblProducto lis:listado) {

	System.out.println("codigo "+lis.getIdproductocl3()+" "+" nombre "+lis.getNombrecl3());

		}

		//enviamos la data hacia la vista..

		modelo.addAttribute("listado",listado);

		//retornamos

		return "/vistas/ListadoProducto";

		

	}  //fin del metodo listado auto...
	
	//creamos los respectivos para metodos para registrar...

	@GetMapping("/RegistrarProducto")

	public String RegistrarProducto(Model modelo) {

		//realizamos la respectiva instancia...

		TblProducto producto=new TblProducto();

		//enviamos a la vista...

		modelo.addAttribute("regproducto",producto);

		//retornamos

		return "/vistas/FrmCrearProducto";

	}  //fin del metodo registrar.
	
	//realizamos el mapeo con postmapping

	@PostMapping("/GuardarProducto")

	public String GuardarProducto(@ModelAttribute TblProducto  producto,Model modelo) {

		iproductoservicio.RegistrarProducto(producto);

		System.out.println("dato registrado en la bd");

		//retornamos al listado...

		return "redirect:/vistas/ListadoProducto";	

	}  //fin del metodo string...

	//*****************crearmos el metodo editar...

	@GetMapping("/editar/{id}")

	public String Editar(@PathVariable("id") Integer idproductocl3,Model modelo) {

		TblProducto producto=iproductoservicio.BuscarporId(idproductocl3);

		//enviamos hacia la vista...

		modelo.addAttribute("regproducto",producto);

		//retornamos el frmcrearcliente...

		return "/vistas/FrmCrearProducto";	

	}  //fin del metodo editar...

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer idproductocl3,Model modelo) {

		//aplicamos inyeccion de dependencia...

		iproductoservicio.Eliminar(idproductocl3);

		//actulizar el listado

		List<TblProducto> listado=iproductoservicio.ListadoProductos();

		//enviamos a la vista

		modelo.addAttribute("listado",listado);

		//redireccionamos

		return "redirect:/vistas/ListadoProducto";		

	}   //fin del metodo eliminar...

	
}

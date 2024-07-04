package com.bd.basico.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bd.basico.modelo.*;

@Repository
public interface IProductoRepositorio extends CrudRepository<TblProducto,Integer> {

}

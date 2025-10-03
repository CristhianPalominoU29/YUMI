package com.example.yumi.Service;

import com.example.yumi.Model.Producto;
import com.example.yumi.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }
}

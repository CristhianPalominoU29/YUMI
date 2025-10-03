    package com.example.yumi.Controller;

    import com.example.yumi.Model.Producto;
    import com.example.yumi.Service.ProductoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/productos")
    public class ProductoController {

        @Autowired
        private ProductoService productoService;

        @GetMapping
        public List<Producto> getAll(){
            return productoService.obtenerTodos();
        }

        @PostMapping
        public ResponseEntity<Producto> create(@RequestBody Producto producto){
            return ResponseEntity.ok((productoService.crearProducto(producto)));
        }

    }

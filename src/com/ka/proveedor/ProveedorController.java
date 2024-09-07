package com.ka.proveedor;
import org.springframework.web.bind.annotation.*;
import com.ka.clientes.RestController;
import com.ka.proveedor.Proveedores.Proveedor;

import Empleado.GetMapping;
import Empleado.PostMapping;
import Empleado.RequestBody;
import productos.DeleteMapping;
import productos.PathVariable;
import productos.PutMapping;
import productos.RequestMapping;

import java.util.ArrayList;
import java.util.List;
	@RestController
	@RequestMapping ("/proveedor")
	public class ProveedorController<listaProveedores> {
	    private List<Proveedor> listaProveedores = new ArrayList<>();
	    @PostMapping("/crear")
	    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
	        listaProveedores.add(proveedor);
	        return proveedor;
	    }
	    @GetMapping("/listar")
	    public List<Proveedor> listarProveedores() { return listaProveedores;}
	    @GetMapping("/{id}")
	    public Proveedor obtenerProveedor(@PathVariable int id) {
	        return listaProveedores.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	    }
	    @PutMapping("/actualizar/{id}")
	    public Proveedor actualizarProveedor(@PathVariable int id, @RequestBody Proveedor proveedorActualizado) {Proveedor proveedor = obtenerProveedor(id);
	        if (proveedor != null) {
	            proveedor.setNombre(proveedorActualizado.getNombre());
	            proveedor.setDireccion(proveedorActualizado.getDireccion());
	            proveedor.setTelefono(proveedorActualizado.getTelefono());
	        }
	        return proveedor;
	    }
	    @DeleteMapping("/eliminar/{id}")
	    public String eliminarProveedor(@PathVariable int id) {
	        Proveedor proveedor = obtenerProveedor(id);
	        if (proveedor != null) {
	            listaProveedores.remove(proveedor);
	            return "Proveedor dado de baja";
	        }
	        return "Proveedor no existente";
	    }
	}
}

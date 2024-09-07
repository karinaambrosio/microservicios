package Empleado;
import org.springframework.web.bind.annotation.*;

import productos.DeleteMapping;
import productos.PathVariable;
import productos.PutMapping;

import java.util.ArrayList;
import java.util.List;
@com.ka.clientes.RestController
@productos.RequestMapping("/empleado")
public class Empleado{
    private List<Empleado> empleados = new ArrayList<>();
    @PostMapping("/crear")
    public Empleado crear(@RequestBody Empleado empleado) {
        empleados.add(empleado);
        return empleado;
    }
    @GetMapping("/listar")
    public List<Empleado> listar() {
        return empleados;
    }
    @GetMapping("/{id}")
    public Empleado obtener(@PathVariable int id) {
        return empleados.stream().filter(e -> ((Object) e).getId() == id).findFirst().orElse(null);
    }
    @PutMapping("/actualizar/{id}")
    public Empleado actualizar(@PathVariable int id, @RequestBody Empleado empleado) {
        Empleado existente = obtener(id);
        if (existente != null) {
            existente.setNombre(empleado.getNombre());
            existente.setPuesto(empleado.getPuesto());
            existente.setSalario(empleado.getSalario());
        }
        return existente;
    }
    private void setSalario(Object salario) {
		
	}
	private void setPuesto(Object puesto) {
	}
	private void setNombre(Object nombre) {
	}
	private Object getSalario() {
		return null;
	}
	private Object getPuesto() {
		return null;
	}
	private Object getNombre() {
		return null;
	}
	@DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        Empleado empleado = obtener(id);
        if (empleado != null) {
            empleados.remove(empleado);
            return "Empleado eliminado";
        }
        return "Empleado no encontrado";
    }
    static class Empleado {
        private int id;
        private String nombre;
        private String puesto;
        private double salario;
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getPuesto() { return puesto; }
        public void setPuesto(String puesto) { this.puesto = puesto; }
        public double getSalario() { return salario; }
        public void setSalario(double salario) { this.salario = salario; }
    }
}

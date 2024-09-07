package productos;
import org.springframework.web.bind.annotation.*;
import Empleado.GetMapping;
import Empleado.PostMapping;
import Empleado.RequestBody;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
@com.ka.clientes.RestController
@RequestMapping("/producto")
public class Producto {
    private List<Producto> productos = new ArrayList<>();
    @PostMapping("/crear")
    public Producto crear(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }
    @GetMapping("/listar")
    public List<Producto> listar() {
        return productos;
    }
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PutMapping("/actualizar/{id}")
    public Factura actualizar(@PathVariable int id, @RequestBody Factura factura) {
        Producto existente = obtener(id);
        if (existente != null) {
            existente.setClienteId(factura.getClienteId());
            existente.settotal(factura.gettotal());
            existente.setFecha(factura.getFecha());
        }
        return existente;
    }
    private void settotal(double monto) {	
	}
	private void setClienteId(int clienteId) {
	}
	@DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        Producto factura = obtener(id);
        if (factura != null) {
            List<Producto> facturas;
			facturas.remove(factura);
            return "Factura eliminada";
        }
        return "Factura no encontrada";
    }

    static class Factura {
        private int id;
        private int clienteId;
        private double monto;
        private String fecha;
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public int getClienteId() { return clienteId; }
        public void setClienteId(int clienteId) { this.clienteId = clienteId; }
        public double getMonto() { return monto; }
        public void setMonto(double monto) { this.monto = monto; }
        public String getFecha() { return fecha; }
        public void setFecha(String fecha) { this.fecha = fecha; }
    }
}
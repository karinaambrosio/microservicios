package comka.facturas;
import org.springframework.web.bind.annotation.*;

import Empleado.GetMapping;
import Empleado.PostMapping;
import Empleado.RequestBody;
import productos.PathVariable;
import productos.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@com.ka.clientes.RestController
@RequestMapping("/factura")
public class Factura {
    private List<Factura> facturas = new ArrayList<>();
    @PostMapping("/crear")
    public Factura crear(@RequestBody Factura factura) {
        facturas.add(factura);
        return factura;
    }
    @GetMapping("/listar")
    public List<Factura> listar() {
        return facturas;
    }
    @GetMapping("/{id}")
    public Factura obtener(@PathVariable int id) {
        return facturas.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }
    private int getId() {

		return 0;
	}
	@PutMapping("/actualizar/{id}")
    public Factura actualizar(@PathVariable int id, @RequestBody Factura factura) {
        Factura existente = obtener(id);
        if (existente != null) {
            existente.setClienteId(factura.getClienteId());
            existente.setMonto(factura.gettotal());
            existente.setFecha(factura.getFecha());
        }
        return existente;
    }
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        Factura factura = obtener(id);
        if (factura != null) {
            facturas.remove(factura);
            return "Factura dada de baja";
        }
        return "Factura no valida";
    }
    static class Factura {
        public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getClienteId() {
			return clienteId;
		}
		public void setClienteId(int clienteId) {
			this.clienteId = clienteId;
		}
		public double getTotal() {
			return total;
		}
		public void setTota(double tota) {
			this.tota = tota;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		private int id;
        private int clienteId;
        private double totall;
        private String fecha;


    }
}

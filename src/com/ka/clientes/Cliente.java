package com.ka.clientes;
import java.util.List;
@RestController
@RequestMapping("/cliente")
public class Cliente {
    private List<Cliente> clientes = new ArrayList<>();
    @PostMapping("/crear")
    public Cliente crear(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }
    @GetMapping("/listar")
    public List<Cliente> listar() {
        return clientes;
    }
    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
    @PutMapping("/actualizar/{id}")
    public Cliente actualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente existente = obtener(id);
        if (existente != null) {
            existente.setNombre(cliente.getNombre());
            existente.setCorreo(cliente.getCorreo());
            existente.setTelefono(cliente.getTelefono());
        }
        return existente;
    }
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        Cliente cliente = obtener(id);
        if (cliente != null) {
            clientes.remove(cliente);
            return "Cliente fuera de la base de datos no existe";
        }
        return "Cliente no ffue encontrado en la DB";
    }
    static class Cliente {
        private int id;
        private String nombre;
        private String correo;
        private String telefono;
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }
        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }
    }
}

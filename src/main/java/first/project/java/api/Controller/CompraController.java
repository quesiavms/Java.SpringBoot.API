package first.project.java.api.Controller;

import first.project.java.api.Dto.CompraDTO;
import first.project.java.api.Dto.CompraRequestDTO;
import first.project.java.api.Entity.Compra;
import first.project.java.api.Service.CompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {
    private CompraService compraService;

    public CompraController(CompraService compraService){
        this.compraService = compraService;
    }

    @PostMapping()
    public ResponseEntity<CompraDTO> salvarCompra(@RequestBody CompraRequestDTO request) {
        CompraDTO novaCompra = compraService.salvarNovaCompra(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCompra);
    }

//    @GetMapping() // RequestParam = GET /compras?id=123
    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> getDetails(@PathVariable Long id){
        CompraDTO compra = compraService.buscarDetalhesCompra(id);
        return ResponseEntity.ok().body(compra);
    }

    @GetMapping()
    public ResponseEntity<List<CompraDTO>> getAllCompras(){
        List<CompraDTO> compras = compraService.buscarTodasCompras();
        return ResponseEntity.ok().body(compras);
    }

    @DeleteMapping("/removerCompra")
    public ResponseEntity<Void> removerCompra(@RequestParam Long id){
        compraService.deletarCompra(id);
        return ResponseEntity.noContent().build();
    }
}

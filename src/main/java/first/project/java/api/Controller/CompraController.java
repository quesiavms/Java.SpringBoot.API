package first.project.java.api.Controller;

import first.project.java.api.Dto.CompraDTO;
import first.project.java.api.Dto.CompraRequestDTO;
import first.project.java.api.Service.CompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

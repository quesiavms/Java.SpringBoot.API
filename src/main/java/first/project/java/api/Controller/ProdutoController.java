package first.project.java.api.Controller;

import first.project.java.api.Dto.ProdutoDTO;
import first.project.java.api.Entity.Produto;
import first.project.java.api.Service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController //Combina @Controller e @ResponseBody
@RequestMapping("/produtos") //o caminho base da API eg. localhost:8081/produtos
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }
    @GetMapping
    public List<ProdutoDTO> getAllProdutos(){
        return produtoService.listarProdutos();
    }

    @PutMapping("/updateProduto/{id}")
    public ResponseEntity<String> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        try{
            produtoService.atualizarProduto(id, dto);
            return ResponseEntity.ok("Produto atualizado com sucesso");
        } catch (RuntimeException e){
            return  ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @PostMapping("/addProduto")
    public ResponseEntity<String> addProduto(@RequestBody ProdutoDTO novoProduto){
        try {
            produtoService.salvar(novoProduto);
            return ResponseEntity.ok("Produto adicionado com sucesso");
        } catch (RuntimeException e){
            return  ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteProduto/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Long id){
        try{
            produtoService.deletarProduto(id);
            return ResponseEntity.ok("Produto deletado com sucesso");
        } catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}

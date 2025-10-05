package first.project.java.api.Controller;

import first.project.java.api.Entity.Produto;
import first.project.java.api.Service.ProdutoService;
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
    public List<Produto> getAllProdutos(){
        return produtoService.listarProdutos();
    }

    @PostMapping("/addProduto")
    public Produto addProduto(@RequestBody Produto novoProduto){
        return produtoService.salvar(novoProduto);
    }
}

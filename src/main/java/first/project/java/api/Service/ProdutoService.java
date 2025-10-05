package first.project.java.api.Service;

import first.project.java.api.Entity.Produto;
import first.project.java.api.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // essencial para que o Spring gerencie
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository; //metodo construtor
    }

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
}

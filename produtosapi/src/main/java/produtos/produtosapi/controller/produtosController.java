package produtos.produtosapi.controller;

import org.springframework.web.bind.annotation.*;
import produtos.produtosapi.models.produtos;
import produtos.produtosapi.service.produtosService;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class produtosController {

    private produtosService produtosService;

    public produtosController(produtosService produtosService) {
        this.produtosService = produtosService;
    }

    @GetMapping
    public List<produtos> buscarTodos(){
        return produtosService.buscarTodos();
    }

    @GetMapping("{id}")
    public produtos buscarPorId(@PathVariable String id){
        return produtosService.buscarPorId(id);
    }

    @PostMapping
    public produtos criar(@RequestBody produtos produtos){
        return produtosService.criar(produtos);
    }

    @PutMapping("{id}")
    public produtos atualizar(@PathVariable String id , @RequestBody produtos produtos){
        return produtosService.atualizar(id , produtos);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        produtosService.deletar(id);
    }
}

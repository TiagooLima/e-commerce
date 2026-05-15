package produtos.produtosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import produtos.produtosapi.models.produtos;
import produtos.produtosapi.repository.produtosRepository;

import java.util.List;

@Service
public class produtosService {

    @Autowired
    private produtosRepository produtosRepository;

    public List<produtos> buscarTodos(){
        return produtosRepository.findAll();
    }

    public produtos buscarPorId(String id){
        return produtosRepository.findById(id).orElse(null);
    }

    public produtos criar(produtos produtos){
        return  produtosRepository.save(produtos);
    }

    public produtos atualizar(String id , produtos produtos){
        if(produtosRepository.existsById(id)){
            produtos.setId(id);
            return produtosRepository.save(produtos);
        } else {
            return null;
        }
    }

    public void deletar(String id){
        produtosRepository.deleteById(id);
    }

}

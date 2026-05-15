package produtos.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import produtos.produtosapi.models.produtos;

public interface produtosRepository extends JpaRepository<produtos, String> {
}

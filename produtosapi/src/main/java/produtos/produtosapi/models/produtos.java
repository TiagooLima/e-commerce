package produtos.produtosapi.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import produtos.produtosapi.enums.produtosEnums;

import java.time.LocalDateTime;

@Data
@Entity
@JsonPropertyOrder({"id" , "nome" , "descricao" , "categoria" , "data"})
public class produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private produtosEnums categoria;

    @CreationTimestamp
    private LocalDateTime data;
}

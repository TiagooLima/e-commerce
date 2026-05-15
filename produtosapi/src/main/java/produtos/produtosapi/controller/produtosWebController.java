package produtos.produtosapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import produtos.produtosapi.enums.produtosEnums;
import produtos.produtosapi.models.produtos;
import produtos.produtosapi.service.produtosService;

@Controller
@RequestMapping("produtos")
public class produtosWebController {

    private final produtosService produtosService;

    public produtosWebController(produtosService produtosService) {
        this.produtosService = produtosService;
    }

    // ── Lista todos ───────────────────────────────────────────────────────────
    @GetMapping
    public String lista(Model model) {
        model.addAttribute("produtos", produtosService.buscarTodos());
        return "produtos/lista";
    }

    // ── Detalhe ───────────────────────────────────────────────────────────────
    @GetMapping("/{id}")
    public String detalhe(@PathVariable String id, Model model,
                          RedirectAttributes ra) {
        produtos produto = produtosService.buscarPorId(id);
        if (produto == null) {
            ra.addFlashAttribute("erro", "Produto não encontrado.");
            return "redirect:/produtos";
        }
        model.addAttribute("produto", produto);
        return "produtos/detalhe";
    }

    // ── Formulário novo ───────────────────────────────────────────────────────
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("produto", new produtos());
        model.addAttribute("categorias", produtosEnums.values());
        return "produtos/form";
    }

    // ── Criar ─────────────────────────────────────────────────────────────────
    @PostMapping
    public String criar(@ModelAttribute produtos produto,
                        RedirectAttributes ra) {
        try {
            produtosService.criar(produto);
            ra.addFlashAttribute("sucesso", "Produto criado com sucesso!");
        } catch (Exception e) {
            ra.addFlashAttribute("erro", "Erro ao criar produto: " + e.getMessage());
            return "redirect:/produtos/novo";
        }
        return "redirect:/produtos";
    }

    // ── Formulário editar ─────────────────────────────────────────────────────
    @GetMapping("/{id}/editar")
    public String editarForm(@PathVariable String id, Model model,
                             RedirectAttributes ra) {
        produtos produto = produtosService.buscarPorId(id);
        if (produto == null) {
            ra.addFlashAttribute("erro", "Produto não encontrado.");
            return "redirect:/produtos";
        }
        model.addAttribute("produto", produto);
        model.addAttribute("categorias", produtosEnums.values());
        return "produtos/form";
    }

    // ── Atualizar (POST com _method=PUT) ──────────────────────────────────────
    @PostMapping("/{id}/atualizar")
    public String atualizar(@PathVariable String id,
                            @ModelAttribute produtos produto,
                            RedirectAttributes ra) {
        produtos atualizado = produtosService.atualizar(id, produto);
        if (atualizado == null) {
            ra.addFlashAttribute("erro", "Produto não encontrado para atualização.");
        } else {
            ra.addFlashAttribute("sucesso", "Produto atualizado com sucesso!");
        }
        return "redirect:/produtos";
    }

    // ── Deletar (POST com _method=DELETE) ─────────────────────────────────────
    @PostMapping("/{id}/deletar")
    public String deletar(@PathVariable String id, RedirectAttributes ra) {
        try {
            produtosService.deletar(id);
            ra.addFlashAttribute("sucesso", "Produto excluído com sucesso!");
        } catch (Exception e) {
            ra.addFlashAttribute("erro", "Erro ao excluir produto: " + e.getMessage());
        }
        return "redirect:/produtos";
    }
}

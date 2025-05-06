package com.lista.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.lista.demo.ConvidadoRepository;
import com.lista.demo.Convidado;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository repository;

    @GetMapping("/")
    public String formulario(Model model) {
        model.addAttribute("convidado", new Convidado());
        return "form";
    }

    // Salvar convidado
    @PostMapping("/adicionar")
    public String adicionar(@Valid Convidado convidado, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "form";
        }
        repository.save(convidado);
        return "redirect:/";
    }

    // Exibir lista
    @GetMapping("/list")
    public String lista(Model model) {
        model.addAttribute("convidados", repository.findAll());
        model.addAttribute("Total", repository.count());
        return "list";
    }

  @GetMapping("/remover/{id}")
public String remover(@PathVariable Long id) {
    repository.deleteById(id);
    return "redirect:/list";
}
    
}
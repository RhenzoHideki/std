package engtelecom.std.labrest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import engtelecom.std.labrest.resources.Saudacao;

@RestController
public class SaudacaoController {
    private static final String MENSAGEM = "Olá %s";
    private final AtomicLong contador = new AtomicLong();

    @GetMapping("/ola")
    public String olaMundo() {
        return "Olá mundo";
    }

    @GetMapping("/saudacao")
    public Saudacao saudacao(@RequestParam(value = "nome", defaultValue = "mundo") String nome) {
        return new Saudacao(contador.incrementAndGet(), String.format(MENSAGEM, nome));
    }
}
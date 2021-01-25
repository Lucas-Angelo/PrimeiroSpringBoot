package com.lcs2001.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // Para retornar os JSONs
// @RequestMapping ("/api/clientes/{id}") // Para usar global nessa classe, e não repetir
public class MeuResource {

    // @RequestMapping (value = "/api/clientes/{id}", method = RequestMethod.GET) // Mesma coisa que o GetMapping
    @GetMapping ("/api/clientes/{id}")
    public Cliente obterDadosCliente( @PathVariable Long id) { // O Path pega o id recebido na requisição
        System.out.println(String.format("ID recebido via url: %d", id));
        Cliente cliente = new Cliente("Lucas", "000.000.000.00");
        return cliente;
    }

    // @RequestMapping (value = "/api/clientes", method = RequestMethod.POST) // Mesma coisa que o PostMapping
    @PostMapping (value = "/api/clientes")
    @ResponseStatus (HttpStatus.CREATED) // Para retornar 201, status CREATED
    public Cliente salvar( @RequestBody Cliente novo ) {
        // Algum comando para salvar no banco de dados
        return novo;
    }

    /*
    Outra forma de fazer o POST, usando o ResponseEntity
    @PostMapping (value = "/api/clientes")
    public ResponseEntity salvar( @RequestBody Cliente novo ) {
        return new ResponseEntity( novo, HttpStatus.CREATED );
    }
     */

    @DeleteMapping ("/api/clientes/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Long id) { // O Path pega o id recebido na requisição
        // Aqui apagaria o cliente do banco de dados
    }

    @PutMapping ("/api/clientes/{id}")
    public Cliente atualizar( @PathVariable Long id, @RequestBody Cliente atualizado) { // O Path pega o id recebido na requisição
        // Procura no banco de dados e atualiza
        return atualizado;
    }

}
package br.com.efirminov.service;


import br.com.efirminov.model.Pessoa;
import br.com.efirminov.model.PessoaRequest;
import br.com.efirminov.model.PessoaResponse;
import br.com.efirminov.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa salvar(PessoaRequest dto) {
        return this.repository.save(convertePessoaRequestParaPessoa(dto));
    }

    public List<PessoaResponse> lista(){
        return this.repository.findAll()
                .stream()
                .map(p-> convertePessoaResponse(p))
                .collect(Collectors.toList());
    }

    private Pessoa convertePessoaRequestParaPessoa(PessoaRequest dto) {
        return Pessoa.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .curso(dto.getCurso())
                .build();
    }

    private PessoaResponse convertePessoaResponse(Pessoa pessoa) {
        return PessoaResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .email(pessoa.getEmail())
                .telefone(pessoa.getTelefone())
                .curso(pessoa.getCurso())
                .build();

    }

    public void deletePessoa(Long id) {
        this.repository.deleteById(id);
    }

}

package service;

import dao.EnderecoDao;
import dao.PacienteDao;
import model.Endereco;
import model.Paciente;

import java.util.Collections;
import java.util.List;

public class PacienteService {

    public void salvar(Paciente paciente) {
        try {
            var daoEndereco = new EnderecoDao();
            var daoPaciente = new PacienteDao();
            System.out.println(paciente.getEndereco().getId());
            System.out.println(paciente.getId());

            if(paciente.getId() == 0){ // Ve se o paciente tem ID
                var consulta = daoEndereco.consultarIdPorCep(paciente.getEndereco().getCep()); // Consulta o ID pelo CEP cadastrado
                if (consulta > 0){ // Se tiver ID ele muda o id para o resultado da consulta
                    paciente.getEndereco().setId(consulta);
                } else { // Se não tiver o ID ele cadastra o endereço e muda para o maior ID da tabela endereço
                    daoEndereco.inserir(paciente.getEndereco());
                    paciente.getEndereco().setId(daoEndereco.consultarMaiorId());
                }
                System.out.println(daoEndereco.consultarMaiorId());
                daoPaciente.inserir(paciente);
            } else {
                daoPaciente.editar(paciente);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Paciente> buscar() {
        try {
            var dao = new PacienteDao();
            return dao.listarTodos();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Paciente> buscarPorCpf(String cpf) {
        try {
            var dao = new PacienteDao();
            return dao.buscarPacientesPorCPF(cpf);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public Paciente buscarPorId(Long id) {
        try {
            var dao = new PacienteDao();
            return dao.buscarPorId(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deletar(Long id){
        try {
            var dao = new PacienteDao();
            dao.deletar(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
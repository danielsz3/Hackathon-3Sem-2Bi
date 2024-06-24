package service;

import dao.AgenteSaudeDao;
import dao.PacienteDao;
import model.AgenteSaude;
import model.Paciente;

import java.util.Collections;
import java.util.List;

public class AgenteSaudeService {
    public void salvar(AgenteSaude agenteSaude) {
        try {
            AgenteSaudeDao dao = new AgenteSaudeDao();
            System.out.println(agenteSaude.getId());
            if (agenteSaude.getId() == 0) { // Verifica se é um novo agendamento ou edição
                dao.inserir(agenteSaude); // Insere o novo agendamento
            } else {
                dao.atualizar(agenteSaude); // Atualiza o agendamento existente
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar agendamento: " + e.getMessage());
        }
    }

    public List<AgenteSaude> listarTodos() {
        try {
            AgenteSaudeDao dao = new AgenteSaudeDao();
            return dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Erro ao listar agendamentos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public String[] listarTodes() {
        try {
            AgenteSaudeDao dao = new AgenteSaudeDao();
            return dao.listarTodes();
        } catch (Exception e) {
            System.out.println("Erro ao listar agendamentos: " + e.getMessage());
            return null;
        }
    }

    public AgenteSaude buscarPorId(Long id) {
        try {
            var dao = new AgenteSaudeDao();
            return dao.consultarId(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

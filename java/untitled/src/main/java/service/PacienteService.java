package service;

import dao.EnderecoDao;
import dao.PacienteDao;
import model.Endereco;
import model.Paciente;

public class PacienteService {
    public void salvar(Endereco endereco, Paciente paciente) {
        try {
            var daoEndereco = new EnderecoDao();
            var daoPaciente = new PacienteDao();
            if(paciente.getId() == null){
                var consulta = daoEndereco.consultarIdPorCep(endereco.getCep());
                if (consulta > 0){
                    endereco.setId(consulta);
                } else {
                    daoEndereco.inserir(endereco);
                    endereco.setId(daoEndereco.consultarMaiorId());
                }
                daoPaciente.inserir(paciente,endereco);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

package service;

import dao.VacinaDao;
import model.Vacina;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VacinaService {
    private static final Logger logger = Logger.getLogger(VacinaService.class.getName());

    public void salvar(Vacina vacina) {
        try {
            var dao = new VacinaDao();
            if (vacina.getId() == null) {
                dao.inserir(vacina);
            } else {
                dao.atualizar(vacina);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao salvar a vacina", e);
        }
    }

    public void excluir(Long id) {
        try {
            var dao = new VacinaDao();
            if (id != null && id > 0) {
                dao.deletar(id);
            } else {
                logger.warning("Erro ao excluir: ID inválido");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao excluir a vacina", e);
        }
    }

    public List<Vacina> listarTodos() {
        try {
            var dao = new VacinaDao();
            return dao.listarTodos();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao listar todas as vacinas", e);
            return Collections.emptyList();
        }
    }
}

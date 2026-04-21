package graphql;

import business.ModuleBusiness;
import business.UniteEnseignementBusiness;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import entities.Module;
import entities.UniteEnseignement;

public class MutationResolver implements GraphQLMutationResolver {

    private UniteEnseignementBusiness ueBusiness;
    private ModuleBusiness moduleBusiness;

    public MutationResolver() {
        ueBusiness = new UniteEnseignementBusiness();
        moduleBusiness = new ModuleBusiness();
    }

    public boolean addModule(String matricule, String nom, int coefficient, int volumeHoraire,
                             Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = new UniteEnseignement();
        ue.setCode(codeUE);

        Module module = new Module(matricule, nom, coefficient, volumeHoraire, type, ue);
        return moduleBusiness.addModule(module);
    }

    public boolean updateModule(String matricule, String nom, int coefficient, int volumeHoraire,
                                Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = new UniteEnseignement();
        ue.setCode(codeUE);

        Module module = new Module(matricule, nom, coefficient, volumeHoraire, type, ue);
        return moduleBusiness.updateModule(matricule, module);
    }

    public String deleteModule(String matricule) {
        boolean deleted = moduleBusiness.deleteModule(matricule);
        return deleted ? "deleted successfully" : "module not found";
    }

    public boolean addUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return ueBusiness.addUniteEnseignement(ue);
    }

    public boolean updateUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return ueBusiness.updateUniteEnseignement(code, ue);
    }

    public String deleteUniteEnseignement(int code) {
        boolean deleted = ueBusiness.deleteUniteEnseignement(code);
        return deleted ? "deleted successfully" : "UE not found";
    }
}
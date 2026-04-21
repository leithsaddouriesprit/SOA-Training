package graphql;

import business.ModuleBusiness;
import business.UniteEnseignementBusiness;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import entities.Module;
import entities.UniteEnseignement;

import java.util.List;

public class QueryResolver implements GraphQLQueryResolver {

    private UniteEnseignementBusiness ueBusiness;
    private ModuleBusiness moduleBusiness;

    public QueryResolver() {
        ueBusiness = new UniteEnseignementBusiness();
        moduleBusiness = new ModuleBusiness();
    }

    public List<Module> allModules() {
        return moduleBusiness.getAllModules();
    }

    public Module moduleByMatricule(String matricule) {
        return moduleBusiness.getModuleByMatricule(matricule);
    }

    public List<Module> modulesByType(Module.TypeModule type) {
        return moduleBusiness.getModulesByType(type);
    }

    public List<UniteEnseignement> allUEs() {
        return ueBusiness.getListeUE();
    }

    public UniteEnseignement ueByCode(int code) {
        return ueBusiness.getUEByCode(code);
    }

    public List<UniteEnseignement> uesByDomaine(String domaine) {
        return ueBusiness.getUEByDomaine(domaine);
    }

    public List<UniteEnseignement> uesBySemestre(int semestre) {
        return ueBusiness.getUEBySemestre(semestre);
    }
}
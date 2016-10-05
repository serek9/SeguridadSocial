import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class SeguridadSocial {
    private List<Persona> personasList;

    public SeguridadSocial() {
        personasList = new ArrayList<>();
    }
    //CREAMOS HASHMAPS
    private Map<String, Persona> personaMapDni = new HashMap<>();
    private Map<String, Persona> personaMapNumeroSS = new HashMap<>();
    //A PARTIR DE AQUI HACER LOS METODOS CON HASH....
    public void altaPersona(Persona persona) {
        if (!personaMapDni.containsKey(persona.getDni()) && !personaMapNumeroSS.containsKey(persona.getNumSS())){
            personaMapDni.put(persona.getDni(), persona);
            personaMapNumeroSS.put(persona.getNumSS(), persona);
        }
    }

    public void bajaPersona(String dni){
        personaMapNumeroSS.remove(personaMapDni.get(dni).getNumSS());
        personasList.removeIf(persona -> persona.getDni().equals(dni));
    }

    public Persona obtenerPersonaPorDNI(String dni){
        return personaMapDni.get(dni);
    }

    public Persona obtenerPersonaPorNumSS(String numSS){
        return  personaMapNumeroSS.get(numSS);
    }

    public List<Persona> obtenerPersonaRangoSalarial(double min, double max){
        return personaMapNumeroSS.values().stream().filter(persona -> persona.getSalario()>=min&&persona.getSalario()<max).collect(Collectors.toList());
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){
        return personaMapDni.values().stream().filter(persona -> persona.getEdad()>edad).collect(Collectors.toList());
    }

    public List<Persona> obtenerTodas(){
        return personasList;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}


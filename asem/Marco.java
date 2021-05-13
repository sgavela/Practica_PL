package asem;

import java.util.ArrayList;

public class Marco {
    ArrayList<EntradaMarco> marco;
    
    public Marco(){
        marco = new ArrayList<>();    
    } 

    public void addEntrada(String id, Object puntero){
        EntradaMarco nuevaEntrada = new EntradaMarco(id, puntero);
        marco.add(nuevaEntrada);
    }
    
    
    public void borrarEntrada(String id) {
        for(int i = 0; i < marco.size(); ++i){
            EntradaMarco entrada = marco.get(i);
            
            if(id.equals(entrada.identificador)){
                marco.remove(i);
                return;
            }
        }
    }

    public Object buscarIdentificador(String id){
        for(EntradaMarco entrada: marco){
            if(id.equals(entrada.getIdentificador())){
                return entrada.getObjeto();
            }
        }
        
        return null;
    }
    
    public class EntradaMarco{
        private String identificador;
        private Object objeto;
        
        public EntradaMarco(String identificador, Object objeto){
            this.identificador = identificador;
            this.objeto = objeto;
        }
        
        public String getIdentificador(){
            return this.identificador;
        }
        
        public Object getObjeto(){
            return this.objeto;
        }
    }
}

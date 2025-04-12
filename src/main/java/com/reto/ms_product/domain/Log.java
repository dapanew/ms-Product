package com.reto.ms_product.domain;
import net.logstash.logback.argument.StructuredArgument;
import static net.logstash.logback.argument.StructuredArguments.entries;

import java.util.HashMap;

public class Log {
private String idUsuario;
    private String description;
    public Log(String idUsuario, String description) {
        this.idUsuario = idUsuario;
        this.description = description;
    }
    public String getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
   public StructuredArgument getValues() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("idUsuario", idUsuario);
        map.put("description", description);
		return entries(map);
   }
}

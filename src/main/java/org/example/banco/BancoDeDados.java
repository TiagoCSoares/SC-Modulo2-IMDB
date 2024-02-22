package org.example.banco;

import java.util.*;

public class BancoDeDados {

    private static final Map<Class<?>, Set<Object>> OBJETOS = new HashMap<>();
    private Long id = 0l;

    public void inserirObjeto(Object objeto) {
        //Set objetos = colecaoDeObjetos(objeto.getClass());
        Set<Object> objetos = colecaoDeObjetos(objeto.getClass());
        objetos.add(objeto);
    }

    public void excluirObjeto(Object objeto) {
        //Set objetos = colecaoDeObjetos(objeto.getClass());
        Set<Object> objetos = colecaoDeObjetos(objeto.getClass());
        objetos.remove(objeto);
    }

    public List<Object> buscarObjetosPorTipo(Class<?> clazz) {
        //Set objetos = colecaoDeObjetos(clazz);
        //return new ArrayList(objetos);
        Set<Object> objetos = colecaoDeObjetos(clazz);
        return new ArrayList<>(objetos);
    }

    private Set<Object> colecaoDeObjetos(Class<?> clazz) {
        Set<Object> objetos = OBJETOS.computeIfAbsent(clazz, k -> new LinkedHashSet<>());
        return objetos;
    }

    public Long proximoId() {
        id = id +1;
        return id;
    }
}

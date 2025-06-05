package tn.esprit.service;

import tn.esprit.entities.Compte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompteService {
    private static Map<Integer, Compte> comptes = new HashMap<>();
    static {
        comptes.put(1, new Compte ( 1,  "Alice", 1200));
        comptes.put(2, new Compte ( 2,  "Bob",  900));
        comptes.put(3, new Compte ( 3,  "Gharbi",  10000));
    }

    public List<Compte> getAll() {
        return new ArrayList<>(comptes.values());
    }
    public Compte getById(int id) {
        return comptes.get(id);
    }
    public Compte add(Compte c) {
        comptes.put(c.getId(), c);
        return c;
    }
    public void delete(int id) {
        comptes.remove(id);
    }
    public Compte update(int id, Compte c) {
        comptes.put(id, c);
        return c;
    }
}
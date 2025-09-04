package fr.raphaelmakaryan.exemples;

public class ClassB implements IClassB {
    @Override
    public String getData() {
        // Retourne la vraie donnée, par exemple la date/heure actuelle
        return "Donnée réelle";
    }
}
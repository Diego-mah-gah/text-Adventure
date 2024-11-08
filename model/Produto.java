package model;

public class Produto {
    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Produto) {
            Produto outro = (Produto) obj;
            return nome.equals(outro.getNome());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}
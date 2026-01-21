package pt.unip.eventastic.modelo;

import java.util.ArrayList;
import java.util.List;

public class Participante extends Utilizador {
    private String tipo;
    private List<Inscricao> inscricoes;

    public Participante(String nome, String email, String password, String tipo) {
        super(nome, email, password);
        this.tipo = tipo;
        this.inscricoes = new ArrayList<>();
    }

    public void inscreverEvento(Evento evento) {
        // Criação de uma nova inscrição
        Inscricao novaInscricao = new Inscricao(this, evento);
        this.inscricoes.add(novaInscricao);
        System.out.println("Participante inscrito no evento: " + evento.getNome());
    }

    public void efetuarPagamento(Inscricao inscricao) {
        if (inscricao.getPagamento() != null) {
            inscricao.getPagamento().registarPagamento();
            System.out.println("Pagamento registado para a inscrição: " + inscricao.getIdInscricao());
        }
    }

    public List<Inscricao> consultarInscricoes() {
        return this.inscricoes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }
    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
    public String toString() {
        return "Participante{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", tipo='" + tipo + '\'' +
                ", inscricoes=" + inscricoes +
                '}';
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return getEmail().equals(that.getEmail());
    }
    public int hashCode() {
        return getEmail().hashCode();
    }
    public Participante clone() {
        return new Participante(this.getNome(), this.getEmail(), this.getPassword(), this.tipo);
    }
    public String getInfoParticipante() {
        return "Nome: " + getNome() + ", Email: " + getEmail() + ", Tipo: " + tipo;
    }
    public String getInfoCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append(getInfoParticipante()).append("\nInscrições:\n");
        for (Inscricao inscricao : inscricoes) {
            sb.append(inscricao.toString()).append("\n");
        }
        return sb.toString();
    }
    public void adicionarInscricao(Inscricao inscricao) {
        this.inscricoes.add(inscricao);
    }
    public void removerInscricao(Inscricao inscricao) {
        this.inscricoes.remove(inscricao);
    }
    public int contarInscricoes() {
        return this.inscricoes.size();
    }
    public boolean estaInscrito(Evento evento) {
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.getEvento().equals(evento)) {
                return true;
            }
        }
        return false;
    }
    public List<Evento> listarEventosInscritos() {
        List<Evento> eventos = new ArrayList<>();
        for (Inscricao inscricao : inscricoes) {
            eventos.add(inscricao.getEvento());
        }
        return eventos;
    }
    public double calcularTotalPago() {
        double total = 0.0;
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.getPagamento() != null) {
                total += inscricao.getPagamento().getValorPago();
            }
        }
        return total;
    }
    public void cancelarInscricao(Inscricao inscricao) {
        this.inscricoes.remove(inscricao);
        System.out.println("Inscrição cancelada: " + inscricao.getIdInscricao());
    }
    public void atualizarTipo(String novoTipo) {
        this.tipo = novoTipo;
        System.out.println("Tipo de participante atualizado para: " + novoTipo);
    }
    public void limparInscricoes() {
        this.inscricoes.clear();
        System.out.println("Todas as inscrições foram removidas.");
    }
    public boolean possuiInscricoes() {
        return !this.inscricoes.isEmpty();
    }
}

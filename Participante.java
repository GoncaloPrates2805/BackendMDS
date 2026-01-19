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
}

package entities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import interfaces.IMensagem;

public class Mensagem implements IMensagem {
	private Usuario autor;
	private TipoMensagem tipoMsg;
	private String corpoMsg;
	private Date dataEnvio;
	private String mensagemGrupo;
	private ArrayList<Usuario> visualizacaoMensagem = new ArrayList<Usuario>();

	public Mensagem(Usuario autor, TipoMensagem tipoMsg, String corpoMsg, Date dataEnvio, String mensagemGrupo) {
		this.autor = autor;
		this.tipoMsg = tipoMsg;
		this.corpoMsg = corpoMsg;
		this.dataEnvio = dataEnvio;
		this.mensagemGrupo = mensagemGrupo;
	}

	public Usuario getAutor() {
		return this.autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public TipoMensagem getTipoMsg() {
		return this.tipoMsg;
	}

	public void setTipoMsg(TipoMensagem tipoMsg) {
		this.tipoMsg = tipoMsg;
	}

	public String getCorpoMsg() {
		return this.corpoMsg;
	}

	public void setCorpoMsg(String corpoMsg) {
		this.corpoMsg = corpoMsg;
	}

	public Date getDataEnvio() {
		return this.dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getMensagemGrupo() {
		return this.mensagemGrupo;
	}

	public void setMensagemGrupo(String mensagemGrupo) {
		this.mensagemGrupo = mensagemGrupo;
	}

	public ArrayList<Usuario> getVisualizacaoMensagem() {
		return this.visualizacaoMensagem;
	}

	public void setVisualizacaoMensagem(ArrayList<Usuario> visualizacaoMensagem) {
		this.visualizacaoMensagem = visualizacaoMensagem;
	}

    public void imprimeMensagens(Grupo g) {
        for(Mensagem msg: g.getMensagem()) {
            System.out.println("Quem não visualizou cada mensagem: ");
            System.out.println("Mensagem: " + msg.getCorpoMsg());
            for(Usuario u : msg.getVisualizacaoMensagem()) {
                System.out.println(u.getNome());
            }

        }
    }


	@Override
	public String toString() {
		return "{ " + getCorpoMsg() + " }";
	}


}

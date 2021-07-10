package entities;

import java.util.Date;

public class Mensagem {
	private Usuario autor;
	private TipoMensagem tipoMsg;
	private String corpoMsg;
	private Date dataEnvio;
	private String mensagemGrupo;

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

}

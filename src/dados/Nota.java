package dados;

public class Nota {

	private Integer reg;
	private String nome;
	private int nota;
	
	public Nota(Integer reg, String nome, int nota) {
		this.reg = reg;
		this.nome = nome;
		this.nota = nota;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public Integer getReg() {
		return reg;
	}
	
	public String toString() {
		return
				"Matricula: " + reg + "\n" +
				"Nome: " + nome + "\n" +
				"Nota: " + nota + "\n";
	}
}

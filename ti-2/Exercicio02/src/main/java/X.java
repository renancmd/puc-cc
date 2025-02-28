public class X {
	private int id;
	private String animal;
	private char sexo;
	
	public X() {
		this.id = -1;
		this.animal = "";
		this.sexo = '*';
	}
	
	public X(int id, String animal, char sexo) {
		this.id = id;
		this.animal = animal;
		this.sexo = sexo;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getanimal() {
		return animal;
	}

	public void setanimal(String animal) {
		this.animal = animal;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", animal=" + animal + ", sexo=" + sexo + "]";
	}	
}
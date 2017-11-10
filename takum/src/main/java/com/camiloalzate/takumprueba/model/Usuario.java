package com.camiloalzate.takumprueba.model;

public class Usuario {

	private long Usuacodi;

	private String Usuanomb;

	private String Usuaapel;

	private String Usuadire;
	
	private long Usuaterc;
	
	private String Usuaemai;
	
	private long Usuarol;

	public Usuario() {
		Usuacodi = 0;
	}

	public Usuario(long Usuacodi, String Usuanomb, String Usuaapel, String Usuadire, long Usuaterc, String Usuaemai, long Usuarol) {
		this.Usuacodi = Usuacodi;
		this.Usuanomb = Usuanomb;
		this.Usuaapel = Usuaapel;
		this.Usuadire = Usuadire;
		this.Usuaterc = Usuaterc;
		this.Usuaemai = Usuaemai;
		this.Usuarol = Usuarol;		
	}

	public String getUsuaemai() {
		return Usuaemai;
	}

	public void setUsuaemai(String Usuaemai) {
		this.Usuaemai = Usuaemai;
	}

	public long getUsuaterc() {
		return Usuaterc;
	}

	public void setUsuaterc(long usuaterc) {
		Usuaterc = usuaterc;
	}

	public long getUsuarol() {
		return Usuarol;
	}

	public void setUsuarol(long usuarol) {
		Usuarol = usuarol;
	}

	public long getUsuacodi() {
		return Usuacodi;
	}

	public void setUsuacodi(long Usuacodi) {
		this.Usuacodi = Usuacodi;
	}

	public String getUsuanomb() {
		return Usuanomb;
	}

	public void setUsuanomb(String Usuanomb) {
		this.Usuanomb = Usuanomb;
	}

	public String getUsuadire() {
		return Usuadire;
	}

	public void setUsuadire(String Usuadire) {
		this.Usuadire = Usuadire;
	}

	public String getUsuaapel() {
		return Usuaapel;
	}

	public void setUsuaapel(String Usuaapel) {
		this.Usuaapel = Usuaapel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Usuacodi ^ (Usuacodi >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (Usuacodi != other.Usuacodi)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [Usuacodi=" + Usuacodi + ", Usuanomb=" + Usuanomb
				+ ", Usuaapel=" + Usuaapel + ", Usuadire=" + Usuadire
				+ ", Usuaterc=" + Usuaterc + ", Usuaemai=" + Usuaemai
				+ ", Usuarol=" + Usuarol + "]";
	}



}

package com.camiloalzate.takumprueba.model;

public class Productos {

	private long Prodcodi;

	private String Prodnomb;

	private String Proddesc;
	
	private long Prodcost;
	
	private long Prodcapr;
	
	private long Produsua;

	public Productos() {
		Prodcodi = 0;
	}

	public Productos(long prodcodi, String prodnomb, String proddesc,
			long prodcost, long prodcapr, long produsua) {
		this.Prodcodi = prodcodi;
		this.Prodnomb = prodnomb;
		this.Proddesc = proddesc;
		this.Prodcost = prodcost;
		this.Prodcapr = prodcapr;
		this.Produsua = produsua;
	}

	public long getProdcodi() {
		return Prodcodi;
	}

	public void setProdcodi(long prodcodi) {
		Prodcodi = prodcodi;
	}

	public String getProdnomb() {
		return Prodnomb;
	}

	public void setProdnomb(String prodnomb) {
		Prodnomb = prodnomb;
	}

	public String getProddesc() {
		return Proddesc;
	}

	public void setProddesc(String proddesc) {
		Proddesc = proddesc;
	}

	public long getProdcost() {
		return Prodcost;
	}

	public void setProdcost(long prodcost) {
		Prodcost = prodcost;
	}

	public long getProdcapr() {
		return Prodcapr;
	}

	public void setProdcapr(long prodcapr) {
		Prodcapr = prodcapr;
	}

	public long getProdusua() {
		return Produsua;
	}

	public void setProdusua(long produsua) {
		Produsua = produsua;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Prodcodi ^ (Prodcodi >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		if (Prodcodi != other.Prodcodi)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Productos [Prodcodi=" + Prodcodi + ", Prodnomb=" + Prodnomb
				+ ", Proddesc=" + Proddesc + ", Prodcost=" + Prodcost
				+ ", Prodcapr=" + Prodcapr + ", Produsua=" + Produsua + "]";
	}


}

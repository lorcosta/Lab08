package it.polito.tdp.extflightdelays.model;

public class CoppieAereoporti {
	private Integer a1;
	private Integer a2;
	private Integer distanza;
	/**
	 * @param a1
	 * @param a2
	 * @param distanza
	 */
	public CoppieAereoporti(Integer a1, Integer a2, Integer distanza) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.distanza = distanza;
	}
	public Integer getA1() {
		return a1;
	}
	public void setA1(Integer a1) {
		this.a1 = a1;
	}
	public Integer getA2() {
		return a2;
	}
	public void setA2(Integer a2) {
		this.a2 = a2;
	}
	public Integer getDistanza() {
		return distanza;
	}
	public void setDistanza(Integer distanza) {
		this.distanza = distanza;
	}
	
}

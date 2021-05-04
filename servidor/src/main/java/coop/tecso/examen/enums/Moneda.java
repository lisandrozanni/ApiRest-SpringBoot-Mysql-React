package coop.tecso.examen.enums;

public enum Moneda {
	PESO,
    DOLAR,
    EURO;	
	
	public static Moneda getMoneda(String moneda)
	{
		if(moneda==null)
			return null;
		if(moneda.toUpperCase().equals(PESO.toString()))
			return PESO;
		if(moneda.toUpperCase().equals(DOLAR.toString()))
			return DOLAR;
		if(moneda.toUpperCase().equals(EURO.toString()))
			return EURO;		
		return null;
	}
}
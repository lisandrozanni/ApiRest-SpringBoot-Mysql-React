package coop.tecso.examen.dto;

import coop.tecso.examen.enums.EstadoResponse;

public class ResponseDto {
	
	private EstadoResponse estadoResponse;
    private String descripcion;
    
	public ResponseDto(EstadoResponse estadoResponse, String descripcion){
		this.setEstadoResponse(estadoResponse);
		this.setDescripcion(descripcion);
	}
	
	public ResponseDto(){}
	
	public EstadoResponse getEstadoResponse() {
		return estadoResponse;
	}
	public void setEstadoResponse(EstadoResponse estadoResponse) {
		this.estadoResponse = estadoResponse;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

package coop.tecso.examen.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractPersistentObject implements Serializable {

	private static final long serialVersionUID = -975560023284258938L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm", timezone="America/Argentina/Buenos_Aires")
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date fechaCreacion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm", timezone="America/Argentina/Buenos_Aires")
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date ultimaModificacion;


    public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}


	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}


	public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    
    @Override
    public boolean equals(Object other) {
        if (super.equals(other)) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (this.getClass() != other.getClass()) {
            return false;
        }

        AbstractPersistentObject persistentObject = (AbstractPersistentObject) other;
        return getId() != null && getId().equals(persistentObject.getId());

    }


    @Override
    public int hashCode() {

        if (getId() != null) {
            return this.getClass().hashCode() + getId().hashCode();
        } else {
            return super.hashCode();
        }
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass());
        sb.append(" ID:");
        sb.append(id);
        return sb.toString();
    }

    @Transient
    public String getDescription() {
        return toString();
    }

}

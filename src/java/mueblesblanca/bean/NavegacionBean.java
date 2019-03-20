package mueblesblanca.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;


@ManagedBean(name = "navegacionBean")
@SessionScoped
public class NavegacionBean implements Serializable {
	private static final long serialVersionUID = 4545919119678482516L;

	private String ruta;
	private Integer pagina;
	private Integer tipificacion;
	private Integer tabActivo;
	private boolean render;

	public static final String redireccionInicio = "/dashboard.xhmtl?faces-redirect=true";
        public static final String redireccionGestion = "pages/solicitud/solicitud.xhtml";
        //public static final String redireccionInicio = "/pages/paquete/insertarPaquete.xhmtl?faces-redirect=true";
	//public static final String redireccionGestion = "/pages/inicio/inicio.xhmtl?faces-redirect=true";
	public static final String redireccionUrl = "/pages/obligacion/obligacion.xhtml?faces-redirect=true";
	public static final String redireccionUrlNoExiste = "/pages/cliente/clienteNoExiste.xhtml?faces-redirect=true";

	@PostConstruct
	public void init() {
		tabActivo = 0;
		pagina = 2;
		render = false;
	}
        
        public void redireccionarDatosPaquete(Integer id) throws Exception{
	    FacesContext.getCurrentInstance().getExternalContext().redirect(redireccionGestion+"?idPaquete="+id);
	}
        
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Integer getTipificacion() {
		return tipificacion;
	}

	public void setTipificacion(Integer tipificacion) {
		this.tipificacion = tipificacion;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public Integer getTabActivo() {
		return tabActivo;
	}

	public void setTabActivo(Integer tabActivo) {
		this.tabActivo = tabActivo;
	}

        
        
}

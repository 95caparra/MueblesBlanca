package mueblesblanca.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import mueblesblanca.service.UsuarioService;
import mueblesblanca.vo.UsuarioVO;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean  implements Serializable{

    private String email;
    private String password;
    private UsuarioService usuarioService;
    private UsuarioVO usuarioVO;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    @ManagedProperty(value = "#{navegacionBean}")
    private NavegacionBean navegacionBean;

    @PostConstruct
    public void init() {
        email = new String();
        password = new String();
        usuarioService = new UsuarioService();
    }

    public boolean isAuthenticated() throws Exception {
        usuarioVO = usuarioService.autenticarUsuario(email, password);
        return usuarioVO != null;
    }

    public String doLogin() throws Exception {
        if (isAuthenticated()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuarioVO);
            return "/index_1.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Correo o clave incorrecto"));
        }
        return "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NavegacionBean getNavegacionBean() {
        return navegacionBean;
    }

    public void setNavegacionBean(NavegacionBean navegacionBean) {
        this.navegacionBean = navegacionBean;
    }

    public String getIpCliente() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}

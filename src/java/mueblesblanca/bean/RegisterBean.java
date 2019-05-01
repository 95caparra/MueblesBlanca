/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mueblesblanca.service.UsuarioService;
import mueblesblanca.vo.UsuarioVO;

/**
 *
 * @author Alexis Holguin
 */
@ManagedBean(name = "registerBean")
@SessionScoped
public class RegisterBean implements Serializable {

    UsuarioVO usuarioVO;
    UsuarioService usuarioService;

    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String address;
    private String personalId;

    @PostConstruct
    public void init() {
        usuarioService = new UsuarioService();
    }

    public void insertar() {
        try {
            usuarioVO = new UsuarioVO();
            usuarioVO.setEmail(email);
            usuarioVO.setFirstName(firstName);
            usuarioVO.setSecondName(secondName);
            usuarioVO.setFirstSurname(firstSurname);
            usuarioVO.setSecondSurname(secondSurname);
            usuarioVO.setPersonalId(personalId);
            usuarioVO.setPassword(usuarioService.convertirSHA256(password));
            usuarioVO.setAddress(address);
            if(usuarioService.insertar(usuarioVO) > 0){
                 FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "se guardó"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
            }
        } catch (Exception e) {
             System.out.println("error: "+ e.getMessage());
        }
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

}

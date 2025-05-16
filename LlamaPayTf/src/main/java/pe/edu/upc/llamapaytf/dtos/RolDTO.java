package pe.edu.upc.llamapaytf.dtos;

import pe.edu.upc.llamapaytf.entities.User;

public class RolDTO {
    private int Rol_id;
    private String TipoRol;
    private User user;

    public int getRol_id() {
        return Rol_id;
    }

    public void setRol_id(int rol_id) {
        Rol_id = rol_id;
    }

    public String getTipoRol() {
        return TipoRol;
    }

    public void setTipoRol(String tipoRol) {
        TipoRol = tipoRol;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

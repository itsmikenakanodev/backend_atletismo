package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Usuario;
import com.atletismo.Service.dto.UsuarioDocumentoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuariosRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario insertar(Usuario usuarios) {
        TypedQuery<Integer> query = this.entityManager.createQuery("SELECT MAX(u.numeroSocio) FROM Usuario u", Integer.class);
        usuarios.setNumeroSocio(query.getSingleResult()==null ? 1 : query.getSingleResult()+1);
        this.entityManager.persist(usuarios);
        return usuarios;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return this.entityManager.find(Usuario.class, id);
    }

    @Override
    public Boolean actualizar(Usuario usuarios) {
        try {
            this.entityManager.merge(usuarios);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        try {
            Usuario user = this.entityManager.find(Usuario.class, id);
            this.entityManager.remove(user);
            return true;
        } catch (Exception e) {
            //System.out.println("Error, ->"+e);
            return false;
        }
    }

    @Override
    public List<Usuario> buscarTodosUsuarios() {
        try {
            TypedQuery<Usuario> myQuery = this.entityManager.createQuery("SELECT u FROM Usuario u ",
                    Usuario.class);
            return myQuery.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Usuario buscarPorEmail(String email) {
        Usuario usua = null;
        try {
            TypedQuery<Usuario> myQuery = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email=:email",
                    Usuario.class);
            usua = myQuery.setParameter("email", email).getSingleResult();
            return  usua;
        } catch (NoResultException e) {

            return null;

        }
    }

    @Override
    public boolean existeUsuarioConEmail(String email) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.email = :email", Long.class);
        query.setParameter("email", email);
        try {
            Long count = query.getSingleResult();
            return count > 0;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public List<Usuario> listarCiudadPorEstadoReg(String provincia,Boolean estadoRegistro) {
        TypedQuery<Usuario> myQ = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.ciudad=:provincia AND u.estadoRegistro=:estadoRegistro",Usuario.class);
        try {
            myQ.setParameter("estadoRegistro", estadoRegistro).setParameter("provincia", provincia);
            return myQ.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }


    @Override
    public List<UsuarioDocumentoDTO> listarCiudadPorTipoDocumento(Boolean estado, String tipoDoc, String provincia) {

        try {
            String sql = "SELECT new UsuarioDocumentoDTO(u.id, u.nombres, u.apellidos, u.ciudad, u.email, u.telefono, u.fechaNacimiento, u.sexo, u.estado, u.fechaSuscripción, d) " +
                    "FROM Documentos d JOIN d.usuario u WHERE d.tipo = :tipoDoc AND u.ciudad = :ciudad";

            if ("Socio".equals(tipoDoc)) {
                sql += " AND u.estado = :estado";
            }
            if ("Registro".equals(tipoDoc)) {
                sql += " AND u.estadoRegistro = :estado";
            }
            if ("Inscripcion".equals(tipoDoc)) {
                sql += " AND u.estadoRegistro = :estado";
            }
            TypedQuery<UsuarioDocumentoDTO> myQ = this.entityManager.createQuery(sql
                    , UsuarioDocumentoDTO.class);

            if ("Socio".equals(tipoDoc) || "Registro".equals(tipoDoc)) {
                myQ.setParameter("estado", estado);
            }
            myQ.setParameter("tipoDoc", tipoDoc);
            myQ.setParameter("ciudad", provincia);
            return myQ.getResultList();

        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    @Override
    public List<Usuario> buscarTodosUsuariosAdmin() {
        TypedQuery<Usuario> myQ = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.rol.id = :rolId", Usuario.class);
        myQ.setParameter("rolId", 1);//id de roles 1
        try {
            return myQ.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Usuario> buscarUsuariosAprobadosPorApellidoOCedula(String apellido, String cedula) {
        try {
            TypedQuery<Usuario> myQuery = this.entityManager.createQuery(
                    "SELECT u FROM Usuario u WHERE u.estadoRegistro = true AND (u.apellidos LIKE :apellido OR u.cedula = :cedula) AND u.rol.id = 5",
                    Usuario.class);
            myQuery.setParameter("apellido", "%" + apellido + "%");
            myQuery.setParameter("cedula", cedula);
            return myQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }



}

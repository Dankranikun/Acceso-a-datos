package DAO;
import java.util.List;

public abstract class GenericDAO<T> {

    /**
     * Crea un nuevo registro en la base de datos.
     *
     * @param entity La entidad a ser creada.
     * @return true si el registro se crea con éxito, false en caso contrario.
     */
    public abstract boolean create(T entity);

    /**
     * Recupera un registro de la base de datos por su ID.
     *
     * @param id El ID de la entidad a ser recuperada.
     * @return La entidad correspondiente al ID dado, o null si no se encuentra.
     */
    public abstract T read(int id);

    /**
     * Recupera todos los registros de la base de datos.
     *
     * @return Una lista de todas las entidades en la base de datos.
     */
    public abstract List<T> readAll();

    /**
     * Actualiza un registro existente en la base de datos.
     *
     * @param entity La entidad con los valores actualizados.
     * @return true si el registro se actualiza con éxito, false en caso contrario.
     */
    public abstract boolean update(T entity);

    /**
     * Elimina un registro de la base de datos por su ID.
     *
     * @param id El ID de la entidad a ser eliminada.
     * @return true si el registro se elimina con éxito, false en caso contrario.
     */
    public abstract boolean delete(int id);
}

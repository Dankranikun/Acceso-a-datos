package DAO;

import java.util.List;

public abstract class GenericDAO<T, K> {

    /**
     * Crea un nuevo registro en la base de datos.
     *
     * @param entity La entidad a ser creada.
     * @return true si el registro se crea con éxito, false en caso contrario.
     */
    public abstract boolean create(T entity);

    /**
     * Recupera un registro de la base de datos por su clave.
     *
     * @param key La clave de la entidad a ser recuperada.
     * @return La entidad correspondiente a la clave dada, o null si no se encuentra.
     */
    public abstract T read(K key);

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
     * Elimina un registro de la base de datos por su clave.
     *
     * @param key La clave de la entidad a ser eliminada.
     * @return true si el registro se elimina con éxito, false en caso contrario.
     */
    public abstract boolean delete(K key);
}

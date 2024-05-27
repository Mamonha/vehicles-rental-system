package models.repositories;

public interface BasicCrud {
    Object create(Object object);

    Object update (Object object);

    void delete(Object object);

    Object findById(Object object);

}

package com.javainuse.data;

import java.util.List;

import com.javainuse.model.Jop;
import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;

public interface JopRepository extends CrudRepository<Jop, Long> {

    @Query(value = "SELECT c FROM Jop c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'"
            + " OR c.address LIKE '%' || :keyword || '%'")
    public List<Jop> search(@Param("keyword") String keyword);
}
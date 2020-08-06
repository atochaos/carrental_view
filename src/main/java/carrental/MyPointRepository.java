package carrental;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyPointRepository extends CrudRepository<MyPoint, Long> {

    List<MyPoint> findByResrvNo(String resrvNo);
}
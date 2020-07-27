package wang.ismy.htmlcachesystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author MY
 * @date 2020/7/27 13:08
 */
@Mapper
@Repository
public interface ConfigDao {

    String get(String name);

    int set(@Param("name") String name,@Param("value") String value);
}

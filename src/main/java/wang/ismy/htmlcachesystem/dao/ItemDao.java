package wang.ismy.htmlcachesystem.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.ismy.htmlcachesystem.entity.Item;

import java.util.List;

/**
 * @author MY
 * @date 2020/7/23 14:19
 */
@Mapper
public interface ItemDao {

    /**
     * 查询全部数据
     * @return 全部item
     */
    List<Item> selectAll();

    int insert(Item item);

    Item selectById(Long id);
}
